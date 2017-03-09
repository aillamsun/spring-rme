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
			<form class="form-horizontal" role="form" method="post"  action="p_member/user/modify_user_info.shtml">
			<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">昵称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="nick" id="inputEmail3" value="${userInfo.nick}" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" id="inputEmail3" value="${userInfo.name }" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="phone" id="inputEmail3" value="${userInfo.phone }"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">毕业学校</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="eduSchool" id="inputEmail3" value="${userInfo.eduSchool }"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-10">
					   	<c:choose >
                    	<c:when test="${userInfo.sex!=null }">
                    		<label class="checkbox-inline">   
                              <input type="radio" name="sex" id="optionsRadios3"  name="sex"
                                 value="男" 	<c:if test="${userInfo.sex=='男' }"> checked</c:if>> 男
                           </label>
                           <label class="checkbox-inline">
                              <input type="radio" name="sex" id="optionsRadios4" name="sex"
                                 value="女" 	<c:if test="${userInfo.sex=='女' }"> checked</c:if> > 女
                   			</label>
                   			</c:when>
                   			<c:otherwise>
                   			
                   			<label class="checkbox-inline">   
                              <input type="radio" name="sex" id="optionsRadios3" value="男" 	name="sex" checked="checked"> 男
                           </label>
                           <label class="checkbox-inline">
                              <input type="radio" name="sex" id="optionsRadios4"  value="女"  name="sex" > 女
                   			</label>
                   			</c:otherwise>
                   			</c:choose>
					</div>
				</div>
                
                <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">生日</label>
					<div class="col-sm-10">
						  <select  class="form-control" name="birthday">
						 
                         	   <c:forEach var= "temp"  begin="1900"  step="1"  end="2016"  varStatus="loop">
                            			 <option  <c:if test="${(loop.end+loop.begin-loop.index)==userInfo.birthday }">selected=selected</c:if> value="${loop.end+loop.begin-loop.index }" >${loop.end+loop.begin-loop.index}</option>
                               </c:forEach>
                          </select>
					</div>
           
				</div>
                
                 <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">婚姻状况</label>
					<div class="col-sm-10">
						  <select  class="form-control" name="martial">
                         	 <option  <c:if test="${'已婚'==userInfo.martial }">selected="selected"</c:if> value="已婚" >已婚</option>
                             <option  <c:if test="${'未婚'==userInfo.martial }">selected="selected"</c:if> value="未婚" >未婚</option>
                             <option  <c:if test="${'其他'==userInfo.martial }">selected="selected"</c:if> value="其他" >其他</option>
                          </select>
					</div>
                   
				</div>
                
                 <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">学历</label>
					<div class="col-sm-10">
						  <select  class="form-control" name="edu">
                         	  <option <c:if test="${'本科'==userInfo.edu }">selected="selected"</c:if> value="本科" >本科</option>
                             <option <c:if test="${'大专'==userInfo.edu }">selected="selected"</c:if> value="大专" >大专</option>
                             <option <c:if test="${'高中'==userInfo.edu }">selected="selected"</c:if> value="高中" >高中</option>
                             <option <c:if test="${'初中'==userInfo.edu }">selected="selected"</c:if> value="初中" >初中</option>
                             <option <c:if test="${'小学'==userInfo.edu }">selected="selected"</c:if> value="小学" >小学</option>
                             <option <c:if test="${'其他'==userInfo.edu }">selected="selected"</c:if> value="其他" >其他</option>
                          </select>
					</div>
                   
				</div>
                
                 <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">当前职业</label>
					<div class="col-sm-10">
						  <select  class="form-control" name="profession">
                         	 <option <c:if test="${'软件工程师'==userInfo.profession }">selected="selected"</c:if>  value="软件工程师" >软件工程师</option>
                             <option <c:if test="${'其他'==userInfo.profession }">selected="selected"</c:if> value="其他" >其他</option>
                          </select>
					</div>
				</div>
                
                <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">工作年份</label>
					<div class="col-sm-10">
						  <select  class="form-control" name="">
                         	 	   <c:forEach var= "temp"  begin="1900"  step="1"  end="2016" varStatus="loop">
                            			 <option  <c:if test="${(loop.end+loop.begin-loop.index)==userInfo.workTime }">selected="selected"</c:if> value="${loop.end+loop.begin-loop.index }" >${loop.end+loop.begin-loop.index }</option>
                               </c:forEach>
                          </select>
					</div>
				</div>
				
				<div class="form-group">
					<div>
						 <button type="submit" class="btn btn-default">修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>
