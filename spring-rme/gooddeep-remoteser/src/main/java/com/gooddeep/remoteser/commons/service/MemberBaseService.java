package com.gooddeep.remoteser.commons.service;

import java.util.Map;

import com.gooddeep.dev.core.service.BaseService;

/**
 * 会员 service基础接口
 * @author lhy
 *
 * @param <T>
 */
public interface MemberBaseService<T> extends BaseService<T>{
	/**
	 * 其他表根据用户外键id查找
	 * @param userId
	 * @return
	 */
	public T getObjByFkUserId(String userId);
	

}
