<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shop/upcyclingShop.css">
<title>업사이클링</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
<div style="width:100%; height:60px;"></div>
    <p class="zerowastemap">ZEROWASTE MAP</p>
    <div class="menu-shop">
        <div class="offline">
       	    <a href="offlineShopView.do">
                <p class="offline">OFFLINE SHOP</p>
            </a>
        </div>
        <div style="width:30px;float:left;height:100%;"></div>
        <div class="online">
            <a href="onlineShopView.do">
                <p>ONLINE SHOP</p>
            </a>
        </div>
    </div>
    <div class="menu-category">
        <div class="zerowaste">
        	<a href="onlineShopView.do">
            	<p class="p-zerowaste">ZERO WASTE</p>
            </a>
        </div>
        <div style="width:30px;float:left;height:100%;"></div>
        <div class="upcycling">
        	<a href="upCyclingView.do">
            	<p class="p-upcycling">UPCYCLING</p>
            </a>
        </div>
    </div>
    <h3>이미지 클릭시 해당 사이트로 이동됩니다.</h3>
    <div class="content">
    	<c:forEach items="${sList }" var="upcycling" varStatus="status">
	        <div class="auction-box">
	            <a href="http://${upcycling.shopAddress }" target="_blank">
	                <div class="auction-img">
	                    <img src="${pageContext.request.contextPath}/resources/shopUploadFiles/${upcycling.shopImage }" class="img">
	                </div>
	            </a>    
	            <div class="auction-title">
	                <p>${upcycling.shopName }</p>
	            </div>
	            <div class="auction-point">
	                <p class="point">${upcycling.shopContents }</p>
	            </div>
	        </div>
	   </c:forEach>
    </div>
    <div class="page_wrap">
		   <c:url var="before" value="upCyclingView.do">
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
		        <c:url var="pagenation" value="upCyclingView.do">
		           <c:param name="page" value="${p }"></c:param>
		        </c:url>
		        <c:if test="${p eq pi.currentPage }">
		           <a href="#" class="active">${p }</a>
		        </c:if>
		        <c:if test="${p ne pi.currentPage }">
		           <a href="${pagenation }">${p }</a>
		        </c:if>
		     </c:forEach>
		     <c:url var="after" value="upCyclingView.do">
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
</body>
</html>