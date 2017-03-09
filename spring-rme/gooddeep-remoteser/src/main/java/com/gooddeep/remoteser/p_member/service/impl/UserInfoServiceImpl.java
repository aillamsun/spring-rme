package com.gooddeep.remoteser.p_member.service.impl;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;








import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.commons.service.impl.MemberBaseServiceImpl;
import com.gooddeep.remoteser.p_member.mapper.UserInfoMapper;
import com.gooddeep.remoteser.p_member.model.UserInfo;
import com.gooddeep.remoteser.p_member.service.UserInfoService;

@Transactional
@Component(value="userInfoService")
public class UserInfoServiceImpl extends MemberBaseServiceImpl<UserInfo> implements UserInfoService{

	@Autowired
	private UserInfoMapper uInfoMapper;
	@Override
	protected MemberBaseMapper<UserInfo> getDao() {
		// TODO Auto-generated method stub
		return uInfoMapper;
	}
	/**
	 * 上传头像
	 * @param is       DWR会自动把dwr.util.getValue("myfile")转换为这里所需的InputStream
	 * @param filename 不同浏览器传进来的值未必相同，IE9传是含全路径的文件名,firefox12传的是文件名
	 * @return 文件的真实名字
	 */
	@Override
	public String uploadHeadImg(InputStream is, String filename,String userId){

		String realpath=null;//设置上传路径
		String allPath=null;//存入数据库总路径
		try {
		WebContext context=WebContextFactory.get();
		//String hz=filename.substring(filename.lastIndexOf("."));
		String name=userId+"."+"jpg";
		HttpServletRequest request = context.getHttpServletRequest(); //获取Servlet API
		realpath = request.getSession().getServletContext().getRealPath("/upload/userHeadImg");
		File file=new File(realpath, name);
		if(!file.getParentFile().exists())
    	{
    		file.getParentFile().mkdirs();
    	}
		FileUtils.copyInputStreamToFile(is, file);
		allPath="upload/userHeadImg/"+name;

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			
		}
		
		return allPath;
	}
   
}