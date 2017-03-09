package com.gooddeep.remoteser.mongodb.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gooddeep.remoteser.mongodb.dao.UserLoginRecordDao;
import com.gooddeep.remoteser.mongodb.model.UserLoginRecord;




/**
 * 单元测试
 * @author marker
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/spring-mongodb.xml")
public class MongoTemplateTest {


    @Autowired 
    private UserLoginRecordDao userLoginRecordDao;


    @Test
    public void test(){
    	
           UserLoginRecord ul=new UserLoginRecord();
           ul.setId("579c331a0a280f42660ed785");;
           Map<String,Object> map=new HashMap<String, Object>();
           map.put("ip", "1234567811");
           
           userLoginRecordDao.updateById(ul ); 
        
        System.out.println("ddddd");
       
    }
}