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
        <!-- ###########################左-->
        <div class="col-md-2 column " >
          <div class="row clearfix">
            <div class="col-md-12" >
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
                        <ul  class="list-unstyled list-inline" class="small-ul">
                        <li> <a>新房</a> </li>
                        <li> <a>二手房</a> </li>
                        <li> <a>租房</a> </li>
                        </ul>
                      </div>
                    </div>
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
        <!-- ###########################中-->
        <div class="col-md-8 column right-border left-border">
          <div class="row clearfix">
            <div class="col-md-12 column">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title"> 淘宝手机数据 </h3>
                </div>
              </div>
            </div>
            <div class="col-md-12 column">
              <div class="row clearfix">
                <div class="col-md-6 column"> <img alt="150x150" src="./image/1.jpg" class="img-thumbnail"  style="width:300px;height:300px"/> </div>
                <div class="col-md-6 column">
                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title"> 淘宝手机数据 </h3>
                    </div>
                    <div class="panel-body text-left" > 积分：10 </div>
                    <div class="panel-body text-left"> 销量：100 </div>
                    <div class="panel-body text-left"> 抓取日期：2016-01-01 </div>
                    <div class="panel-body text-left"> 数据量：100000 </div>
                    <div class="panel-body text-left"> 好评度：99% </div>
                  </div>
                  <div class="col-md-6 column">
                    <button type="button" class="btn btn-default">购买</button>
                  </div>
                  <div class="col-md-6 column">
                    <button type="button" class="btn btn-default">收藏</button>
                  </div>
                </div>
              </div>
              <div class="row clearfix">
                <div class="col-md-12 column">
                  <div class="tabbable" id="tabs-151577">
                    <ul class="nav nav-tabs">
                      <li class="active"> <a href="#xxms" data-toggle="tab">详细描述</a> </li>
                      <li > <a href="#csjs" data-toggle="tab">参数介绍</a> </li>
                      <li> <a href="#sjjt" data-toggle="tab">数据截图</a> </li>
                    </ul>
                    <div class="tab-content">
                      <div class="tab-pane active" id="xxms">
                        <div class="panel panel-default">
                          <div class="panel-body text-left " style="font-size:12px" > 淘宝手机数据是 </div>
                        </div>
                      </div>
                      <div class="tab-pane " id="csjs">
                        <div class="panel panel-default">
                          <div class="panel-body text-left" >
                            <div class="col-md-3"><font style="font-weight: bold;">数据平台</font></div>
                            淘宝 </div>
                          <div class="panel-body text-left">
                            <div class="col-md-3"><font style="font-weight: bold;">数据格式</font></div>
                            aa bb cc  dd</div>
                          <div class="panel-body text-left">
                            <div class="col-md-3"><font style="font-weight: bold;">数据量</font> </div>
                            10000 </div>
                          <div class="panel-body text-left">
                            <div class="col-md-3"> <font style="font-weight: bold;">文件大小</font></div>
                            1M</div>
                            <div class="panel-body text-left">
                            <div class="col-md-3"> <font style="font-weight: bold;">文件类型</font></div>
                            txt</div>
                          <div class="panel-body text-left">
                            <div class="col-md-3"><font style="font-weight: bold;">抓取日期</font></div>
                            2016-01-01</div>
                        </div>
                      </div>
                      <div class="tab-pane" id="sjjt">
                        <div class="panel panel-default">
                          <div class="panel-body " ><img alt="140x140" src="./image/1.jpg" class="img-rounded" style="max-width:99%" /> </div>
                          <div class="panel-body "> <img alt="140x140" src="./image/1.jpg" class="img-rounded" style="max-width:99%" /></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- ###########################右-->
        <div class="col-md-2 column">
          <div class="row clearfix bottom-border">
            <div class="list-group" style="margin-top:20px">
            <div class="list-group-item active">
					店铺信息
				</div>
              <div class="list-group-item">
                <h4 class="list-group-item-heading"> 淘宝数据专营店 </h4>
              </div>
              <div class="list-group-item"> <span class="badge">14</span>信用 </div>
              <div class="list-group-item"> <span class="badge">14</span>数据量 </div>
              <button type="button" class="btn btn-primary btn-default btn-block" style="margin-top:15px">进入店铺</button>
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
