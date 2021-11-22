<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      width: 13%;
      height: 100px;
      float: left;
      text-align: right;
    }
    .navi-menu {
      list-style-type: none;
      text-align: center;
      margin-top: 13px;
    }
    .navi-menu>li {
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
    .user-area>a {
      color: black;
      font-weight: 300;
      text-decoration: none;
      display: inline-block;
      margin: 5px;
      position: relative;
    }
    .user-navi {
      position: absolute;
      width: 80px;
      right: 30px;
      top: 40px;
      display: none;
    }
    .user-navi>li {
      list-style-type: none;
      width: 85px;
    }
    .user-navi>li>a {
      text-decoration: none;
      margin: 10px;
      font-size: 12px;
      font-weight: 300;
      color: black;
    }
	.icon:hover ~ .user-navi{
      display: block;
   }
</style>
</head>
<body>
  <div class="header">
    <div class="main-img"><img style="width: 100px; height: 100px; margin: 10px 0 10px 60px;" src="${pageContext.request.contextPath}/resources/img/mainlogo.png"></div>
    <div class="navi-area">
      <ul class="navi-menu">
        <li><a href="main.do">Home</a></li>
        <li><a href="ChallengeListView.do?check=recent">Challenge</a></li>
        <li><a href="auctionListView.do">Auction</a></li>
        <li><a href="donationBoardList.do">Donation</a></li>
        <li><a href="offlineShopView.do">Map</a></li>
      </ul>
    </div>
    <div class="user-area">
    <c:if test="${userId eq null }"><a href="loginView.do">Login</a></c:if>
	    <div class="user-area">
	      <a class="icon" href="userList.do" style="margin: 0;"><i class="fas fa-user-circle fa-2x" style="color: gray;"></i></a>
	      <ul class="user-navi">
	      	<li><a href="myPage.do">마이페이지</a></li>
	      	<li><a href="chargeList.do">포인트</a></li>
	      	<li><a href="logout.do">로그아웃</a></li>
	      </ul>
	    </div><!--괜찮  -->
    <c:if test="${userId eq 'admin' and userId ne null}"><i class="fas fa-user-cog fa-2x" style="color: gray;"></i></c:if> <!-- 안괜찮 -->
      
<!--       <ul> -->
<!--       	<li>마이페이지</li> -->
<!--       	<li>포인트</li> -->
<!--       	<li>로그아웃</li> -->
<!--       </ul> -->
    </div>
  </div>
</body>
</html>