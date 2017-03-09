package com.gooddeep.remoteser.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.service.UserService;




/**
 * 单元测试
 * @author marker
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mybatis.xml","classpath:config/spring/spring-redis.xml","classpath:config/spring/spring-mongodb.xml","classpath:config/spring/applicationContext.xml"})
public class RedisCacheTest {

	static{
		
		PropertyConfigurator.configure("/home/lhy/Workspaces/MyEclipse_data/gooddeep/src/main/java/config/log4j.properties");;
	}

    @Autowired 
    private UserService userService;


    @Test
    public void test() throws InterruptedException{
    	
    
    	Thread.sleep(5000);
    	
    	Map map=new HashMap();
    	map.put("password", "123456");
    
    	System.out.println("\n\n**********************************************************");
    	List <User>u=userService.list(map, null);
    	System.out.println("#################################"+u.size());
    	System.out.println("\n\n**********************************************************");
    	User user=new User();
    	user.setPassword("123456111111111114444444444444444");
    	user.setId("018a696aa6314c0aacf1d3e4cc4583bf");
    	userService.modifyById(user);
    	System.out.println("\n\n**********************************************************");
    	List <User>u1= userService.list(map, null);
    	for(User uu:u1)
    	{
    		System.out.println(uu.toString());
    	}
      System.out.println("#################################"+u1.size());
       
    }
}