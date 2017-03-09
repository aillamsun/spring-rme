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
			<table class="table">
				<thead>
					<tr>
						<th>名称</th>
						<th>交易类型</th>
						<th>充值平台</th>
						<th>内部平台</th>
						<th>交易积分</th>
						<th>交易前积分</th
						<th>剩余积分</th>
						<th>交易时间</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="credit" items="${page.results}">
					<tr>
						<td>${credit.reson }</td>
						<td>${credit.tradeTypeStr }</td>
						<td>${credit.fromPlatform }</td>
						<td>${credit.gdTypeStr }</td>
						<td>${credit.tradeCredits }</td>
						<td>${credit.preCredits }</td>
						<td>${credit.nowCredits }</td>
						<td>${credit.dateTimeStr }</td>
						<td>${credit.remark }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
