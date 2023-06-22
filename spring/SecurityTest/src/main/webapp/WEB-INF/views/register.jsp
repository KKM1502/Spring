<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>	
<body>
	<!-- template.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Register Page</h2>
	
	<form action="/security/registerok.do" method="Post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name= "userid" required></td>
			</tr>
			<tr>
				<th>비번</th>
				<td><input type="password" name= "userpw" required></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name= "username" required></td>
			</tr>
			<tr>
				<th>권한</th>
				<td> <select  name= "auth" required>
						<option value="1" >일반회원</option>
						<option value="2" >관리자</option>
					</select>
			</tr>
		</table>
		<div>
			<input type="submit" value="제출">
		</div>
		<input type="hidden" name="${_csrf.parameterName }" value= "${_csrf.token}">
	</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






