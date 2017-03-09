package com.gooddeep.front.p_public.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.p_public.model.PublicHeadImage;
import com.gooddeep.remoteser.p_public.service.PublicHeadImageService;
import com.gooddeep.remoteser.p_robot.model.RobotSetting;

@Controller
@RequestMapping("/p_public/headImage")
public class PublicHeadImageController{
	
	@Autowired
	private PublicHeadImageService publicHeadImageService;
	
	String REQ_URL="/p_public/headImage";
	/**
	 * 首页图片首页列表
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/image_index.shtml")
	public String imageIndex(Model model,BasePage<PublicHeadImage>page){
		page=publicHeadImageService.findPage(new HashMap<String, Object>(), page, null);
		model.addAttribute("page", page);
		return "public/image_index.jsp";	
	}
	
	/**
	 * 添加首页图片
	 * @param model
	 * @param publicHeadImage
	 * @return
	 */
	@RequestMapping("/add_image.shtml")
	public String addImage(Model model,PublicHeadImage publicHeadImage){
		publicHeadImageService.add(publicHeadImage);
		return REQ_URL+"/image_index.shtml";	
	}
   
}