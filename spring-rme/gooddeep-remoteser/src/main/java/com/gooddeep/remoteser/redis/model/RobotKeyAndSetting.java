package com.gooddeep.remoteser.redis.model;

import com.gooddeep.dev.redis.commons.model.RedisBaseBean;

/**
 * 每次系统启动需要从mysql中查出并保存在redis， key与Setting的对应关系
 * id=robot_api_key
 * @author lhy
 *
 */
public class RobotKeyAndSetting  extends RedisBaseBean{
	private String id;//robot_api_key
	private Boolean useSysReply;//是否启用系统词条
	public Boolean getUseSysReply() {
		return useSysReply;
	}
	public void setUseSysReply(Boolean useSysReply) {
		this.useSysReply = useSysReply;
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

	

}
