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
  
  	<div class="row clearfix bootm-boder"  >
  <div class="col-md-5 column">
    <div class="col-md-8 column col-md-offset-2">
      <div class="input-group">
        <input type="text" class="form-control"  placeholder="关键内容" style="height:40px" >
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" style="height:40px"> 搜索 </button>
        </span> </div>
      <!-- /input-group -->
    </div>
  </div>
  <div class="col-md-7 column">
    <div class="btn-group btn-group-lg" style="float:right">
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-left"></em>上传数据 </button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-center"></em>数据预览</button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em>下架数据</button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em>在线数据</button>
    </div>
  </div>
</div>
<div class="row clearfix" style="margin-top:20px">
  <div class="col-md-10 column col-md-offset-1">
    <div class="row">
      <div class="col-md-3">
        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
          <div style="margin-top:0px;height:50px">
            <p><a> 淘宝数据</a></p>
            <div class="row clearfix">
              <p class="col-md-4 column"> 下载&nbsp; 10 </p>
              <p class="col-md-4 column"> 积分&nbsp; 20 </p>
               <p class="col-md-4 column"> <button class="btn btn-default" type="button" >下架</button></p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
          <div style="margin-top:0px;height:50px">
            <p><a> 淘宝数据</a></p>
            <div class="row clearfix">
              <p class="col-md-6 column"> 下载量&nbsp; 10 </p>
              <p class="col-md-6 column"> 积分&nbsp; 20 </p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
          <div style="margin-top:0px;height:50px">
            <p><a> 淘宝数据</a></p>
            <div class="row clearfix">
              <p class="col-md-6 column"> 下载量&nbsp; 10 </p>
              <p class="col-md-6 column"> 积分&nbsp; 20 </p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
          <div style="margin-top:0px;height:50px">
            <p><a> 淘宝数据</a></p>
            <div class="row clearfix">
              <p class="col-md-6 column"> 下载量&nbsp; 10 </p>
              <p class="col-md-6 column"> 积分&nbsp; 20 </p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
          <div style="margin-top:0px;height:50px">
            <p><a> 淘宝数据</a></p>
            <div class="row clearfix">
              <p class="col-md-6 column"> 下载量&nbsp; 10 </p>
              <p class="col-md-6 column"> 积分&nbsp; 20 </p>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  </div>
   
       <div class="row clearfix" >
          <div class="col-md-12 column" style="margin-bottom:10px;height:50px">
            <ul class="pagination">
              <li> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">上页</a> </li>
              <li> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">第 2 页</a> </li>
              <li> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">共 100 页</a> </li>
              <li> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">下页</a> </li>
              <li> <a>
                <input type="text" class="form-control" id="exampleInputPassword1" style="height:20px;width:50px"/>
                </a> </li>
              <li><a>
                <button type="button" class="btn btn-default" style="height:20px;width:50px;padding-top:0px">跳转</button>
                </a></li>
            </ul>
          </div>
        </div>
</div>
  </body>
</html>
