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
	<script src="resource/highcharts/js/highcharts.js"></script>  
<script src="resource/highcharts/js/highcharts-3d.js"></script>  
<script src="resource/highcharts/js/modules/exporting.js"></script>  
<script language="javascript" type="text/javascript" src="<%=basePath%>resource/commons/calendar/WdatePicker.js"></script>
  </head>
  
  <body>
  <script type="text/javascript">
  var count_msg='${countMsg}';
	eval("var result="+count_msg);
  var zx_big_title=result.zx_big_title;
  var zx_small_title="..";
  var zx_categories=[];
  var zx_data=[];
  var content=result.content;
  for(int i=0;i<content.length;i++)
	  {
	   zx_categories.push(content[i].zx_categories);
	   zx_data.push(content[i].zx_data);
	  }
  </script>
  <div class="row clearfix">
  <div class="col-md-12 column">
			<form role="form" class="form-inline" method="post" id="countForm">
				<div class="form-group">
					 <input type="text" class="form-control" id="startTime" onClick="WdatePicker()"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="endTime" onClick="WdatePicker()"/>
				</div>
				
				<div class="form-group">
					<select id="timeType">
						<option value="1">日</option>
						<option value="2">月</option>
						<option value="3">年</option>
					</select>
				</div>
				<button type="buttom" id="countButton" class="btn btn-default">查询</button>
			</form>
		</div>
	<div class="col-md-12 column">
	   <div id="container"></div>  
	 </div>
	</div>
	<script type="text/javascript">
	
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'line'
	        },
	        title: {
	            text: zx_big_title
	        },
	        subtitle: {
	            text: zx_small_title
	        },
	        xAxis: {
	            categories: zx_categories
	        },
	        yAxis: {
	            title: {
	                text: '单位 (条)'
	            }
	        },
	        plotOptions: {
	            line: {
	                dataLabels: {
	                    enabled: true
	                },
	                enableMouseTracking: false
	            }
	        },
	        series: [{
	            name: '统计',
	            data: zx_data
	        }]
	    });
	});

	
	
	  $(".countButton").click(function(){
		  var reg=/^\d{4}-\d{2}-\d{2}/g;
		  var reg2=/^\d{4}-\d{2}-\d{2}/g;
		 
			var beginTime=$("#startTime").val();
			var endTime=$("#endTime").val();
			
		  if(beginTime.length!=0&&!reg.test(beginTime))
				{
				    alert("起始日期格式不正确"+beginTime);
				    return ;
				}
			if(endTime.length!=0&&!reg2.test(endTime))
			{
			    alert("终止日期格式不正确");
			    return ;
			}
			var timeType=$("#timeType").val();
			var requestUrl="p_robot/robot/";
			if(timeType==1)//按日
				{
				  requestUrl=requestUrl+"robot_day_call_analysis.shtml";
				}
			else if(timeType==2)//按月
				{
				 requestUrl=requestUrl+"robot_month_call_analysis.shtml";
				}
			else{//按年
				 requestUrl=requestUrl+"robot_year_call_analysis.shtml";
			 }
			
			$("#countForm").attr("action",requestUrl);
			$("#countForm").submit();
			/* $.ajax({
				type : "POST",
				//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
				url : requestUrl,
				data : {
					"startTime" : startTime,
					"endTime":endTime
				},
				success : function(data) {
					//	alert(data);
					if (data == "error") {
						alert("查询出错")
					} else {
						
						return;
					}

				}
			}) */
		    	
		});
	</script>
  </body>
</html>
