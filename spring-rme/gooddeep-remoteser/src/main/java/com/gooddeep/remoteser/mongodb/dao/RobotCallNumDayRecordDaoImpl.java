package com.gooddeep.remoteser.mongodb.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDaoImpl;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumDayRecord;

@Mongodb
@Transactional
@Component(value="robotDayCallNumDao")
public class RobotCallNumDayRecordDaoImpl extends MongoBaseDaoImpl<RobotCallNumDayRecord> implements RobotCallNumDayRecordDao{

	@Override
	public Class<RobotCallNumDayRecord> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotCallNumDayRecord.class;
	}


	
	


}
