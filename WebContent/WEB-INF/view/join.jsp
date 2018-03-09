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
				<small>- 회 원 가 입 -</small>
				<hr>
			</div>
			<form action="/join" method="post">
			<div >
			<table style="padding-bottom: 5px;">
				<tr>
					<td><b>ID</b></td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td><b>EMAIL</b></td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td><b>PASS</b></td>
					<td><input type="password" name="pass"/></td>
				</tr>
			</table>
			<button type="submit" style="width:23%;">가 입 신 청</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>