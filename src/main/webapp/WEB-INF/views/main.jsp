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
<link rel="stylesheet" href="../css/main.css">
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>
<body>
<div class="container">
  <div class="main-area">
    <div class="header"></div>
      <div class="ocean">
        <div class="wave"></div>
        <div class="wave"></div>
    </div>
  </div>
  <div class="site-info">
    <a href="#">
      <div class="img-box">
        <img src="../img/zero2.jpeg" alt="">
        <span style="color: white;">Zero <br> Waste</span>
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="../img/upcycling2.jpeg" alt="">
        <span style="color: #293e31;">Upcycling</span>
      </div>
    </a>
    <a href="#">
      <div class="img-box">
        <img src="../img/recycling.jpeg" alt="">
        <span style="color: white;">Recycling</span>
      </div>
    </a>
  </div>
  <div class="event-area"></div>
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
<div class="footer"></div>
<!-- Initialize Swiper -->
<script>
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
</script>
</body>
</html>