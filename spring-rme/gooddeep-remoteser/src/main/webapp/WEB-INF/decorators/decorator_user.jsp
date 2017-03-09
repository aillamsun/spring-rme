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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<sitemesh:write property='head' />
</head>

<body>
	<div class="container" style="width:100%">
	<div class="row clearfix bottom-border" style="height:40px">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-6 column">
                	<ul class="list-inline list-unstyled"
							style="float:left;margin-top:10px;margin-bottom:0px;">
							<%if (AppContext.getUserInfo()!=null){ %>
							<li><span data-toggle="dropdown" class="dropdown-toggle"><%=(AppContext.getUserInfo().getAccount()==null?AppContext.getUserInfo().getEmail():AppContext.getUserInfo().getAccount()) %><span
									class="caret"></span></span>
								<ul class="dropdown-menu font_size_12">
									<li><a href="p_member/user/index.shtml">个人中心</a></li>
									<li class="disabled"><a href="p_member/user/user_info.shtml">账号设置</a></li>

									<li><a href="logout.shtml">退出</a></li>
								</ul></li>
							<li><span class="badge">14</span></li>
							<%}else{ %>
							<li><a style="" href="p_member/user/before_login.htm">登录</a></li>
							<%} %>
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
	<div class="row clearfix" style="margin-top:20px;margin-bottom: 80px">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
					<ul class="nav nav-tabs nav-stacked">
						<li class="active">
							 <a href="p_member/user/before_upload_head_img.shtml">头像设置</a>
						</li>
                        <li>
							 <a href="p_member/user/show_user_info.shtml">详细资料</a>
						</li>
                        <li>
							 <a href="p_member/user/show_account.shtml">账号管理</a>
						</li>
                        <li>
							 <a href="p_member/user/show_user_credits.shtml">积分管理</a>
						</li>
                        <li>
							 <a href="p_member/user/show_user_messages.shtml">消息管理<span class="badge">14</span></a>
						</li>
                        <li>
							 <a href="p_member/user/before_recharge.shtml">充值</a>
						</li>
						
					</ul>
				</div>
				<div class="col-md-7 column">
					<div class="row clearfix" style="margin-bottom:10px">
						<div class="col-md-12 column">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										${messageAndUrl.title }
									</h3>
								</div>
							</div>
						</div>
					</div>
                   
                   
                   <!-- 此处添加内容-->
                    <sitemesh:write property='body' />
                    
                    <!-- 分页 -->
						<c:if test="${page.isAjax==0 }">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<ul class="pagination">
								
								<c:if test="${page.pageNo-1>0 }">
									<li><a href="${page.pageUrl }?pageNo=${page.pageNo-1}&${page.urlParam }">上页</a></li>
								</c:if>

									<li><a href="http://www.runoob.com/try/bootstrap/layoutit/#">第 ${page.pageNo }页</a></li>
									<li><a href="http://www.runoob.com/try/bootstrap/layoutit/#">共${page.totalRecord }条&nbsp;共${page.totalPage}页</a></li>
								<c:if test="${page.pageNo+1<=page.totalPage }">
									<li><a href="${page.pageUrl }?pageNo=${page.pageNo+1}&${page.urlParam }">下页</a></li>
								</c:if>
									<li><a> <input type="text" class="form-control" id="zc_tz_text" style="height:24px;width:50px" /></a></li>
									<li><a><button type="button" class="btn btn-default" style="height:24px;width:50px;padding-top:0px" 
									onclick="zcTzClick(${page.totalPage},'${page.pageUrl }')">跳转</button></a></li>
								</ul>
							</div>
						</div>
						</c:if>
						
						<!-- 分页结束 -->
                   
				</div>
               
			</div>
		</div>
	</div>
    		<!-- 底部 -->
    <div id="footer" class="container">
			<nav class="navbar navbar-default navbar-fixed-bottom" style="margin-bottom:-70px;">
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
</body>
</html>
