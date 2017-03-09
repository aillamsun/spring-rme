package com.gooddeep.remoteser.p_robot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;










import org.springframework.ui.Model;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.elasticsearch.model.RobotAutoReply;
import com.gooddeep.remoteser.p_robot.mapper.RobotApiKeyMapper;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.p_robot.service.RobotApiKeyService;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;


@Transactional
@Component(value="robotApiKeyService")
public class RobotApiKeyServiceImpl extends MemberBaseServiceImpl<RobotApiKey> implements RobotApiKeyService{

	@Autowired
	private RobotApiKeyMapper roKeyMapper;
	@Override
	protected MemberBaseMapper<RobotApiKey> getDao() {
		// TODO Auto-generated method stub
		return roKeyMapper;
	}
	@Override
	public List<RobotKeyAndSetting> listApikeyAndSetting() {
		// TODO Auto-generated method stub
		return roKeyMapper.listApikeyAndSetting();
	}

	
    
}