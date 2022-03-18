<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/* $(document).ready(function(){

    $("#btnDelete").click(function(){

        // 확인 대화상자 

        if(confirm("삭제하시겠습니까?")){

            document.wd.action = "Withdrawal.jsp";

            document.wd.submit();

        }

    });

}); */
</script>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<div id="container">
<h2>탈퇴 안내</h2>
</div>
<p class="contxt">회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
<div>
			<h3>
				사용하고 계신 아이디(<em>${login.userid}</em>)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
			</h3>
			<p>
				<em>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</em>하오니 신중하게 선택하시기 바랍니다.
			</p>
			
			<h3>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</h3>
			<p>
			회원정보 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.<br>
			삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.
			</p>
			
			<table cellspacing="0" border="1" 
			summary="탈퇴 후 회원정보 및 개인형 서비스 이용기록 삭제 안내" class="tbl_type">
			<caption>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</caption>
			<colgroup>
			<col width="145"><col width="*">
			</colgroup>
			<tbody> 
			<tr>
			<th scope="row">회원정보</th>
			<td>회원정보 모두 삭제</td>
			</tr>
			
			<tr>
			<th scope="row">구매 물품</th>
			<td>구매 물품 모두 삭제</td>
			</tr>

            
			<tr>
			<th scope="row">modoo!(모두)</th>
			<td>등록된 리뷰 게시물 삭제</td>
			</tr>			

			<tr>
			<th scope="row">SPOWEB 이용 이력</th>
			<td>이용내역, 보유 중인 할인 쿠폰 등 관련된 모든 정보 삭제, 포인트 소멸 및 약관 동의 철회</td>
			</tr>
							
            <tr>
			<th scope="row">기타</th>
			<td>아이디에 연계된 개인적 영역의 정보 및 게시물 삭제</td>
			</tr>
			</tbody>
			</table>
			
			
			<p>
				삭제를 원하는 게시글이 있다면 <em>반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.</em>			     
			<br>
				탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 
				게시글을 임의로 삭제해드릴 수 없습니다. 			 
			</p>
			
			<form name="wd" id ="wd" method="post">
				<input type="hidden"/>
				<input type="hidden" value="ko_KR" />
				<div>
					<p>
						<strong>
						     	  탈퇴 후에는 아이디 <em>sw</em> 로 다시 가입할 수 없으며 아이디와 데이터는 복구할 수 없습니다.
						     <br>
								 게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다.
							</strong>
					</p>
					<input type="checkbox" id="chDel" name="chDel">
					<label for="chDel"><strong>안내 사항을 모두 확인하였으며, 이에 동의합니다.</strong></label>
				</div>
				<input type="button" id="wdDel" onclick="location = 'Withdrawal.jsp'"
				value="탈퇴"/> 
				<input type="button" value="취소" onclick="location = 'mypage.jsp'">			
			</form>
		</div>
</body>
</html>