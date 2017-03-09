package com.gooddeep.front.quarz_jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import net.sf.ehcache.search.attribute.AttributeExtractor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BaseConditions.BaseCriteria;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseConditions;
import com.gooddeep.front.commons.helper.DateTimeHelper;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumDayRecordDao;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumMonthRecordDao;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumYearRecordDao;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumDayRecord;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumMonthRecord;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumYearRecord;
import com.gooddeep.remoteser.mongodb.model.UserCallNum;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.p_robot.service.RobotApiKeyService;
import com.gooddeep.remoteser.redis.dao.RobotAllCallNumDao;
import com.gooddeep.remoteser.redis.dao.RobotDayCallNumDao;
import com.gooddeep.remoteser.redis.dao.RobotKeyAndSettingDao;
import com.gooddeep.remoteser.redis.model.RobotAllCallNum;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;

/**
 * 智能机器人 的key和 setting的对应，系统启动的时候需要，执行一次
 * @author lhy
 *
 */

public class RobotCallNumToMongdbJob implements BaseJob{

	static Logger logger = LoggerFactory.getLogger(UserRegisterJob.class);
	@Autowired
	private RobotDayCallNumDao robotDayCallNumDao;
	@Autowired
	private RobotCallNumDayRecordDao robotCallNumDayRecordDao;
	@Autowired
	private RobotCallNumMonthRecordDao robotCallNumMonthRecordDao;
	@Autowired
	private RobotCallNumYearRecordDao robotCallNumYearRecordDao;
	@Autowired
	private RobotAllCallNumDao robotAllCallNumDao;
	@Autowired
	private RobotApiKeyService robotApiKeyService;
	@Autowired
	private RobotKeyAndSettingDao robotKeyAndSettingDao;
	

