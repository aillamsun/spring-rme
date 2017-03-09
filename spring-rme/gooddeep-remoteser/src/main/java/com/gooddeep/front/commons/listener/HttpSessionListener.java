package com.gooddeep.front.commons.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.p_member.model.UserInfo;


/**
 * shiroSession监听器
 * 使用shiro之后载web.xml中配置不再起作用，应该载shiro.xml中配置
 * @author lhy
 * 
 * 
 */
public class HttpSessionListener implements SessionListener {  
	
	Logger logger=LoggerFactory.getLogger(HttpSessionListener.class);
	
	
	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		logger.info("#################");
		
	}

	@Override
	public void onStop(Session session) {
		logger.info("#################");
		
	}

	@Override
	public void onExpiration(Session session) {

		logger.info("#################");
		
	}
	/**
	 * 添加Session
	 */
	/*@Override
	public void attributeAdded(HttpSessionBindingEvent event) {  
        if ("userInfo".equals(event.getName())) {  
           
        }  
    }  
  
	*//**
	 * 替代Session
	 *//*
	@Override
    public void attributeReplaced(HttpSessionBindingEvent event) {  
        if ("userInfo".equals(event.getName())) {  
        	logger.info("#############session变量userInfo值改变，重置AppContext");
        	AppContext.setUserInfo((UserInfo)event.getSession().getAttribute("userInfo"));
        }  
    }

    *//**
     * 销毁Session
     *//*
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("userInfo".equals(event.getName())){
			
		}  
	}     */

	
}  