<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Runtime Exception</title>
</head>
	<body>
		<h1>Error</h1>
		<p>오류발생! 관리자에게 연락하시려면 gctserf@gmail.com 또는  010-1111-1111으로 연락주세요.</p>
		<!-- Failed URL : ${url}
		Exception : ${exception.message}
		<c:forEach items="${exception.stackTrace}" var="ste"> ${ste}</c:forEach>
		 -->
	</body>
</html>