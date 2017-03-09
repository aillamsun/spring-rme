package com.gooddeep.dev.mongodb.commons.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseConditions;

@Mongodb
public interface MongoBaseDao<T> {

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(String id);

	/**
	 * 根据一些id删除
	 * 
	 * @param list
	 * @param objClass
	 * @return
	 */
	public int deleteBySomeId(List<String> list);

	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	public int insertList(List<T>list);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public T selectById(String id);

	/**
	 * 查询 不分页
	 * 
	 * @param conditionList
	 * @param objClass
	 * @return
	 */

	public List<T> list(MongoBaseConditions  conditions);

	/**
	 * 更新
	 * 
	 * @param t
	 * @return
	 */
	public int updateById(T t);
	
	/**
	 * 批量更新
	 * @param t
	 * @return
	 */
	public int updateListById(List<T> list);

	/**
	 * 分页查找
	 * @param conditionList
	 * @param page
	 * @param objClass
	 * @return
	 */
	public List<T> findPage(MongoBaseConditions  conditions,
			BasePage<T> page);

	/**
	 * 总页数
	 * 
	 * @param map
	 * @param sqlData
	 * @return
	 */
	public long rowsSize(MongoBaseConditions  conditions);

	/**
	 * 批量id查询
	 * @param list
	 * @param objClass
	 * @return
	 */
	public List<T> listBySomeId(List<String> list);

	
	/**
	 * 多条件查询
	 * @param conditionList
	 * @param objClass
	 * @return
	 */
	public int deleteMore(MongoBaseConditions  conditions);

	/**
	 * 查询所有
	 * @param objClass
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 查询所有记录条目
	 * @param objClass
	 * @return
	 */
	public long findAllCount();
	
/**
 * 删除集合
 * @param objClass
 */
	public void dropCollection();
	
/**
 * 创建集合
 * @param objClass
 */
	public void createCollection();

	/**
	 * 根据名字删除集合
	 * @param collectionName
	 */
	public void dropCollection(String collectionName);

	/**
	 * 根据名字创建集合
	 * @param collectionName
	 */
	public void createCollection(String collectionName);
	
	/**
	 * 查询条件
	 * 
	 * @param map
	 * @return
	 */
	public Query getQuery(MongoBaseConditions  conditions);

	
	/**
	 * 得到类型
	 * @return
	 */
	public Class<T> getEntityClass();

}
