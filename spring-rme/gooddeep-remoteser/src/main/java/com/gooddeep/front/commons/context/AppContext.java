package com.gooddeep.front.commons.context;

import com.gooddeep.remoteser.p_member.model.UserInfo;


/**
 * 项目上下文
 * @author lhy 
 *
 *
 */
public class AppContext {
	
	private static ThreadLocal<UserInfo> userInfo = new ThreadLocal<UserInfo>();
	
	
	
	public static UserInfo getUserInfo() {
		return AppContext.userInfo.get();
	}
	public static void setUserInfo(UserInfo userInfo) {
		AppContext.userInfo.set(userInfo);;
	}
	

    
    
}