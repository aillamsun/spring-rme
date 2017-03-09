package com.gooddeep.remoteser.mongodb.dao;

import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDao;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.remoteser.mongodb.model.UserLoginRecord;

/**
 * 日登陆记录
 * @author lhy
 *
 */
@Mongodb
public interface UserLoginRecordDao extends MongoBaseDao<UserLoginRecord>{

}
