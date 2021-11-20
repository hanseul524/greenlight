<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오프라인 매장</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shop/offlineShop.css">
<style>
	/* map / + & - */
	.radius_border{border:1px solid #919191;border-radius:5px;}     
	.custom_typecontrol {position:absolute;top:10px;right:10px;overflow:hidden;height:30px;margin:0;padding:0;z-index:1;font-size:12px;font-family:'Malgun Gothic', '맑은 고딕', sans-serif;}
	.custom_typecontrol span {display:block;width:65px;height:30px;float:left;text-align:center;line-height:30px;cursor:pointer;}
	.custom_typecontrol .btn {background:#fff;background:linear-gradient(#fff,  #e6e6e6);}       
	.custom_typecontrol .btn:hover {background:#f5f5f5;background:linear-gradient(#f5f5f5,#e3e3e3);}
	.custom_typecontrol .btn:active {background:#e6e6e6;background:linear-gradient(#e6e6e6, #fff);}    
	.custom_typecontrol .selected_btn {color:#fff;background:#425470;background:linear-gradient(#425470, #5b6d8a);}
	.custom_typecontrol .selected_btn:hover {color:#fff;}   
	.custom_zoomcontrol {position:absolute;top:50px;right:10px;width:36px;height:80px;overflow:hidden;z-index:1;background-color:#f5f5f5;} 
	.custom_zoomcontrol span {display:block;width:36px;height:40px;text-align:center;cursor:pointer;}     
	.custom_zoomcontrol span img {width:15px;height:15px;padding:12px 0;border:none;}             
	.custom_zoomcontrol span:first-child{border-bottom:1px solid #bfbfbf;}
	
	/* 인포 윈도우 */
	.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 110px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
	.wrap * {padding: 0;margin: 0;}
	.wrap .info {width: 286px;height: 100px;border-radius: 10px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
	.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
	.info .title {padding: 5px 0 0 10px;height: 25px;background: #eee;border-bottom: 1px solid #ddd;font-size: 16px;font-weight: bold;}
	.info .close {position: absolute;top: 8px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
	.info .close:hover {cursor: pointer;}
	.info .body {position: relative;overflow: hidden;}
	.info .desc {position: relative;margin: 13px 0 0 20px; padding-right:10px;}
	.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
	.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
	.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
	.info .link {color: #5085BB;}
	#after:after{content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')};
	 
	/* overlay */
	.overlay_info a {display: block; background: #d95050; background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center; text-decoration: none; color: #fff; padding:12px 36px 12px 14px; font-size: 14px; border-radius: 0px 0px 0 0}
	.overlay_info a strong {background: no-repeat; padding-left: 2px;}
	.overlay_info .desc {padding:14px;position: relative; min-width: 190px; height: 56px}
	.overlay_info .address {font-size: 12px; color: #333; position: absolute; left: 80px; right: 14px; top: 24px; white-space: normal}
	
	
	.map_wrap, .map_wrap * {font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
	.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
	.map_wrap {position:relative;width:100%;height:500px;}
	#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 1);z-index: 1;font-size:12px;border-radius: 10px;}
	.bg_white {background:#fff;}
	#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
	#menu_wrap .option{text-align: center;}
	#menu_wrap .option p {margin:10px 0;}  
	#menu_wrap .option button {margin-left:5px;}
	#placesList li {list-style: none;}
	ul{padding:0px;}
	#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
	#placesList .item span {display: block;margin-top:4px;}
	#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	#placesList .item .info{padding:10px 0 10px 55px; text-overflow: ellipsis;}
	#placesList .info .gray {color:#8a8a8a;}
	#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
	#placesList .info .tel {color:#009900;}
	#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 10px 10px; background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
	#placesList .item .marker_1 {background-position: 0 -10px;}
	#placesList .item .marker_2 {background-position: 0 -56px;}
	#placesList .item .marker_3 {background-position: 0 -102px}
	#placesList .item .marker_4 {background-position: 0 -148px;}
	#placesList .item .marker_5 {background-position: 0 -194px;}
	#placesList .item .marker_6 {background-position: 0 -240px;}
	#placesList .item .marker_7 {background-position: 0 -286px;}
	#placesList .item .marker_8 {background-position: 0 -332px;}
	#placesList .item .marker_9 {background-position: 0 -378px;}
	#placesList .item .marker_10 {background-position: 0 -423px;}
	#placesList .item .marker_11 {background-position: 0 -470px;}
	#placesList .item .marker_12 {background-position: 0 -516px;}
	#placesList .item .marker_13 {background-position: 0 -562px;}
	#placesList .item .marker_14 {background-position: 0 -608px;}
	#placesList .item .marker_15 {background-position: 0 -654px;}
	#pagination {margin:10px auto;text-align: center;}
	#pagination a {display:inline-block;margin-right:10px;}
	#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
<div style="width:100%; height:60px;"></div>
    <p class="zerowastemap">ZEROWASTE MAP</p>
        <div class="menu-shop">
            <div class="offline">
        	    <a href="offlineShopView.do">
	                <p>OFFLINE SHOP</p>
	            </a>
            </div>
            <div style="width:30px;float:left;height:100%;"></div>
            <div class="online">
	            <a href="onlineShopView.do">
	                <p>ONLINE SHOP</p>
	            </a>
            </div>
        </div>
        <!-- ------------------------------------------------------------------------- -->
		<form method="post" name="listForm" id="listForm" action="offlineSearch.do">
			<div>
				<div class="map_wrap">
			        <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div> 
			     <!-- 지도타입 컨트롤 div 입니다 -->
			    <div class="custom_typecontrol radius_border">
			        <span id="btnRoadmap" class="selected_btn" onclick="setMapType('roadmap')">지도</span>
			        <span id="btnSkyview" class="btn" onclick="setMapType('skyview')">스카이뷰</span>
			    </div>
			    <!-- 지도 확대, 축소 컨트롤 div 입니다 -->
			    <div class="custom_zoomcontrol radius_border"> 
			        <span onclick="zoomIn()"><img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_plus.png" alt="확대"></span>  
			        <span onclick="zoomOut()"><img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_minus.png" alt="축소"></span>
			    </div>
					<div id="menu_wrap" class="bg_white">
				        <div class="option">
				            <div>
				                    키워드 : <input type="text" value="ZERO WASTE" id="keyword" size="15" name="searchKeyWord"> 
				                    <button type="submit">검색하기</button> 
				            </div>
				        </div>
				        <hr>
				        <ul id="placesList"></ul>
				        <div id="pagination">
						<p style='text-align:center; margin-top:10px;'>
							<c:url var='before' value='offlineShopView.do'> 
								<c:param name='page' value="${pi.currentPage - 1 }"></c:param>
							</c:url>
							<c:if test="${pi.currentPage <= 1 }">
								[이전]
							</c:if>
							<c:if test="${pi.currentPage > 1 }">
								<a href="${before }">
									[이전]
								</a>
							</c:if>
							<c:forEach var='p' begin="${pi.startNavi }" end="${pi.endNavi }">
								<c:url var='pagination' value='offlineShopView.do'>
									<c:param name='page' value="${p }"></c:param>
								</c:url>
								<c:if test="${p eq pi.currentPage }">
									<font color='red' size='4' style="margin-right:10px;">
										${p }
									</font>
								</c:if>
								<c:if test="${p ne pi.currentPage }">
									<a href="${pagination }">
										${p }
									</a>&nbsp;
								</c:if>
							</c:forEach>
							<c:url var='after' value='offlineShopView.do'>
								<c:param name='page' value="${pi.currentPage + 1 }"></c:param>
							</c:url>
							<c:if test="${pi.currentPage >= pi.maxPage }">
								[다음]
							</c:if>
							<c:if test="${pi.currentPage < pi.maxPage }">
								<a href="${after }">
									[다음]
								</a>
							</c:if>
						</p>
				        </div>
				    </div>
			    </div>
			</div>
		</form>
		<div style="width:100%; height:200px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fd570f17739018454dc708a7398620de&libraries=services"></script>
<script>

		function fn_search() { 
		    $("#listForm").submit();
		    return false;
		}
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    mapOption = { 
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3, // 지도의 확대 레벨
		    };
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		//지도타입 컨트롤의 지도 또는 스카이뷰 버튼을 클릭하면 호출되어 지도타입을 바꾸는 함수입니다
		function setMapType(maptype) { 
		  var roadmapControl = document.getElementById('btnRoadmap');
		  var skyviewControl = document.getElementById('btnSkyview'); 
		  if (maptype === 'roadmap') {
		      map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);    
		      roadmapControl.className = 'selected_btn';
		      skyviewControl.className = 'btn';
		  } else {
		      map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);    
		      skyviewControl.className = 'selected_btn';
		      roadmapControl.className = 'btn';
		  }
		}
		
		//지도 확대, 축소 컨트롤에서 확대 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
		function zoomIn() {
		  map.setLevel(map.getLevel() - 1);
		}
		
		//지도 확대, 축소 컨트롤에서 축소 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
		function zoomOut() {
		  map.setLevel(map.getLevel() + 1);
		}
		
		/* --------------------------------------------------------------------------------------------- */
		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		var addrList = new Array();
		var nameList = new Array();
		var instaList = new Array();
		var noList = new Array();
		var phoneList = new Array();
		var x = new Array();
		var y = new Array();
		var setMapFocus = new Array();
		
		var rdnList =JSON.parse('${sList }');
		for(var k in rdnList){    
		    var $obj = rdnList[k]; // 리스트 객체를 나눠 보자..
		    var shopNo = $obj.shopNo;
		    var shopAddr =  $obj.shopAddress; // 주소
		    var shopName  =  $obj.shopName; // 상점이름
		    var shopInsta = $obj.shopInstagram; // 인스타그램
		    var shopPhone = $obj.shopPhone;
		    
		    addrList.push(shopAddr); // 주소 리스트
		    nameList.push(shopName); // 상점이름 리스트
		    instaList.push(shopInsta); // 인스타 리스트
		    noList.push(shopNo);
		    phoneList.push(shopPhone);
		}
		
		var i = 1;
		//주소 리스트 
		addrList.forEach(function(addr, index){
		  // 주소로 좌표를 검색합니다
		  geocoder.addressSearch(addr, function(result, status) {
			  console.log(i);
		      // 정상적으로 검색이 완료됐으면 
		       if (status === kakao.maps.services.Status.OK) {
		  
		          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		          y.push(result[0].y);
		          x.push(result[0].x);
		          setMapFocus.push(coords);
		          
		          /* ----------------------------------------------------------- */
				  /* ----------------------------------------------------------- */
				   
					var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });

		          
				   
		          var content = '<div class="wrap">' + 
		          '    <div class="info" id="after">' + 
		          '        <div class="title">' + 
		         			  nameList[index]+ 
		          '        </div>' + 
		          '        <div class="body">' + 
		          '            <div class="desc">' + 
		          '                <div class="ellipsis">'+addrList[index]+'</div>' + 
		          '                <div><a href="offlineShopDetail.do?shopNo='+noList[index]+'" class="link">홈페이지</a></div>' + 
		          '            </div>' + 
		          '        </div>' + 
		          '    </div>' + 
		          '</div>';
		          
				var el = document.createElement('li');
			    itemStr = '<span class="markerbg marker_' + (i) + '"></span>' +
			                '<div class="info" onclick="setMaps('+result[0].y+', '+result[0].x+');">' +
			                '   <h5 style="margin:0px;">' + nameList[index] + '</h5>';
			
			    if (addrList[index]) {
			        itemStr += '<span>' + addrList[index] + '</span>'
			    }
			                 
			      itemStr += '  <span class="tel">' + phoneList[index] + '</span></div>';         
			
			    el.innerHTML += itemStr;
			    el.className = 'item';
			    $("#placesList").append(el);		          
		       
		       
		       // 마커 위에 커스텀오버레이를 표시합니다
		       // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
		       var overlay = new kakao.maps.CustomOverlay({
	        	    content: content,
	        	    map: map,
	        	    position: marker.getPosition()       
		       });
		       // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
		       
		       
		       // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
		       
		       (function(marker, overlay) {
		           // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다 
		           kakao.maps.event.addListener(marker, 'click', function() {
		        	   overlay.setMap(map);
		           });

		           // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
		           kakao.maps.event.addListener(marker, 'mouseover', function() {
		        	   overlay.setMap(null);
		           });
		           
		       })(marker, overlay);
		       
		  
		          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		          if(index == 0){
		              map.setCenter(coords);    
		          }
		          
		      }
			i++;
		  });   
		}); 
		
		console.log(setMapFocus[0]);
		console.log(nameList);
		
		
		function infoWindow(t){
	    	   $(t).parent().parent().parent().remove();
	    }
		
		function setMaps(y, x){
			var moveLatLon = new kakao.maps.LatLng(y, x);
			map.panTo(moveLatLon);
		}
		
</script>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>