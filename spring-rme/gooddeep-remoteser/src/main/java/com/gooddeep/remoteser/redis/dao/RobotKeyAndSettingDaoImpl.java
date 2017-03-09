package com.gooddeep.remoteser.redis.dao;

import org.springframework.stereotype.Component;

import com.gooddeep.dev.redis.commons.dao.RedisBaseDaoImpl;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;

@Component("robotKeyAndSettingDao")
public class RobotKeyAndSettingDaoImpl extends RedisBaseDaoImpl<RobotKeyAndSetting> implements RobotKeyAndSettingDao {

	@Override
	public String getCollectionName() {
		// TODO Auto-generated method stub
		return "robot_key_and_setting";
	}

	@Override
	protected Class<RobotKeyAndSetting> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotKeyAndSetting.class;
	}



}
