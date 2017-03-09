package com.gooddeep.remoteser.mongodb.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BaseBean;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
import com.gooddeep.front.commons.helper.DateTimeHelper;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;

@Mongodb
@Document(collection="robot_call_year_num")
public class RobotCallNumYearRecord extends MongoBaseBean{
	/**
	 * 注意。id由mongodb自动生成
	 */
    private String fkUser;
    private Long amount;
    private String createYear;//2016
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

    public String getCreateYear() {
		return createYear;
	}

	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}
	
	 /**
	  * 添加对象
	  * @param userCallNum
	  */
		public void addUserCallNum(UserCallNum userCallNum)
		{
			setAmount(userCallNum.getAmount());
			setApiKey(userCallNum.getApiKey());
			setId(UuidHelper.getRandomUUID());
			setCreateYear(DateTimeHelper.getLastYear(new Date()));
		}

}