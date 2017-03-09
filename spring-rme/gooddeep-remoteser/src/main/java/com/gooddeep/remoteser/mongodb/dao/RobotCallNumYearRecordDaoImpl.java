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
import com.gooddeep.remoteser.mongodb.model.RobotCallNumYearRecord;
import com.gooddeep.remoteser.mongodb.model.UserCallNum;

@Mongodb
@Transactional
@Component(value="robotDayCallNumDao")
public class RobotCallNumYearRecordDaoImpl extends MongoBaseDaoImpl<RobotCallNumYearRecord> implements RobotCallNumYearRecordDao{

	@Override
	public Class<RobotCallNumYearRecord> getEntityClass() {
		// TODO Auto-generated method stub
		return RobotCallNumYearRecord.class;
	}

	@Override
	public List<UserCallNum> getUserYearCallSum(String startDate,String endDate) {
			   Criteria criteria=Criteria.where("createMonth").gte(startDate).lte(endDate);
		     Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria),Aggregation.group("apiKey").sum("amount").as("amount") );  
		     AggregationResults<UserCallNum> ar = getMongoTemplate().aggregate(aggregation, getEntityClass(), UserCallNum.class);  
		     List<UserCallNum> list = ar.getMappedResults();  
			  return list;
	

	}



}
