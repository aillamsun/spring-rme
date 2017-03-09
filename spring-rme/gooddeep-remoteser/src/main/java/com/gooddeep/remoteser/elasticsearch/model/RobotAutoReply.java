package com.gooddeep.remoteser.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.gooddeep.dev.elasticsearch.commons.model.EsBaseBean;
/**
 * 用户自动回复，存在elasticsearch
 * @author lhy
 *
 */
@Document(indexName ="robot_auto_reply", type ="member")
public class RobotAutoReply extends EsBaseBean{
	  
	@Id
   @Field(index = FieldIndex.not_analyzed, store = true) 
	private String id;
	
	 @Field(type = FieldType.String, analyzer="ik", store = true)  
	private String keyword;
   @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String reply;
   @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String userKey;
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/
   
   public RobotAutoReply(){
	   super();
   }

	public RobotAutoReply(String id, String keyword, String reply,String userKey) {
		this.id = id;
		this.keyword = keyword;
		this.reply = reply;
		this.userKey = userKey;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AutoReply [id=" + id + ", keyword=" + keyword + ", reply="
				+ reply + ", userKey=" + userKey + "]";
	}
	
	
	
	
}
