<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
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
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<h2>Board <small>list</small> </h2>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>아이디</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr onclick="location.href='/board/view.do?seq=${dto.seq}';">
			<td>${dto.seq }</td>
			<td>${dto.subject }</td>
			<td>${dto.regdate }</td>
			<td>${dto.id }</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<button type="button" class="add" onclick="location.href='/board/add.do';">글쓰기</button>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>