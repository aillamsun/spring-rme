package com.gooddeep.remoteser.redis.model;

import com.gooddeep.dev.redis.commons.model.RedisBaseBean;

/**
 * 接口总调用次数
 * id=robot_api_key
 * @author lhy
 *
 */
public class RobotAllCallNum extends RedisBaseBean{
	private String id;//robot_api_key
	private Long amount;//总调用次数
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		this.id=id;
		
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	


	

}
