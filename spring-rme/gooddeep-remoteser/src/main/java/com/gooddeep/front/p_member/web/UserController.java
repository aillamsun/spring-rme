package com.gooddeep.front.p_member.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gooddeep.dev.core.helper.MailHelper;
import com.gooddeep.dev.core.helper.StringHelper;
import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.dev.core.model.BasePage;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.front.commons.global.GlobalFinal;
import com.gooddeep.front.commons.model.MessageAndUrl;
import com.gooddeep.front.quarz_jobs.UserRegisterJob;
import com.gooddeep.remoteser.mongodb.dao.RobotCallNumDayRecordDao;
import com.gooddeep.remoteser.mongodb.dao.UserLoginRecordDao;
import com.gooddeep.remoteser.mongodb.model.RobotCallNumDayRecord;
import com.gooddeep.remoteser.p_member.model.User;
import com.gooddeep.remoteser.p_member.model.UserCredits;
import com.gooddeep.remoteser.p_member.model.UserCreditsTrade;
import com.gooddeep.remoteser.p_member.model.UserInfo;
import com.gooddeep.remoteser.p_member.model.UserSignRecord;
import com.gooddeep.remoteser.p_member.service.UserCreditsService;
import com.gooddeep.remoteser.p_member.service.UserCreditsTradeService;
import com.gooddeep.remoteser.p_member.service.UserInfoService;
import com.gooddeep.remoteser.p_member.service.UserService;
import com.gooddeep.remoteser.p_member.service.UserSignRecordService;
import com.gooddeep.remoteser.p_robot.model.RobotApiKey;
import com.gooddeep.remoteser.p_robot.model.RobotSetting;
import com.gooddeep.remoteser.p_robot.service.RobotApiKeyService;
import com.gooddeep.remoteser.p_robot.service.RobotSettingService;
import com.gooddeep.remoteser.redis.dao.RobotAllCallNumDao;
import com.gooddeep.remoteser.redis.dao.RobotDayCallNumDao;
import com.gooddeep.remoteser.redis.model.RobotAllCallNum;
import com.gooddeep.remoteser.redis.model.RobotDayCallNum;

@Controller
@RequestMapping("/p_member/user")
public class UserController {
	
	String REQ_URL="p_member/user";
	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RobotApiKeyService robotApiKeyService;
	@Autowired
	private UserCreditsService userCreditsService;
	@Autowired
	private UserCreditsTradeService userCreditsTradeService;
	@Autowired
	private RobotSettingService robotSettingService;

	@Autowired
	private RobotDayCallNumDao robotDayCallNumDao;

