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
      <div class="col-md-3 column"> </div>
      <div class="col-md-9 column">
        <div class="btn-group btn-group-lg" style="float:right">
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-left"></em> 上报分词记录</button>
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-center"></em> 上报系统关键词记录</button>
                 <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-right"></em> 上报分词</button>
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em> 上报系统关键词回复</button>
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em> 分词查询</button>
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em> 分词测试</button>
          <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em> 系统关键词测试</button>
        </div>
      </div>
      </div>
    <div class="row clearfix top-boder " style="margin-top:10px">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-12 column">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th> 请求句子 </th>
                   <th> 回复句子 </th>
                  <th>上报时间</th>
                  <th>审核时间</th>
                  <th>审核状态</th>
                  <th>状态原因</th>
                </tr>
              </thead>
              <tbody>
                <tr class="error">
                  <td> 1 </td>
                  <td> 中国 </td>
                  <td> 大国崛起 </td>
                  <td> 01/04/2012 </td>
                  <td> 01/04/2012 </td>
                  <td> 未通过 </td>
                  <td> 不符合要求</td>
                </tr>
                <tr class="success">
                  <td> 1 </td>
                  <td> 中国 </td>
                   <td> 大国崛起 </td>
                  <td> 01/04/2012 </td>
                  <td> 01/04/2012 </td>
                  <td> 未通过 </td>
                  <td> 不符合要求</td>
                </tr>
                <tr class="error">
                   <td> 1 </td>
                  <td> 中国 </td>
                   <td> 大国崛起 </td>
                  <td> 01/04/2012 </td>
                  <td> 01/04/2012 </td>
                  <td> 未通过 </td>
                  <td> 不符合要求</td>
                </tr>
                <tr class="warning">
                   <td> 1 </td>
                  <td> 中国 </td>
                   <td> 大国崛起 </td>
                  <td> 01/04/2012 </td>
                  <td> 01/04/2012 </td>
                  <td> 未通过 </td>
                  <td> 不符合要求</td>
                </tr>
                <tr class="info">
                  <td> 1 </td>
                  <td> 中国 </td>
                   <td> 大国崛起 </td>
                  <td> 01/04/2012 </td>
                  <td> 01/04/2012 </td>
                  <td> 未通过 </td>
                  <td> 不符合要求</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-12 column">
          		<ul class="pagination pagination-lg">
				<li>
					 <a href="http://www.runoob.com/try/bootstrap/layoutit/#">上页</a>
				</li>
				
				<li>
					 <a href="http://www.runoob.com/try/bootstrap/layoutit/#">第 2 页</a>
				</li>
                <li>
					 <a href="http://www.runoob.com/try/bootstrap/layoutit/#">共 100 页</a>
				</li>
				
				<li>
					 <a href="http://www.runoob.com/try/bootstrap/layoutit/#">下页</a>
				</li>
                <li>
                <a> <input type="text" class="form-control" id="exampleInputPassword1" style="height:24px;width:50px"/></a>
                </li>
                <li><a><button type="button" class="btn btn-default" style="height:24px;width:50px;padding-top:0px">跳转</button></a></li>
			</ul>
          </div>
          </div>
      </div>
    </div>
  </div>
</div>
  </body>
</html>
