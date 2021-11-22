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
</head>
<style>
    body {
      font-family: 'Noto Sans KR', sans-serif;
    }
    a {
    
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
    .login-area {
      width: 13%;
      height: 100px;
      float: left;
      text-align: right;
    }
    .login-area a {
      text-decoration: none;
      color: black;
      display: inline-block;
      margin: 30px 30px;
      font-weight: 300;
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
    .user-area {
      margin: 30px 20px;
    }
    .user-area>a {
      color: black;
      font-weight: 300;
      text-decoration: none;
      display: inline-block;
      margin: 30px 20px;
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
/*     .user-area a { */
/*       margin: 30px 20px; */
/*     } */
	.login-area:hover .user-navi {
      display: block;
   }
</style>
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
    <div class="login-area">
    <c:if test="${userId eq null }"><a href="loginView.do">Login</a></c:if>
    <div class="user-area">
    <c:if test="${userId ne null and userId ne 'admin'}">
    	<span style="font-size: 13px; font-weigth: 200; margin-right: 7px;">${userId }님, 안녕하세요.</span>
      <a class="icon" style="margin: 0;"><i class="fas fa-ellipsis-h"></i></a>
      <ul class="user-navi">
      	<li><a href="myPage.do">마이페이지</a></li>
      	<li><a href="chargeList.do">포인트</a></li>
      	<li><a href="logout.do">로그아웃</a></li>
      </ul>
    </c:if>
    <c:if test="${userId ne null and userId eq 'admin'}">
    	<span style="font-size: 13px; font-weigth: 200; margin-right: 7px;">관리자님, 안녕하세요.</span>
      <a class="icon" href="userList.do" style="margin: 0;"><i class="fas fa-ellipsis-h"></i></a>
    </c:if>
    </div><!--괜찮  -->
<%--     <c:if test="${userId eq 'admin' and userId ne null}"><i class="fas fa-user-cog fa-2x" style="color: gray;"></i></c:if> <!-- 안괜찮 --> --%>
      
    </div>
  </div>
</body>
</html>