package com.gooddeep.remoteser.mongodb.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class gg {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:config/spring/spring-mongodb.xml");
		MongoTemplate m=(MongoTemplate)factory.getBean("mongoTemplate");
		Customer c = new Customer();
        c.setFirstName("wu");
        c.setLastName("wei");
        m.insert(c); 
        System.out.println("dddddddddd");
	}

}
