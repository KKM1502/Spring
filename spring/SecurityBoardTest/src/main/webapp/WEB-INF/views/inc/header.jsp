<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
	<header>
		<sec:authorize access="isAnonymous()">
		<h1>Spring Security</h1>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_MEMBER')">
		<h1 style="background-color:cornflowerblue;">Spring Security</h1>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_MEMBER')">
		<h1>관리자</h1>
		</sec:authorize>
		<ul>
			<li> <a href="/index.do">Home</a></li>
			<li class="divider"></li>
			<sec:authorize access="isAnonymous()">
			<li> <a href="/member/login.do">Login</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<li> <a href="/member/logout.do">Logout</a></li>
			</sec:authorize>
			<li class="divider"></li>
			<li> <a href="/board/list.do">Board</a></li>
		</ul>
	</header>