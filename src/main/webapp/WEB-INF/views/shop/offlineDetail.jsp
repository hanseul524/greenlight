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
        <span <c:if test="${offlineShop.category == '매장'}">style="color:orange"</c:if><c:if test="${offlineShop.category == '공방/갤러리'}">style="color:brown"</c:if><c:if test="${offlineShop.category == '나무'}">style="color:green"</c:if><c:if test="${offlineShop.category == '카페/책방'}">style="color:red"</c:if>> ${offlineShop.category } </span>&nbsp;&nbsp;&nbsp;&nbsp;<span> ${offlineShop.shopName }</span>
    </div>
    <div class="offline-info">
        <div class="address">
            <div class="address-image">
                <i class="fas fa-map-marker-alt"></i>
                <span style="margin-left:5px;">${offlineShop.shopAddress }</span>
                <c:if test="${ offlineShop.shopPhone ne 'N' }">
	                <i class="fas fa-phone" style="margin-left : 30px;"></i>
	                <span style="margin-left:5px;">${offlineShop.shopPhone }</span>
                </c:if>
            </div>
            <div class="address-image">
            	<c:if test="${ offlineShop.shopInstagram ne 'N' }">
	                <i class="fas fa-globe" style="margin-top : 15px;"></i>
	                <span style="margin-left:5px;"><a href="${offlineShop.shopInstagram }" target="_blank">${offlineShop.shopInstagram }</a></span>
                </c:if>
            </div>
        </div>
        <div class="offline-map" id="offline-map">

        </div>
    </div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fd570f17739018454dc708a7398620de&libraries=services"></script>
<script>
	var address = '${offlineShop.shopAddress }';
	console.log(address);
	
	var mapContainer = document.getElementById('offline-map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3, // 지도의 확대 레벨
    };
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	//주소로 좌표를 검색합니다
	geocoder.addressSearch(address, function(result, status) {
	
	// 정상적으로 검색이 완료됐으면 
	 if (status === kakao.maps.services.Status.OK) {
	
	    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	    // 결과값으로 받은 위치를 마커로 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: coords
	    });
	
	
	    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	    map.setCenter(coords);
	} 
	});    

</script>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>