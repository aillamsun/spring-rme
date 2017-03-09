<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/commons/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="resource/commons/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="resource/commons/css/index.css"/>
	<script src="resource/commons/js/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/commons/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript" src="resource/commons/js/login_yzm.js"></script>
  </head>
  
  <body>
  <div class="row clearfix" style="margin-top:100px">
		<div class="col-md-6 col-md-offset-3 column">
        <div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						用户登录
					</h3>
				</div>
			</div>
           </div>
           </div>
<div class="row clearfix" style="margin-top:20px">
		<div class="col-md-6 column col-md-offset-3">
			<form class="form-horizontal" role="form"  method="post" action="p_member/user/index.shtml">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="username" class="form-control" name="username" id="username" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password" id="password" />
					</div>
				</div>
                <div class="form-group">
					 <label for="inputPassword3" class="col-sm-12 text-danger text-center">账号或密码错误</label>
				</div>
				<div class="form-group">
					<div class="text-center">
						<div class="checkbox">
							 <label><input type="checkbox" />下次直接登录</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="text-center">
						 <button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>
