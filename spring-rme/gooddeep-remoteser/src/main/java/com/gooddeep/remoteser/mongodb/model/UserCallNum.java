package com.gooddeep.remoteser.mongodb.model;

/**
 * 中间类，用于保存统计出来的信息
 * @author lhy
 *
 */
public class UserCallNum {
	private String apiKey;//用户apiKey
	private Long amount;//总计
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	

}
