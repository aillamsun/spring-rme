<%@page import="com.gooddeep.front.commons.context.AppContext"%>
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
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/UserInfoService.js"></script>
  </head>
  
  <body>
 <div class="row clearfix">
		<div class="col-md-8  col-md-offset-2 colum">
			<div class="tabbable" id="tabs-794765">
				<ul class="nav nav-tabs" >
					<li class="active">
						 <a href="#panel-541384" data-toggle="tab">自定义头像</a>
					</li>
					<li>
						 <a href="#panel-333152" data-toggle="tab">热门头像</a>
					</li>
				</ul>
				<div class="tab-content"  style="margin-top:20px">
					<div class="tab-pane active "   id="panel-541384" >
							<form role="form" method="post" action="p_member/user/modify_account.shtml">
				
				<div class="form-group">
					<!--  <label for="exampleInputFile">File input</label> -->
                     <p > 
                      <button type="button" class="btn btn-default" OnClick='javascript:document.getElementById("uploadImg").click();'>选择图片</button>
                     <input type="file" id="uploadImg" name="uploadImg" style="visibility:hidden;" /></p>
                     <input type="hidden" name="headImgUrl" id="headImgUrl"/>
                     <p class="help-block">
                            预览
                     </p>
					<p class="help-block">
						<img alt="140x140"  class="img-thumbnail"  id="showHeadImage"/>
					</p>
				</div>
				<button type="submit"  class="btn btn-default">确定</button>
			</form>
					</div>
					<div class="tab-pane " id="panel-333152">
						<ul class="list-inline list-unstyled" style="margin-top:20px">
				<li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
                <li style="height:80px;width:90px;">
					<img src="v3/default3.jpg" class="img-thumbnail"  style="height:100%;width:100%"/>
				</li>
				
			</ul>
            <button type="button"  class="btn btn-default">确定</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>

$(function(){

       $("#uploadImg").change(function(e){
         var file = dwr.util.getValue("uploadImg");
          alert(file.value)
           UserInfoService.uploadHeadImg(file, file.value,'<%=AppContext.getUserInfo().getUserId() %>' ,function(data){
                 $("#headImgUrl").val(data);
                  $("#showHeadImage").attr("src",data);
			  });
          
      });
  });
</script>
  </body>
</html>
