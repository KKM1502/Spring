<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiles</title>
<%@include file= "/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<header>
		<h1>Tiles</h1>
		<%@include file= "/WEB-INF/views/inc/main_menu.jsp" %>
		<%@include file= "/WEB-INF/views/inc/member_menu.jsp" %>
	</header>
	<h1>회원 <small>활동내역</small> </h1>
	
	<div class="list">
		<div>15:45:11 밥먹기</div>
		<div>15:40:11 밥먹기</div>
		<div>15:43:11 밥먹기</div>
	</div>

</body>
</html>