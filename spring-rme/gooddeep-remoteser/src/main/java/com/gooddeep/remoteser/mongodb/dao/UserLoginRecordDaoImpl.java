package com.gooddeep.remoteser.mongodb.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDaoImpl;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.remoteser.mongodb.model.UserLoginRecord;

@Mongodb
@Transactional
@Component(value="userLoginRecordDao")
public class UserLoginRecordDaoImpl extends MongoBaseDaoImpl<UserLoginRecord> implements UserLoginRecordDao{



	@Override
	public Class<UserLoginRecord> getEntityClass() {
		// TODO Auto-generated method stub
		return UserLoginRecord.class;
	}



}
