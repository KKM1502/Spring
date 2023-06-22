<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiles</title>
<tiles:insertAttribute name="asset"></tiles:insertAttribute>
<style>

</style>
</head>
<body>
	<header>
		<h1>Tiles</h1>
	<%-- 	<%@include file= "/WEB-INF/views/inc/main_menu.jsp" %> --%>
	<tiles:insertAttribute name="main_menu"></tiles:insertAttribute>
	<%-- 	<%@include file= "/WEB-INF/views/inc/member_menu.jsp" %> --%>
	<tiles:insertAttribute name="member_menu"></tiles:insertAttribute>
	</header>
	
	
	<tiles:insertAttribute name="content"></tiles:insertAttribute>


</body>
</html>