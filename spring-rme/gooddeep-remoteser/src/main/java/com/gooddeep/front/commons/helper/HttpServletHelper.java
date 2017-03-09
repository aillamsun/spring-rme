package com.gooddeep.front.commons.helper;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpServletHelper {

	/**
	 * 向页面返回对象
	 * @param object
	 */
  public static void  writeReturn(Object object)
  {
	  HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	  try {
		response.getWriter().print(object);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
