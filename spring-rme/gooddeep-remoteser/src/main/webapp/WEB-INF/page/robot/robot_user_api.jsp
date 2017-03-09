<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>接口API</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
 <div class="row clearfix">
		<div class="col-md-12 column">
			<dl class="dl-horizontal">
				<dt>
					接口地址：
				</dt>
				<dd style="text-align: left;">
					http://localhost:8080/gooddeep-remoteser/p_robot/robot/robot_replys.htm
				</dd>
				<dt>
					你的key：
				</dt>
				<dd style="text-align: left;">
					${robotApiKey.apiKey }
				</dd>
				
				<dt>
					使用方法：
				</dt>
				<dd style="text-align: left;">
				      curl get/post  http://gooddeep.com/autoreply/你的key/关键词句
				</dd>
				<dt>
					例子：
				</dt>
				<dd style="text-align: left;">
				     GET 例子：http://localhost:8080/gooddeep-remoteser/p_robot/robot/robot_replys.htm?keyword=你好&robot_apiKey=123456&reply_size=1&is_height=false
				</dd>
				<dt>
					说明：
				</dt>
                <dd style="text-align: left;">
					   使用post或者get方法请求 ，返回数据{"request_word":"hello","reply_word":"hi","create_time":"12345678"}
				    </dd>
				    <dd>keyword:问句(必须设置)</dd>
				    <dd>robot_apiKey：你的key（必须设置）</dd>
				    <dd>reply_size：显示多少条（如果设置必须时数字，可不设置，默认最精确1条）</dd>
				    <dd>is_height：是否高亮（如果设置必须时false或true，可不设置，默认为false）</dd>
				
			</dl>
		</div>
	</div>
  </body>
</html>
