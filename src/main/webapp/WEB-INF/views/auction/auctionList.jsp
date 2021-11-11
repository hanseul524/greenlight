<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auction List</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/auction/auctionList.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
    <div class="header"></div>
    <div class="body">
        <div class="content">
            <div class="auction"><span>A</span>&nbsp;&nbsp;<span>U</span>&nbsp;&nbsp;<span>C</span>&nbsp;&nbsp;<span>T</span>&nbsp;&nbsp;<span>I</span>&nbsp;&nbsp;<span>O</span>&nbsp;&nbsp;<span>N</span></div>
            <div class="button" onclick="auctionWriteView();" style="cursor: pointer;">경매 신청</div>
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
		                    <img src="${pageContext.request.contextPath}/resources/auctionImage/${auction.fileName }" class="img">
		                </div>
		                <input type="hidden" id="hidden" value="${auction.auctionPrice }">
		                <div class="auction-title">
		                    <p>${auction.auctionTitle }</p>
		                </div>
		                <div class="auction-point">
		                    <p class="point">현재 입찰가 : ${auction.auctionPrice }P</p>
		                    <p class="time"></p>
		                </div>
		            </div>
	            </c:forEach>
	        </c:if>
        </div>
    </div>
	<div class="page_wrap">
    <c:url var="before" value="auctionListView.do">
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
      	<c:url var="pagenation" value="auctionListView.do">
      		<c:param name="page" value="${p }"></c:param>
      	</c:url>
      	<c:if test="${p eq pi.currentPage }">
         	<a href="#" class="active">${p }</a>
      	</c:if>
      	<c:if test="${p ne pi.currentPage }">
      		<a href="${pagenation }">${p }</a>
      	</c:if>
      </c:forEach>
      <c:url var="after" value="auctionListView.do">
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
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>    
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
	        	location.href="auctionListView.do";
	        	$(obj).siblings().last().children().last().html("경매가 마감되었습니다.");
			}
        }
		 
</script>
</body>
</html>