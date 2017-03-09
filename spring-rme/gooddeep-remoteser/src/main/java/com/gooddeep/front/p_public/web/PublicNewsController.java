package com.gooddeep.front.p_public.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.remoteser.p_public.model.PublicHeadImage;
import com.gooddeep.remoteser.p_public.model.PublicNews;
import com.gooddeep.remoteser.p_public.service.PublicNewsService;

@Controller
@RequestMapping("/p_public/news")
public class PublicNewsController{
	
	String REQ_URL="/p_public/news";
	@Autowired
	private PublicNewsService publicNewsService;
	@RequestMapping("/news_index.shtml")
	public String imageIndex(Model model,BasePage<PublicNews>page){
		page=publicNewsService.findPage(new HashMap<String, Object>(), page, null);
		model.addAttribute("page", page);
		return "public/image_index.jsp";	
	}
	
	@RequestMapping("/add_news.shtml")
	public String addNews(Model model,PublicNews publicNews){
		publicNewsService.add(publicNews);
		return REQ_URL+"/image_index.shtml";	
	}
  
}