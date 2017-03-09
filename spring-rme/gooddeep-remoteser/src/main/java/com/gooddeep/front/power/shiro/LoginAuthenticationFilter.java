package com.gooddeep.front.power.shiro;
 
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
 

















import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.mongodb.dao.UserLoginRecordDao;
import com.gooddeep.remoteser.mongodb.model.UserLoginRecord;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.model.UserInfo;
import com.gooddeep.remoteser.p_member.service.UserInfoService;
import com.gooddeep.remoteser.p_member.service.UserService;
import com.gooddeep.remoteser.p_member.service.UserSignRecordService;
import com.gooddeep.remoteser.p_robot.service.RobotApiKeyService;


 
/**
 * 
 * @author <a href="mailto:ketayao@gmail.com">ketayao</a> 
 * Version 1.1.0
 * @since 2012-8-7 上午9:20:26
 */
 
public class LoginAuthenticationFilter extends FormAuthenticationFilter {
    Logger logger=LoggerFactory.getLogger(LoginAuthenticationFilter.class);

	@Resource
	private UserService userService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private RobotApiKeyService robotApiKeyService;
	@Autowired
	private UserLoginRecordDao userLoginRecordDao;
	@Autowired
	private UserSignRecordService userSignRecordService;
	/**
	 * 创建token时回调
	 */
    @Override
    protected AuthenticationToken createToken(ServletRequest request,
            ServletResponse response) {
    	
    /*    String username = getUsername(request);
        String password = getPassword(request);

        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
	    token.setRememberMe(true);*/
        return super.createToken(request, response);
    }
    
    /**
     * 没有认证时，回调
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
 
        //执行父类里的登录逻辑，调用Subject.login登录  

    	if(StringUtils.isNotEmpty(getUsername(request))&&StringUtils.isNotEmpty(getPassword(request)))
    	  return executeLogin(request, response);
    
          return super.onAccessDenied(request, response); 
      //  
        
    }
 
    /**
     * 用来判断用户是否已经认证，
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
 
    	 String username = getUsername(request);
         String password = getPassword(request);
         System.out.println(username+"   "+password);
    	return super.isAccessAllowed(request, response, mappedValue);
    }
    
    /**
     * 登陆成功时回调
     */
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
    	
    	 String username = getUsername(request);
    	User user = userService.findByAccount(username);
    	Map<String, Object> map=new HashMap<String, Object>();
    	UserInfo userInfo=userInfoService.list(map, null).get(0);
    	userInfo.setEmail(user.getEmail());
    	userInfo.setUserId(user.getId());
    	userInfo.setAccount(user.getAccount());
    	 boolean isSign=userSignRecordService.isSignToday(user.getId(),new Date() );
 		userInfo.setSignToday(isSign);//是否签到
    	userInfo.setRobotApiKey(robotApiKeyService.getObjByFkUserId(user.getId()).getApiKey());
    	
    	((HttpServletRequest)request).getSession().setAttribute("userInfo", userInfo);
    	UserLoginRecord userLoginRecord=new UserLoginRecord();
    	userLoginRecord.setFkUser(user.getId());
    	userLoginRecord.setCreateTime(new Date());
    	userLoginRecord.setId(UuidHelper.getRandomUUID());
    	userLoginRecordDao.insert(userLoginRecord);
        
    	
    	  logger.info("##############用户信息存入session,存入AppContext");
    	 return super.onLoginSuccess(token, subject, request, response);
    }
    
    /**
     * 登陆失败时回调
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
    		AuthenticationException e, ServletRequest request,
    		ServletResponse response) {
    	// TODO Auto-generated method stub
    	try {
			WebUtils.issueRedirect(request, response, getLoginUrl());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return false;
    }
}