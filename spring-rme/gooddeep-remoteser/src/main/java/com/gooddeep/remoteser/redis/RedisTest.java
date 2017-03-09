package com.gooddeep.remoteser.redis;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * 单元测试
 * @author marker
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-redis.xml","classpath:config/spring/spring-mybatis.xml","classpath:config/spring/spring-mongodb.xml","classpath:config/spring/applicationContext.xml"})
public class RedisTest {

	static{
		
		PropertyConfigurator.configure("/home/lhy/Workspaces/MyEclipse_data/gooddeep/src/main/java/config/log4j.properties");;
	}

    @Autowired 
    private RankIngDao rankIngDao;


    @Test
    public void test() throws InterruptedException{
    	
    RankIng rankIng=new RankIng();
    rankIng.setRankInfo("排名第一");
    rankIng.setRankNum("rank1");
    	rankIngDao.add(rankIng);
    	//System.out.println(rankIngDao.get("rankIng:df573ca9b2b7497eacd8c75bb9f4b95e").toString());
       
    }
}