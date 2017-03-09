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

public class CopyOfddd {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext factory=new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring/spring-redis.xml","classpath:config/spring/spring-mybatis.xml","classpath:config/spring/spring-mongodb.xml","classpath:config/spring/applicationContext.xml"});
		RankIngDao rankIngDao=(RankIngDao)factory.getBean("rankIngDao");
		System.out.println(rankIngDao.get("rankIng:758c9f7cd2644e50acda5c0478ea1546").getRankInfo());
	}

}
