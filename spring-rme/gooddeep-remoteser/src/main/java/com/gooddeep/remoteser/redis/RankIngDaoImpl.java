package com.gooddeep.remoteser.redis;

import org.springframework.stereotype.Component;

import com.gooddeep.dev.redis.commons.dao.RedisBaseDaoImpl;

@Component("rankIngDao")
public class RankIngDaoImpl extends RedisBaseDaoImpl<RankIng> implements RankIngDao {

	@Override
	public String getCollectionName() {
		
		// TODO Auto-generated method stub
		return "rankIng";
	}

	@Override
	protected Class getEntityClass() {
		// TODO Auto-generated method stub
		return RankIng.class;
	}

	
}
