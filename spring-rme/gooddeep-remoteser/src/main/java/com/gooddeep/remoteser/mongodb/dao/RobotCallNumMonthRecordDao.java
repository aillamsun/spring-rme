package com.gooddeep.remoteser.mongodb.dao;

import java.util.Date;
import java.util.List;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDao;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumMonthRecord;
import com.gooddeep.remoteser.mongodb.model.UserCallNum;

/**
 * 月调用
 * @author lhy
 *
 */
@Mongodb
public interface RobotCallNumMonthRecordDao extends MongoBaseDao<RobotCallNumMonthRecord>{

	/**
	 * 聚合求各用户当月的接口调用总和
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<UserCallNum> getUserMonthCallSum(String startDate,String endDate);
}
