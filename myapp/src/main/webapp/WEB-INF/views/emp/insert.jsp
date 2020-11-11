<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title> ${message} </title>
</head>
<body>
<h1> 사원 정보 ${message eq "insert" ? "입력" : "수정"}</h1>
<%-- <c:if test="${message eq insert}"> --%>
<%-- <form action="./${message}" method=post modeLAttribute="emp">
<table border=1>
<tr>
<td>사원번호</td><td><input type=text name=employeeId value="${emp.employeeId}" ${empty emp ? "" : "readonly"}></td>
<tr>
<td>이름, 성</td><td><input type=text name=firstName value="${emp.firstName}"><input type=text name=lastName value="${emp.lastName}"></td>
<tr>
<td>이메일<td><input type=text name=email value="${emp.email}" ${empty emp ? "" : "readonly"}></td>
<tr>
<td>연락처</td><td><input type=text name=phoneNumber value="${emp.phoneNumber}"></td>
<tr>
<td>입사일</td><td><input type=date name=hireDate value="${emp.hireDate}"></td>
<tr>
<td>직무</td><td><select name=jobId>
<c:forEach var="job" items="${jobList}">
<option value="${job.jobId}" ${emp.jobId eq job.jobId ? "selecred" : ""}>${job.jobTitle}</option>
</c:forEach>
</select>
</td>
<tr>
<td>급여</td><td><input type=text name=salary value="${emp.salary}"></td>
<tr>
<td>보너스율</td><td><input type=number name=commissionPct min=0 max=0.95 step=0.05 value="${emp.commissionPct}"></td>
<tr>
<td>매니저번호</td><td><select name=managerId>
<c:forEach var="man" items="${manList}">
<option value="${man.managerId}" ${emp.managerId eq man.managerId ? "selecred" : ""}>${man.managerName}</option>
</c:forEach>
</select>
</td>
<tr>
<td>부서번호</td><td><select name=departmentId>
<c:forEach var="department" items="${deptList}">
<option value="${department.departmentId}" ${emp.departmentId eq departmentId.departmentId ? "selecred" : ""}>${department.departmentName}</option>
</c:forEach>
</select>
</td>
</table>
<input type=submit value=저장>&nbsp;&nbsp;<input type="reset" value=취소>  
</form> --%>
<%-- </c:if> --%>

<%-- <c:if test="${message eq update}"> --%>
<form:form action="./${message}" method="post" modelAttribute="emp" enctype="multipart/form-data">
<table border=1>
<tr>
<th>Employee_id</th>
<td><form:input path="employeeId"/>
<form:errors path="employeeId"/><button id="check">중복 검사</button></td>
</tr>
<tr>
<th>First_name</th>
<td><form:input path="firstName"/>
<form:errors path="firstName"/></td>
</tr>
<tr>
<th>Last_name</th>
<td><form:input path="lastName"/>
<form:errors path="lastName"/></td>
</tr>
<tr>
<th>Email</th>
<td><form:input path="email"/>
<form:errors path="email"/></td>
</tr>
<tr>
<th>Phone_number</th>
<td><form:input path="phoneNumber"/>
<form:errors path="phoneNumber"/></td>
</tr>
<tr>
<th>Hire_date</th>
<td><form:input path="hireDate" type="date" required="required"/>
<form:errors path="hireDate"/></td>
</tr>
<tr>
<th>Job_id</th>
<td><form:select path="jobId">
<c:forEach var="job" items="${jobList}">
<option value="${job.jobId}">${job.jobTitle}</option>
</c:forEach>
</form:select></td>
</tr>
<tr>
<th>Salary</th>
<td><form:input path="salary"/>
<form:errors path="salary"/></td>
</tr>
<tr>
<th>Commission_pct</th>
<td><form:input path="commissionPct" type="number" step="0.05"/>
<form:errors path="commissionPct"/></td>
</tr>
<tr>
<th>Manager_Id</th>
<td><form:select path="managerId">
<c:forEach var="man" items="${manList}">
<option value="${man.managerId}">${man.managerName}</option>
</c:forEach>
</form:select></td>
</tr>
<tr>
<th>department_Id</th>
<td><form:select path="departmentId">
<c:forEach var="dept" items="${deptList}">
<option value="${dept.departmentId}">${dept.departmentName}</option>
</c:forEach>
</form:select></td>
</tr>
<tr>
<td>프로필 사진(5Mb 이하)</td><td><input type=file name=file></td>
</tr>
<tr>
<th colspan=2><input type=submit value="저장" id=submit>
<input type=reset value="취소"></th>
</tr>
</table>
</form:form>
<script>
$(function(){
	var ck = false;
	$("#check").on("click",function(){
		if($("#employeeId").val()){
			$.ajax({
				url : "check",
				type : "post",
				data : {empId : $("#employeeId").val()},
				dataType : "text",
				success : function(check){
					if(check){
						alert("중복되지 않습니다.");
						$("#check").remove();
						$("#employeeId").attr("readonly",true);
						ck = !ck;
					}else{
						alert("사원번호가 중복됩니다.");
					}
					return false;
				},
				error : function(){
					alert("ajax에 문제가 있습니다.")
					return false;
				}
			});
		}else{
			alert("입력 값이 없습니다.");
			return false; // 유의 사항 : 리턴 펄스 미 작성 시 폼이 리셋된다.
		}
	});
	$("#submit").on("click",function(){
		if(ck){
			
		}else{
			alert("중복검사를 해주세요")
			return false;
		}
	});
});
</script>


<%-- </c:if> --%>

<%-- <c:choose>
<c:when test="${message eq insert}"></c:when>

<c:otherwise>


</c:otherwise>
</c:choose> --%>

</body>
</html>