package com.gooddeep.front.p_robot.web;

public interface RobotFinal {
	
	final String ERROR_CODE_OK="ROBOT_000";
	final String ERROR_CODE_KEYWORD_NULL="ROBOT_001";
	final String ERROR_CODE_APIKEY_NULL="ROBOT_002";
	final String ERROR_CODE_REPLYSIZE_ERROR="ROBOT_003";
	final String ERROR_CODE_ISHEIGHT_ERROR="ROBOT_004";
	final String ERROR_CODE_OUTCALLNUM_ERROR="ROBOT_005";
	final String ERROR_CODE_NO_THISKEY_ERROR="ROBOT_006";
	
	final String ERROR_MSG_KEYWORD_NULL="keyword关键字为空";
	final String ERROR_MSG_APIKEY_NULL="robot_apiKey值为空";
	final String ERROR_MSG_REPLYSIZE_ERROR="reply_size设置错误";
	final String ERROR_MSG_ISHEIGHT_ERROR="is_height设置错误";
	final String ERROR_MSG_OUTCALLNUM_ERROR="超出调用次数限制";
	final String ERROR_MSG_NO_THISKEY_ERROR="没有此key";

}
