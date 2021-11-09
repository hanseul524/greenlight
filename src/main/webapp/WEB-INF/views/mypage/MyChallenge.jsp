<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyChallengeList</title>
<link rel="stylesheet" href="../../../resources/css/mypage/mpChallenge.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> <!-- 부트스트랩 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
	       <jsp:include page="/common/header.jsp"></jsp:include>
	</header>
	<div class="container">
       <div id="nav-section">
           <ul id="nav nav-tabs">
			  <li class="nav-item"><a href="myPage.do" class="nav-link active">활동 기여도</a></li>
	       	  <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
	          <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
	          <li class="nav-item"><a href="myChallenge.do" class="nav-link active">내가 쓴 글</a></li>
	          <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
	          <li class="nav-item"><a href="myAcution.do" class="nav-link active">내 경매</a></li>
	          <li class="nav-item"><a href="#" class="nav-link active">나의 기부 현황</a></li>
           </ul>
       </div>
    <ul class="box">
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp; 6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
      <li class="item">
        <div class="box-inner">
          <div class="box-img"></div>
          <div class="contents-bottom">
            <div class="box-user">
              <div style="float: left; margin-right: 15px;">
                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
              </div>
              <span style="color: #293e31a2;">user01 <br>2021.10.28</span>
            </div>
            <div class="box-contents">
              <a href="#">
                오늘은 비닐봉지 대신 <br> 장바구니를 사용했어요.
              </a>
            </div>
            <br>
            <hr>
            <div style="padding-top: 10px;">
              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;6</span>
              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;10</span>
            </div>
          </div>
          </div>
      </li>
    </ul>
    <div class="page_wrap">
      <div class="page_nation">
         <a class="arrow prev" href="#"></a>
         <a href="#" class="active">1</a>
         <a href="#">2</a>
         <a href="#">3</a>
         <a href="#">4</a>
         <a href="#">5</a>
         <a href="#">6</a>
         <a href="#">7</a>
         <a href="#">8</a>
         <a href="#">9</a>
         <a href="#">10</a>
         <a class="arrow next" href="#"></a>
      </div>
   </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>