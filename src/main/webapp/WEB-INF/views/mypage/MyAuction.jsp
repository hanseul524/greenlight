<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Auction List</title>
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
		<nav>
            <div id="nav-section">
                <ul id="nav nav-tabs">
                  <li class="nav-item"><a href="myPage.do" class="nav-link active">활동 기여도</a></li>
                  <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
                  <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
                  <li class="nav-item"><a href="myChallenge.do" class="nav-link active">내가 쓴 글</a></li>
                  <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
                  <li class="nav-item"><a href="myAcution.do" class="nav-link active"  style="color: rgb(42, 173, 248);">내 경매</a></li>
                  <li class="nav-item"><a href="myDonation.do" class="nav-link active">나의 기부 현황</a></li>
                </ul>
            </div>
        </nav>
	       <div id="my-auction-butn">
           		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="myAcution.do">내가 올린 경매</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           		<a href="myBidList.do">내가 입찰한 경매</a>
	       </div>
            <c:if test="${ empty aList }">
            	<h1 align="center">진행중인 경매가 없습니다</h1>
            </c:if>
            <c:if test="${ not empty aList }">
            	<c:forEach items="${aList }" var="auction" varStatus="index">
		            <div class="auction-box" onclick="location.href='auctionDetail.do?auctionNo=${auction.auctionNo}'" style="cursor: pointer;">
		                <div class="auction-img" onmouseover="timer(this, '${auction.auctionStart}', ${auction.auctionTime })">
		                    <div class="quick-view">
		                        <p>quick view</p>
		                    </div>
		                    <img src="../../../resources/auctionImage/${auction.fileName }" class="img">
		                </div>
		                <input type="hidden" id="hidden" value="${auction.auctionPrice }">
		                <div class="auction-title">
		                    <p>${auction.auctionTitle }</p>
		                </div>
		                <div class="auction-point">
		                    <p class="point">현재 입찰가 : ${auction.auctionPrice }</p>
		                    <p class="time"></p>
		                </div>
		            </div>
	            </c:forEach>
	        </c:if>
        </div>
    </div>
	<div class="page_wrap">
    <c:url var="before" value="myAcution.do">
    	<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
    </c:url>
      <div class="page_nation">
      <c:if test="${pi.currentPage <= 1 }">
         <a class="arrow prev" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage > 1 }">
         <a class="arrow prev" href="${before }"></a>
      </c:if>
      <c:forEach var="p" begin="${pi.startNavi}" end="${pi.endNavi }">
      	<c:url var="pagenation" value="myAcution.do">
      		<c:param name="page" value="${p }"></c:param>
      	</c:url>
      	<c:if test="${p eq pi.currentPage }">
         	<a href="#" class="active">${p }</a>
      	</c:if>
      	<c:if test="${p ne pi.currentPage }">
      		<a href="${pagenation }">${p }</a>
      	</c:if>
      </c:forEach>
      <c:url var="after" value="myAcution.do">
      	<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
      </c:url>
      <c:if test="${pi.currentPage >= pi.maxPage }">
         <a class="arrow next" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage < pi.maxPage }">
         <a class="arrow next" href="${after }"></a>
      </c:if>
      </div>
    </div>
<jsp:include page="/common/footer.jsp"></jsp:include>   
<script>
    var time = $(".time");
    var point = $(".point");
    var imgBox = $(".auction-img");
    var img = $(".img");
    $(time).hide();
        $.each(imgBox, function (index, item) {
            $(item).on("mouseover", function(){
                $(point).eq(index).fadeOut("nomal");
                $(time).eq(index).fadeIn("nomal");
                /* timer($(item).next("input").val()); */
            })
        })
        $.each(imgBox, function (index, item) {
            $(item).on("mouseout", function(){
                $(point).eq(index).fadeIn("nomal");
                $(time).eq(index).fadeOut("nomal");
            })
        })

        function auctionWriteView(){
			location.href="auctionWrite.do";
        }
        
        
        /* ----------------------------경매 시간--------------------------------- */
        
        function timer(obj, a, b){
			var x = setInterval(function(){
				var now = new Date();
				var year = now.getFullYear();
				var month = now.getMonth();
				var day = now.getDate();
				var hours = now.getHours();
				var minutes = now.getMinutes();
				var seconds = now.getSeconds();
				
				console.log(a)
				
				console.log(b)
				
				var sttDt = a;
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				console.log(sttYear);
				var sttMonth = sttDt[1]-1;
				console.log(sttMonth);
				var sttDay = sttDt[2];
				console.log(sttDay);
				var sttHour = sttDt[3];
				var sttHours = parseInt(sttHour.substr(0, 2)) + parseInt(b);
				console.log(sttHours);
				var sttMinutes = sttDt[4];
				console.log(sttMinutes);
				var sttSeconds = sttDt[5];
				console.log(sttSeconds);
				
				var date1 = new Date(year, month, day, hours, minutes, seconds);
				var date2 = new Date(sttYear, sttMonth, sttDay, sttHours, sttMinutes, sttSeconds);
				console.log(date1);
				console.log(date2);
				
				var elapsedMSec = date2.getTime() - date1.getTime();
				var elapsedMSec = elapsedMSec / 1000; // 초
				
				var hours = Math.floor(elapsedMSec/3600);
				var mins = Math.floor((elapsedMSec - hours*3600)/60);
				var secs = elapsedMSec - hours*3600 - mins*60;
				
	            if (hours.toString().length==1) hours = "0" + hours;
	            if (mins.toString().length==1) mins = "0" + mins;  
	            if (secs.toString().length==1) secs = "0" + secs;
				
				 if(hours < 0){
					 result();
					clearInterval(x);
				}else{
					$(obj).siblings().last().children().last().html(hours + "시간 " + mins + "분 " + secs + "초 후 경매 마감합니다.");
				}
				 
			},1000);
			 
	        function result(){
	        	$(obj).siblings().last().children().last().html("경매가 마감되었습니다.");
			}
        }
        
        
		 
</script>
</body>
</html>