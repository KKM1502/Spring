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
	<!--  -->
	<h1>결과</h1>
	<div class="message" title="삭제">${result}</div>
	<div class="message" title="리스트count"> ${count}</div>
		${dto.seq}
		${dto.name}
		${dto.age}
		${dto.address}
		${dto.gender}

	<c:forEach items="${names }" var="name">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td>${name}</td>
		</tr>
	</table>	
	</c:forEach>
	<table class="vertical">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>성별</th>
		</tr>
	<c:forEach items="${list }" var="dto">
		<tr>
			<th>${dto.seq}</th>
			<th>${dto.name}</th>
			<th>${dto.age}</th>
			<th>${dto.address}</th>
			<th>${dto.gender}</th>
		</tr>
	</c:forEach>
	</table>	
	
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






