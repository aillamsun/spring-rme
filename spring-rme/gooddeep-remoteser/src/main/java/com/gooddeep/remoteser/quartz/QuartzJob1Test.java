package com.gooddeep.remoteser.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 单元测试
 * @author lhy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-quartz.xml"})
public class QuartzJob1Test {

	
	
	static{
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
	    JoranConfigurator configurator = new JoranConfigurator();
	    configurator.setContext(lc);
	    lc.reset();
	    try {
	        configurator.doConfigure("/home/lhy/Workspaces/MyEclipse_data/gooddeep/src/main/java/config/logback.xml");//加载logback配置文件
	   } catch (JoranException e) {
	        e.printStackTrace();
	    }
		//PropertyConfigurator.configure("/home/lhy/Workspaces/MyEclipse_data/gooddeep/src/main/java/config/log4j.properties");//加载logj配置文件
	}

  

    Logger logger=LoggerFactory.getLogger(QuartzJob1Test.class);
    @Test
    public void test() throws InterruptedException{
    	logger.debug("###################************************####quartz测试启动");
    	while (true){
    		Thread.sleep(2000);
    	}
    	

    }
}