	@Autowired
	private RobotCallNumDayRecordDao robotCallNumRecordDao;
	@Autowired
	private RobotAllCallNumDao robotAllCallNumDao;
	@Autowired
	private UserSignRecordService userSignRecordService;
	
	
	@RequestMapping("/before_login.htm")
	public String beforeLogin(User user,Model model){
		return "login.jsp";	
	}
	
/*	@RequestMapping("/login.htm")
	public String login(User user,Model model,HttpServletRequest req,HttpServletResponse response){
		boolean b=SecurityUtils.getSubject().isAuthenticated();
        if(b&& !response.isCommitted())
            return REQ_URL+"user_index.shtml";
       
		return "login.jsp";	
	}
	*/

	
	/**
	 * 注册前
	 * @param model
	 * @return
	 */
	@RequestMapping("/before_register.htm")
	public String beforeRegister(Model model){
		return "register.jsp";	
	}
	/**
	 * 注册中
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/nsajax/on_register.htm")
	@ResponseBody
	public String onRegister(User user,Model model){
		
		String email=user.getEmail();
	     User u=userService.findByAccount(email);
	     if(u!=null)
	     {
	    	 return GlobalFinal.ERROR;
	     }
	     else
	     {
		  MailHelper mh=new MailHelper();
		  String mailName=user.getEmail();
		  mh.setToAddress(mailName);
		  mh.setMailTitle("优深用户注册验证");
		  user.setRegisterId(UuidHelper.getRandomUUID());
		  user.setRegisterTime(new Date().getTime());
		  mh.setMailContent("请点击以下链接完成验证<a href=http://localhost:8080/gooddeep-remoteser/p_member/user/done_register.htm?registerId="+user.getRegisterId()+">立即验证</a>");
		  try {
			mh.sendMail();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  String emailUrl="https://mail."+mailName.substring(mailName.lastIndexOf("@")+1);
	     UserRegisterJob.setRegisterUserMap(user);
	     return emailUrl;
	    }
		//return "messageAndUrl.jsp";	
	}
	
	
	@RequestMapping("/on_register_em.htm")
	public String onRegisterEm(String emailUrl,Model model){
		  model.addAttribute("messageAndUrl", new MessageAndUrl("验证信息已经发送至您的邮箱，<a href="+emailUrl+">请点击查看！</a>", "邮箱验证"));
		  return "messageAndUrl.jsp";	
	}
	
	
	/**
	 * 完成注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/done_register.htm")
	public String doneRegister(String registerId,Model model){
		boolean b=UserRegisterJob.checkAndRemoveOutTimeRegister(registerId);

	     if(b)//如果未超时
		{
			User user=UserRegisterJob.getRegisterUser(registerId);
		  	String email=user.getEmail();
		     User u=userService.findByAccount(email);
		     if(u!=null)
		     {
		    	 model.addAttribute("messageAndUrl", new MessageAndUrl("您好，你的邮箱已经被注册，注册失败，<a href="+REQ_URL+"/before_register.htm"+">再次注册</a>","注册验证失败"));
		     }
		     else{
			user.setId(UuidHelper.getRandomUUID());
			userService.add(user);
			UserInfo userInfo=new UserInfo();
			userInfo.setId(user.getId());
			userInfo.setFkUser(user.getId());
			userInfoService.add(userInfo);
			
			RobotApiKey robotApiKey=new RobotApiKey();
			robotApiKey.setFkUser(user.getId());
			robotApiKey.setApiKey(StringHelper.getMD5(user.getId()));
			robotApiKeyService.add(robotApiKey);
			RobotSetting robotSetting=new RobotSetting();
			robotSetting.setFkUser(user.getId());
			robotSetting.setUseSysReply(true);
			robotSettingService.add(robotSetting);
			UserRegisterJob.removeRegisterUser(registerId);//删除掉
			
			
			RobotDayCallNum robotDayCallNum=new RobotDayCallNum();
			robotDayCallNum.setAmount((long)0);
			robotDayCallNum.setId(robotDayCallNumDao.createKey(robotApiKey.getApiKey()));
			robotDayCallNum.setId(UuidHelper.getRandomUUID());
			robotDayCallNumDao.add(robotDayCallNum);
			
			RobotAllCallNum robotAllCallNum=new RobotAllCallNum();
			robotAllCallNum.setAmount((long)0);
			robotAllCallNum.setId(robotAllCallNumDao.createKey(robotApiKey.getApiKey()));
			robotAllCallNumDao.add(robotAllCallNum);
			
			RobotCallNumDayRecord robotCallNumRecord=new RobotCallNumDayRecord();
			robotCallNumRecord.setAmount((long)0);
			robotCallNumRecord.setApiKey(robotApiKey.getApiKey());
			robotCallNumRecord.setFkUser(user.getId());
			robotCallNumRecord.setCreateTime(new Date());
			robotCallNumRecord.setId(robotDayCallNum.getRcnrDayId());
			robotCallNumRecordDao.insert(robotCallNumRecord);
			
			model.addAttribute("messageAndUrl", new MessageAndUrl("恭喜您注册成功，点击，<a href="+REQ_URL+"/before_login.htm"+">登陆</a>","注册成功"));
		     }
		}
		else
			 model.addAttribute("messageAndUrl", new MessageAndUrl("您好，验证失败，可能是因为您注册时间超时，请在一个小时内完成验证，<a href="+REQ_URL+"/before_register.htm"+">再次注册</a>","注册验证失败"));
			
		return "messageAndUrl.jsp";	
	}
	
	
	@RequestMapping("/index.shtml")
	public String userIndex(Model model){

	

		UserInfo userInfo=AppContext.getUserInfo();

		model.addAttribute("userInfo", userInfo);
		return "user/index.jsp";
			
	}
	/**
	 * 显示帐号信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_account.shtml")
	public String showAccount(Model model){
   
		User user=userService.findById(AppContext.getUserInfo().getUserId());
		model.addAttribute("user", user);
		model.addAttribute("messageAndUrl", new MessageAndUrl("帐号信息"));
		return "user/user_account.jsp";
			
	}
	/**
	 * 密码是否正确
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/nsajax/is_correct_password.shtml")
	@ResponseBody
	public String isCorrectPassword(Model model,User user){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("password", StringHelper.getMD5(user.getPassword()));
		map.put("email", AppContext.getUserInfo().getEmail());
		List <User>list=userService.list(map, null);
		if(list.size()>0)
			return GlobalFinal.CORRECT;
		else
			return GlobalFinal.ERROR;
		
	}
	
	/**
	 * 修改帐号信息(信息及密码)
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify_account.shtml")
	public String beforeMdifyPassword(Model model,User user){

		if(!StringUtils.isEmpty(user.getPassword()))
		{
			user.setPassword(StringHelper.getMD5(user.getPassword()));
		}
	   user.setId(AppContext.getUserInfo().getId());
		userService.modifyById(user);
		
		return "redirect:/"+REQ_URL+"/show_account.shtml";
			
	}
	
	/**
	 * 个人信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_user_info.shtml")
	public String showUserInfo(Model model){
		UserInfo userInfo=userInfoService.getObjByFkUserId(AppContext.getUserInfo().getId());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("messageAndUrl", new MessageAndUrl("用户信息"));
		return  "user/user_info.jsp";
	}
	
	
	/**
	 * 修改信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify_user_info.shtml")
	public String modifyUserInfo(UserInfo userInfo,Model model,HttpServletRequest request,HttpServletResponse response){
		
	
		userInfo.setId(AppContext.getUserInfo().getUserId());
		userInfoService.modifyById(userInfo);
		userInfo=userInfoService.findById(userInfo.getId());
		userInfo.addUserOtherInfo(AppContext.getUserInfo().getUserOtherInfo());
		request.getSession().setAttribute("userInfo", userInfo);
		return "redirect:/"+REQ_URL+"/show_user_info.shtml";
	}

	
	/**
	 * 上传头像之前
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/before_upload_head_img.shtml")
	public String beforeUploadHeadImg(String id,Model model){
		model.addAttribute("messageAndUrl", new MessageAndUrl("上传头像"));
		return "user/user_head_img.jsp";
	}

	
	/**
	 * 显示积分管理
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_user_credits.shtml")
	public String showUserCredits(Model model){
		UserCredits userCredit=userCreditsService.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		model.addAttribute("credit", userCredit);
		model.addAttribute("messageAndUrl", new MessageAndUrl("积分信息"));
		return "user/user_credits.jsp";	
	}
	
	/**
	 * 积分交易记录
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_user_credits_trade.shtml")
	public String showUserCreditsTrade(Model model,BasePage<UserCreditsTrade>page){
		//UserCreditsTrade userCreditTrade=userCreditsTradeService.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("fk_user", AppContext.getUserInfo().getId());
		page=userCreditsTradeService.findPage(map, page, null);
		page.setPageUrl(REQ_URL+"/show_user_credits_trade.shtml");
		model.addAttribute("messageAndUrl", new MessageAndUrl("积分交易记录"));
		model.addAttribute("page", page);
		return "user/user_credits_trade.jsp";	
	}
	
	/**
	 * 消息列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_user_messages.shtml")
	public String showUserMessages(Model model){
		UserCredits userCredit=userCreditsService.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		model.addAttribute("creditTrade", userCredit);
		model.addAttribute("messageAndUrl", new MessageAndUrl("消息列表"));
		return "user/user_messages.jsp";	
	}
	
	/**
	 * 消息信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/show_message_info.shtml")
	public String showMessageInfo(Model model){
		UserCredits userCredit=userCreditsService.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		model.addAttribute("creditTrade", userCredit);
		model.addAttribute("messageAndUrl", new MessageAndUrl("消息信息"));
		return "user/message_info.jsp";	
	}
	/**
	 * 充值
	 * @param model
	 * @return
	 */
	@RequestMapping("/before_recharge.shtml")
	public String beforeRecharge(Model model){
		UserCredits userCredit=userCreditsService.getObjByFkUserId(AppContext.getUserInfo().getUserId());
		model.addAttribute("creditTrade", userCredit);
		model.addAttribute("messageAndUrl", new MessageAndUrl("充值"));
		return "user/user_recharge.jsp";	
	}
	
	
	/**
	 * 用户签到
	 * @param model
	 * @return
	 */
	@RequestMapping("/nsajax/user_sign.shtml")
	@ResponseBody
	public String userSign(Model model){
		if(userSignRecordService.isSignToday(AppContext.getUserInfo().getUserId(),new Date() ))
		{
			return GlobalFinal.ERROR;
		}
		userSignRecordService.signToday(AppContext.getUserInfo().getUserId());;
		return GlobalFinal.CORRECT;	
	}
	
	/**
	 * 用户签到记录
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/user_sign_record.shtml")
	@ResponseBody
	public String userSignRecord(Model model,BasePage<UserSignRecord>page){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("fkUser", AppContext.getUserInfo().getUserId());
		page=userSignRecordService.findPage(map, page, null);
		page.setPageUrl(REQ_URL+"/user_sign_record.shtml");
		return GlobalFinal.CORRECT;	
	}
	
	

}
