package com.gooddeep.dev.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gooddeep.dev.core.model.BaseConditions;
import com.gooddeep.dev.core.model.BasePage;


public interface BaseMapper<T> {
	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id")String id);
	
	/**
	 * 根据一些id删除
	 * @param map
	 * @param sqlData
	 * @param idList
	 */
	public void deleteBySomeId(@Param("map")Map map,@Param("sqlData") String sqlData, @Param("list")List list);

	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */
	public int insert(T t);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public T selectById(@Param("id")String id);
	

	/**
	 * 查询 不分页
	 * 
	 * @param map
	 *            参数map
	 * @param sqlData
	 *            sql语句
	 * @return
	 */
	public List<T> list(@Param("map") Map<String,Object> map, @Param("sqlData") String sqlData);

	/**
	 * 更新
	 * 
	 * @param t
	 * @return
	 */
	public int updateById(T t);
	
	
	


	/**
	 * 分页查找
	 * 
	 * @param map
	 * @param page
	 * @param sqlData
	 * @return
	 */
	public List<T> findPage(@Param("map") Map<String,Object> map,
			@Param("page") BasePage<T> page, @Param("sqlData") String sqlData);

	/**
	 * 总页数
	 * 
	 * @param map
	 * @param sqlData
	 * @return
	 */
	public int rowsSize(@Param("map") Map<String,Object> map, @Param("sqlData") String sqlData);

	/**
	 * 用于in查询
	 * 
	 * @param map
	 * @param sqlData
	 * @param list
	 * @return
	 */
	public List<T> listBySomeId(@Param("map") Map<String,Object> map,
			@Param("sqlData") String sqlData, @Param("list") List<String> list);


	/**
	 * 根据查询条件删除 
	 * @param map
	 * @return
	 */
	public int deleteBySelect(@Param("map")Map<String,Object>map);
	
/*	*//**
	 * 根据条件更新
	 * @param t
	 * @return
	 *//*
	public int updateBySelect(@Param("map")Map<String,Object> map,T t);
	
	
	
	*//**
	 * 根据条件更新 各种条件
	 * @param conditions
	 * @return
	 *//*
	public int updateBySelectConditions(@Param("conditions")BaseConditions  conditions);*/
	/**
	 * 根据条件查询记录数  各种条件
	 * @param list
	 * @param sql
	 * @return
	 */
	public int rowsSizeConditions(@Param("conditions")BaseConditions conditions, @Param("sqlData")String sql);
	
	/**
	 * 根据条件删除  各种条件
	 * @param map
	 * @param sql
	 * @return
	 */
	public List<T> listConditions(@Param("conditions")BaseConditions  conditions, @Param("sqlData")String sql);

	/**
	 * 根据条件分页  各种条件
	 * @param list
	 * @param page
	 * @param sql
	 * @return
	 */
	public BasePage<T> findPageConditions(@Param("conditions")BaseConditions  conditions,@Param("page") BasePage<T> page, @Param("sqlData")String sql);
	

	/**
	 * 根据查询条件删除 各种条件
	 * @param map
	 * @return
	 */
	public int deleteBySelectConditions(@Param("conditions")BaseConditions  conditions);
	
	

	
}


