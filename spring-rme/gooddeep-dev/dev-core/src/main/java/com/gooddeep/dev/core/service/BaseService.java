package com.gooddeep.dev.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gooddeep.dev.core.model.BaseConditions;
import com.gooddeep.dev.core.model.BasePage;

/**
 * 基础服务类
 * @author lhy
 *
 * @param <T>
 */
public interface BaseService<T>  {
	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public int removeById(String id);
	
	/**
	 * 根据查询条件删除 
	 * @param map
	 * @return
	 */
	public int removeBySelect(Map<String,Object>map);
	
	/**
	 *  根据一些id删除
	 * @param map
	 * @param sql
	 * @param idList
	 */
	public void removeBySomeId(Map<String,Object> map, String sql, List<Object> idList);

	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */
	public int add(T t);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id);
	

	/**
	 * 根据 sql 获得参数map查找 不分页
	 * @param map
	 * @param sql
	 * @return
	 */
	public List<T> list(Map<String,Object> map, String sql);
	
	
	/**
	 * 修改
	 * 
	 * @param t
	 * @return
	 */
	public int modifyById(T t);

	/**
	 * 分页查找
	 * 
	 * @param map
	 *            参数
	 * @param page
	 *            分页对象
	 * @param sql
	 *            sql查找
	 * @return
	 */
	public BasePage<T> findPage(Map<String,Object> map, BasePage<T> page, String sql);


	/**
	 * 用于 in 查询
	 * @param map
	 * @param sqlData
	 * @param list
	 * @return
	 */
	public List<T> listBySomeId(Map <String,Object>map, String sqlData, List<String> list);

	/**
	 * 根据条件查询有几条记录
	 * 
	 * @param map
	 * @param sql
	 * @return
	 */
	public int rowsSize(Map<String,Object> map, String sql);
	
	/**
	 * 根据条件查询记录数  各种条件
	 * @param list
	 * @param sql
	 * @return
	 */
	public int rowsSizeConditions(BaseConditions conditions, String sql);
	
	/**
	 * 根据条件删除  各种条件
	 * @param map
	 * @param sql
	 * @return
	 */
	public List<T> listConditions(BaseConditions conditions, String sql);

	/**
	 * 根据条件分页  各种条件
	 * @param list
	 * @param page
	 * @param sql
	 * @return
	 */
	public BasePage<T> findPageConditions(BaseConditions  conditions, BasePage<T> page, String sql);
	

	/**
	 * 根据查询条件删除 各种条件
	 * @param map
	 * @return
	 */
	public int removeBySelectConditions(BaseConditions  conditions);
	
/*	*//**
	 * 根据条件更新
	 * @param t
	 * @return
	 *//*
	public int modifyBySelect(Map<String,Object> map,T t);
	
	*//**
	 * 根据条件更新 各种条件
	 * @param conditions
	 * @return
	 *//*
	public int modifyBySelectConditions(BaseConditions  conditions);*/
}
