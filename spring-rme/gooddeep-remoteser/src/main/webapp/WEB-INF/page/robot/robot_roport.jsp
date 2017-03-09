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
		<div class="col-md-6 column col-md-offset-3" style="margin-top:20px" >
			<div class="tabbable" id="tabs-888452">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="http://www.runoob.com/try/bootstrap/layoutit/#tab1" data-toggle="tab">上报分词</a>
					</li>
                   
					<li>
						 <a href="http://www.runoob.com/try/bootstrap/layoutit/#tab2" data-toggle="tab">上报系统关键词回复</a>
					</li>
                    
                    <li class="active">
						 <a href="http://www.runoob.com/try/bootstrap/layoutit/#tab3" data-toggle="tab">分词查询</a>
					</li>
                   
					<li>
						 <a href="http://www.runoob.com/try/bootstrap/layoutit/#tab4" data-toggle="tab">分词测试</a>
					</li>
                    <li>
						 <a href="http://www.runoob.com/try/bootstrap/layoutit/#tab5" data-toggle="tab">系统关键词查询</a>
					</li>
               
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
						<form role="form">
                            <div class="form-group">
                                 <label for="exampleInputEmail1">分词</label><input type="text" class="form-control" id="exampleInputEmail1" />
                            </div>
                             <button type="submit" class="btn btn-default">提交</button>
                        </form>
					</div>
					<div class="tab-pane" id="tab2">
						<form role="form">
                                <div class="form-group">
                                     <label for="exampleInputEmail1">关键词句</label><input type="text" class="form-control" id="exampleInputEmail1" />
                                </div>
                                 <div class="form-group">
                                     <label for="exampleInputEmail1">回复</label>
                                     <textarea class="form-control" id="exampleInputEmail1" ></textarea>
                                    
                                </div>
                                 <button type="submit" class="btn btn-default">提交</button>
                            </form>
					</div>
                    <div class="tab-pane" id="tab3">
						<form role="form">
                                <div class="form-group">
                                     <label for="exampleInputEmail1">分词查询</label><input type="text" class="form-control" id="exampleInputEmail1" />
                                </div>
                                 <button type="submit" class="btn btn-default">查询</button>
                                 <dl class="dl-horizontal">
                                    <dt>
                                        查询结果
                                    </dt>
                                    <dd style="text-align: left;">
                                        11111111111111111111
                                    </dd>
                                 </dl>
                            </form>
					</div>
                    <div class="tab-pane" id="tab4">
						<form role="form">
                                <div class="form-group">
                                     <label for="exampleInputEmail1">语句</label><input type="text" class="form-control" id="exampleInputEmail1" />
                                </div>
                                <button type="submit" class="btn btn-default">分词</button>
                                 <dl class="dl-horizontal">
                                    <dt>
                                        分词结果
                                    </dt>
                                    <dd style="text-align: left;">
                                        aaa
                                    </dd>
                                    <dd style="text-align: left;">
                                       bbb
                                    </dd>
                                 </dl>
                                 
                            </form>
					</div>
                    <div class="tab-pane" id="tab5">
						<form role="form">
                                <div class="form-group">
                                     <label for="exampleInputEmail1">系统关键词</label><input type="text" class="form-control" id="exampleInputEmail1" />
                                </div>
                          
                                 <button type="submit" class="btn btn-default">查询</button>
                                 <dl class="dl-horizontal">
                                    <dt>
                                        查询结果
                                    </dt>
                                    <dd style="text-align: left;">
                                        此关键词已经存在
                                    </dd>
                                   
                                 </dl>
                            </form>
					</div>
                    
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
