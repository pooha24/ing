<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div>
			<a href="<%=request.getContextPath()%>/login"><button type="button">로그인</button></a> | 
			<a href="<%=request.getContextPath()%>/join"><button type="button">회원가입</button></a> 
			</div>
		</div>
	</div>
</body>
</html>