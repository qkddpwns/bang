<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
	<body>
		삭제하려는 ${emp.firstName}${emp.lastName}은
		<h3>${count.empCount}</h3>명의 매니저이고<br>
		<h3>${count.empCount}</h3>개의 부서를 책임지고 있습니다.<br>
		<h3>정말 삭제하시겠습니까?</h3>
		<form action="delete" method="post">
			<input type="hidden" name=empId value="${emp.employeeId}">
			<input type=submit value=삭제>
			<input type="button" value=취소 onclick="history.back(-1)">
		</form>
	</body>
</html>