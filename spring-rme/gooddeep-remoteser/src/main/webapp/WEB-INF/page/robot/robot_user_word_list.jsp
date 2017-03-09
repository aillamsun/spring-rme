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
    <div class="row clearfix">
      <div class="col-md-6 column"> </div>
      <div class="col-md-6 column">
        <div class="btn-group btn-group-lg" style="float:right">
         
          <button class="btn btn-default" type="button" style="font-size:12px" onclick="javascript:window.location.href='p_robot/robot/robot_replys_opt.shtml'">
          <em class="glyphicon glyphicon-align-left"></em> 
          			操作</button>
         	<button class="btn btn-default" type="button" style="font-size:12px" id="removeReplys">
							<em class="glyphicon glyphicon-align-right"></em> 删除
				</button>
      </div>
      
      </div>
    </div>
    <div class="row clearfix top-border " style="margin-top:10px">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-12 column">
          <form action="p_robot/robot/robot_replys_remove.shtml" id="replyForm" method="post" >
            <table class="table table-striped">
              <thead>
                <tr>
                  <th><input type="checkbox"  id="quanxuan" /></th>
                  <th>问 </th>
                  <th>回复 </th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="robot" items="${page.results}">
                <tr>
                  <td> <input type="checkbox" name="ids"  value="${user.id }" class="ids" /> </td>
                  <td>${robot.keyword } </td>
                  <td>${robot.reply }</td>
                  <td> <button type="button" class="modify" class="btn btn-default">修改</button></td>
                </tr>
                </c:forEach>
               
              </tbody>
            </table>
            </form>
          </div>
        </div>
       
      </div>
    </div>
  </div>
</div>
  <script type="text/javascript">
  
  $(function(){
  		 $("#removeReplys").click(function(){
  
  if($(".ids:checked").length>0)
  {
     $("#replyForm").submit();
  }
  else
     alert("您还没有选择");
       //alert("fffff");
     // alert($(".ids:checked").length);
      //$("#usersForm").submit();
  })
  
  })
  </script>
  </body>
</html>
