package com.gooddeep.remoteser.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.gooddeep.remoteser.mongodb.helper.Customer;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.service.UserService;

public class ddd {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext factory=new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring/spring-redis.xml","classpath:config/spring/spring-mybatis.xml","classpath:config/spring/spring-mongodb.xml","classpath:config/spring/applicationContext.xml"});
		UserService userService=(UserService)factory.getBean("userService");
Thread.sleep(5000);
    	
    	Map map=new HashMap();
    	map.put("password", "123456");
    
    	System.out.println("\n\n**********************************************************");
    	List <User>u=userService.list(map, null);
    	System.out.println("#################################"+u.size());
    	System.out.println("\n\n**********************************************************");
    	User user=new User();
    	user.setPassword("12345611111111111");
    	user.setId("018a696aa6314c0aacf1d3e4cc4583bf");
    	userService.modifyById(user);
    	System.out.println("\n\n**********************************************************");
    	List <User>u1= userService.list(map, null);
      System.out.println("#################################"+u1.get(0).getAccount());
	}

}
