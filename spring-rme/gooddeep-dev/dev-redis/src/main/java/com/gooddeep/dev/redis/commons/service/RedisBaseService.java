package com.gooddeep.dev.redis.commons.service;

import java.util.List;

public interface RedisBaseService<T> {  
      
    /** 
     * 新增 
     * <br>------------------------------<br> 
     * @param user 
     * @return 
     */  
    boolean add(T t);  
      
    /** 
     * 批量新增 使用pipeline方式 
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
     * 修改 
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
}  