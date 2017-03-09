package com.gooddeep.dev.elasticsearch.commons.service;

import java.util.List;
import java.util.Map;

import org.elasticsearch.search.sort.SortOrder;

import com.gooddeep.dev.core.model.BasePage;

public interface EsBaseService <T>{
	
	/**
	   * 插入或等新，需要有id，id需要自己生成
	   * @param tList
	   * @return
	   */
	    public boolean insertOrUpdate(List<T> tList) ;  
	  
	  /**
	   * 插入或更新
	   * @param t
	   * @return
	   */
	    public boolean insertOrUpdate(T t) ; 
	  
	    /**
	     * 删除
	     * @param id
	     * @return
	     */
	    public boolean deleteById(String id);
	  
	  /**
	   * 检查健康状态   
	   * @return
	   */
	    public boolean ping();
	  
	    /**
	     * 安条件查询 分页basePage.getRecordNo(), basePage.getPageSize()
	     * @param filedContentMap
	     * @param heightFields
	     * @param sortField
	     * @param order
	     * @param basePage
	     * @return
	     */
	    public BasePage<T> queryPage(Map<String,Object> filedContentMap, List<String> heightFields, String sortField, SortOrder order, BasePage<T>basePage);
	    
	    /**
	     * list
	     * @param filedContentMap
	     * @param heightFields
	     * @param sortField
	     * @param order
	     * @param basePage
	     * @return
	     */
	    public List<T> queryList(Map<String,Object> filedContentMap, List<String> heightFields, String sortField, SortOrder order);
	    

	    
	    /**
	     * 本类查询
	     * @param id
	     * @return
	     */
	    public T queryById(String id);
	   
	    /**
	     * 查询删除
	     * @param filedContentMap
	     * @return
	     */
	    public boolean deleteByQuery(Map<String,Object> filedContentMap);
	    
	    /**
	     * 通过ids 删除
	     * @param idList
	     * @return
	     */
	    public boolean deleteByIds(List<String> idList);

}
