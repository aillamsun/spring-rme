package com.gooddeep.dev.elasticsearch.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.gooddeep.dev.core.helper.SysConfig;
/**
 * Es初始化
 * @author lhy
 *
 */
@Component
public class EsInit {	
	    
	private ElasticsearchTemplate elasticsearchTemplate;  

	public ElasticsearchTemplate getElasticsearchTemplate() {
		return elasticsearchTemplate;
	}
	@Autowired
	public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
		this.elasticsearchTemplate = elasticsearchTemplate;
		 String indexsStr=SysConfig.getValue("elasticsearch.db");
	       if(indexsStr!=null)
	       {
	    	   String []indexs=indexsStr.split("&");
	    	   for(String index:indexs)
	    	   {
	    		   if (!elasticsearchTemplate.indexExists(index)) {  
	    	            elasticsearchTemplate.createIndex(index);  
	    	            }  
	    	   }
	        
	       }
		
	}
	

	
}
