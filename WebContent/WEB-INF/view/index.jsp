<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String id = (String)session.getAttribute("id");
%>
<html>
<head>
<title>Spring - managed by GIT</title>
</head>
<body>
	<div align="center">
		<div style="width: 980px;">
			<div>
				<h1>Spring Project</h1>
				<small>- ${ment } -</small>
				<hr>
			</div>
			<%if(id == null){ %>
			<div>
				<a href="<%=request.getContextPath()%>/login"><button type="button">로그인</button></a> | 
				<a href="<%=request.getContextPath()%>/join"><button type="button">회원가입</button></a> 
			</div>
			<%}else{ %>
			<div align="right">
				<b><%=id %></b>님 환영 합니다♥
				<hr/>
			</div>
			<%} %>
		</div>
	</div>
	<div class="alert alert-warning alert-dismissible" id="warn" style="display: none">
			<a href="javascript:location.reload();" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>경고!</strong> 다른 윈도우 혹은 탭에서 상태가 변경되었습니다.
		</div>
	<script>
		var alertws = new WebSocket("ws://192.168.10.88/chap05/alert");
		alertws.onmessage = function(rst){
			console.log(rst);
			var obj= JSON.parse(rst);
		}
		
		var ws = new WebSocket("ws://${pageContext.request.serverName}/alert");
		ws.onmessage = function(rst) {
			console.log(rst);
			$("#warn").show();
			// var obj = JSON.parse(rst);
		}
		
	
	</script>
	
</body>
</html>