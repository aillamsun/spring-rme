package com.gooddeep.remoteser.p_member.model;

import java.util.Date;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 会员用户账户
 * @author lhy
 *
 */
public class User extends MemBaseBean{
  

    private String email;

    private String account;

    private String password;
    
    private Date lastLoginTime;
    
    
    /**
     * 临时变量
     */
    private long registerTime;//开始注册的时间
    private String registerId;//注册的id

   

  

    public long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(long registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		
		this.registerId = registerId;
	}

	
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	@Override
	public String toString() {
		return "User [email=" + email + ", account=" + account + ", password="
				+ password + ", lastLoginTime=" + lastLoginTime + "]";
	}

  
}