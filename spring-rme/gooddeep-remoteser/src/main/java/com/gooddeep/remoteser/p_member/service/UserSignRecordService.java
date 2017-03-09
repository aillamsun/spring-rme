package com.gooddeep.remoteser.p_member.service;

import java.util.Date;

import com.gooddeep.remoteser.commons.service.MemberBaseService;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.model.UserSignRecord;

public interface UserSignRecordService extends MemberBaseService<UserSignRecord>{
	
	/**
	 * 按帐号和日期查找今天是否签到
	 * @param userId
	 * @param date
	 * @return
	 */
	public boolean isSignToday(String userId,Date date);
	
	/**
	 * 签到
	 * @param userId
	 */
	public void signToday(String userId);
 
}