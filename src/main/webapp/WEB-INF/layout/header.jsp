<%@page import="com.ssamz.biz.user.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8"
         errorPage="errors/boardError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 프로그램</title>
</head>
<body>
<hr>
<a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<c:if test="${user == null}">
	<a href="insertUserView.do">회원가입</a>&nbsp;&nbsp;&nbsp;
	<a href="loginView.do">로그인</a>&nbsp;&nbsp;&nbsp;
</c:if>

<c:if test="${sessionScope.user != null}">
	<a href="logout.do">로그아웃</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">게시판ver1</a>&nbsp;&nbsp;&nbsp;
</c:if>

<hr>
<br>
