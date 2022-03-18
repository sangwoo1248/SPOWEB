<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${!empty mesg}">
 <script>
   alert('${mesg}');
 </script>
</c:if>    
<form action="LoginServlet" method="get">
아이디:<input type="text" name="userid"><br>
비밀번호:<input type="text" name="passwd"><br>
<input type="submit" value="로그인">
<input type="button" onclick="location.href='Main.jsp'" value="뒤로가기">
<button type="button" onclick="location.href='idFind.jsp'">ID찿기</button>
<button type="button" onclick="location.href='passFind.jsp'">PW찿기</button>
<!-- <input type="submit" value="ID찿기">
<input type="submit" value="PW찿기"> -->
</form>