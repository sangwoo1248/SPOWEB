<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
<script type="text/javascript">
function proinfo(action, MyForm){
	if(action=='cart'){
		MyForm.action="CartAddServlet"
	}
	else{
		MyForm.action="OderAddServlet"
	}
}

$(document).ready(function() {

	$("#up").on("click", function() {
		var count = $("#sAmount").val();
		$("#sAmount").val(parseInt(count) + 1);
	});
	$("#down").on("click", function() {
		var count = $("#sAmount").val();
		if (count != 1) {
			$("#sAmount").val(parseInt(count) - 1);
		}
	});
});
</script>
<html>
<head>
<meta charset="UTF-8">
<title>spoweb</title>
</head>
<body>
<form name="productRetrieveForm" method="GET" action="#">
<input type="hidden" name="sImage" value="${productRetrieve.sImage}">
<input type="hidden" name="sCode" value="${productRetrieve.sCode}"> 
<input type="hidden" name="sName" value="${productRetrieve.sName}"> 
<input type="hidden" name="sPrice" value="${productRetrieve.sPrice}">

<table width="100%" cellspacing="0" cellpadding="0">
<tr>
	<td height="30">
</tr>
<tr>
	<td>
		<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
				<tr>
					<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;
					</td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
						<td height="10"></td>
				</tr>
				<tr>
					<td rowspan="7"><img src="image/items/${productRetrieve.sImage}.jpg"
							border="0" align="left" width="200" /></td>
					<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						${productRetrieve.sCode}
						</td>
				</tr>
				<tr>
					<td class="td_title">제품명</td>
					<td class="td_default" colspan="2" style='padding-left: 30px'>
					${productRetrieve.sContent}
					</td>
				</tr>
				<tr>
					<td class="td_title">가격</td>
					<td class="td_default" colspan="2" style='padding-left: 30px'>
					${productRetrieve.sPrice}
					</td>
				</tr>
				<tr>
						<td class="td_title">배송비</td>
						<td colspan="2">
						<font color="#2e56a9" size="2" style='padding-left: 30px'>
						</font>
						<p class="product_article_tit"><span>-</span>평균 배송일</p>
						<font size="2">(영업일 기준, 결제 후 평균 배송기간)</font>
						</td>
				</tr>
				<tr>
					<td colspan="2" style='padding-left: 30px' height="30px">
					<select id="sSize" name="sSize" class="select_change" size="1">
					<option selected value="">사이즈선택</option>
								<option value="XL">XL</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="S">S</option>
					</select>
					</td>
				</tr>
				<tr>
						<td colspan="2" style='padding-left: 30px'>
						<select
							class="select_change" size="1" name="sColor"
							id="sColor">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								<option value="gray">gray</option>
						</select>
						</td>
				</tr>
				<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
						<input type="text" name="sAmount" value="1" id="sAmount"
							style="text-align: right; height: 20px"> 
							<img src="image/up.PNG" id="up" > 
							<img src="image/down.PNG" id="down"></td>
				</tr>
				
				
	   </table>
	   <br> <button onclick="proinfo('order',productRetrieveForm)">구매</button>
	&nbsp;&nbsp;
	<button onclick="proinfo('cart',productRetrieveForm)">장바구니에 추가</button>
</td>
</tr>
</table>
</form>
</body>
</html>