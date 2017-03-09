package com.gooddeep.dev.redis.commons.dao;

import java.util.List;
import java.util.Set;

public interface RedisBaseDao<T> {  
      
    /** 
     * 新增  数据库中有时，不会进行任何操作
     * <br>------------------------------<br> 
     * @param user 
     * @return 
     */  
    boolean add(T t);  
    
    
      
    /** 
     * 批量新增  数据库中有时，不会进行任何操作  使用pipeline方式 
     * <br>------------------------------<br> 
     * @param list 
     * @return 
     */  
    boolean add(List<T> list);  
      
    /** 
     * 删除 
     * <br>------------------------------<br> 
     * @param key 
     */  
    void delete(String key);  
      
    /** 
     * 删除多个 
     * <br>------------------------------<br> 
     * @param keys 
     */  
    void delete(List<String> keys);  
      
    /** 
     * 修改 ，，有的时候更新，没有的时候添加
     * <br>------------------------------<br> 
     * @param user 
     * @return  
     */  
    boolean update(T t);  
  
    /** 
     * 通过key获取 
     * <br>------------------------------<br> 
     * @param keyId 
     * @return  
     */  
    T get(String keyId);  
	
    /**
     * 更新，有的时候更新，没有的时候添加
     * @param list
     * @return
     */
    public boolean update(final List<T> list);
    
    /**
     * 模糊查询key
     * @param fuzzyKey
     * @return
     */
    Set<String> getkeys(String fuzzyKey);
	 
	 /**
	  * 生产key的方法
	  * @param id
	  * @return
	  */
	 public String createKey(String id);
	 
	 /**
	  * 或的表名
	  * @return
	  */
	 public String getCollectionName();
}  