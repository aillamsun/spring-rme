package com.gooddeep.dev.redis.commons.model;

import java.util.Date;

public abstract class RedisBaseBean {

	
	
   private Date createTime;
    

	public Date getCreateTime() {
		if(createTime==null)
			return new Date();
	return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public abstract String getId();

	public abstract void setId(String id);

	
	

}
