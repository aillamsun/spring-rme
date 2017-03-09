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
<script type="text/javascript" src="resource/commons/js/ajaxfileupload.js"></script>
  </head>
  
  <body>
  <div class="row clearfix">
  <div class="col-md-3 column"> </div>
  <div class="col-md-9 column">
    <div class="btn-group btn-group-lg" style="float:right">
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-left"></em>上传数据 </button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-center"></em>数据预览</button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-right"></em>删除数据</button>
      <button class="btn btn-default" type="button" style="font-size:12px"><em class="glyphicon glyphicon-align-justify"></em>下架</button>
    </div>
  </div>
</div>
<div class="col-md-6 column col-md-offset-3" style="margin-top:20px" >
  <div class="tabbable" id="tabs-888452">
    <form role="form">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">一级分类</label>
        <div class="col-sm-9">
          <select class="form-control">
            <option>电子产品</option>
            <option>汽车</option>
            <option>房地产</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">二级分类(<a>上报</a>)</label>
        <div class="col-sm-9" style="margin-bottom:10px">
          <select class="form-control">
            <option>手机</option>
            <option>电脑</option>
            <option>相机</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">名字</label>
        <div class="col-sm-9"  style="margin-bottom:10px">
       <input type="text" class="form-control" id="inputEmail3" />
        </div>
      <div class="form-group">
      <label></label>
        <div>
          <button type="button" class="btn btn-default" OnClick='javascript:document.getElementById("selectData").click();'>未选择数据文件</button>
          <input type="file" id="selectData" style="visibility:hidden"/>
        </div>
      </div>
      <div class="form-group">
        <div>
          <button type="button" class="btn btn-default" OnClick='javascript:document.getElementById("selectImg").click();'>未选择图片</button>
          <input type="file" id="selectImg" style="visibility:hidden"/>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">详细描述</label>
        <div class="col-sm-9"  style="margin-bottom:10px">
        <textarea class="form-control"></textarea>
        </div>
       
      </div>
       <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">数据平台</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
       
       </div>
        <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">数据格式</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
   
       </div>
        <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">文件类型</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
     
       </div>
        <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">文件大小</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
       </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">数据量</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
       </div>
       <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">抓取时间</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
       </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-3 control-label">消费积分</label>
        <div class="col-sm-7">
          <input type="text" class="form-control" id="inputEmail3" />
        </div>
        <label  class="  text-danger" style="font-size:12px">请填整数</label>
      </div>
        <div class="form-group" >
        </div>
      <div class="form-group" >
          <div class="col-sm-12" style="margin-top:20px">
               <button type="submit" class="btn btn-default">确定</button>
          </div>
      </div>
      <div class="form-group">
        <div>
          <button type="button" class="btn btn-default" OnClick='javascript:document.getElementById("selectImg").click();'>未选择图片</button>
          <input type="file" id="selectImg" style="visibility:hidden"/>
        </div>
      </div>
    </form>
  </div>
</div>
</div>
<script type="text/javascript">

function ajaxFileUploadPic(projectId,name,type) {  
    $.ajaxFileUpload({  
        url : '${ctx}/projectPic/saveorupdate.jhtml?projectId='+projectId+'&name='+name+'&type='+type, //用于文件上传的服务器端请求地址  
        secureuri : false, //一般设置为false  
        fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />  
        type : 'post',  
        dataType : 'json', //返回值类型 一般设置为json  
        success : function(data, status) //服务器成功响应处理函数  
        {  
             $("#picList").datagrid('reload');  
             $('#uploadPicWindow').window('close');  
            // alert(data.msg);  
        },  
        error : function(data, status, e)//服务器响应失败处理函数  
        {  
             $("#picList").datagrid('reload');  
             $('#uploadPicWindow').window('close');  
            // alert(data.msg);  
        }  
    });  
    return false;  
}  
</script>
  </body>
</html>
