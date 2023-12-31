<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
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
	
	<h2>Info Page</h2>
	
	<div class="message" title="principal">
		<sec:authentication property="principal"/>
	</div>
	<div class="message" title="MemberDTO">
		<sec:authentication property="principal.member"/>
 	</div>
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.member.userid"/>
	</div>
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.username"/>
	</div>
	<div class="message" title="사용자 이름">
		<sec:authentication property="principal.member.username"/>
	</div>
			 
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.member.authlist"/>
	</div>
			 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






