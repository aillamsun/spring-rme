package com.gooddeep.remoteser.p_member.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;




























import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_member.mapper.UserCreditsMapper;
import com.gooddeep.remoteser.p_member.mapper.UserSignRecordMapper;
import com.gooddeep.remoteser.p_member.model.UserCredits;
import com.gooddeep.remoteser.p_member.model.UserSignRecord;
import com.gooddeep.remoteser.p_member.service.UserSignRecordService;

@Transactional
@Component(value="userSignRecordService")
public class UserSignRecordServiceImpl extends MemberBaseServiceImpl<UserSignRecord> implements UserSignRecordService{

	@Autowired
	private UserSignRecordMapper userSignRecordMapper;
	@Autowired
	private UserCreditsMapper userCreditsMapper;
	
	
	@Override
	protected MemberBaseMapper<UserSignRecord> getDao() {
		// TODO Auto-generated method stub
		return userSignRecordMapper;
	}
	@Override
	public boolean isSignToday(String userId, Date date) {
		List<UserSignRecord> list=userSignRecordMapper.listSignToday(userId, date);
		if(list!=null&&list.size()>0)
			return true;
		else
			return false;
	}
	
	
	/**
	 * 签到
	 * @param userId
	 * @return
	 */
	public void signToday(String userId)
	{
		UserSignRecord userSignRecord=new  UserSignRecord();
		userSignRecord.setFkUser(userId);
		userSignRecord.setSignCredits((float)0.1);
		userSignRecordMapper.insert(userSignRecord);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("fkUser", userId);
		List<UserCredits>list=userCreditsMapper.list(map, null);
		if(list!=null&&list.size()>0)
		{
			list.get(0).setCredits(list.get(0).getCredits()+userSignRecord.getSignCredits());
			userCreditsMapper.insert(list.get(0));
		}
		
	}

	
 
}