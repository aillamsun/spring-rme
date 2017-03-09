package com.gooddeep.dev.elasticsearch.commons.service.impl;

import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.gooddeep.dev.elasticsearch.commons.dao.EsNotEntityDao;

@Component("esNotEntityService")
public class EsNotEntityService {
	
	@Autowired
	private EsNotEntityDao esNotEntityDao;
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Object queryObjectById(String id) {
		
		return esNotEntityDao.queryObjectById(id);

	}

	/**
	 * 库和类型
	 * 
	 * @param indexs
	 * @param types
	 * @return
	 */
	public long count(String indexs[], String types[]) {
		
		return esNotEntityDao.count(indexs, types);
	}
	
	
	/**
	 * 清空types
	 * @param indexs
	 * @param types
	 * @return
	 */
	public boolean clearIndexTypes(String index, String types[]) {
		
		return esNotEntityDao.clearIndexTypes(index, types);
	}
	
	/**
	 * 清空 index
	 * @param index
	 * @return
	 */
	public boolean clearIndex(String index) {
	   
		return esNotEntityDao.clearIndex(index);
	}
	

	/**
	 * 查询返回一个Map对象
	 * @param esIndexName
	 * @param type
	 * @param fields
	 * @param content
	 * @param sortField
	 * @param order
	 * @param heightFields高亮字段
	 * @param from
	 * @param size
	 * @return
	 */

	public List<Map<String, Object>> queryForObject(String esIndexName,String type, String[] fields, String content, String sortField,SortOrder order,List<String> heightFields, int from, int size) {
		
		return esNotEntityDao.queryForObject(esIndexName, type, fields, content, sortField, order, heightFields, from, size);
	}

	public ElasticsearchTemplate getElasticsearchTemplate() {
		return esNotEntityDao.getElasticsearchTemplate();
	}



	public Client getEsClient() {
		return esNotEntityDao.getEsClient();
	}

	
	

}
