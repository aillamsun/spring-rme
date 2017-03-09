package com.gooddeep.remoteser.p_member.model;

import java.util.Date;

import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 会员信息
 * @author lhy
 *
 */
public class UserInfo extends MemBaseBean {

	private String nick;

	private String name;

	private String phone;

	private String sex;

	private String birthday;

	private String martial;

	private String edu;

	private String eduSchool;

	private String profession;

	private String workTime;

	private Date updateTime;

	private String headImgUrl;
	
	private boolean isSignToday;//是否签到
	
	

	/**
	 * 自定义变量
	 */
	private String email;

	private String account;


	private String userId;
	
	private String robotApiKey;//apikey

	public String getUserId() {
		return userId;
	}
	
	

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSignToday() {
		return isSignToday;
	}



	public void setSignToday(boolean isSignToday) {
		this.isSignToday = isSignToday;
	}



	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMartial() {
		return martial;
	}

	public void setMartial(String martial) {
		this.martial = martial;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getEduSchool() {
		return eduSchool;
	}

	public void setEduSchool(String eduSchool) {
		this.eduSchool = eduSchool;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	
	


	public String getRobotApiKey() {
		return robotApiKey;
	}



	public void setRobotApiKey(String robotApiKey) {
		this.robotApiKey = robotApiKey;
	}



	public void addUserOtherInfo(UserOtherInfo userOtherInfo)
	{
		setUserId(userOtherInfo.getUserId());
		setEmail(userOtherInfo.getEmail());
		setAccount(userOtherInfo.getAccount());
		setRobotApiKey(robotApiKey);;
		setSignToday(userOtherInfo.isSignToday());
	}
	
	public UserOtherInfo getUserOtherInfo()
	{
		UserOtherInfo userOtherInfo=new UserOtherInfo();
		userOtherInfo.setAccount(getAccount());
		userOtherInfo.setEmail(getEmail());
		userOtherInfo.setRobotApiKey(getRobotApiKey());
		userOtherInfo.setUserId(getUserId());
		userOtherInfo.setSignToday(isSignToday());
		
		return userOtherInfo;
	}
	
	public static class UserOtherInfo {
		
		/**
		 * 自定义变量
		 */
		private String email;

		private String account;

		private String userId;
		private String robotApiKey;
		
		private boolean isSignToday;
		
		public boolean isSignToday() {
			return isSignToday;
		}
		public void setSignToday(boolean isSignToday) {
			this.isSignToday = isSignToday;
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
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getRobotApiKey() {
			return robotApiKey;
		}
		public void setRobotApiKey(String robotApiKey) {
			this.robotApiKey = robotApiKey;
		}
	
		
	}

}