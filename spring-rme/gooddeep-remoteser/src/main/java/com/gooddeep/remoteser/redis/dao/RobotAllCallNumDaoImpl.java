package com.gooddeep.remoteser.redis.dao;

import com.gooddeep.dev.redis.commons.dao.RedisBaseDaoImpl;
import com.gooddeep.remoteser.redis.model.RobotAllCallNum;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;

public class RobotAllCallNumDaoImpl extends RedisBaseDaoImpl<RobotAllCallNum> implements RobotAllCallNumDao{

	@Override
	public String getCollectionName() {
		// TODO Auto-generated method stub
		return "robot_all_call_num";
	}

	@Override
	protected Class<RobotAllCallNum> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotAllCallNum.class;
	}

}
