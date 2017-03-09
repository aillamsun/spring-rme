package com.gooddeep.remoteser.redis.model;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.redis.commons.model.RedisBaseBean;

/**
 * 接口日调用次数，每日都是同一个
 * id=robot_api_key
 * @author lhy
 *
 */
public class RobotDayCallNum extends RedisBaseBean{
	private String id;//robot_api_key
	private Long amount;//今天调用次数
	
	private String rcnrDayId;//mongob按天存储的调用次数的id，他先生成，mongodb按照他生成

	 public String getRcnrDayId() {
	    	if(rcnrDayId==null)
	    	{
	    		this.rcnrDayId=UuidHelper.getRandomUUID();
	    		return this.rcnrDayId;
	    	}
			return rcnrDayId;
		}

		public void setRcnrDayId(String rcnrDayId) {
			this.rcnrDayId = rcnrDayId;
		}
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
