<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<style>
    body {
      font-family: 'Noto Sans KR', sans-serif;
    }
    .header {
      width: 100%;
      height: 100px;
      margin-bottom: 40px;
    }
    .main-img {
      width: 15%;
      height: 100px;
      font-weight: 300;
      float: left;
    }
    .navi-area {
      width: 70%;
      height: 100px;
      float: left;
    }
    .user-area {
      width: 15%;
      height: 100px;
      float: left;
      text-align: right;
    }
    .navi-menu {
      list-style-type: none;
      text-align: center;
      margin-top: 13px;
    }
    .navi-menu li {
      display: inline-block;
      margin: 20px;
      position: relative;
    }
    .navi-menu li a::after {
      content: "";
      position: absolute;
      bottom: 0;
      left: 50%;
      transform: translateX(-50%);
      transition: all .5s ease-out;
      width: 0;
      height: 3px;
      background: #455c4e;
    }
    .navi-menu li a:hover::after {
      width: 100%;
    }
    .navi-menu a{
      color: black;
      text-decoration: none;
      font-weight: 300;
      font-size: 15px;
    }
    .user-area a {
      color: black;
      font-weight: 300;
      text-decoration: none;
      display: inline-block;
      margin: 20px;
      position: relative;
    }
</style>
</head>
<body>
  <div class="header">
    <div class="main-img"><img style="width: 100px; height: 100px; margin: 10px 0 10px 60px;" src="${pageContext.request.contextPath}/resources/img/mainlogo.png"></div>
    <div class="navi-area">
      <ul class="navi-menu">
        <li><a href="#">Home</a></li>
        <li><a href="ChallengeListView.do">Challenge</a></li>
        <li><a href="auctionListView.do">Auction</a></li>
        <li><a href="#">Donation</a></li>
        <li><a href="#">Map</a></li>
      </ul>
    </div>
    <div class="user-area">
      <i class="fas fa-user-circle fa-2x" style="color: gray;"></i><a href="loginView.do">Login</a>
    </div>
  </div>
</body>
</html>