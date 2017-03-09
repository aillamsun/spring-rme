package com.gooddeep.remoteser.p_robot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;







import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_robot.mapper.RobotSettingMapper;
import com.gooddeep.remoteser.p_robot.model.RobotSetting;
import com.gooddeep.remoteser.p_robot.service.RobotSettingService;

@Transactional
@Component(value="robotSettingService")
public class RobotSettingServiceImpl extends MemberBaseServiceImpl<RobotSetting>implements RobotSettingService{

	@Autowired
	private RobotSettingMapper robMapper;
	@Override
	protected MemberBaseMapper<RobotSetting> getDao() {
		// TODO Auto-generated method stub
		return robMapper;
	}
   
}