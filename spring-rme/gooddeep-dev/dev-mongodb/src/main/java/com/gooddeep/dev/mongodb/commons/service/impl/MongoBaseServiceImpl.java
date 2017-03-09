package com.gooddeep.dev.mongodb.commons.service.impl;

import java.util.List;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.mongodb.commons.dao.MongoBaseDao;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseConditions;
import com.gooddeep.dev.mongodb.commons.service.MongoBaseService;
@Mongodb
public  abstract class MongoBaseServiceImpl<T> implements MongoBaseService<T>{

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return getDao().deleteById(id);
	}

	@Override
	public int deleteBySomeId(List<String> list) {
		// TODO Auto-generated method stub
		return getDao().deleteBySomeId(list);
	}

	@Override
	public int insert(T t) {
		// TODO Auto-generated method stub
		return getDao().insert(t);
	}

	@Override
	public T selectById(String id) {
		// TODO Auto-generated method stub
		return getDao().selectById(id);
	}

	@Override
	public List<T> list(MongoBaseConditions  conditions) {
		// TODO Auto-generated method stub
		return getDao().list(conditions);
	}

	@Override
	public int updateById(T t) {
		// TODO Auto-generated method stub
		return getDao().updateById(t);
	}

	@Override
	public List<T> findPage(MongoBaseConditions  conditions, BasePage<T> page) {
		// TODO Auto-generated method stub
		return getDao().findPage(conditions, page);
	}

	@Override
	public long rowsSize(MongoBaseConditions  conditions) {
		// TODO Auto-generated method stub
		return getDao().rowsSize(conditions);
	}

	@Override
	public List<T> listBySomeId(List<String> list) {
		// TODO Auto-generated method stub
		return getDao().listBySomeId(list);
	}

	
	


	@Override
	public int deleteMore(MongoBaseConditions  conditions) {
		// TODO Auto-generated method stub
		return getDao().deleteMore(conditions);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getDao().findAll();
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return getDao().findAllCount();
	}

	@Override
	public void dropCollection() {
		getDao().dropCollection();
		
	}

	@Override
	public void createCollection() {
		getDao().createCollection();
	}

	@Override
	public void dropCollection(String collectionName) {
		getDao().dropCollection(collectionName);
		
	}

	@Override
	public void createCollection(String collectionName) {
		getDao().createCollection(collectionName);
		
	}


	protected abstract MongoBaseDao<T> getDao();

}
