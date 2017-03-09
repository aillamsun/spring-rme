package com.gooddeep.remoteser.p_member.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
import com.gooddeep.front.commons.helper.DateTimeHelper;
import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 签到积分
 * @author lhy
 *
 */
public class UserSignRecord extends MemBaseBean{

 private Float signCredits;//迁到积分


	public Float getSignCredits() {
		return signCredits;
	}
	
	public void setSignCredits(Float signCredits) {
		this.signCredits = signCredits;
	}

}
