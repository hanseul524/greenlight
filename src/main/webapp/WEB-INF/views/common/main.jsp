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
  <jsp:include page="/common/header.jsp"></jsp:include>
  <div class="main-area">
  <svg id="visual" viewBox="0 0 1550 700" width="1550" height="700" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"><rect x="0" y="0" width="1550" height="700" fill="#FFFFFF"></rect><path d="M0 576L36.8 572.3C73.7 568.7 147.3 561.3 221.2 548.2C295 535 369 516 442.8 503.3C516.7 490.7 590.3 484.3 664.2 491C738 497.7 812 517.3 885.8 539.5C959.7 561.7 1033.3 586.3 1107.2 575C1181 563.7 1255 516.3 1328.8 489.8C1402.7 463.3 1476.3 457.7 1513.2 454.8L1550 452L1550 701L1513.2 701C1476.3 701 1402.7 701 1328.8 701C1255 701 1181 701 1107.2 701C1033.3 701 959.7 701 885.8 701C812 701 738 701 664.2 701C590.3 701 516.7 701 442.8 701C369 701 295 701 221.2 701C147.3 701 73.7 701 36.8 701L0 701Z" fill="#b2d6c4" stroke-linecap="round" stroke-linejoin="miter"></path></svg>
  <img src="${pageContext.request.contextPath}/resources/img/mainone.png">
	                  <div id="main-text">
	                	<c:forEach items="${history }" var="history">
		                <c:forEach items="${user }" var="user">
	                		<p>
					                        그린라이트에서 회원들이 사용한<br> 포인트는  <span>${history.pointUse }</span>이고
					                        보유한 포인트는 <span>${user.point }</span>입니다.
		                    </p>
		                	<c:if test="${iValue == 1 || iValue == 3 || iValue == 5 || iValue == 7 || iValue == 9}">
			                    <p>
						                        총합  <span>${history.pointUse + user.point }</span>의 포인트로<br>
						                        나무를 <c:choose>
						                    <c:when test="${history.pointUse + user.point eq 0 }"><span>0그루</span></c:when>
						                  	<c:when test="${history.pointUse + user.point <= 999}"><span>10그루</span></c:when>
						                  	<c:when test="${history.pointUse + user.point <= 9999}"><span>100그루</span></c:when>
						                  	<c:when test="${history.pointUse + user.point <= 99999}"><span>1000그루</span></c:when>
						                  	<c:when test="${history.pointUse + user.point >= 100000}"><span>10000그루</span></c:when>
						                  </c:choose>를 심는 효과를 얻었습니다.
			                    </p>
			                </c:if>
			                <c:if test="${iValue == 2 || iValue == 4 || iValue == 6 || iValue == 8 || iValue == 10}">
				                    <p>
							                        총합 ${history.pointUse + user.point }의 포인트로<br>
							                        쓰레기 <c:choose>
							                    <c:when test="${history.pointUse + user.point eq 0 }"><span>0kg</span></c:when>
							                  	<c:when test="${history.pointUse + user.point <= 999}"><span>10kg</span></c:when>
							                  	<c:when test="${history.pointUse + user.point <= 9999}"><span>100kg</span></c:when>
							                  	<c:when test="${history.pointUse + user.point <= 99999}"><span>1t</span></c:when>
							                  	<c:when test="${history.pointUse + user.point >= 100000}"><span>10t</span></c:when>
							                  </c:choose>을 줄이는 효과를 얻었습니다.
				                    </p>
			                </c:if>
		                </c:forEach>
		                </c:forEach>
	                </div>
  </div>
  <div class="site-info" style="background-attachment: fixed;">
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/zerowaste.png">
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/upcycling.png">
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="${pageContext.request.contextPath}/resources/img/recycling.png">
      </div>
    </a>
  </div>
  <div class="event-area">
  	<img src="${pageContext.request.contextPath}/resources/img/eventimg2.png">
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
     <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
		<c:forEach items="${cFList }" var="File">
            <c:url var="cDetail" value="ChallengeDetail.do">
               <c:param name="chNo" value="${File.chNo }"></c:param>
            </c:url>
           <div class="swiper-slide">
              <a href="${cDetail }">
                 <img src="${pageContext.request.contextPath}/resources/cuploadFiles/${File.fileName }">
              </a>
           </div>
        </c:forEach>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </div>
  </div>
</div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<!-- Initialize Swiper -->
<script>

	time();
	auctionTimer();
	$("#eventEndImage").hide();
	
	
  var swiper2 = new Swiper(".mySwiper ", {
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