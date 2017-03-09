package com.gooddeep.front.commons.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gooddeep.front.commons.context.AppContext;




/**
 * 
 * @author Administrator 用于根据类型修改请求路径，和根据backgroupid过滤不同租户
 * 
 */
public class CharacterEncodingFilter implements Filter{

	public void doFilter(final ServletRequest req, final ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		chain.doFilter(req, resp);

	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}



	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
		

}
