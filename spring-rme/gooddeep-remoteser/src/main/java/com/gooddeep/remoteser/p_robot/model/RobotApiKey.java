package com.gooddeep.remoteser.p_robot.model;

import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 用户调用api的key
 * @author lhy
 *
 */
public class RobotApiKey extends MemBaseBean{
  

    private String apiKey;



    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

  
}