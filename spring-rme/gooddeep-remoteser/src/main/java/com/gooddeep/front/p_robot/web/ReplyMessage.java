package com.gooddeep.front.p_robot.web;

import java.util.List;

public class ReplyMessage {
	/**
	 * 错误代码
	 */
	private String error_code;
	/**
	 * 关键字
	 */
	private String keyword;
	/**
	 * 回复内容
	 */
	private List<ask_reply> reply_msgs;
	

	public ReplyMessage(String error_code, String keyword,
			List<ask_reply> reply_msgs) {
		super();
		this.error_code = error_code;
		this.keyword = keyword;
		this.reply_msgs = reply_msgs;
	}
	public List<ask_reply> getReply_msgs() {
		return reply_msgs;
	}
	public void setReply_msgs(List<ask_reply> reply_msgs) {
		this.reply_msgs = reply_msgs;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	public static class ask_reply{
		
		
		public ask_reply(String ask_words, String reply_words) {
			super();
			this.ask_words = ask_words;
			this.reply_words = reply_words;
		}
		private String ask_words;
		private String reply_words;
		public String getAsk_words() {
			return ask_words;
		}
		public void setAsk_words(String ask_words) {
			this.ask_words = ask_words;
		}
		public String getReply_words() {
			return reply_words;
		}
		public void setReply_words(String reply_words) {
			this.reply_words = reply_words;
		}
		
		
	}

}
