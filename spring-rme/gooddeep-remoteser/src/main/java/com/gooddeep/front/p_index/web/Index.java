package com.gooddeep.front.p_index.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.model.UserCredits;
import com.gooddeep.remoteser.p_member.model.UserInfo;
import com.gooddeep.remoteser.p_member.service.UserService;

@Controller
public class Index {
	
	String REQ_URL="/p_index";
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.htm")
	public String userCreditsIndex(Model model){
		UserInfo userInfo=AppContext.getUserInfo();
		if(userInfo!=null)
		{
			model.addAttribute("userInfo", userInfo);
		}
		return "index.jsp";	
	}

}
