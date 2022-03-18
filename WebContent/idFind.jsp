<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>   
<script type="text/javascript">
function id_search()
{
    var f = document.id;

        if(f.username.value=="")
        {
            alert("이름을 입력해주세요.");
            f.username.focus();
            return;
        }

        if(f.email1.value=="")
        {
            alert("E-mail을 입력해주세요.");
            f.email1.focus();
            return;
        }
        
	f.submit();
}

function checkemail(){
    if (id.emailSelect == '1') {
        id.email2.readonly = false;
        id.email2.value = '';
        id.email2.focus();
    }
    else {
        id.email2.readonly = true;
        id.email2.value = id.emailSelect.value;
    }
}
</script> 
<title>아이디찿기</title>
<form name="id" id="id" action="IdFindServlet" method="get">
<table width="1330px" height="430px" align="center">
    <tr>
     <td>
      <table width="600px" align="center" border="0"
       style="color: black; background-color: sky; font-size: 20px;">
       <tr>
        <td>
         <table width="750px" align="center" border=0;
          style= "background-color: white; margin-top: 3%">
          <tr>
           <td align="left"><img src="image/main.PNG"
            height="30px"></td>
            <td align="left">아이디 찾기</td>
           <td><div id="sub-title" align="right">| 회원정보에 등록한 정보로 인증.</td>
           <td></td>
          </tr>
         </table>
        </td>
       </tr>

          <tr>
           <td>
            <table width="300px" height="20px" border="0"
             style="margin-top: 3%; font-size: 18px;">
             <br>
             <br>
             <tr>
              <td>
              &nbsp;&nbsp; <img src="image/main.PNG" height="30px">
              </td>
              <td>&nbsp;이름,이메일로 찾기</td>
             </tr>
            </table>
           </td>
          </tr>

		  <tr>
          <td>
           <table width="380px" height="70px" align="center" border="0"
            style="font-size: 16px;">
            <tr>
             <td>이름</td>
             <td><input type="text" name="username" id="username"></td>
            </tr>
            <tr>
             <td style="text-align: center;">e-mail&nbsp;</td>
             <td><input type="text" name="email1" id="email1" style="width: 80px">@ 
              <input type="text" name="email2" id="email2" style="width: 80px"> 
              <select name="emailSelect" onchange="checkemail();">
               <option value="" selected>선택</option>
       		   <option value="">직접입력</option>
        	   <option value="daum.net">daum.net</option>
        	   <option value="naver.com">naver.com</option>
        	   <option value="gmail.net">gmail.net</option>
             </select>
             </td>
            </tr>
           </table>
          </td>
          </tr>

          <tr>
           <td>
            <table width="140px" height="10px" border="0"
             style="margin-top: 2%" align="center">
             <tr>
              <td><input type="button" id="button" onclick="id_search();" value="찿기"
              style="cursor: pointer; background: white; color: black; 
              border-color: black">
              </td>
              <td>
            <input type="button" id="button" onclick="location.href='loginForm.jsp'" 
            value="취소" style="cursor: pointer; background: white; color: black; 
            border-color: black"> 
             </td>
             </tr>
            </table>
            <br>
           </td>
          </tr>
         </table>
        </td>
       </tr>
      </table>
   </form>
   
<!-- <form name="id" id="id" action="IdFindServlet" method="get"> 
<h1>아이디 찿기</h1>     
이름<input type = "text" name="username" id="username"><br>
이메일:<input type="text" value="" name="email1" id="email1">@
       <input type="text" value="" name="email2" id="email2">
       <select  id="emailSelect" name="emailSelect" onChange="checkemail();">
       <option value="" selected>선택</option>
       <option value="">직접입력</option>
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
        <option value="gmail.net">gmail.net</option>
       </select>
<br>
<input type="button" id="button" onclick="id_search();" value="찿기">
</form>   
 -->

