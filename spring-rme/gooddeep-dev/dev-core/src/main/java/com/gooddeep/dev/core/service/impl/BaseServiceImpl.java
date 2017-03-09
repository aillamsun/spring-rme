package com.gooddeep.dev.core.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.gooddeep.dev.core.dao.BaseMapper;
import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BaseBean;
import com.gooddeep.dev.core.model.BaseConditions;
import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.core.service.BaseService;
import com.mysql.fabric.xmlrpc.base.Array;


public  abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	public int removeById(String id) {
		// TODO Auto-generated method stub
		return getDao().deleteById(id);
	}
	
	@Override
	public void removeBySomeId(Map<String,Object> map, String sql, List<Object> list){
		if(null!=list&&list.size()>0)
		  getDao().deleteBySomeId(map, sql, list);
	}
	@Override
	public int add(T t) {
         if(StringUtils.isEmpty(((BaseBean)t).getId()))
        	     ((BaseBean)t).setId(UuidHelper.getRandomUUID());
		((BaseBean)t).setCreateTime(new Date()); 
		return getDao().insert(t);
	}
	@Override
	public T findById(String id) {
		// TODO Auto-generated method stub
		return getDao().selectById(id);
	}
	@Override
	public List<T> list(Map<String,Object> map, String sql) {
		// TODO Auto-generated method stub
		System.out.println("##################");
		return getDao().list(map, sql);
	}
	@Override
	public int modifyById(T t) {
		// TODO Auto-generated method stub
		return getDao().updateById(t);
	}
	@Override
	public BasePage<T> findPage(Map<String,Object>  map, BasePage<T> page, String sql) {

		Long totalRecord = (long)getDao().rowsSize(map, sql);
		page.setTotalRecord(totalRecord);
		page.setResults(getDao().findPage(map, page, sql));
		//page.setRecordNo(recordNo)
		return page;
	}
	@Override
	public List<T> listBySomeId(Map<String,Object> map, String sqlData, List <String>list) {
		// TODO Auto-generated method stub
		if(list.size()<=0)
			return new ArrayList<T>();
		return getDao().listBySomeId(map, sqlData, list);
	}
	@Override
	public int rowsSize(Map<String,Object> map, String sql) {
		return getDao().rowsSize(map, sql);
	}

	


	@Override
	public int removeBySelect(Map<String, Object> map) {
	
		return getDao().deleteBySelect(map);
	}


	@Override
	public int rowsSizeConditions(BaseConditions conditions, String sql) {
		// TODO Auto-generated method stub
		return getDao().rowsSizeConditions(conditions, sql);
	}


	@Override
	public List<T> listConditions(BaseConditions conditions, String sql) {
		// TODO Auto-generated method stub
		return getDao().listConditions(conditions, sql);
	}


	@Override
	public BasePage<T> findPageConditions(BaseConditions conditions,
			BasePage<T> page, String sql) {
		// TODO Auto-generated method stub
		return getDao().findPageConditions(conditions, page, sql);
	}


	@Override
	public int removeBySelectConditions(BaseConditions conditions) {
		// TODO Auto-generated method stub
		return getDao().deleteBySelectConditions(conditions);
	}


/*	@Override
	public int modifyBySelect(Map<String, Object> map,T t) {
		// TODO Auto-generated method stub
		return getDao().updateBySelect(map,t);
	}

	@Override
	public int modifyBySelectConditions(BaseConditions conditions) {
		// TODO Auto-generated method stub
		return getDao().updateBySelectConditions(conditions);
	}*/
	
	protected abstract BaseMapper<T> getDao();
}
