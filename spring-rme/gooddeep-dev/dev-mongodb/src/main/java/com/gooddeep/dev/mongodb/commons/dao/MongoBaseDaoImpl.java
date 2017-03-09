package com.gooddeep.dev.mongodb.commons.dao;
import java.util.HashMap;
import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;  
import org.springframework.data.mongodb.core.query.Query;  
import org.springframework.data.mongodb.core.query.Update;  

import com.gooddeep.dev.core.helper.PropertyHelper;
import com.gooddeep.dev.core.model.BaseConditions.BaseCriteria;
import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.mongodb.commons.export.Mongodb;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseBean;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseConditions;
import com.mongodb.WriteResult;
 
@Mongodb
public  abstract class  MongoBaseDaoImpl<T> implements MongoBaseDao<T>{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}


	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}


	@Override
	public int deleteById(String id) {
		MongoBaseBean mb = new MongoBaseBean();
		mb.setId(id);
	    WriteResult wr=mongoTemplate.remove((T)mb);  
		return wr.getN();
	}

	
	/**
	 * 聚合
	 */
/*	public long getNewMessageCount(MongoBaseConditions  conditions){  
        Long total = 0l;  
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("toUid").is(userId).and("appId").is(appId)),Aggregation.group("toUid").sum("unreadCount").as("total") );  
          
        AggregationResults<T> ar = mongoTemplate.aggregate(aggregation, getEntityClass(), getEntityClass());  
        List<T> list = ar.getMappedResults();  
        if(list.size() > 0){  
            total = list.get(0).total;  
        }  
        return total;  
    }  */
	
	
	@Override
	public int deleteBySomeId(List<String> list) {
		
		Query query = new Query();  
		for(String id:list)
		{
				  Criteria criteria = Criteria.where("id").is(id);  
		            query.addCriteria(criteria);  
		}
		WriteResult wr=mongoTemplate.remove(query, getEntityClass());
        return   wr.getN();
	}

	@Override
	public int insert(T t) {
		mongoTemplate.insert(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T selectById(String id) {
		return mongoTemplate.findById(id,getEntityClass());
	}

	@Override
	public List<T> list(MongoBaseConditions  conditions) {
		
		return mongoTemplate.find(getQuery(conditions), getEntityClass());
	}
	

	@Override
	public int insertList(List<T> list) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(list, getEntityClass());
		return list.size();
	}

	@Override
	public int updateListById(List<T> list) {

		for(T t :list)
		{
			updateById(t);
		}
		return list.size();
	}

	@Override
	public int updateById(T t) {

		     Criteria criteria = Criteria.where("id").is(((MongoBaseBean)t).getId());  
	        Query query = new Query(criteria);  
	  
	        Update update=new Update();
	        Map<String,Object> map=PropertyHelper.recursiveNotNull(t, t.getClass(), new HashMap<String, Object>());
	          for(String key:map.keySet())
	          {
	        	  if(map.get(key)!=null)
	        		  update.set(key, map.get(key));
	          }
	        WriteResult wr=mongoTemplate.updateFirst(query, update, t.getClass());  
		return wr.getN();
	}

	@Override
	public List<T> findPage(MongoBaseConditions  conditions, BasePage<T> page) {
		// TODO Auto-generated method stub
		   Query query = getQuery(conditions);  
        query.skip(page.getRecordNo());  
        query.limit(page.getPageSize());  
        return mongoTemplate.find(query, getEntityClass());  
	}

	@Override
	public long rowsSize(MongoBaseConditions  conditions) {
		   Query query = getQuery(conditions);  
        return mongoTemplate.count(query, getEntityClass());  

	}

	@Override
	public List<T> listBySomeId(List<String> list) {
		Query query = new Query();  
		for(String id:list)
		{
			
				  Criteria criteria = Criteria.where("id").is(id);  
		            query.addCriteria(criteria);  
		}
		
		return mongoTemplate.find(query, getEntityClass());
	}
	


	@Override
	public List<T> findAll() {
		
		return mongoTemplate.findAll(getEntityClass());
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return mongoTemplate.count(new Query(), getEntityClass());
	}  
	
	
	public void dropCollection()
	{
		mongoTemplate.dropCollection(getEntityClass());
		
	}
	
	public void createCollection()
	{
		mongoTemplate.createCollection(getEntityClass());
	}
	public void dropCollection(String collectionName)
	{
		mongoTemplate.dropCollection(collectionName);
		
	}
	
	public void createCollection(String collectionName)
	{
		mongoTemplate.createCollection(collectionName);
	}

	@Override
	public int deleteMore(MongoBaseConditions  conditions) {
		// TODO Auto-generated method stub
		return mongoTemplate.remove(getQuery(conditions), getEntityClass()).getN();
	}

	
	
	

	/**
	 * 查询条件
	 * @param map
	 * @return
	 */
	@Override
	public Query getQuery(MongoBaseConditions conditions) {  
        
		 Query query = new Query();  
	  //  Criteria criteria=new Criteria();
		 
		for(BaseCriteria condition:conditions.getConditions())
		{
			String conValue=condition.getCondition();
			  if(conValue.equals("=")){
				  Criteria criteria = Criteria.where(condition.getProName()).is(condition.getValue());  
		         query.addCriteria(criteria);
		         }
		      else if(conValue.equals("between"))
		    		  {
		    	      Criteria criteria = Criteria.where(condition.getProName()).gte(condition.getValue()).lte(condition.getSecondValue());  
			         query.addCriteria(criteria);
		    		  }
		      else if(conValue.equals(">"))
		      {

		    	  Criteria criteria = Criteria.where(condition.getProName()).gt(condition.getValue());  
			         query.addCriteria(criteria);
		      }
		
		      else if(conValue.equals(">="))
		      {
		    	  Criteria criteria = Criteria.where(condition.getProName()).gte(condition.getValue());  
			         query.addCriteria(criteria);
		      }
		      else if(conValue.equals("<"))
		      {
		    	  Criteria criteria = Criteria.where(condition.getProName()).lt(condition.getValue());  
			         query.addCriteria(criteria);
		      }
		      else if(conValue.equals("<="))
		      {
		    	  Criteria criteria = Criteria.where(condition.getProName()).lte(condition.getValue());  
			         query.addCriteria(criteria);
		      }
			  
		      else if(conValue.equals("!="))
		      {
		    	  Criteria criteria = Criteria.where(condition.getProName()).ne(condition.getValue());  
			         query.addCriteria(criteria);
			         
		      }
		}
        return query;  
    }

	public abstract Class<T> getEntityClass();

	
    
}
