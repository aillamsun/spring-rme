package com.gooddeep.remoteser.mongodb.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BaseBean;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;

@Mongodb
@Document(collection="robot_call_day_num")
public class RobotCallNumDayRecord extends MongoBaseBean{
	/**
	 * 注意。id为robotDayCallNum的rcnrDayId
	 */
    private String fkUser;
    private Long amount;
    private String createDay;//2016-10-12
    private String apiKey;
 

	public String getFkUser() {
        return fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }

  
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

  

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }
    public void addRobotDatCallNum(RobotDayCallNum robotDayCalllNum)
    {
    	setAmount(robotDayCalllNum.getAmount());
    	setApiKey(robotDayCalllNum.getId());
    	setId(robotDayCalllNum.getRcnrDayId());
    	setCreateTime(robotDayCalllNum.getCreateTime());
    }
}