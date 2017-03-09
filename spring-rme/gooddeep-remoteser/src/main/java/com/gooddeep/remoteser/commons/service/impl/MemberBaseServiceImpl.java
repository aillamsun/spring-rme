package com.gooddeep.remoteser.commons.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooddeep.dev.core.service.impl.BaseServiceImpl;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.model.MemBaseBean;
import com.gooddeep.remoteser.commons.service.MemberBaseService;



public abstract class MemberBaseServiceImpl<T> extends BaseServiceImpl<T> implements MemberBaseService<T>{

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
	public int removeById(String id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("fkUser", AppContext.getUserInfo().getUserId());
		map.put("id", id);
		return super.removeBySelect(map);
	}
	
	@Override
	public void removeBySomeId(Map<String,Object> map, String sql, List<Object> list){
		if(map==null)
			map=new HashMap<String,Object>();
		map.put("fkUser", AppContext.getUserInfo().getUserId());
		
		if(null!=list&&list.size()>0)
		  getDao().deleteBySomeId(map, sql, list);
	}


	@Override
	public int modifyById(T t) {
       ((MemBaseBean)t).setFkUser(AppContext.getUserInfo().getUserId());

		return getDao().updateById(t);
	}

	
	@Override
	protected abstract MemberBaseMapper<T> getDao();
}
