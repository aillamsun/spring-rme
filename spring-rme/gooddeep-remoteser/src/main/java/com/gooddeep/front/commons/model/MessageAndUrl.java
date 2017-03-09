package com.gooddeep.front.commons.model;

/**
 * 调转到页面后显示的信息
 * @author lhy
 *
 */
public class MessageAndUrl {
	
	private String message;
	private String url;
	private String title;
	
	public MessageAndUrl(){
		super();
	}
	
	public MessageAndUrl(String title){
		this.title=title;
	}
	public MessageAndUrl(String message,String title)
			{
		     this.message = message;
		     this.title = title;
			}
	public MessageAndUrl(String message, String url,String title) {
		this.message = message;
		this.url = url;
		 this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
