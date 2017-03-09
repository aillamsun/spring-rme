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
    
    <title>数据列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
 <div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" id="form" action="p_member/user/modify_account.shtml">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3" readonly value="${user.email }"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">输入原始密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="ypassword" />
					</div>
				</div>
                <div class="form-group">
					 <label for="inputPassword3"  class="col-sm-2 control-label">输入新密码</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" id="rpassword" />
					</div>
				</div>
				 <div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">重复密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="button" id="tijiao" class="btn btn-default">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		$("#tijiao").click(function() {

			//var userId = $("#userId").val();
			var ypassword = $("#ypassword").val();
			var rpassword = $("#rpassword").val();
			var password = $("#password").val();
			
			if (ypassword.length <= 0) {
				alert("请输入原始密码！");
				return;
			}
			$.ajax({
				type : "POST",
				//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
				url : "p_member/user/nsajax/is_correct_password.shtml",
				data : {
					"password" : ypassword
				},
				success : function(data) {
					//	alert(data);
					if (data == "correct") {
						if (password.length <= 0) {
							alert("请输入新密码！");
							return;
						} else if (password != rpassword) {
							alert("密码输入不一致");
							return;
						} else {
							$("#form").submit();
							return;
						}
					} else {
						alert("原始密码错误！请重新输入！");
						return;
					}

				}
			})

		})
	</script>
  </body>
</html>
