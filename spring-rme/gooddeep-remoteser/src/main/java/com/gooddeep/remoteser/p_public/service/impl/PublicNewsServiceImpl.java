package com.gooddeep.remoteser.p_public.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.SystemBaseServiceImpl;
import com.gooddeep.remoteser.p_public.mapper.PublicNewsMapper;
import com.gooddeep.remoteser.p_public.model.PublicNews;
import com.gooddeep.remoteser.p_public.service.PublicNewsService;

@Transactional
@Component(value="publicNewsService")
public class PublicNewsServiceImpl extends SystemBaseServiceImpl<PublicNews>implements PublicNewsService{

	@Autowired
	private PublicNewsMapper puMapper;
	@Override
	protected MemberBaseMapper<PublicNews> getDao() {
		// TODO Auto-generated method stub
		return puMapper;
	}
  
}