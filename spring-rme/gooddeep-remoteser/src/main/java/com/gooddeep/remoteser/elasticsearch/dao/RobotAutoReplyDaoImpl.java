package com.gooddeep.remoteser.elasticsearch.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gooddeep.dev.elasticsearch.commons.dao.EsBaseDaoImpl;
import com.gooddeep.remoteser.elasticsearch.model.RobotAutoReply;

@Component("robotAutoReplyDao")
public class RobotAutoReplyDaoImpl extends EsBaseDaoImpl<RobotAutoReply> implements RobotAutoReplyDao{
    
	@Override
	public Class<RobotAutoReply> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotAutoReply.class;
	}
	
	@PostConstruct
	@Override
	public void putClassMapping() {
/*		 if(getElasticsearchTemplate().getPersistentEntityFor(RobotAutoReply.class)==null)
 {
			 System.out.println("ffffffffffffffff");*/
			 getElasticsearchTemplate().putMapping(RobotAutoReply.class);  
/*	 }*/
	}

 
}
