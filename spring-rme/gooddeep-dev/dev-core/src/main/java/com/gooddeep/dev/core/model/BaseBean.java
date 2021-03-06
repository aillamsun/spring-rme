package com.gooddeep.dev.core.model;

import java.io.Serializable;
import java.util.Date;

import com.gooddeep.dev.core.helper.DateHelper;

/**
 * 基本bean类
 * 
 * @author lhy
 * 
 */
public class BaseBean implements Serializable{


	private String id;
	private Date createTime;



	private Boolean usable;
	private String createDateStr;// （临时变量）数据库中没有此属性，只为页面显示用，createTime的str形式，
	private String dateTimeStr;// 日期和时间（临时变量）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public Boolean getUsable() {
		return usable;
	}

	public void setUsable(Boolean usable) {
		this.usable = usable;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		if (createTime != null) {
			this.setCreateDateStr(DateHelper.dateToStrYMD(createTime));
			this.setDateTimeStr(DateHelper.dateToDateTimeStr(createTime));
		}
	}

	public String getCreateDateStr() {
		return this.createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getDateTimeStr() {
		return dateTimeStr;
	}

	public void setDateTimeStr(String dateTimeStr) {
		this.dateTimeStr = dateTimeStr;
	}
}
