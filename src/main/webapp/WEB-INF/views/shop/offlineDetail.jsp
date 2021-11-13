<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오프라인 매장 디테일</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shop/offlineDetail.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/><!-- fontAwesome -->
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
<div class="top">
        ZEROWASTE MAP
    </div>
    <div class="auction-title">
        <span>카페/책방 </span>&nbsp;&nbsp;&nbsp;&nbsp;<span> 제로 스테이</span>
    </div>
    <div class="offline-info">
        <div class="address">
            <div class="address-image">
                <i class="fas fa-map-marker-alt"></i>
                <span style="margin-left:5px;">대구 달서구 진천로 114-17</span>
                <i class="fas fa-phone" style="margin-left : 30px;"></i>
                <span style="margin-left:5px;">010-0000-0000</span>
            </div>
            <div class="address-image">
                <i class="fas fa-globe" style="margin-top : 15px;"></i>
                <span style="margin-left:5px;"><a href="#">instagram</a></span>
            </div>
        </div>
        <div class="offline-map">

        </div>
    </div>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>