package com.gooddeep.dev.redis.commons.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.exceptions.JedisConnectionException;

import com.gooddeep.dev.redis.commons.dao.AbstractBaseRedisDao;

/**
 * 作为mybatis的缓存使用
 * @author lhy
 *
 */
public class RedisCache1  extends AbstractBaseRedisDao<String,Object> implements Cache
{
    private static final Logger logger = LoggerFactory.getLogger(RedisCache1.class);

     private final String id;
 /*    private static  RedisConnectionFactory redisConnectionFactory;

 
	

	public static RedisConnectionFactory getRedisConnectionFactory() {
		return redisConnectionFactory;
	}

	public static void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
		RedisCache.redisConnectionFactory = redisConnectionFactory;
	}

	public RedisConnection getConnection()
	{
		return redisConnectionFactory.getConnection();
	}*/
	/**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache1(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public void clear()
    {
     
        try
        {
        	getConnection().flushDb();
        	getConnection().flushAll();
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public Object getObject(Object key)
    {
    	logger.debug("######################得到key:"+key);
        Object result = null;
        
        try
        {
           // connection = redisConnection;
          
        // RedisSerializer<Object> jsonSerializer = new JdkSerializationRedisSerializer();
        	 RedisSerializer<Object> jsonSerializer =new GenericJackson2JsonRedisSerializer();
        	// RedisSerializer<Object> jsonSerializer = new JacksonJsonRedisSerializer<Object>(Object.class);
        	result = jsonSerializer.deserialize(getConnection().get(getRedisSerializer().serialize(key.toString())));
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock()
    {
        return this.readWriteLock;
    }

    @Override
    public int getSize()
    {
        int result = 0;
       
        try
        {
            result = Integer.valueOf(getConnection().dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
      
        return result;
    }

    @Override
    public void putObject(Object key, Object value)
    {
    	logger.debug("######################存入key:"+key+"##########value:"+value);
        try
        {
            @SuppressWarnings("unchecked")
			//	RedisSerializer<Object> jsonSerializer = new JdkSerializationRedisSerializer();
            RedisSerializer<Object> jsonSerializer =new GenericJackson2JsonRedisSerializer();
            //RedisSerializer<Object> jsonSerializer = new JacksonJsonRedisSerializer<Object>(Object.class);
            getConnection().set(getRedisSerializer().serialize(key.toString()), jsonSerializer.serialize(value));
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
      
    }

    @Override
    public Object removeObject(Object key)
    {
        Object result = null;
        try
        {
           
           // RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result =getConnection().expire(getRedisSerializer().serialize(key.toString()), 0);
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
   
        return result;
    }

    
    
  /*  public static void setCacheRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.redisConnection = redisTemplate.getConnectionFactory().redisConnection;
        RedisCache.redisTemplate=redisTemplate;
        RedisCache.stringSerializer=redisTemplate.getStringSerializer();
    }*/
   
   // private static RedisConnection redisConnection;
   //  private static RedisTemplate redisTemplate;
     //private static RedisSerializer<String> stringSerializer;

  



	

}