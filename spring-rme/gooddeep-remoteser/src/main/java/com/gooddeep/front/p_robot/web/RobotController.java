package com.gooddeep.front.p_robot.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BaseConditions.BaseCriteria;
import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.dev.mongodb.commons.model.MongoBaseConditions;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.front.commons.global.GlobalFinal;
import com.gooddeep.front.p_robot.helper.ExcelHelper;
import com.gooddeep.front.p_robot.web.ReplyMessage.ask_reply;
import com.gooddeep.remoteser.elasticsearch.dao.RobotAutoReplyDao;
import com.gooddeep.remoteser.elasticsearch.dao.RobotSysAutoReplyDao;
import com.gooddeep.remoteser.elasticsearch.model.RobotAutoReply;
import com.gooddeep.remoteser.elasticsearch.model.RobotSysAutoReply;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumDayRecordDao;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumMonthRecordDao;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumYearRecordDao;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumDayRecord;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumMonthRecord;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumYearRecord;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.p_robot.model.RobotSetting;
import com.gooddeep.remoteser.p_robot.service.RobotApiKeyService;
import com.gooddeep.remoteser.p_robot.service.RobotSettingService;
import com.gooddeep.remoteser.redis.dao.RobotAllCallNumDao;
import com.gooddeep.remoteser.redis.dao.RobotDayCallNumDao;
import com.gooddeep.remoteser.redis.dao.RobotKeyAndSettingDao;
import com.gooddeep.remoteser.redis.model.RobotAllCallNum;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;
import com.gooddeep.remoteser.redis.model.RobotKeyAndSetting;

@Controller
@RequestMapping("/p_robot/robot")
public class RobotController {
	String REQ_URL = "p_robot/robot";
	@Autowired
	private RobotApiKeyService robotApiKeyService;
	@Autowired
	private RobotAutoReplyDao robotAutoReplyDao;
	@Autowired
	private RobotSysAutoReplyDao robotSysAutoReplyDao;
	@Autowired
	private RobotSettingService robotSettingService;
	@Autowired
	private RobotKeyAndSettingDao robotKeyAndSettingDao;
	@Autowired
	private RobotDayCallNumDao robotDayCallNumDao;
	@Autowired
	private RobotAllCallNumDao robotAllCallNumDao;
	@Autowired
	private RobotCallNumDayRecordDao robotCallNumDayRecordDao;
	@Autowired
	private RobotCallNumMonthRecordDao robotCallNumMonthRecordDao;
	@Autowired
	private RobotCallNumYearRecordDao robotCallNumYearRecordDao;

	@RequestMapping("/robot_index.shtml")
	public String robotIndex(Model model) {
		RobotApiKey robotApiKey = robotApiKeyService
				.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		model.addAttribute("robotApiKey", robotApiKey);
		return "robot/robot_user_api.jsp";
	}

