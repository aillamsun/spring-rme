package com.gooddeep.remoteser.mongodb.dao;

import java.util.Date;
import java.util.List;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDao;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumYearRecord;
import com.gooddeep.remoteser.mongodb.model.UserCallNum;

/**
 * 年调用
 * @author lhy
 *
 */
@Mongodb
public interface RobotCallNumYearRecordDao extends MongoBaseDao<RobotCallNumYearRecord>{

	/**
	 * 聚合求各用户当年的接口调用次数总和
	 * @param StartDate
	 * @param endDate
	 * @return
	 */
	public List<UserCallNum> getUserYearCallSum(String startDate,String endDate);
}
