package com.gooddeep.remoteser.elasticsearch.dao;

import org.springframework.stereotype.Component;

import com.gooddeep.dev.elasticsearch.commons.dao.EsBaseDaoImpl;
import com.gooddeep.remoteser.elasticsearch.model.RobotSysAutoReply;
@Component("robotSysAutoReplyDao")
public class RobotSysAuroReplyDaoImpl extends EsBaseDaoImpl<RobotSysAutoReply> implements RobotSysAutoReplyDao{

	@Override
	public Class<RobotSysAutoReply> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotSysAutoReply.class;
	}

	@Override
	public void putClassMapping() {
		 getElasticsearchTemplate().putMapping(RobotSysAutoReply.class);  
		
	}

}
