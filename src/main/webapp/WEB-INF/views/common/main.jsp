<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GreenLight</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/main.css">
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>
<body>
<div class="container">
  <div class="main-area">
<jsp:include page="/common/header.jsp"></jsp:include>
      <div class="first-area">
    </div>
  </div>
  <div class="site-info">
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/zero2.jpeg" alt="">
        <span style="color: white;">Zero <br> Waste</span>
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/upcycling2.jpeg" alt="">
        <span style="color: #293e31;">Upcycling</span>
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/recycling.jpeg" alt="">
        <span style="color: white;">Recycling</span>
      </div>
    </a>
  </div>
  <div class="event-area">
  	<img src="${pageContext.request.contextPath}/resources/img/event01.png">
  	<div>${event.eventQuestion }<br>
  		<span class="event-span">이벤트는 5일동안 진행됩니다! 정답을 맞히신 분들에게 100포인트. <br>추첨을 통해 정답자 중 10%의 회원에게 500포인트를 드립니다.
  		많은 참여 부탁드립니다.</span>
  		<c:if test="${sessionScope.userId ne null }">
	  		<input type="text" name="event-answer" class="input-area" id="eventUser">
	  		<button onclick="userCheck()">참여하기</button>
	  	</c:if>
	  	<c:if test="${sessionScope.userId eq null }">
	  		<p>로그인 후 이벤트 참여 가능합니다.</p>
  		</c:if>
  			<p class="event-time">참여 기간 : 2021.11.21 ~ 2021.11.28일 저녁 8시</p>
  	</div>
  		<img src="${pageContext.request.contextPath}/resources/img/eventEnd.png" id="eventEndImage">
  </div>
  	<c:if test="${wList ne null }">
  		<input type="text" name="userCheck" class="input-area" id="userCheck" style="position : relative; left:600px; bottom:200px;"placeholder="아이디를 검색하여 결과를 확인해주세요.">
  		<button class="searchBtn" onclick="eventCheckUser();" style="position : relative; left: 561px; top: -200px"><i class="fas fa-search" style="color:white"></i></button>
  	</c:if>
  	<!-- <button onclick="winnerCheck()" class="event-button" style="position : relative; left:725px; bottom:170px;">결과 확인</button> -->
  <div class="ch-area">
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide">Slide 1</div>
        <div class="swiper-slide">Slide 2</div>
        <div class="swiper-slide">Slide 3</div>
        <div class="swiper-slide">Slide 4</div>
        <div class="swiper-slide">Slide 5</div>
        <div class="swiper-slide">Slide 6</div>
        <div class="swiper-slide">Slide 7</div>
        <div class="swiper-slide">Slide 8</div>
        <div class="swiper-slide">Slide 9</div>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<!-- Initialize Swiper -->
<script>

	time();
	auctionTimer();
	$("#eventEndImage").hide();
	
	
  var swiper = new Swiper(".mySwiper", {
    slidesPerView: 3,
    spaceBetween: 30,
    slidesPerGroup: 3,
    loop: true,
    loopFillGroupWithBlank: true,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
  
  
  function time(){
	  
	  var st = '${event.eventStart }';
	  var et = '${event.eventEnd }';
	  
	  var startTime = new Array();
	  var endTime = new Array();
	  
	  startTime = st.split("-");
	  endTime = et.split("-");
	  console.log(startTime);
	  console.log(endTime);
	  
	  $(".event-time").text("참여 기간 : "+startTime[0]+"."+startTime[1]+"."+startTime[2]+" ~ "+endTime[0]+"."+endTime[1]+"."+endTime[2]+"일 저녁 8시");
	  
  }
  
  function userCheck(){
	  
	  var input = $("#eventUser").val();
	  var answer = '${event.eventAnswer }';
	  var eventNo = '${event.eventNo }';
	  
	if(input != answer){
		Swal.fire({
            icon: 'error',
            text: '오답입니다. 다시 참여 부탁드립니다.'
        })
	}else{
		$.ajax({
			url : "eventUserIdCheck.do",
			type : "post",
			success : function(data){
				if(data == "success"){
					eventApply(eventNo);
				}else{
					Swal.fire({
			            icon: 'error',
			            text: '이미 참여하셨습니다.'
			        })
				}
			},
			error : function(){
				console.log("ajax 실패")
			}
		})
	}
	  
  };
  
  function eventApply(eventNo){
	  
	  $.ajax({
		  url : "eventUserApply.do",
		  type : "post",
		  data : {
			"eventNo" : eventNo
		  },
		  success : function(data){
		  	if(data == "success"){
		  		$("#eventUser").val("");
				Swal.fire(
                   '참여성공!',
                   '이벤트 참여 완료했습니다. 추첨을 기다려주세요',
                   'success'
                )
		  	}else{
		  	  Swal.fire({
		  	      icon: 'error',
		  	      text: '이미 참여하셨습니다.'
		  	  })
		  	}
		  },
		  error : function(){
			  console.log("ajax 실패!")
		  }
	  })
  }
  
  /* ------------------------------------------------------- */
  		function auctionTimer(){
  			var x = setInterval(function(){
				var now = new Date();
				var year = now.getFullYear();
				var month = now.getMonth();
				var day = now.getDate();
				var hours = now.getHours();
				var minutes = now.getMinutes();
				var seconds = now.getSeconds();
				
				
				var sttDt = '${event.eventEnd }';
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				var sttMonth = sttDt[1]-1;
				var sttDay = sttDt[2];
				var sttHour = sttDt[3];
				var sttHours = parseInt(sttHour);
				var sttMinutes = sttDt[4];
				var sttSeconds = sttDt[5];
				
				/* var sttDt = "2021-11-22";
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				var sttMonth = sttDt[1]-1;
				var sttDay = sttDt[2];
				
				// 관리자가 경매 진행할 시간 입력하기
				var sttHours = 18; // 시
				var sttMinutes = 34; // 분
				var sttSeconds = 00; // 초  */
				
			/* ----------------------------------------------------------- */
				
				var date1 = new Date(year, month, day, hours, minutes, seconds);
				var date2 = new Date(sttYear, sttMonth, sttDay, sttHours, sttMinutes, sttSeconds);
				
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
					console.log("남은 시간 " + hours + " : " + mins + " : " + secs);
				}
			
			},1000);
			
			 function result(){
				 $("#eventEndImage").show();
			}
		}
  
  /* ------------------------------------------------------------------------------------------------------------------------- */
  
  function eventCheckUser(){
	  
	  $.ajax({
		  url : "eventSearchView.do",
		  type : "post",
		  data : {
			  "userId" : $("#userCheck").val()
		  },
		  success : function(data){
			  if(data == "success"){
				  $("#userCheck").val("");
					Swal.fire(
	                   '당첨!',
	                   '이벤트의 당첨되셨습니다 축하드립니다!',
	                   'success'
	                )
			  }else{
			  	  Swal.fire({
			  	      icon: 'error',
			  	      text: '이벤트에 당첨되지 않으셨습니다.'
			  	  })
			  }
		  },
		  error : function(){
			  console.log("ajax 비동기 실패!");
		  }
	  })
	  
  }
  
</script>
</body>
</html>