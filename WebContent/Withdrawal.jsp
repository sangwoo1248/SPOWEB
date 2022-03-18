<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<script type="text/javascript">

/* function pw_check(){
    if(!document.deletewd.passwd.value){
        alert("비밀번호를 입력하지 않았습니다.");
        return false;
    }
} */


function ck_passwd()
{
    var f = document.deletewd;

        if(f.passwd.value=="")
        {
            alert("비밀번호 입력");
            f.passwd.focus();
            return;
        }
        
	f.submit();
} 

</script>
<body>
   <br><br>

    <b><font size="6" color="gray">회원탈퇴</font></b>

    <br><br><br>
<form name="deletewd" id="deletewd" method="get" action="WithdrawalServlet">
<table>
	<tr>
	 	<td>비밀번호 입력</td>
			<td><input type="text" name="passwd" id="passwd" maxlength="50"></td>
	</tr>
</table>
<input type="button" id="wdDel" onclick = "ck_passwd();" value="탈퇴"/> 
<input type="button" onclick="location = 'mypage.jsp'" value="취소">
</form>
</body>
</html>