	/**
	 * 每60min从redis向mongodb更新一次
	 */
	@Scheduled(cron ="0 0/60 * * * ?")//
	@Override
	public void doWork() {
		logger.info("####################开始从redis向mongodb更新接口调用次数数据");
		Set<String>keys=robotDayCallNumDao.getkeys(robotDayCallNumDao.getCollectionName()+":*");
		List <RobotCallNumDayRecord> listRcnr=new ArrayList<RobotCallNumDayRecord>();
		for(String key:keys)
		{
			RobotDayCallNum robotDayCallNum=robotDayCallNumDao.get(key);
			RobotCallNumDayRecord rcnr=new RobotCallNumDayRecord();
			rcnr.addRobotDatCallNum(robotDayCallNum);
			rcnr.setId(robotDayCallNum.getRcnrDayId());
			listRcnr.add(rcnr);
		}
		robotCallNumDayRecordDao.updateListById(listRcnr);
		logger.info("####################从redis向mongodb更新接口调用次数数据，结束");
	}
	
	
	/**
	 * 每天零点向mongodb更新数据，并清空redis数据为0
	 */
	@Scheduled(cron ="0 0 0 * * ?")//
	public void dayEnd() {
		logger.info("####################本天结束，开始从redis向mongodb更新接口调用次数数据，并清空redis数据");
		Set<String>keys=robotDayCallNumDao.getkeys(robotDayCallNumDao.getCollectionName()+":*");
		for(String key:keys)
		{
			/**
			 * 昨天数据更新到mongodb
			 */
			RobotDayCallNum robotDayCallNum=robotDayCallNumDao.get(key);
			RobotCallNumDayRecord rcnr=new RobotCallNumDayRecord();
			rcnr.addRobotDatCallNum(robotDayCallNum);
			rcnr.setId(robotDayCallNum.getRcnrDayId());
			robotCallNumDayRecordDao.updateById(rcnr);//本天最后一次更新mongodb次数
			
			/**
			 * redis更新成今天的
			 */
			robotDayCallNum.setAmount((long)0);
			robotDayCallNum.setRcnrDayId(UuidHelper.getRandomUUID());//每天产生一个新的uuid，供mongodb做id使用
			robotDayCallNum.setCreateTime(new Date());
			robotDayCallNumDao.update(robotDayCallNum);
			/**
			 * 产生今天的mongodb数据
			 */
			RobotCallNumDayRecord robotCallNumRecord=new RobotCallNumDayRecord();
			robotCallNumRecord.addRobotDatCallNum(robotDayCallNum);
			robotCallNumDayRecordDao.insert(robotCallNumRecord);
		}
		logger.info("####################本天结束，从redis向mongodb更新接口调用次数数据，结束");
	}
	
	
	/**
	 * 新的一月的第一天1点，统计上月情况，mongogo统计当月，并插入
	 */
	@Scheduled(cron ="0 0 1 1 * ?")//
	public void monthEnd() {
		logger.info("###########新的一月的第一天1点，统计上月情况，mongogo统计当月，并插入----开始");
		String startDate=DateTimeHelper.getLastMonthFirstDay(new Date());
		String endDate=DateTimeHelper.getLastMonthEndDay(new Date());
		List<UserCallNum> list=robotCallNumMonthRecordDao.getUserMonthCallSum(startDate, endDate);
		
		for(UserCallNum userCall:list)
		{   RobotCallNumMonthRecord rpCallNumMonthRecord=new RobotCallNumMonthRecord();
		    rpCallNumMonthRecord.addUserCallNum(userCall);
			 robotCallNumMonthRecordDao.insert(rpCallNumMonthRecord);
		}
		logger.info("###########新的一月的第一天1点，统计上月情况，mongogo统计当月，并插入------结束");
		/*Set <String> racndKeys=robotAllCallNumDao.getkeys(robotAllCallNumDao.getCollectionName()+":*");
		for(String key:racndKeys)
		{
			String robotApiKey=robotAllCallNumDao.get(robotAllCallNumDao.createKey(key)).getId();
			MongoBaseConditions mongoBaseConditions=new MongoBaseConditions();
			BaseCriteria baseCriteria=new BaseCriteria("=");
			baseCriteria.setProName("apiKey");
			baseCriteria.setValue(robotApiKey);
			mongoBaseConditions.addCondition(baseCriteria);
			
			BaseCriteria baseCriteria2=new BaseCriteria("between");
			baseCriteria2.setProName("createDay");
			String monthStartDay=DateTimeHelper.getLastMonthFirstDay(new Date());
			String monthEndDay=DateTimeHelper.getLastMonthEndDay(new Date());
			baseCriteria2.setValue(monthStartDay);
			baseCriteria2.setSecondValue(monthEndDay);
			mongoBaseConditions.addCondition(baseCriteria2);
			List<RobotCallNumDayRecord> robotCallNumDayRecords=robotCallNumDayRecordDao.list(mongoBaseConditions);
			
			
		}*/
	}
	/**
	 * 新的一年1月的第一天2点，mongogo统计当年，并插入
	 */
	@Scheduled(cron ="0 0 2 1 1 ?")//
	public void yearEnd() {
		logger.info("###########新的一年1月的第一天2点，mongogo统计当年，并插入----开始");
		String startDate=DateTimeHelper.getLastYearFirstMonth(new Date());
		String endDate=DateTimeHelper.getLastYearEndMonth(new Date());
		List<UserCallNum> list=robotCallNumYearRecordDao.getUserYearCallSum(startDate, endDate);
		
		for(UserCallNum userCall:list)
		{   RobotCallNumYearRecord rpCallNumYearRecord=new RobotCallNumYearRecord();
		    rpCallNumYearRecord.addUserCallNum(userCall);
			 robotCallNumYearRecordDao.insert(rpCallNumYearRecord);
		}
		logger.info("###########新的一年1月的第一天2点，mongogo统计当年，并插入----结束");
		
	}
/**
 * 新用户注册时，
 */
}
