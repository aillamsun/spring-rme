package com.gooddeep.remoteser.p_robot.service;

import java.util.List;

import com.gooddeep.remoteser.commons.service.MemberBaseService;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;



public interface RobotApiKeyService extends MemberBaseService<RobotApiKey>{
	/**
	 * 得到apikey和settig的对应关系方法
	 * @return
	 */
	List<RobotKeyAndSetting> listApikeyAndSetting();
	
    
}