package com.gooddeep.remoteser.mongodb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDaoImpl;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.front.commons.helper.DateTimeHelper;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumMonthRecord;
import com.gooddeep.remoteser.mongodb.model.UserCallNum;

@Mongodb
@Transactional
@Component(value="robotDayCallNumDao")
public class RobotCallNumMonthRecordDaoImpl extends MongoBaseDaoImpl<RobotCallNumMonthRecord> implements RobotCallNumMonthRecordDao{

	@Override
	public Class<RobotCallNumMonthRecord> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotCallNumMonthRecord.class;
	}

	@Override
	public List<UserCallNum> getUserMonthCallSum(String startDate,String endDate) {
		   Criteria criteria=Criteria.where("createDay").gte(startDate).lte(endDate);
	     Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria),Aggregation.group("apiKey").sum("amount").as("amount") );  
	     AggregationResults<UserCallNum> ar = getMongoTemplate().aggregate(aggregation, getEntityClass(), UserCallNum.class);  
	     List<UserCallNum> list = ar.getMappedResults();  
		  return list;
	}



}
