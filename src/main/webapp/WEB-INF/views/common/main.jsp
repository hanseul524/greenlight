<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GreenLight</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
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
     <img src="${pageContext.request.contextPath}/resources/img/mainone.png">
<!--   <div class="first-area"> -->
<%--   	<img src="${pageContext.request.contextPath}/resources/img/mainone.png"> --%>
<!--   </div> -->
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
  	<div>일회용품 사용을 줄이고 일상에서 사용되는 자원과 제품을 재활용할 수 있도록 쓰레기를 최소화하자는 사회운동은 무엇일까요?<br>
  		<span class="event-span">이벤트는 5일동안 진행됩니다! 정답을 맞히신 분들에게 100포인트. <br>추첨을 통해 정답자 중 10%의 회원에게 500포인트를 드립니다.
  		많은 참여 부탁드립니다.</span>
  		<input type="text" name="event-answer" class="input-area">
  		<button onclick="">참여하기</button>
  		<p class="event-time">참여 기간 : 2021.11.21 ~ 2021.11.28일 저녁 8시</p>
  	</div>
  </div>
  <div class="ch-area">
     <!-- Swiper -->
    <div class="swiper mySwiper2">
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
	var swiper1 = new Swiper(".mySwiper1", {
	    spaceBetween: 30,
	    effect: "fade",
	    navigation: {
	      nextEl: ".swiper-button-next1",
	      prevEl: ".swiper-button-prev1",
	    },
	    pagination: {
	      el: ".swiper-pagination1",
	      clickable: true,
	    },
	  });

  var swiper2 = new Swiper(".mySwiper2 ", {
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


</script>
</body>
</html>