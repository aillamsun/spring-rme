<%@page import="com.gooddeep.front.commons.context.AppContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><sitemesh:write property='title' /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />

<title><sitemesh:write property='title' /></title>
<script src="resource/commons/js/jquery-3.0.0.min.js"></script>
<script src="resource/commons/js/bootstrap.min.js"></script>

<link href="resource/commons/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/commons/css/gooddeep/index.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<sitemesh:write property='head' />
</head>

<body>

	<div class="container" style="width:100%">
		<!-- 头部 -->
		<div class="row clearfix bottom-border" style="height:40px">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-6 column">
						<ul class="list-inline list-unstyled"
							style="float:left;margin-top:10px;margin-bottom:0px;">
							<%
								if (AppContext.getUserInfo() != null) {
							%>
							<li><span data-toggle="dropdown" class="dropdown-toggle"><%=(AppContext.getUserInfo().getAccount() == null ? AppContext
						.getUserInfo().getEmail() : AppContext.getUserInfo()
						.getAccount())%><span
									class="caret"></span></span>
								<ul class="dropdown-menu font_size_12">
									<li><a href="p_member/user/index.shtml">个人中心</a></li>
									<li id="qiandao">签到</li>
									<li class="disabled"><a
										href="p_member/user/user_info.shtml">账号设置</a></li>

									<li><a href="logout.shtml">退出</a></li>
								</ul></li>
							<li><span class="badge">14</span></li>
							<%
								} else {
							%>
							<li><a style="" href="p_member/user/before_login.htm">登录</a></li>
							<%
								}
							%>
							<li><a style="" href="p_member/user/before_register.htm">注册</a></li>
						</ul>
					</div>
					<div class="col-md-6 column">
						<ul class="list-inline list-unstyled"
							style="float:right;margin-top:10px;margin-bottom:0px;">
							<li><a style="font-weight: bold;" href="index.htm">首页</a></li>
							<li><a style="font-weight: bold;" href="p_robot/robot/robot_index.shtml">机器人</a></li>
							<li><a style="font-weight: bold;">数据市场</a></li>
							<li><a style="font-weight: bold;">克隆</a></li>
							<li><a style="font-weight: bold;">未卜</a></li>
							<li><a style="font-weight: bold;">先知</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="row clearfix " style="margin-bottom: 80px">
			<div class="col-md-12 column">
				<!-- 中间内容 -->
				<sitemesh:write property='body' />
			</div>
		</div>

		<!-- 底部 -->
		<div id="footer" class="container">
			<nav class="navbar navbar-default navbar-fixed-bottom">
			<div class="navbar-inner navbar-content-center">
				<p class="text-muted credit" style="padding: 10px;">
				<ul class="list-inline list-unstyled">
					<li style="font-size:12px">Copyright © 2015-2016 优深网络科技
						gooddeep.com All Rights Reserved. 备案号：京 ICP 备16027411号</li>
					<br />
					<li><a style="font-weight: bold;">你好</a></li>
					<li><a style="font-weight: bold;">世界</a></li>
					<li><a style="font-weight: bold;">克隆</a></li>
					<li><a style="font-weight: bold;">未卜</a></li>
					<li><a style="font-weight: bold;">先知</a></li>
				</ul>
				</p>
			</div>
			</nav>
		</div>
	</div>
	<script type="text/javascript">
	$("#qiandao").click(function(){
		$.ajax({
			type : "POST",
			//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
			url : "p_member/user/nsajax/user_sign.shtml",
			data : {
	/* 			"startTime" : startTime,
				"endTime":endTime */
			},
			success : function(data) {
				//	alert(data);
				if (data == "error") {
					alert("今天已经签到")
				} else {
					alert("签到成功，+0.1积分");
					return;
				}

			}
		}) 
		
	})
	</script>
</body>
</html>
