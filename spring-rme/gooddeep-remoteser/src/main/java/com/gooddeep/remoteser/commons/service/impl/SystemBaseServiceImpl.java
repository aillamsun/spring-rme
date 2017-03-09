package com.gooddeep.remoteser.commons.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooddeep.dev.core.service.impl.BaseServiceImpl;
import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.MemberBaseService;
import com.gooddeep.remoteser.commons.service.SystemBaseService;



public abstract class SystemBaseServiceImpl<T> extends BaseServiceImpl<T> implements SystemBaseService<T>{

	@Override
	public T getObjByFkUserId(String userId) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fkUser", userId);
		List<T>list=getDao().list(map, null);
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	
	

	@Override
	protected abstract MemberBaseMapper<T> getDao();
}
