package com.gooddeep.front.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.p_member.model.UserInfo;



/**
 * 
 * @author Administrator 用于根据类型修改请求路径，和根据backgroupid过滤不同租户
 * 
 */
public class UrlAndGroupFilter implements Filter{

	public void doFilter(final ServletRequest req, final ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		 AppContext.setUserInfo(userInfo);
		String url = request.getRequestURI();
		System.out.println("请求路径：：：：：："+url);
		chain.doFilter(req, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 重新封装request包装类
	 * 
	 * @author Administrator
	 * 
	 */
	class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
		private String url;

		public MyHttpServletRequestWrapper(HttpServletRequest request,
				String url) {
			super(request);
			this.url = url;
		}

		@Override
		public String getServletPath() {// spring mvc 根据这个方法获得路径
			if (super.getDispatcherType().name().equals("REQUEST"))// 当是客服端请求服务器类型时，设置新url
				return url;
			else
				// 当不是请求类型时，此时为服务器跳转，转发为FORWARD等等，默认服务器跳转地址
				return super.getServletPath();
		}

	}

}
