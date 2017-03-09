package com.gooddeep.remoteser.p_member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;










import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_member.mapper.UserCreditsMapper;
import com.gooddeep.remoteser.p_member.model.UserCredits;
import com.gooddeep.remoteser.p_member.service.UserCreditsService;

@Transactional
@Component(value = "userCreditsService")
public class UserCreditsServiceImpl extends MemberBaseServiceImpl<UserCredits>
		implements UserCreditsService {

	@Autowired
	private UserCreditsMapper userCreditsMapper;

	@Override
	protected MemberBaseMapper<UserCredits> getDao() {
		// TODO Auto-generated method stub
		return userCreditsMapper;
	}

}