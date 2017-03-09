package com.gooddeep.dev.redis.commons.service.impl;

import java.util.List;

import com.gooddeep.dev.redis.commons.dao.RedisBaseDao;
import com.gooddeep.dev.redis.commons.service.RedisBaseService;

public abstract class RedisBaseServiceImpl<T> implements RedisBaseService<T>{

	@Override
	public boolean add(T t) {
		// TODO Auto-generated method stub
		return getDao().add(t);
	}

	@Override
	public boolean add(List<T> list) {
		// TODO Auto-generated method stub
		return getDao().add(list);
	}

	@Override
	public void delete(String key) {
		getDao().delete(key);
		
	}

	@Override
	public void delete(List<String> keys) {
		getDao().delete(keys);
		
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return getDao().update(t);
	}

	@Override
	public T get(String keyId) {
		// TODO Auto-generated method stub
		return getDao().get(keyId);
	}

	protected abstract RedisBaseDao<T> getDao();
}
