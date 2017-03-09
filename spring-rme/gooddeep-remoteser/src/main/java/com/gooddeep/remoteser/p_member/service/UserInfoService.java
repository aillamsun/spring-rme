package com.gooddeep.remoteser.p_member.service;

import java.io.InputStream;

import com.gooddeep.remoteser.commons.service.MemberBaseService;
import com.gooddeep.remoteser.p_member.model.UserInfo;

public interface UserInfoService extends MemberBaseService<UserInfo>{
   
	/**
	 * 上传头像
	 * @param is
	 * @param filename
	 * @param userId
	 * @return
	 */
	public String uploadHeadImg(InputStream is, String filename,String userId);
}