package com.gooddeep.remoteser.p_member.service;

import com.gooddeep.remoteser.commons.service.MemberBaseService;
import com.gooddeep.remoteser.p_member.model.User;

public interface UserService extends MemberBaseService<User>{
	
	/**
	 * 按帐号查找
	 * @param account
	 * @return
	 */
	public User findByAccount(String account);
	

 
}