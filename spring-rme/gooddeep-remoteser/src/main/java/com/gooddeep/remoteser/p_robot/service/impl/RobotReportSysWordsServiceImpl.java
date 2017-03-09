package com.gooddeep.remoteser.p_robot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_robot.mapper.RobotReportSysWordsMapper;
import com.gooddeep.remoteser.p_robot.model.RobotReportSysWords;
import com.gooddeep.remoteser.p_robot.service.RobotReportSysWordsService;

@Transactional
@Component(value="robotReportSysWordsService")
public class RobotReportSysWordsServiceImpl extends MemberBaseServiceImpl<RobotReportSysWords> implements RobotReportSysWordsService{

	@Autowired
	private RobotReportSysWordsMapper roMapper;
	@Override
	protected MemberBaseMapper<RobotReportSysWords> getDao() {
		// TODO Auto-generated method stub
		return roMapper;
	}
 
}