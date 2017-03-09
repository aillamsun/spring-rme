package com.gooddeep.remoteser.redis;

import com.gooddeep.dev.redis.commons.model.RedisBaseBean;

/**
 * 本天排名实体类
 * @author lhy
 *
 */
public class RankIng extends RedisBaseBean{
	private String id;
	private String rankNum;//排名
	private String rankInfo;//排名信息
	public String getRankNum() {
		return rankNum;
	}
	public void setRankNum(String rankNum) {
		this.rankNum = rankNum;
	}
	public String getRankInfo() {
		return rankInfo;
	}
	public void setRankInfo(String rankInfo) {
		this.rankInfo = rankInfo;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(String id) {
		this.id=id;
		
	}

	
	

}
