package com.gooddeep.front.quarz_jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

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

public class RobotKeyAndSettingJob implements BaseJob{

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

	@Scheduled(cron ="0 0 3 * * ?")//每天晚上3点执行一次
	@Override
	public void doWork() {
		logger.info("####################开始从mysql中查询ApiKey和Setting的对应关系，并插入或更新redis");
		List<RobotKeyAndSetting>list=robotApiKeyService.listApikeyAndSetting();
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				String apiKey=list.get(i).getId();//robot_api_key
				
				
				RobotKeyAndSetting rkas=robotKeyAndSettingDao.get(robotKeyAndSettingDao.createKey(apiKey));
				if(rkas!=null)
					list.get(i).setCreateTime(rkas.getCreateTime());
				robotKeyAndSettingDao.add(list.get(i));
			}
		}
		logger.info("####################从mysql中查询ApiKey和Setting的对应关系，结束");
		
	}

}
