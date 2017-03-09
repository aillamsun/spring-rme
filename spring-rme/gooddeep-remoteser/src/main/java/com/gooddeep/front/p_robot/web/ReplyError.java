package com.gooddeep.front.p_robot.web;

public class ReplyError {
	
	
	/**
	 * 错误代码
	 */
	private String error_code;
	/**
	 * 错误信息
	 */
	private String error_msg;
	
	
	public ReplyError(String error_code, String error_msg) {
		super();
		this.error_code = error_code;
		this.error_msg = error_msg;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	
	

}
