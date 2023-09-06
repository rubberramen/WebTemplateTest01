<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-04
  Time: PM 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
	<head> 
    	<meta charset="utf-8">
<title>웹페이지 제목</title>
	</head> 
	<body>
	<c:set var='i' value='abc' />
	<c:out value="${i}" />
        정수 : ${35}<br>
        실수 : ${35.8}<br>
        문자열 : ${"SSAMZ"}<br>
	</body>
</html>