package com.gooddeep.remoteser.redis.dao;

import com.gooddeep.dev.redis.commons.dao.RedisBaseDaoImpl;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;

public class RobotDayCallNumDaoImpl extends RedisBaseDaoImpl<RobotDayCallNum> implements RobotDayCallNumDao{

	@Override
	public String getCollectionName() {
		// TODO Auto-generated method stub
		return "robot_call_num";
	}

	@Override
	protected Class<RobotDayCallNum> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotDayCallNum.class;
	}

}
