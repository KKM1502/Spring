<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
</head>
<body>
	<h1>결과</h1>
	<div class="message" title="데이터">	${dto.name} ${dto.age} ${dto.address} </div>
	
<h1>결과</h1>
	<div class="list">	 
		<c:forEach items="${cb}" >
			${cb["1"]}
		</c:forEach>
	</div>

<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<script>
</script>
</body>
</html>