package com.gooddeep.remoteser.p_member.model;

import java.util.Date;

import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 用户当前积分情况
 * @author lhy
 *
 */
public class UserCredits extends MemBaseBean{
   

    private Date updateTime;

    private Float credits;



   
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Float getCredits() {
        return credits;
    }

    public void setCredits(Float credits) {
        this.credits = credits;
    }

   
}