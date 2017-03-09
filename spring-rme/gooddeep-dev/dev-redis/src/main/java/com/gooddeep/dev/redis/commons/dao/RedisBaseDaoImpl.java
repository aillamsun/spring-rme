package com.gooddeep.dev.redis.commons.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.redis.commons.model.RedisBaseBean;
@Component("redisBaseDao")
public abstract class RedisBaseDaoImpl<T> extends AbstractBaseRedisDao<String, T>implements RedisBaseDao<T>{

    
	@Override
	public boolean add(final T t) {
		 boolean result = getRedisTemplate().execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> strSerializer = getRedisSerializer();  
	                RedisSerializer<T> jsonSerializer = new JacksonJsonRedisSerializer<T>(getEntityClass());
	                if(StringUtils.isEmpty(((RedisBaseBean)t).getId()))
	                   {
	                 String uuid=UuidHelper.getRandomUUID();
	                ((RedisBaseBean)t).setId(uuid);
	                   }
	                byte[] key  = strSerializer.serialize(createKey(((RedisBaseBean)t).getId())); 
	                byte[] value = jsonSerializer.serialize(t);  
	                return connection.setNX(key, value); 
	            }  
	        });  
	        return result;  
	}

	@Override
	public boolean add(final List<T> list) {
		Assert.notEmpty(list);  
        boolean result = getRedisTemplate().execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
               
                RedisSerializer<T> jsonSerializer = null;
                for (T  t : list) {  
                	if(jsonSerializer==null)
                		jsonSerializer=new JacksonJsonRedisSerializer<T>(getEntityClass());
                	   if(StringUtils.isEmpty(((RedisBaseBean)t).getId()))
	                   {
	                 String uuid=UuidHelper.getRandomUUID();
	                ((RedisBaseBean)t).setId(uuid);
	                   }
	                byte[] key  = serializer.serialize(createKey(((RedisBaseBean)t).getId())); 
                    byte[] name = jsonSerializer.serialize(t);  
                    connection.setNX(key, name);  
                }  
                return true;  
            }  
        }, false, true);  
        return result;  
	}
	
	@Override
	public boolean update(final List<T> list) {
	
		Assert.notEmpty(list);  
        boolean result = getRedisTemplate().execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
               
                RedisSerializer<T> jsonSerializer = null;
                for (T  t : list) {  
                	if(jsonSerializer==null)
                		jsonSerializer=new JacksonJsonRedisSerializer<T>(getEntityClass());
                	   if(StringUtils.isEmpty(((RedisBaseBean)t).getId()))
	                   {
	                 String uuid=UuidHelper.getRandomUUID();
	                ((RedisBaseBean)t).setId(uuid);
	                   }
	                byte[] key  = serializer.serialize(createKey(((RedisBaseBean)t).getId())); 
                    byte[] name = jsonSerializer.serialize(t);  
                    connection.setNX(key, name);  
                    
                }  
                return true;  
            }  
        }, false, true);  
        return result;  
	}
	
	
	@Override
	public Set<String> getkeys(String fuzzyKey){
		return getRedisTemplate().keys(fuzzyKey);
	}

	@Override
	public void delete(String key) {
		
		List<String> list = new ArrayList<String>();  
        list.add(key);  
        delete(list);  
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(List<String> keys) {
		getRedisTemplate().delete(keys);  
	}

	@Override
	public boolean update(final T t) {
		 
		   final String key=createKey(((RedisBaseBean)t).getId());
	        if (get(key)== null) {  
	            throw new NullPointerException("数据行不存在, key = " + key);  
	        }  
	       
	        boolean result = getRedisTemplate().execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	            	 RedisSerializer<T> jsonSerializer = new JacksonJsonRedisSerializer<T>(getEntityClass());
	                RedisSerializer<String> serializer = getRedisSerializer();  
	                byte[] key2  = serializer.serialize(key);  
	                byte[] value = jsonSerializer.serialize(t);  
	                connection.set(key2, value);  
	                return true;  
	            }  
	        });  
	        return result;  
	}

	@Override
	public T get(final String key) {
		
		
		T t = getRedisTemplate().execute(new RedisCallback<T>() {  
            public T doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                
                byte[] key2 = serializer.serialize(key); 
                RedisSerializer<T> jsonSerializer = new JacksonJsonRedisSerializer<T>(getEntityClass());
                byte[] value = connection.get(key2);  
                if (value == null) {  
                    return null;  
                }  
                T t = jsonSerializer.deserialize(value);  
                return t;
            }  
        });  
		  // System.out.println("##################"+((RedisBaseBean)t).getId());
        return t;  
	}
	
	/**
	 * 获得集合名字
	 * @return
	 */
	public abstract String getCollectionName();
	/**
	 * 实体类
	 * @return
	 */
	protected abstract Class<T> getEntityClass();
	
	/**
	 * 生产key  collection:uuid
	 * @return
	 */
	@Override
	public String createKey(String id){
		return getCollectionName()+":"+id;
		
	}
	

}
