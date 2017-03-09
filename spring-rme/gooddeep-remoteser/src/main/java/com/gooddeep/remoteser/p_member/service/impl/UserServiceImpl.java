package com.gooddeep.remoteser.p_member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;














import com.gooddeep.dev.core.helper.StringHelper;
import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_member.mapper.UserMapper;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.service.UserService;

@Transactional
@Component(value="userService")
public class UserServiceImpl extends MemberBaseServiceImpl<User> implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	protected MemberBaseMapper<User> getDao() {
		// TODO Auto-generated method stub
		return userMapper;
	}
	@Override
	public User findByAccount(String account) {

	    Map<String,Object> map=new HashMap<String, Object>();
	    map.put("email", account);
	   List<User>list= userMapper.list(map, null);
	   User user=null;
	   if(list.size()>0)
		   user=list.get(0);
		return user;
	}
	@Override
	public int add(User u) {
		// TODO Auto-generated method stub
		u.setPassword(StringHelper.getMD5(u.getPassword()));
		return super.add(u);
	}

	
 
}