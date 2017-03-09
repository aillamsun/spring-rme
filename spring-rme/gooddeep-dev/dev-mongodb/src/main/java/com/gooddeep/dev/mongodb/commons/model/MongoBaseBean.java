package com.gooddeep.dev.mongodb.commons.model;

import java.util.Date;

import com.gooddeep.dev.core.model.BaseBean;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;

@Mongodb
public class MongoBaseBean{
	
	private String id;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
