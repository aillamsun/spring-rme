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
   <style>
#data-left-nav {
}
#data-left-nav small-ul {
	float:right;
}
#data-left-nav small-ul li {
	float:left;
	width:60px;
	text-align:left
}
</style>
  </head>
  
  <body>
  <div class="container" style="width:100%">
<div class="row clearfix">
  <div class="col-md-12 column">
    <div class="row clearfix bottom-border"  style="height:50px;margin-top:10px">
    
      <div class="col-md-4 column ">
        <ul class="nav nav-pills" >
          <li class="active"> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">首页</a> </li>
          <li> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">手机</a> </li>
          <li class="disabled"> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">电脑</a> </li>
          <li class="disabled"> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">新房</a> </li>
          <li class="disabled"> <a href="http://www.runoob.com/try/bootstrap/layoutit/#">二手房</a> </li>
        </ul>
      </div>
      <div class="col-md-4 column ">
     	 <div class="input-group">
        <input type="text" class="form-control"  placeholder="关键内容" style="height:40px" >
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" style="height:40px"> 搜索 </button>
        </span> </div>
      </div>
    </div>
    <div class="row clearfix" style="margin-top:20px">
      <div class="col-md-2 column " >
        <div class="panel-group " id="data-left-nav" style="height:300px;">
          <div class="panel panel-default left-nav-list">
            <div class="panel-heading"> <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-713737" href="#panel-element-598003" style="font-weight: bold;">电子产品</a> </div>
            <div id="panel-element-598003" class="panel-collapse collapse">
              <div class="panel-body">
                <div style="font-size:12px;padding-left:0px;padding-right:0px">
                  <ul class="list-unstyled list-inline" class="small-ul">
                  <li> <a>手机</a> </li>
                  <li> <a>笔记本</a> </li>
                  <li><a> 数码相机</a> </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div class="panel panel-default left-nav-list">
            <div class="panel-heading"> <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-713737" href="#panel-element-991101" style="font-weight: bold;">房地产</a> </div>
            <div id="panel-element-991101" class="panel-collapse collapse">
              <div class="panel-body">
                <div style="font-size:12px;padding-left:0px;padding-right:0px">
                  <ul class="list-unstyled list-inline" class="small-ul">
                  <li> <a>新房</a> </li>
                  <li> <a>二手房</a> </li>
                  <li> <a>租房</a> </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--  ##########################  -->
        <div class="row clearfix">
          <div class="col-md-12 column top-border" style="padding-top:5px">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title"> 热门推荐 </h3>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-12 column top-border" style="padding-top:5px">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title"> 热销数据 </h3>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-8 column right-border left-border">
        <div class="row clearfix">
          <div class="col-md-12 column">
            <div class="carousel slide" id="carousel-899686">
              <ol class="carousel-indicators">
                <li class="active" data-slide-to="0" data-target="#carousel-899686"> </li>
                <li data-slide-to="1" data-target="#carousel-899686"> </li>
                <li data-slide-to="2" data-target="#carousel-899686"> </li>
              </ol>
              <div class="carousel-inner">
                <div class="item active"> <img alt="" src="./image/1.jpg" />
                  <div class="carousel-caption">
                    <h4> First Thumbnail label </h4>
                    <p>aaaaaaaaaaaaaaaaaaaaaaa. </p>
                  </div>
                </div>
                <div class="item"> <img alt="" src="./image/1.jpg" />
                  <div class="carousel-caption">
                    <h4> Second Thumbnail label </h4>
                    <p> bbbbbbbbbbbbbbbbbbbbbbb. </p>
                  </div>
                </div>
                <div class="item"> <img alt="" src="./image/1.jpg" />
                  <div class="carousel-caption">
                    <h4> Third Thumbnail label </h4>
                    <p> cccccccccccccccccccccc. </p>
                  </div>
                </div>
              </div>
              <a class="left carousel-control" href="#carousel-899686" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-899686" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> </div>
            <div class="row clearfix">
              <div class="col-md-12 column" style="margin-top:20px">
                <div class="tabbable" id="tabs-311394">
                  <ul class="nav nav-tabs">
                    <li class="active"> <a href="#tab_news" data-toggle="tab">手机</a> </li>
                    <li> <a href="#tab_gonggao" data-toggle="tab">电脑</a> </li>
                  </ul>
                  <div class="tab-content" style="margin-top:10px">
                    <div class="tab-pane active col-md-12" id="tab_news">
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
                    <div class="tab-pane col-md-12" id="tab_gonggao">
                      <div class="col-md-3">
                        <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
                          <div style="margin-top:0px;height:50px">
                            <p><a> 淘宝数据1111</a></p>
                            <div class="row clearfix">
                              <p class="col-md-6 column"> 下载量&nbsp; 10 </p>
                              <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-2 column">
        <div class="row clearfix bottom-border">
          <div class="tabbable" id="tabs-311394">
            <ul class="nav nav-tabs">
              <li class="active"> <a href="#tab_news" data-toggle="tab">新闻</a> </li>
              <li> <a href="#tab_gonggao" data-toggle="tab">公告</a> </li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active col-md-12" id="tab_news">
                <ul class="list-unstyled">
                  <li style="text-align:left"> aaa </li>
                  <li style="text-align:left"> bbb </li>
                  <li style="text-align:left"> ccc </li>
                </ul>
              </div>
              <div class="tab-pane col-md-12" id="tab_gonggao">
                <ul class="list-unstyled">
                  <li style="text-align:left"> Lorem ipsum dolor sit amet</li>
                  <li style="text-align:left"> Consectetur adipiscing elit </li>
                  <li style="text-align:left"> Integer molestie lorem at massa </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="row clearfix " style="margin-top:20px;margin-bottom:20px">
          <div class="col-md-6 column">
            <button type="button" class="btn btn-default btn-primary">控制台</button>
          </div>
          <div class="col-md-6 column">
            <button type="button" class="btn btn-default btn-primary">控制台1</button>
          </div>
        </div>
        <div class="row clearfix bottom-border" style="margin-bottom:20px;">
          <div class="list-group"> <a href="http://www.runoob.com/try/bootstrap/layoutit/#" class="list-group-item active">数据排行</a>
            <div class="list-group-item text-left" > <img src="image/1.jpg" style="width:20px;height:20px"/>&nbsp;&nbsp;&nbsp;淘宝数据 <span class="badge">1</span></div>
            <div class="list-group-item text-left""> <img src="image/1.jpg" style="width:20px;height:20px"/> &nbsp;&nbsp;&nbsp;京东数据 <span class="badge">14</span> </div>
            <div class="list-group-item text-left""> <img src="image/1.jpg" style="width:20px;height:20px"/>&nbsp;&nbsp;&nbsp;京东数据 <span class="badge">14</span> </div>
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-12 column">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title"> 商家推荐 </h3>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-12 column top-border" style="padding-top:5px">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title"> 用户推荐 </h3>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
            <div class="thumbnail"><a> <img alt="150x150" src="v3/default6.jpg"  style="height:150px;width:150px"/></a>
              <div style="margin-top:0px;height:50px">
                <p><a> 淘宝数据</a></p>
                <div class="row clearfix">
                  <p class="col-md-6 column"> 下载&nbsp; 10 </p>
                  <p class="col-md-6 column"> 积分&nbsp; 20 </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<script>
   $(function(){
   		$(".left-nav-list").click(function(){
		
		     var index_1=$(".left-nav-list").index($(this));
		    $(".left-nav-list .panel-collapse").each(function(){
			 var index_now=$(".left-nav-list").index($(this));
			
			if(index_1!=index_now)
			{
			   $(this).removeClass("in");
			   }
			})
		})
   
   })
</script>
  </body>
</html>
