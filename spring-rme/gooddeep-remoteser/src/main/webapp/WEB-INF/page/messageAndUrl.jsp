<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${messageAndUrl.title}</title>
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
  <div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title text-center">
					   ${messageAndUrl.message}
					</h3>
				</div>
				
			</div>
		</div>
	</div>
  </body>
</html>
