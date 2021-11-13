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
            <p>OFFLINE SHOP</p>
        </div>
        <div style="width:30px;float:left;height:100%;"></div>
        <div class="online">
            <p>ONLINE SHOP</p>
        </div>
    </div>
    <div class="menu-category">
        <div class="zerowaste">
            <p>ZERO WASTE</p>
        </div>
        <div style="width:30px;float:left;height:100%;"></div>
        <div class="upcycling">
            <p>UPCYCLING</p>
        </div>
    </div>
    <h3>이미지 클릭시 해당 사이트로 이동됩니다.</h3>
    <div class="content">
        <div class="auction-box">
            <a href="#">
                <div class="auction-img">
                    <img src="../../img/지갑 목걸이.jpg" class="img">
                </div>
            </a>    
            <div class="auction-title">
                <p>더 피커</p>
            </div>
            <div class="auction-point">
                <p class="point">제로웨이스트 라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼</p>
            </div>
        </div>
        <div class="auction-box">
            <a href="#">
                <div class="auction-img">
                    <img src="../../img/지갑 목걸이.jpg" class="img">
                </div>
            </a>    
            <div class="auction-title">
                <p>더 피커</p>
            </div>
            <div class="auction-point">
                <p class="point">제로웨이스트 라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼</p>
            </div>
        </div>
        <div class="auction-box">
            <a href="#">
                <div class="auction-img">
                    <img src="../../img/지갑 목걸이.jpg" class="img">
                </div>
            </a>    
            <div class="auction-title">
                <p>더 피커</p>
            </div>
            <div class="auction-point">
                <p class="point">제로웨이스트 라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼라이프스타일 플랫폼</p>
            </div>
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
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>