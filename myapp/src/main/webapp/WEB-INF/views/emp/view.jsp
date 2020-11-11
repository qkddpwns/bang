<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
	<body>
		<h3>사원 정보</h3>
		<table border="1">
			<tr>
			<th>사원번호</th>
			<td>${emp.employeeId}</td>
			</tr>
			<tr>
			<th>성</th>
			<td>${emp.firstName}</td>
			</tr>
			<tr>
			<th>이름</th>
			<td>${emp.lastName}</td>
			</tr>
			<tr>
			<th>이메일</th>
			<td>${emp.email}</td>
			</tr>
			<tr>
			<th>연락처</th>
			<td>${emp.phoneNumber}</td>
			</tr>
			<tr>
			<th>입사일</th>
			<td>${emp.hireDate}</td>
			</tr>
			<tr>
			<th>직무</th>
			<td>${emp.jobTilte}(${emp.jobId})</td>
			</tr>
			<tr>
			<th>급여</th>
			<td>${emp.salary}</td>
			</tr>
			<tr>
			<th>보너스율</th>
			<td>${emp.commissionPct}</td>
			</tr>
			<tr>
			<th>매니저</th>
			<td>${emp.managerName}(${emp.managerId})</td>
			</tr>
			<tr>
			<th>부서</th>
			<td>${emp.departmentName}(${emp.departmentId})</td>
			</tr>
			<tr>
		</table>
		<a href="update/${emp.employeeId}">정보 수정</a>
		<a href="delete/${emp.employeeId}">정보 삭제</a>
	</body>
</html>