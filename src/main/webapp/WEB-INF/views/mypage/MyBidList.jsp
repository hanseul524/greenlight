<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bid List</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/mypage/auctionList.css" type="text/css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> <!-- 부트스트랩 -->
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
    <div class="body">
        <div class="content">
			<div id="nav-section">
	           <ul id="nav nav-tabs">
				  <li class="nav-item"><a href="myPage.do" class="nav-link active">활동 기여도</a></li>
		       	  <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
		          <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
		          <li class="nav-item"><a href="myChallenge.do" class="nav-link active">내가 쓴 글</a></li>
		          <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
		          <li class="nav-item"><a href="myAcution.do" class="nav-link active">내 경매</a></li>
		          <li class="nav-item"><a href="#" class="nav-link active">나의 기부 현황</a></li>
	           </ul>
	       </div>
            <c:if test="${ empty aList }">
            	<h1 align="center">진행중인 경매가 없습니다</h1>
            </c:if>
            <c:if test="${ not empty aList }">
            	<c:forEach items="${aList }" var="auction" varStatus="index">
		            <div class="auction-box" onclick="location.href='auctionDetail.do?auctionNo=${auction.auctionNo}'" style="cursor: pointer;">
		                <div class="auction-img">
		                    <div class="quick-view">
		                        <p>quick view</p>
		                    </div>
		                    <img src="${pageContext.request.contextPath}/resources/auctionImage/${auction.fileName }" class="img">
		                </div>
		                <div class="auction-title">
		                    <p>${auction.auctionTitle }</p>
		                </div>
		                <div class="auction-point">
		                    <p class="point">현재 입찰가 : ${auction.auctionPrice }</p>
		                    <p class="time">??시간 : ??분 : ??초</p>
		                </div>
		            </div>
	            </c:forEach>
	        </c:if>
        </div>
    </div>
    <div class="page_wrap">
        <div class="page_nation">
           <a class="arrow prev" href="#"></a>
           <a href="#" class="active">1</a>
           <a href="#">2</a>
           <a href="#">3</a>
           <a href="#">4</a>
           <a href="#">5</a>
           <a href="#">6</a>
           <a href="#">7</a>
           <a href="#">8</a>
           <a href="#">9</a>
           <a href="#">10</a>
           <a class="arrow next" href="#"></a>
        </div>
     </div>
<div class="footer"></div>
<script>
    var time = $(".time");
    var point = $(".point");
    var imgBox = $(".auction-img");
    var img = $(".img");
    $(point).hide();
        $.each(imgBox, function (index, item) {
            $(item).on("mouseover", function(){
                $(point).eq(index).fadeIn("nomal");
                $(tiem).eq(index).fadeOut("nomal");
            })
        })
        $.each(imgBox, function (index, item) {
            $(item).on("mouseout", function(){
                $(point).eq(index).fadeOut("nomal");
                $(tiem).eq(index).fadeIn("nomal");
            })
        })

        function auctionWriteView(){
			location.href="auctionWrite.do";
        }
</script>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>