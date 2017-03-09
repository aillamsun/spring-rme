<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>优深</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class="container" style="width:100%">
	
		<div class="row clearfix" style="margin-top:20px">
			<div class="col-md-12 column ">
				<img style="width:70px;height:92px" src="resource/commons/image/logo.png"
					class="img-rounded" />
			</div>
		</div>
		<div class="row clearfix" style="margin-top:10px">
			<div class="col-md-12 column">
				<div class="row clearfix" style="height:50px">
					<div class="col-md-12 column">
						<form class="bs-example bs-example-form" role="form">
							<div class="row">
								<div class="col-lg-6 col-md-offset-3">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="输入您想说的内容..." style="height:50px"> <span
											class="input-group-btn">
												<button class="btn btn-default" type="button"
													style="height:50px">SPEAK</button>
										</span>
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
							</div>
							<!-- /.row -->
						</form>
					</div>
				</div>
				<div class="row clearfix" style="margin-top:100px;">
					<div class="col-md-12 column">
						<h3 class="text-center">越简单，越优秀，越明了，越深奥...</h3>
					</div>
				</div>
			</div>
		</div>

		

	</div>
     
  </body>
</html>
