package com.gooddeep.dev.elasticsearch.commons.service.impl;

import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.elasticsearch.commons.dao.EsBaseDao;
import com.gooddeep.dev.elasticsearch.commons.service.EsBaseService;

@Transactional
@Component(value = "esBaseService")
public   abstract class EsBaseServiceImpl<T> implements EsBaseService<T> {

	private Logger logger = LoggerFactory.getLogger(EsBaseService.class);

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private Client esClient;
	
	@Override
	public boolean insertOrUpdate(List<T> tList) {
		// TODO Auto-generated method stub
		return getDao().insertOrUpdate(tList);
	}

	@Override
	public boolean insertOrUpdate(T t) {
		// TODO Auto-generated method stub
		return getDao().insertOrUpdate(t);
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return getDao().deleteById(id);
	}

	@Override
	public boolean ping() {
		// TODO Auto-generated method stub
		return getDao().ping();
	}

	@Override
	public  List<T> queryList(Map<String, Object> filedContentMap,List<String> heightFields, String sortField, SortOrder order) {
		// TODO Auto-generated method stub
		return getDao().queryList(filedContentMap, heightFields, sortField, order);
	}
	@Override
	public BasePage<T> queryPage(Map<String, Object> filedContentMap,List<String> heightFields, String sortField, SortOrder order,
			BasePage<T> basePage) {
		// TODO Auto-generated method stub
		return getDao().queryPage(filedContentMap, heightFields, sortField, order, basePage);
	}

	@Override
	public T queryById(String id) {
		// TODO Auto-generated method stub
		return getDao().queryById(id);
	}

	
	public ElasticsearchTemplate getElasticsearchTemplate() {
		return elasticsearchTemplate;
	}


	public Client getEsClient() {
		return esClient;
	}


	@Override
	public boolean deleteByIds(List<String> idList) {
		// TODO Auto-generated method stub
		return getDao().deleteByIds(idList);
	}
	protected abstract EsBaseDao<T> getDao();

	@Override
	public boolean deleteByQuery(Map<String, Object> filedContentMap) {
		// TODO Auto-generated method stub
		return getDao().deleteByQuery(filedContentMap);
	}

	





}
