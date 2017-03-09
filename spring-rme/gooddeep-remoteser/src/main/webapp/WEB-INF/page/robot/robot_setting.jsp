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

<title>设置</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</style>
</head>

<body>
	<div class="row clearfix">
		<div class="col-md-6 column col-sm-offset-3">
			<form class="form-horizontal" role="form" >
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">使用系统词条:</label>
					<div class="col-sm-5">
						<div class="radio" style="float:left">

							<label> <input type="radio" name="useSysReply" value="true" 
								<c:if test="${robotSetting.useSysReply }">checked="checked"</c:if> />是
							</label> 
							<label><input type="radio" name="useSysReply"
								value="false"
								<c:if test="${!robotSetting.useSysReply }">checked="checked"</c:if> />否</label>
						</div>
					</div>
					<div class="col-sm-3">
						<button type="button" id="modifySetting" class="btn btn-default">确定</button>
					</div>

				</div>

			</form>
		</div>
	</div>
	<script type="text/javascript">
	$("#modifySetting").click(function(){
	var useSysReply = $("input[name='useSysReply']:checked").val();
			$.ajax({
					type : "POST",
					//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
					url : "p_robot/robot/nsajax/setting_modify.shtml",
					data : {
						"useSysReply" : useSysReply,
						"id":'${robotSetting.id}'
					},
					success : function(data) {
						if (data == "correct")
							alert("修改成功");
						else
							alert("修改失败");

					}
				})
		
	})
	
	</script>
</body>
</html>
