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
	<h2>Board <small>view</small></h2>

	<table class="vertical">
		<tr>
			<th>번호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id }</td>
		</tr>
		<tr>	
			<th>내용</th>
			<td>${dto.content }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate }</td>
		</tr>
	</table>
	<div>
		<button type="button" class="back" onclick="location.href='/board/list.do'">돌아가기</button>
		<sec:authentication property="principal" var="pinfo"/>
		
		<sec:authorize access="isAuthenticated() and !hasRole('Role_ADMIN')">
		
		<c:if test="${pinfo.username==dto.id }">
		<button type="button" class="edit" onclick="location.href='/board/edit.do?seq=${dto.seq}'">수정하기</button>
		<button type="button" class="del" onclick="location.href='/board/del.do?seq=${dto.seq}'">삭제하기</button>
		</c:if>
		
		</sec:authorize>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>