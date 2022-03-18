<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>SPOWEB</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }

    function member(){
    	//아이디 입력 여부
    	if(f.userid.value==""){
    		alert("아이디를 입력하지 않했습니다");
    		f.userid.focus();
            return false;
    	}
    	//아이디 유효성 검사
    	for(var i = 0; i<document.userid.value.length; i++){
    		ch=document.f.userid.value.charAt(i)
    		if(!(ch>='0'||ch<='9')&&!(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')){
    			alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.")
                document.f.userid.focus();
                document.f.userid.select();
                return false;
    		}
    	}
    	
    	//비밀번호 유효성 검사
    	if (f.passwd.value == "") {
            alert("비밀번호를 입력하지 않았습니다.")
            f.passwd.focus();
            return false;
        }
        if (f.passwd.value == f.userid.value) {
            alert("아이디와 비밀번호가 같습니다.")
            document.f.passwd.focus();
            return false;
        }
        //비밀번호 길이 체크(4~8자 까지 허용)
        if (document.f.passwd.value.length<4 || document.f.passwd.value.length>16) {
            alert("비밀번호를 4~16자까지 입력해주세요.")
            document.f.passwd.focus();
            document.f.passwd.select();
            return false;
        }
        //비밀번호와 비밀번호 확인 일치여부 체크
        if (document.f.passwd.value != document.f.password2.value) {
            alert("비밀번호가 일치하지 않습니다")
            document.f.passwd2.value = ""
            document.f.passwd2.focus();
            return false;
        }
    }
</script>
<form name = "f" action="MemberAddServlet" method="get" onsubmit="return member();">
<table border="1" bordercolor="skyblue">

<tr>
<th scope="row" bgcolor="blue">아이디* 
</th>
<td> 
<input type="text" name="userid" id="userid">
<span id="result">(영문소문자/숫자, 4~16자)</span><br>
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">비밀번호*
</th>
<td><input type = "text" id="passwd" name="passwd" maxlength="16" size="16"/> 
<span id="result">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)</span><br>
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">비밀번호확인*
</th>
<td><input type = "text" id="passwd2" name="passwd2" maxlength="16" size="16"/> 
<span id="result"></span><br>
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">이름*
</th>
<td><input type = "text" id="username" name="username"/> 
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">주소*
</th>
<td>
<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span><br>
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">전화번호
</th>
<td>
<select name="phone1">
  <option value="010">010</option>
  <option value="011">011</option>
</select>
<input type="text" name="phone2" >-<input type="text" name="phone3">
<br>
</td>
</tr>

<tr>
<th scope="row" bgcolor="blue">이메일
<td>
	   <input type="text" name="email1" id="email1">@
       <input type="text" name="email2" id="email2" placeholder="직접입력">
       <select  id="emailSelect">
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
        </select><br>
</td>
</tr>

</table>
<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>