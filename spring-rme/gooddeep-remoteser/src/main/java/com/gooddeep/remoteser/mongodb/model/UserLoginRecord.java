package com.gooddeep.remoteser.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
@Mongodb
@Document(collection="user_login_record")
public class UserLoginRecord extends MongoBaseBean{


    private String fkUser;


    private String ip;



   

   

    public String getFkUser() {
        return fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

   
}