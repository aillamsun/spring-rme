package com.gooddeep.dev.redis.commons.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
  
/**  
 * AbstractBaseRedisDao 
 * @author http://blog.csdn.net/java2000_wl  
 * @version <b>1.0</b>  
 */   
@Component("abstractBaseRedisDao")
public class AbstractBaseRedisDao<K, V> {  

   
   private  static  RedisTemplate redisTemplate; 

    /** 
     * 设置redisTemplate 
     * @param redisTemplate the redisTemplate to set 
     */  
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {  
        this.redisTemplate = redisTemplate; 
        //RedisCache.setRedisConnectionFactory(redisTemplate.getConnectionFactory());
    }  
      
    /**
     * redis 模板
     * @return
     */
    public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}

	/** 
     * 获取 RedisSerializer 
     * <br>------------------------------<br> 
     */  
    public RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  

    }  
    /**
     * 获取 RedisConnectionFactory
     * @return
     */
    public RedisConnectionFactory getConnectionFactory() {  
        return redisTemplate.getConnectionFactory();  
    }  
    /**
     * 得到连接
     * @return
     */
    public RedisConnection getConnection() {  
        return redisTemplate.getConnectionFactory().getConnection();  
    }  
    
   
  
}  