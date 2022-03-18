<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 보여주기 화면 -->
<body>
<h1 align="center">회원가입</h1>
<hr>
<p>기본정보</p>
<p align="right">*은 필수 입력사항입니다.</p>
<jsp:include page="member/SignUpForm.jsp" flush="true" />
</body>
</html>