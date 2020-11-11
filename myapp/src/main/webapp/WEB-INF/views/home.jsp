<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h3>Test</h3>
	<h3>${message}</h3>
	
	<a href="emp/count"><button>1. 사원의 수</button></a>
	
	<form action="emp/count">
	출력하려는 부서 번호를 입력하세요 : <input type=text name=deptId>
	<input type=submit value=검색>
	</form>
	<br>
	
	<a href="emp/list"><button>2. 사원 목록</button></a>
	<br>
	
	<form action="emp/viewlist">
	3. 사원 정보를 부서번호로 조회 : <input type=text name=deptId>
	<input type=submit value=검색>
	</form>
	<br>
	
	<form action="emp/namelist">
	4. 사원 정보를 이름으로 조회 : <input type=text name=name>&nbsp;
	<input type=submit value=검색>
	</form>
	<br>
	
	</body>
</html>
