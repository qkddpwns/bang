<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form:form action="" method="post" modelAttribute="emp" enctype="multipart/form-data">
<table border=1>
<tr>
<th>UserId</th>
<td><form:input path="userId"/>
<form:errors path="userId"/><button id="check">중복 검사</button></td>
</tr>
<tr>
<th>PassWord</th>
<td><form:input path="passWord"/>
<form:errors path="passWord"/></td>
</tr>
<tr>
<th>Name</th>
<td><form:input path="name"/>
<form:errors path="name"/></td>
</tr>
<tr>
<td>프로필 사진(5Mb 이하)</td><td><input type=file name=file></td>
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
				data : $("#userId").val(),
				dataType : "text",
				success : function(check){
					if(check){
						alert("중복되지 않습니다.");
						$("#check").remove();
						$("#userId").attr("readonly",true);
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
</body>
</html>
