package com.gooddeep.remoteser.p_public.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.SystemBaseServiceImpl;
import com.gooddeep.remoteser.p_public.mapper.PublicHeadImageMapper;
import com.gooddeep.remoteser.p_public.model.PublicHeadImage;
import com.gooddeep.remoteser.p_public.service.PublicHeadImageService;

@Transactional
@Component(value="publicHeadImageService")
public class PublicHeadImageServiceImpl extends SystemBaseServiceImpl<PublicHeadImage> implements PublicHeadImageService{

	@Autowired
	private PublicHeadImageMapper puMapper;
	@Override
	protected MemberBaseMapper<PublicHeadImage> getDao() {
		// TODO Auto-generated method stub
		return puMapper;
	}
   
}