<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin Auction</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/adminShop.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="container">
		<div class="nav-admin">
			<i class="fas fa-user-circle fa-4x"
				style="color: gray; margin: 15px;"></i> <span>admin01</span>
			<div
				style="margin-left: 40px; font-size: 14px; font-weight: 500; color: #7ea18b;">
				관리자님, 안녕하세요. <br> 오늘은 <span id="today" style="width: 80px;"></span>일
				입니다.
			</div>
			<div class="nav-inner">
				<ul>
					<li class="li-area"><i class="fas fa-user-cog"
						style="margin-right: 10px;"></i><a href="#">회원관리</a></li>
					<li class="li-area"><i class="fas fa-coins"
						style="margin-right: 10px;"></i><a href="#">경매관리</a>
						<ul>
							<li><a href="adminAuctionView.do">재고관리</a></li>
							<li><a href="adminSellAuctionView.do">판매관리</a></li>
						</ul></li>
					<li class="li-area"><i class="far fa-calendar-check"
						style="margin-right: 10px;"></i><a href="AdminChList.do">챌린지
							관리</a></li>
					<li class="li-area"><i class="fas fa-hand-holding-usd"
						style="margin-right: 10px;"></i><a href="#">기부관리</a></li>
					<li class="li-area"><i class="fas fa-warehouse"
						style="margin-right: 10px;"></i><a href="#">매장관리</a>
						<ul>
							<li><a href="adminOnlineShop.do">온라인 매장 관리</a></li>
							<li><a href="adminOfflineShop.do">오프라인 매장 관리</a></li>
						</ul></li>
					<li class="li-area"><i class="fas fa-gifts"
						style="margin-right: 10px;"></i><a href="#">이벤트관리</a>
						<ul>
							<li><a href="#">이벤트 생성</a></li>
							<li><a href="#">당첨자 관리</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="contents">
			<div class="con-title">
				<form action="offlineShopUpdateWriteView.do" method="post">
					<input type="hidden" name="shopNo" value="${offlineShop.shopNo }">
					<div>오프라인 매장</div>
					<button type="submit">수정</button>
			</div>
			<div id="writeView">
				<fieldset style="border: 0px; display: inline-block;">
					<legend style="width: 100%; height: 100px;">
						<p>매장 이름</p>
						<div class="div-auction">
							<input type="text" value="${offlineShop.shopName }" class="auction-input" name="shopName" id="auctionTitle" readonly>
						</div>
					</legend>
				</fieldset>
				<fieldset
					style="border: 0px; display: inline-block; margin-left: 100px;">
					<legend style="width: 100%; height: 100px;">
						<p>카테고리</p>
						<select name="category" style="font-size: 12px; margin-top: 8px;">
							<c:if test="${offlineShop.category == '카페/책방' }">
								<option value="카페/책방" >카페/책방</option>
							</c:if>
							 <c:if test="${offlineShop.category == '매장' }">
								<option value="매장">매장</option>
							</c:if>
							<c:if test="${offlineShop.category == '공방/갤러리' }">
								<option value="공방/갤러리" >공방/갤러리</option>
							</c:if>
							<c:if test="${offlineShop.category == '나무' }">
								<option value="나무" >나무</option>
							</c:if>
						</select>
					</legend>
				</fieldset>
				<fieldset style="border: 0px; margin-bottom: 20px;">
					<legend style="width: 100%; height: 100px;">
						<p style="display: inline-block">매장 주소</p>
						<div class="div-auction">
							<input type="text" value="${offlineShop.shopAddress }" class="auction-input" name="shopAddress" id="offlineAddr" style="width: 500px; float: left;" readonly>
							<!-- <button id="addrButton" style="float:left; margin-top:9px;" onclick="sample6_execDaumPostcode()">우편번호</button> -->
						</div>
					</legend>
				</fieldset>
				<fieldset style="border: 0px;">
					<legend style="width: 100%; height: 100px;">
						<p>매장 번호</p>
						<div class="div-auction">
							<input type="text" value="${offlineShop.shopPhone }" class="auction-input" name="shopPhone" id="auctionPrice"  readonly>
						</div>
					</legend>
				</fieldset>
				<fieldset style="border: 0px;">
					<legend style="width: 100%; height: 100px;">
						<p>매장 인스타그램</p>
						<div class="div-auction">
							<input type="text" value="${offlineShop.shopInstagram }" class="auction-input" name="shopInstagram" id="auctionPrice" style="width: 500px;" readonly>
						</div>
					</legend>
				</fieldset>
			</div>
			</form>
		</div>
	</div>
	</div>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
	todayDate();

	function todayDate(){
	  var today = new Date();
	
	  var year = today.getFullYear();
	  var month = ('0' + (today.getMonth() + 1)).slice(-2);
	  var day = ('0' + today.getDate()).slice(-2);
	
	  var dateString = year + '.' + month  + '.' + day;
	
	  $("#today").html(dateString);
	}
	
	$('div > ul > li').click(function() {
        if ( $(this).hasClass('active') ) {
          $(this).find(' > ul').stop().slideUp(
	300);
			$(this).removeClass('active');
		} else {
			$(this).find(' > ul').stop().slideDown(300);
			$(this).addClass('active');
		}
	});
</script>
</body>
</html>