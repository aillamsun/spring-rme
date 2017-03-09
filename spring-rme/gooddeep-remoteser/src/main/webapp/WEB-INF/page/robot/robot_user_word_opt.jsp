<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>用户关键词操作</title>

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
				<div class="col-md-6 column"></div>
				<div class="col-md-6 column">
					<div class="btn-group btn-group-lg" style="float:right">
						<a href="p_robot/robot/robot_replys_page.shtml">
							<button class="btn btn-default" type="button"
								style="font-size:12px">
								<em class="glyphicon glyphicon-align-center"></em> 列表
							</button>
						</a>

					</div>
				</div>
			</div>
			<div class="row clearfix top-border " style="margin-top:10px">
				<div class="col-md-12 column">
					<div class="tabbable" id="tabs-842940">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#shoudongshangchuan"
								data-toggle="tab">手动上传</a></li>
							<li><a href="#excelshangchuan" data-toggle="tab">excel上传</a></li>
							<li><a href="#ceshi" data-toggle="tab">测试</a></li>
						</ul>
						<div class="tab-content" style="margin-top:20px">
							<div class="tab-pane active" id="shoudongshangchuan">
								<form role="form" method="post"
									action="p_robot/robot/nsajax/robot_replys_handle_add.shtml">
									<div class="form-group">
										<label for="exampleInputEmail1">关键词句</label> <input
											type="text" class="form-control" name="keyword"
											id="handle_keyword" />
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">回复</label>
										<textarea class="form-control" name="reply" id="handle_reply"></textarea>

									</div>
									<button type="button" id="robot_replys_handle_add"
										class="btn btn-default">提交</button>
								</form>
							</div>
							<div class="tab-pane" id="excelshangchuan">
								<form role="form" method="post"
									action="p_robot/robot/robot_replys_excel_add.shtml"
									enctype="multipart/form-data">

									<div class="form-group">
										<!--  <label for="exampleInputFile">File input</label> -->
										<p>
											<button type="button" class="btn btn-default"
												OnClick='javascript:document.getElementById("uploadExcel").click();'>选择文件</button>
											<input type="file" id="uploadExcel" name="file"
												style="visibility:hidden;" />
										</p>

									</div>
									<button type="submit" id="uploadExcel" class="btn btn-default">确定</button>
								</form>
							</div>
							<div class="tab-pane" id="ceshi">
								<form role="form">
									<div class="form-group">
										<input type="text" class="col-md-3 column" id="t_robot_apiKey"
											placeholder="robot_apiKey：钥匙" /> <input type="text"
											class="col-md-3 column" id="t_reply_size"
											placeholder="reply_size：结果集大小" />
										<!-- <input type="text" class="form-control col-md-3" id="t_is_height" placeholder="is_height：是否高亮" /> -->
										<label>是否高亮</label> <label class="checkbox-inline"> <input
											type="radio" name="t_is_height" value="false"
											checked="checked" />否
										</label> <label class="checkbox-inline"> <input type="radio"
											name="t_is_height" value="true"> 是
										</label>

									</div>
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="输入您想说的内容..." id="t_keyword" name="t_keyword"
											style="height:30px"> <span class="input-group-btn">
											<button class="btn btn-default" type="button" id="t_tijiao"
												style="height:30px">对话</button>
										</span>
									</div>

									<div class="tabbable" id="tabs-29649">
										<ul class="nav nav-tabs">
											<li class="active"><a href="#panel-785743"
												data-toggle="tab">对话结果</a></li>
											<li><a href="#panel-763719" data-toggle="tab">返回代码</a></li>
										</ul>
										<div class="tab-content">
											<div class="tab-pane active" id="panel-785743">
												<label style="width:100px">状态：</label><label id="errorMsg"></label>

												<table class="table  table-condensed table-bordered">
													<thead>
														<tr>
															<th>编号</th>
															<th>命中</th>
															<th>回复</th>
														</tr>
													</thead>
													<tbody id="returnMsg">
														<!-- <tr>
															<td>1</td>
															<td>TB - Monthly</td>
															<td>01/04/2012</td>
														</tr> -->
														
													</tbody>
												</table>
											</div>
											<div class="tab-pane" id="panel-763719">
												<p id="retuenCode"></p>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {

			$("#robot_replys_handle_add").click(function() {
				var keyword = $("#handle_keyword").val();
				var reply = $("#handle_reply").val();
				//alert(keyword)
				if (keyword.length == 0) {
					alert("关键字不能为空");
					return;
				}
				if (reply.length == 0) {
					alert("回复不能为空");
					return;
				}

				$.ajax({
					type : "POST",
					//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
					url : "p_robot/robot/nsajax/robot_replys_handle_add.shtml",
					data : {
						"keyword" : keyword,
						"reply" : reply
					},
					success : function(data) {
						if (data == "correct")
							alert("添加成功");
						else
							alert("添加失败");

					}
				})

			})

			$("#t_tijiao")
					.click(
							function() {

								$("#errorMsg").html("");
								$("#returnMsg").html("");
								$("#retuenCode").html("");
								var t_keyword = $("#t_keyword").val();
								var t_robot_apiKey = $("#t_robot_apiKey").val();
								var t_reply_size = $("#t_reply_size").val();

								if (t_keyword.length == null) {
									alert("关键字不能为空");
									return;
								} else if (isNaN(t_reply_size)) {
									alert("t_reply_size必须为数字")
									return;
								}
								var t_is_height = $("input[name='t_is_height']:checked").val();

								$.ajax({
											type : "POST",
											//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
											url : "p_robot/robot/nsajax/robot_replys_test.htm",
											data : {
												"keyword" : t_keyword,
												"reply_size" : t_reply_size,
												"robot_apiKey" : t_robot_apiKey,
												"is_height" : t_is_height
											},
											success : function(data) {
												eval("var jsonData=" + data);
												var error_code = jsonData.error_code;
												if (error_code == "ROBOT_000") {
													
													var reply_msgs = jsonData.reply_msgs;
													$("#errorMsg").append("<label style='color:red'>查询成功，命中:"+reply_msgs.length+"条</label>");
													//alert(reply_msgs.length)
													for (var i = 0; i < reply_msgs.length; i++) {
														var ask_words = reply_msgs[i].ask_words;
														var reply_words = reply_msgs[i].reply_words;
														var html=" <tr><td>"+(i+1)+"</td><td>"+ask_words+"</td><td>"+reply_words+"</td></tr>";
														$("#returnMsg").append(html);
													}
												} else {
													$("#errorMsg").append("<label style='color:red'>查询失败，原因："+ jsonData.error_msg+ "</label>");
												}

												$("#retuenCode").text(data);
											}
										})

							})
		})
	</script>

</body>
</html>
