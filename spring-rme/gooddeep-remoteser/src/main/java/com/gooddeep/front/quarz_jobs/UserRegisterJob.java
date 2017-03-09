package com.gooddeep.front.quarz_jobs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gooddeep.remoteser.p_member.model.User;

/**
 * 用户注册作业
 * 
 * @author lhy
 * 
 */

public class UserRegisterJob implements BaseJob {

	static Logger logger = LoggerFactory.getLogger(UserRegisterJob.class);
	private static Map<String, User> registerUserMap = new HashMap<String, User>();

	public static Map<String, User> getRegisterUserMap() {
		return registerUserMap;
	}
	
	public static User getRegisterUser(String registerId) {
		return registerUserMap.get(registerId);
	}
	
	public static User removeRegisterUser(String registerId) {
		return registerUserMap.remove(registerId);
	}

	public static void setRegisterUserMap(User user) {

		UserRegisterJob.registerUserMap.put(user.getRegisterId(), user);
		logger.info("#########################新用户注册" + user.getEmail());
	}

	/**
	 * 作业执行方法
	 */
	@Scheduled(cron = "0/5 * *  * * ? ")//每5s执行一次
	@Override
	public void doWork() {
		//logger.info("#########################注册作业检查超时");
		for (String key : registerUserMap.keySet()) {
			//logger.info("######################队列开始遍历" + registerUserMap.size());
			User user = registerUserMap.get(key);
			long time = new Date().getTime() - user.getRegisterTime();
			if (time > 3600000)// 朝时删除
			{
				logger.info("##############################新用户" + user.getEmail()+ "注册时间超时");
				registerUserMap.remove(key);
			}
		}
	}

	/**
	 * 检查用户是否存在，用户是否超时，超时删除， 当用户存在并且未超时，返回true
	 * 
	 * @param registerId
	 * @return
	 */
	public static boolean checkAndRemoveOutTimeRegister(String registerId) {
		User user = registerUserMap.get(registerId);
		if(user==null)
			return false;
		long time = new Date().getTime() - user.getRegisterTime();
		if (time > 3600000)// 朝时删除
		{
			logger.info("##############################新用户" + user.getEmail()+ "注册时间超时");
			registerUserMap.remove(registerId);
			return false;
		}
		return true;

	}

}
