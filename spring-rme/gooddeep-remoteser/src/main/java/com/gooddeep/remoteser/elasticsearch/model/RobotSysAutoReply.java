package com.gooddeep.remoteser.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.gooddeep.dev.elasticsearch.commons.model.EsBaseBean;

/**
 * 系统自动回复类
 * @author lhy
 *
 */
@Document(indexName ="robot_auto_reply", type ="system")
public class RobotSysAutoReply extends EsBaseBean{
	  
	@Id
   @Field(index = FieldIndex.not_analyzed, store = true) 
	private String id;
	
	 @Field(type = FieldType.String, analyzer="ik", store = true)  
	private String keyword;
   @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String reply;

   
   
   
	public RobotSysAutoReply() {

}

	public RobotSysAutoReply(String id, String keyword, String reply) {
	this.id = id;
	this.keyword = keyword;
	this.reply = reply;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
