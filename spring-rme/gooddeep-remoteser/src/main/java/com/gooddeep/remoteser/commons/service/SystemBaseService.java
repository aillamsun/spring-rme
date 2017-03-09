package com.gooddeep.remoteser.commons.service;

import com.gooddeep.dev.core.service.BaseService;

/**
 * 系统service基础接口
 * @author lhy
 *
 * @param <T>
 */
public interface SystemBaseService<T> extends BaseService<T>{
	/**
	 * 其他表根据用户外键id查找
	 * @param userId
	 * @return
	 */
	public T getObjByFkUserId(String userId);

}
