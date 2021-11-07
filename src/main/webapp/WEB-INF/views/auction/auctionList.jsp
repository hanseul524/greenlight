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
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>