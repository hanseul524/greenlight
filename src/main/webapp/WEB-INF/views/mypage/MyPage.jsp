<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>마이페이지</title>
    <link rel="stylesheet" href="../../../resources/css/mypage/myPage.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
    <div class="warper">
    <c:if test="${empty userId }">
    	<br><br><br>
 		<br><br><br>
 		<br><br><br>   
    	<h2 align="center">로그인 후 이용할 수 있는 기능입니다.</h2>
    	<br><br><br>
    	<div align="center"><button align="center" onclick="location.href='loginView.do'">로그인</button></div>
    	<br><br><br>
    	<br><br><br>
    </c:if>
    <c:if test="${not empty userId }">
    <nav>
            <div id="nav-section">
                <ul id="nav nav-tabs">
                  <li class="nav-item"><a href="myPage.do" class="nav-link active" style="color: rgb(42, 173, 248);">활동 기여도</a></li>
                  <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
                  <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
                  <li class="nav-item"><a href="myChallenge.do" class="nav-link active">내가 쓴 글</a></li>
                  <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
                  <li class="nav-item"><a href="myAcution.do" class="nav-link active">내 경매</a></li>
                  <li class="nav-item"><a href="myDonation.do" class="nav-link active">나의 기부 현황</a></li>
                </ul>
            </div>
        </nav>
        <main>
<!--             <div id="main-section"> -->
                <div id="main-img"><img src="${pageContext.request.contextPath}/resources/img/mypageimg.png"></div>
                <div id="main-text">
                	<c:if test="${empty history }">
	                	<p>
				                        회원님이 사용하신<br> 포인트는 
				           <span>0</span>이고 보유한 포인트는<br><span>0</span>입니다.
	                    </p>
	                    <c:if test="${iValue == 1 || iValue == 3 || iValue == 5 || iValue == 7 || iValue == 9}">
		                    <p>
					                        총합<span>0</span>의 포인트로<br>
					                        나무를 <span>0</span>그루를 심는 효과를  <br>얻었습니다.
		                    </p>
		                </c:if>
		                <c:if test="${iValue == 2 || iValue == 4 || iValue == 6 || iValue == 8 || iValue == 10}">
		                    <p>
					                        총합 <span>0</span>의 포인트로<br>
					                        쓰레기<span>0</span>을 줄이는 효과를  <br>얻었습니다.
		                    </p>
		                </c:if>
	                </c:if>
                	<c:forEach items="${history }" var="history">
	                <c:forEach items="${user }" var="user">
                		<p>
				                        회원님이 사용하신<br> 포인트는  <span>${history.pointUse }</span>이고
				                        보유한 포인트는  <br><span>${user.point }</span>입니다.
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
					                  </c:choose>를 심는 효과를  <br>얻었습니다.
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
						                  </c:choose>을 줄이는 효과를  <br>얻었습니다
			                    </p>
		                </c:if>
	                </c:forEach>
	                </c:forEach>
                </div>
                <div id="main-butn">
                	<div><button class="point-use-butn" style="background: rgb(42, 173, 248); color: #ffff;"onclick="location.href=donationBoardList.do''">기부하기</button></div>
                	<div><button class="point-use-butn" onclick="location.href='auctionListView.do'">경매하기</button></div>
                </div>
<!--             </div> -->
        </main>
    </div>
    </c:if>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>