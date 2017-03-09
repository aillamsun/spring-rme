<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link rel="stylesheet" type="text/css"
	href="resource/commons/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="resource/commons/css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="resource/commons/css/index.css" />
<script src="resource/commons/js/jquery-1.10.2.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="resource/commons/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="resource/commons/js/login_yzm.js"></script>
</head>

<body>
	<div class="container" style="width:100%">

		<div class="row clearfix" style="margin-top:100px">
			<div class="col-md-6 col-md-offset-3 column">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">用户注册</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="row clearfix" style="margin-top:20px">
			<div class="col-md-6 col-md-offset-3 column">
				<form class="form-horizontal" role="form" action="p_member/user/on_register.htm">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-7">
							<input type="email" name="email" id="email" class="form-control" id="inputEmail3" />
						</div>
						<label class="col-sm-3  text-danger" style="font-size:12px">此邮箱已经被使用</label>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-7">
							<input type="password" name="password" id="password" class="form-control" id="inputPassword3" />
						</div>
						<label class="col-sm-3  text-danger" style="font-size:12px">密码中必须含有英文和数字</label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-4">
							<div class="checkbox">
								<label style="font-size:12px"><input type="checkbox" />遵守优深《<a>用户协议</a>》</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-2">
							<button type="button"  id="register" class="btn btn-default">注册</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<form action="p_member/user/on_register_em.htm" id="on_register_em_form" method="post">
		<input type="hidden" id="emailUrl" name="emailUrl"/>
		
		</form>

	</div>
	
	<script type="text/javascript">
	$("#register").click(function(){
	var email=$("#email").val();
	var password=$("#password").val();
				$.ajax({
				type : "POST",
				//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
				url : "p_member/user/nsajax/on_register.htm",
				data : {
					"password" : password,
					"email":email
				},
				success : function(data) {
					if (data == "error") {
						alert("邮箱已经被占用")
						return;
					} else {
						  $("#emailUrl").val(data);
						  $("#on_register_em_form").submit();
						return;
					}

				}
			})
	
	})
	
	</script>
</body>
</html>