	/**
	 * 智能回复列表
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/robot_replys_page.shtml")
	public String robotReplysPage(Model model, BasePage<RobotAutoReply> page) {
		Map<String, Object> filedContentMap = new HashMap<String, Object>();
		String apiKey = AppContext.getUserInfo().getRobotApiKey();
		filedContentMap.put("userKey", apiKey);
		page.setPageUrl(REQ_URL + "/robot_replys_page.shtml");
		page = robotAutoReplyDao.queryPage(filedContentMap, null, null, null,
				page);
		model.addAttribute("page", page);
		return "robot/robot_user_word_list.jsp";
	}

	@RequestMapping("/robot_replys_opt.shtml")
	public String robotReplysOpt(Model model) {
		return "robot/robot_user_word_opt.jsp";
	}

	/**
	 * 手动添加
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/nsajax/robot_replys_handle_add.shtml")
	@ResponseBody
	public String robotReplysHandleAdd(Model model,
			RobotAutoReply robotAutoReply) {
		robotAutoReply.setId(UuidHelper.getRandomUUID());
		String userkey=AppContext.getUserInfo().getRobotApiKey();
		robotAutoReply.setUserKey(userkey);
		boolean b = robotAutoReplyDao.insertOrUpdate(robotAutoReply);

		if (b)
			return GlobalFinal.CORRECT;
		else
			return GlobalFinal.ERROR;
	}

	/**
	 * excel 导入
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/robot_replys_excel_add.shtml")
	public String robotReplysUploadExcel(HttpServletRequest request,
			ModelMap model) {
		try {
			MultipartResolver resolver = new CommonsMultipartResolver(request
					.getSession().getServletContext());
			MultipartHttpServletRequest multipartRequest = resolver
					.resolveMultipart(request);
			/*
			 * MultipartHttpServletRequest multipartRequest =
			 * (MultipartHttpServletRequest) request;
			 */
			String realpath = request.getSession().getServletContext()
					.getRealPath("/upload/robot_reply_excel");
			/** 根据真实路径创建目录 **/
			File logoSaveFile = new File(realpath);
			if (!logoSaveFile.exists())
				logoSaveFile.mkdirs();
			/** 页面控件的文件流 **/
			MultipartFile multipartFile = multipartRequest.getFile("file");
			/** 获取文件的后缀 **/
			String suffix = multipartFile.getOriginalFilename().substring(
					multipartFile.getOriginalFilename().lastIndexOf("."));
			String name = UuidHelper.getRandomUUID() + suffix;
			File file = new File(realpath, name);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);

			List<RobotAutoReply> trList = ExcelHelper.getRobotAutoByExcel(
					multipartFile.getInputStream(),
					multipartFile.getOriginalFilename());
			robotAutoReplyDao.insertOrUpdate(trList);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/" + REQ_URL + "/robot_replys_page.shtml";
	}

	/**
	 * 关键字回复 内部测试使用
	 * 
	 * @param model
	 * @param keyword
	 * @param robot_apiKey
	 * @param reply_size
	 * @param height
	 * @return
	 */
	@RequestMapping("/nsajax/robot_replys_test.htm")
	@ResponseBody
	public String robotReplysTest(Model model, String keyword,
			String robot_apiKey, String reply_size, String is_height) {
		if (StringUtils.isEmpty(robot_apiKey))
			robot_apiKey = AppContext.getUserInfo().getRobotApiKey();
		String replyMsg = robotReplys(model, keyword, robot_apiKey, reply_size,is_height);
		return replyMsg;
	}

	/**
	 * 关键字回复 外部调用
	 * localhost:8080/gooddeep-remoteser/p_robot/robot/robot_replys.htm
	 * ?keyword=你好&robot_apiKey=123456"&reply_size=1&is_height=false
	 * 
	 * @param model
	 * @param keyword
	 *            关键字
	 * @param robot_apiKey
	 *            apikey
	 * @param reply_size
	 *            结果数量 ,如果不设置默认显示最匹配一条，-1表示显示全部
	 * @param height
	 *            是否高亮 默认为false
	 * @return
	 */
	@RequestMapping("/robot_replys.htm")
	@ResponseBody
	public String robotReplys(Model model, String keyword, String robot_apiKey,
			String reply_size, String is_height) {
		
		RobotAllCallNum robotAllCallNum=robotAllCallNumDao.get(robotAllCallNumDao.createKey(robot_apiKey));
		if(robotAllCallNum==null)
		{
			return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_NO_THISKEY_ERROR,RobotFinal.ERROR_MSG_NO_THISKEY_ERROR)).toString();
		}
		else if(robotAllCallNum.getAmount()<=0)//超出调用次数
		{
			return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_OUTCALLNUM_ERROR,RobotFinal.ERROR_MSG_OUTCALLNUM_ERROR)).toString();
		}
		robotAllCallNum.setAmount(robotAllCallNum.getAmount()-1);
		robotAllCallNumDao.update(robotAllCallNum);//redis总调用次数更新
		Map<String, Object> map = new HashMap<String, Object>();
		BasePage<RobotAutoReply> page = new BasePage<RobotAutoReply>();
		List<String> heightFields = new ArrayList<String>();
		if (StringUtils.isEmpty(keyword)) {
			return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_KEYWORD_NULL,RobotFinal.ERROR_MSG_KEYWORD_NULL)).toString();
		} else if (StringUtils.isEmpty(robot_apiKey)) {
			return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_APIKEY_NULL,RobotFinal.ERROR_MSG_APIKEY_NULL)).toString();
		}
		if (StringUtils.isEmpty(reply_size)) {
			page.setPageSize(1);
		} else {
			try {
				int reply_size_int = Integer.valueOf(reply_size);
				page.setPageSize(reply_size_int);
			} catch (Exception e) {
				return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_REPLYSIZE_ERROR,RobotFinal.ERROR_MSG_REPLYSIZE_ERROR)).toString();
			}
		}
		if (is_height != null)// 高亮
		{
			try {
				boolean is_height_boolean = Boolean.valueOf(is_height);
				if (is_height_boolean)
					heightFields.add("keyword");
			} catch (Exception e) {
				return JSONObject.fromObject(new ReplyError(RobotFinal.ERROR_CODE_ISHEIGHT_ERROR,RobotFinal.ERROR_MSG_ISHEIGHT_ERROR)).toString();
			}
		}
		map.put("keyword", keyword);
		map.put("userKey", robot_apiKey);

		List<RobotAutoReply> rarList = robotAutoReplyDao.queryPage(map,heightFields, null, null, page).getResults();
		List<ask_reply> reply_msgs = new ArrayList<ask_reply>();
		for (RobotAutoReply replyw : rarList) {
			reply_msgs.add(new ask_reply(replyw.getKeyword(), replyw.getReply()));
		}
		if (rarList.size() < page.getPageSize())// 如果自己的自动回复小于 查询条数，则判断系统是否启用
		{
			String key = robotKeyAndSettingDao.createKey(robot_apiKey);
			RobotKeyAndSetting ras = robotKeyAndSettingDao.get(key);
			if (ras != null && ras.getUseSysReply()) {
				BasePage<RobotSysAutoReply> page2 = new BasePage<RobotSysAutoReply>();
				page2.setPageSize(page.getPageSize() - rarList.size());
				List<RobotSysAutoReply> rsarList = robotSysAutoReplyDao.queryPage(map, heightFields, null, null, page2).getResults();
				for (RobotSysAutoReply replyw : rsarList) {
					reply_msgs.add(new ask_reply(replyw.getKeyword(), replyw
							.getReply()));
				}
			}

		}
		RobotDayCallNum robotDayCalllNum=robotDayCallNumDao.get(robotDayCallNumDao.createKey(robot_apiKey));
		robotDayCalllNum.setAmount(robotDayCalllNum.getAmount()+1);
		robotDayCallNumDao.update(robotDayCalllNum);
		
		String a = JSONObject.fromObject(new ReplyMessage(RobotFinal.ERROR_CODE_OK, keyword,reply_msgs)).toString();
		return a.replace("\\/", "/");
	}

	/**
	 * 多id删除
	 * 
	 * @param model
	 * @param ids
	 * @return
	 */
	@RequestMapping("/robot_replys_remove.shtml")
	public String replysRemove(Model model, String ids[]) {
		Map<String, Object> filedContentMap = new HashMap<String, Object>();
		String apiKey = AppContext.getUserInfo().getRobotApiKey();
		filedContentMap.put("userKey", apiKey);
		List<String> idList = Arrays.asList(ids);
		robotAutoReplyDao.deleteByIds(idList);
		return "redirect:/" + REQ_URL + "/robot_replys_page.shtml";
	}

	/**
	 * 设置页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/setting_index.shtml")
	public String setingIndex(Model model) {
		RobotSetting robotSetting = robotSettingService
				.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		// RobotSetting robotSetting=(RobotSetting)
		// JSONObject.toBean(JSONObject.fromObject(oo), RobotSetting.class);
		model.addAttribute("robotSetting", robotSetting);
		return "robot/robot_setting.jsp";
	}

	/**
	 * 设置页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/nsajax/setting_modify.shtml")
	@ResponseBody
	public String setingIndex(Model model, RobotSetting robotSetting) {
		robotSetting.setFkUser(AppContext.getUserInfo().getUserId());
		robotSettingService.modifyById(robotSetting);
		String rkey = robotKeyAndSettingDao.createKey(AppContext.getUserInfo().getRobotApiKey());
		RobotKeyAndSetting robotKeyAndSetting = robotKeyAndSettingDao.get(rkey);
		robotKeyAndSetting.setUseSysReply(robotSetting.getUseSysReply());
		robotKeyAndSetting.setCreateTime(robotKeyAndSettingDao.get(rkey).getCreateTime());
		robotKeyAndSettingDao.update(robotKeyAndSetting);// redis更新
		return GlobalFinal.CORRECT;
	}

	/**
	 * 按天统计分析 yyyy-mm-dd
	 * @param model
	 * @return
	 */
	@RequestMapping("/robot_day_call_analysis.shtml")
	//@ResponseBody
	public String robotDayCallAnalysis(Model model,String startTime,String endTime) {
		MongoBaseConditions mongoBaseConditions=new MongoBaseConditions();
		BaseCriteria baseCriteria=new BaseCriteria("between");
		baseCriteria.setProName("createDay");
		baseCriteria.setValue(startTime);
		baseCriteria.setSecondValue(endTime);
		mongoBaseConditions.addCondition(baseCriteria);
		BaseCriteria baseCriteria2=new BaseCriteria("=");
		baseCriteria2.setProName("fkUser");
		baseCriteria2.setValue(AppContext.getUserInfo().getUserId());
		mongoBaseConditions.addCondition(baseCriteria2);
		
		
		List<RobotCallNumDayRecord>list=robotCallNumDayRecordDao.list(mongoBaseConditions);
		String zx_big_title=startTime+"日到"+endTime+"日接口调用统计";
		JSONObject json=new JSONObject();
		json.accumulate("zx_big_title", zx_big_title);
		List <CountMessage>list2=new ArrayList<CountMessage>();
		for(RobotCallNumDayRecord rcyr:list)
		{
			list2.add(new CountMessage(rcyr.getCreateDay(), String.valueOf(rcyr.getAmount())));
		}
		json.accumulate("content", JSONArray.fromObject(list2).toString());
		model.addAttribute("countMsg", json.toString());
		return "robot/robot_call_count.jsp";

	}
	
	/**
	 * 按月统计
	 * @param model
	 * @param startMonth
	 * @param endMonth
	 * @return
	 */
	@RequestMapping("/robot_month_call_analysis.shtml")
	public String robotmonthCallAnalysis(Model model,String startTime,String endTime) {
		startTime=startTime.substring(0, 7);
		endTime=endTime.substring(0, 7);
		MongoBaseConditions mongoBaseConditions=new MongoBaseConditions();
		BaseCriteria baseCriteria=new BaseCriteria("between");
		baseCriteria.setProName("createMonth");
		baseCriteria.setValue(startTime);
		baseCriteria.setSecondValue(endTime);
		mongoBaseConditions.addCondition(baseCriteria);
		BaseCriteria baseCriteria2=new BaseCriteria("=");
		baseCriteria2.setProName("fkUser");
		baseCriteria2.setValue(AppContext.getUserInfo().getUserId());
		mongoBaseConditions.addCondition(baseCriteria2);
		List<RobotCallNumMonthRecord>list=robotCallNumMonthRecordDao.list(mongoBaseConditions);
		
		String zx_big_title=startTime+"月到"+endTime+"月接口调用统计";
		JSONObject json=new JSONObject();
		json.accumulate("zx_big_title", zx_big_title);
		List <CountMessage>list2=new ArrayList<CountMessage>();
		for(RobotCallNumMonthRecord rcyr:list)
		{
			list2.add(new CountMessage(rcyr.getCreateMonth(), String.valueOf(rcyr.getAmount())));
		}
		json.accumulate("content", JSONArray.fromObject(list2).toString());
	   System.out.println(json.toString());
	   model.addAttribute("countMsg", json.toString());
		return "robot/robot_call_count.jsp";
		
	}
	
	/**
	 * 按年统计
	 * @param model
	 * @param startYear
	 * @param endYear
	 * @return
	 */
	@RequestMapping("/robot_year_call_analysis.shtml")
	public String robotYearCallAnalysis(Model model,String startTime,String endTime) {
		startTime=startTime.substring(0, 4);
		endTime=endTime.substring(0, 4);
		MongoBaseConditions mongoBaseConditions=new MongoBaseConditions();
		BaseCriteria baseCriteria=new BaseCriteria("between");
		baseCriteria.setProName("createYear");
		baseCriteria.setValue(startTime);
		baseCriteria.setSecondValue(endTime);
		mongoBaseConditions.addCondition(baseCriteria);
		BaseCriteria baseCriteria2=new BaseCriteria("=");
		baseCriteria2.setProName("fkUser");
		baseCriteria2.setValue(AppContext.getUserInfo().getUserId());
		mongoBaseConditions.addCondition(baseCriteria2);
		List<RobotCallNumYearRecord>list=robotCallNumYearRecordDao.list(mongoBaseConditions);
		
		String zx_big_title=startTime+"年到"+endTime+"年接口调用统计";
		JSONObject json=new JSONObject();
		json.accumulate("zx_big_title", zx_big_title);
		List <CountMessage>list2=new ArrayList<CountMessage>();
		for(RobotCallNumYearRecord rcyr:list)
		{
			list2.add(new CountMessage(rcyr.getCreateYear(), String.valueOf(rcyr.getAmount())));
		}
		json.accumulate("content", JSONArray.fromObject(list2).toString());
	   System.out.println(json.toString());
	   model.addAttribute("countMsg", json.toString());
		return "robot/robot_call_count.jsp";
	}
	
	
	
	/**
	 * 上报首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/report_index.shtml")
	public String report_index(Model model) {

		return "robot/robot_roport.jsp";
	}

	/**
	 * count数据
	 * @author lhy
	 *
	 */
	public static class CountMessage{
		
		/*private String zx_big_title;
		private String zx_small_title;*/
		private String zx_categories;//x
		private String zx_data;//y
		public String getZx_categories() {
			return zx_categories;
		}
		
		public CountMessage(String zx_categories, String zx_data) {
			this.zx_categories = zx_categories;
			this.zx_data = zx_data;
		}

		public void setZx_categories(String zx_categories) {
			this.zx_categories = zx_categories;
		}
		public String getZx_data() {
			return zx_data;
		}
		public void setZx_data(String zx_data) {
			this.zx_data = zx_data;
		}
		
		
	}
	
	public static void main(String[] args) {
		List <CountMessage>list2=new ArrayList<CountMessage>();
		list2.add(new CountMessage("ffff", String.valueOf(11111)));
		list2.add(new CountMessage("ffff", String.valueOf(11111)));
		list2.add(new CountMessage("ffff", String.valueOf(11111)));
		String aa=JSONArray.fromObject(list2).toString();
		System.out.println(aa);
	}

}