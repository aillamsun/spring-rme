package com.gooddeep.remoteser.commons.model;

import com.gooddeep.dev.core.model.BaseBean;

public class SystemBaseBean extends BaseBean{

	private String groupid;//所属组id

	private String createUser;//创建者

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
