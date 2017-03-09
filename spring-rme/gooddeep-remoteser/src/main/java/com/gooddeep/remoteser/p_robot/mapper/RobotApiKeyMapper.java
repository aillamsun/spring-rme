package com.gooddeep.remoteser.p_robot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;



public interface RobotApiKeyMapper extends MemberBaseMapper<RobotApiKey>{
	
	/**
	 * 得到apikey和settig的对应关系方法
	 * @return
	 */
	@Select("SELECT rak.api_key as id ,rs.use_sys_reply as useSysReply FROM robot_api_key rak JOIN robot_setting rs ON rak.fk_user=rs.fk_user")
	List<RobotKeyAndSetting> listApikeyAndSetting();
    
}