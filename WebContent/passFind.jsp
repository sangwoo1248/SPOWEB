<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찿기</title>
</head>
<body>
<form name="pw" id="pw" action="PassFindServlet" method="get">
<table width="1330px"  border="0"  height="430px" align="center"   >
   <tr>
    <td>
     <table width="450px" align="center"  border="0" 
     style="color:black; background-color: sky; font-size:20px; ">
    <tr>
    <td>
     <table width="750px" align="center" border=0; 
     style="background-color:white; margin-top:3%" >
      <tr>
       <td align="center"><img src="image/main.PNG" height="30px"></td>
       <td align="left">비밀번호 찾기</td>
       <td><div id="sub-title" align="right"> |  회원정보에 등록한 정보로 인증.</td>
      </tr>
     </table>
    </td> 
    </tr>       
   <tr> 
    <td>
   <table width="600px"  height="300px" align="center" border="0"  
   style=" background-color:none; border:dotted 5px none;">
    <tr>
     <td>
      <table width="400px"  border="0" style="margin-top:3%">
       <tr>
        <td></td>
        <td><div id="middle-title">&nbsp;아이디와 핸드폰번호를 입력해주세요.</div>
        </td>
       </tr>
      </table>
     </td>
    </tr>

    <tr>
     <td>
      <table width="380px" align="center" border="0" style="font-size:19px">
       <tr>
        <td>아이디</td>
        <td><input type="text" name="userid" id="userid"></td>
       </tr>
       <tr>
        <td>휴대폰</td>
        <td><select name="phone1">
        <option value ="010" selected="selected">010</option>
        <option value ="011">011</option>
        <option value ="016">016</option> 
        <option value ="017">017</option>
        </select> -
        <input type="text" name="phone2" id="phone2" style="width:70px"> -
        <input type="text" name="phone3" id="phone3" style="width:70px"></td>
       </tr>
      </table>
     </td>
    </tr>
   
    <tr>
     <td>
      <table width="150px"  align="center" border="0" style="margin-top:1%">
       <tr>
        <td>
        <input type="button" id="button" onclick="pw_search();" value="찿기">
        <input type="button" id="button" 
        onclick="location.href='loginForm.jsp'" value="취소"> 
        </td>
       </tr>
      </table>
     </td>
    </tr>

  </table>
 </td>
</tr>
</table>
</td>
</table>
</form>
</body>
</html>

<script>
function pw_search()
{
    var f = document.pw;

        if(f.userid.value=="")
        {
            alert("아이디를 입력해주세요.");
            f.userid.focus();
            return;
        }

        if(f.phone2.value=="")
        {
            alert("번호 입력.");
            f.phone2.focus();
            return;
        }
        if(f.phone3.value=="")
        {
            alert("번호 입력.");
            f.phone3.focus();
            return;
        }
        
	f.submit();
}
</script>