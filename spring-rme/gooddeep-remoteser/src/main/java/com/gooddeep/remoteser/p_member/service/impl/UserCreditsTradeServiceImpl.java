package com.gooddeep.remoteser.p_member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_member.mapper.UserCreditsTradeMapper;
import com.gooddeep.remoteser.p_member.model.UserCreditsTrade;
import com.gooddeep.remoteser.p_member.service.UserCreditsTradeService;

@Transactional
@Component(value="userSpendCreditsService")
public class UserCreditsTradeServiceImpl extends MemberBaseServiceImpl<UserCreditsTrade> implements UserCreditsTradeService{

	@Autowired
	private UserCreditsTradeMapper userCreditsTradeMapper;
	
	@Override
	protected MemberBaseMapper<UserCreditsTrade> getDao() {
		// TODO Auto-generated method stub
		return userCreditsTradeMapper;
	}
	
	
   
}