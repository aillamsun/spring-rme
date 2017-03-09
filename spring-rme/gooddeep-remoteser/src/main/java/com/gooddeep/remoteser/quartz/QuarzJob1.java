package com.gooddeep.remoteser.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooddeep.remoteser.elasticsearch.dao.RobotAutoReplyDao;
import com.gooddeep.remoteser.elasticsearch.model.RobotAutoReply;
import com.gooddeep.remoteser.mongodb.dao.UserLoginRecordDao;
import com.gooddeep.remoteser.mongodb.model.UserLoginRecord;
import com.gooddeep.remoteser.redis.RankIng;
import com.gooddeep.remoteser.redis.RankIngDao;

/**
 * job
 * 
 * @author lhy
 * 
 */
public class QuarzJob1 {
	@Autowired
	private RankIngDao rankIngDao;
	@Autowired
	private UserLoginRecordDao userLoginRecordDao;

	@Autowired
	private RobotAutoReplyDao autoReplyService;
	Logger logger=LoggerFactory.getLogger(QuarzJob1.class);

	public void doWork() {
		RankIng rankIng = new RankIng();
		rankIng.setRankInfo("排名第一");
		rankIng.setRankNum("rank1");
		boolean b=rankIngDao.add(rankIng);
		logger.debug("######################Redis:"+b);
		
		

		UserLoginRecord ul = new UserLoginRecord();
		ul.setId("579c331a0a280f42660ed785");
		ul.setIp("1234567890");
		int mi=userLoginRecordDao.updateById(ul ); 
		logger.debug("######################Mogo:"+mi);
		
		
		List<String> list0=new ArrayList<String>();
		list0.add("keyword");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("keyword", "三星中蝙蝠侠特别版");
		List<RobotAutoReply> list = autoReplyService.queryList(map2,
				list0, null, null);
		for (RobotAutoReply autoReply : list) {
			logger.debug("######################Es:"+autoReply.toString());
		}

	}

}
