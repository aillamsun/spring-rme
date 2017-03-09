package com.gooddeep.front.quarz_jobs;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumDayRecordDao;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumDayRecord;
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
public class InitJob implements BaseJob{

	static Logger logger = LoggerFactory.getLogger(UserRegisterJob.class);
	@Autowired
	private RobotApiKeyService robotApiKeyService;

	@Autowired
	private RobotKeyAndSettingDao robotKeyAndSettingDao;
	
	@Autowired
	private RobotCallNumDayRecordDao robotCallNumRecordDao;
	@Autowired
	private RobotAllCallNumDao robotAllCallNumDao;
	
	@Autowired
	private RobotDayCallNumDao robotDayCallNumDao;

	@PostConstruct
	@Override
	public void doWork() {
		logger.info("####################服务启动开始初始化。。。。。。。");
		List<RobotKeyAndSetting>list=robotApiKeyService.listApikeyAndSetting();
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				String apiKey=list.get(i).getId();//robot_api_key

				/**
				 * redis  apikey和用户设置setting的关系影射
				 */
				RobotKeyAndSetting rkas=robotKeyAndSettingDao.get(robotKeyAndSettingDao.createKey(apiKey));
				if(rkas!=null)
					list.get(i).setCreateTime(rkas.getCreateTime());
				robotKeyAndSettingDao.add(list.get(i));
				
				

				/**
				 * redis 今日日调用次数
				 */
			
				RobotDayCallNum robotDayCallNum=robotDayCallNumDao.get(robotDayCallNumDao.createKey(apiKey));
				if(robotDayCallNum==null)
				{
					RobotDayCallNum robotDayCallNum2=new RobotDayCallNum();
					robotDayCallNum2.setAmount((long)0);
					robotDayCallNum2.setId(robotDayCallNumDao.createKey(apiKey));
					robotDayCallNum2.setId(UuidHelper.getRandomUUID());
					robotDayCallNumDao.add(robotDayCallNum2);
				}
				
				/**
				 * redis总调用次数
				 */
				RobotAllCallNum robotAllCallNum=robotAllCallNumDao.get(robotAllCallNumDao.createKey(apiKey));
				if(robotAllCallNum==null)
				{
					RobotAllCallNum robotAllCallNum2=new RobotAllCallNum();
					robotAllCallNum2.setAmount((long)0);
					robotAllCallNum2.setId(robotAllCallNumDao.createKey(apiKey));
					robotAllCallNumDao.add(robotAllCallNum2);
				}
				/**
				 * mongdodb调用记录，天
				 */
					if(robotCallNumRecordDao.selectById(robotDayCallNum.getId())==null)
					{
						RobotCallNumDayRecord robotCallNumRecord2=new RobotCallNumDayRecord();
						robotCallNumRecord2.setAmount((long)0);
						robotCallNumRecord2.setApiKey(apiKey);
						robotCallNumRecord2.setCreateTime(new Date());
						robotCallNumRecord2.setId(robotDayCallNum.getRcnrDayId());
						robotCallNumRecordDao.insert(robotCallNumRecord2);
					}
				
					
			}
		}
		logger.info("####################初始化，结束");
		
	}

}
