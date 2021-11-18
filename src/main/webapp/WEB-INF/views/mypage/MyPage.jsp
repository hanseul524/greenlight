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
    <header>
	<jsp:include page="/common/header.jsp"></jsp:include>
    </header>
    <div class="warper">
    <nav>
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
        </nav>
        <main>
            <div id="main-section">
                <div id="main-img"><img src="../../../resources/css/mypage/img/mybatis.png" alt=""></div>
                <div id="main-text">
                	<c:forEach items="${history }" var="history">
	                <c:forEach items="${user }" var="user">
                		<p>
				                        회원님이 사용하신 포인트는 ${history.pointUse }이고<br>
				                        보유한 포인트는 ${user.point }입니다.
	                    </p>
	                	<c:if test="${iValue == 1 || iValue == 3 || iValue == 5 || iValue == 7 || iValue == 9}">
		                    <p>
					                        총합 ${history.pointUse + user.point }의 포인트로<br>
					                        나무를 <c:choose>
					                    <c:when test="${history.pointUse + user.point eq 0 }">0그루</c:when>
					                  	<c:when test="${history.pointUse + user.point <= 999}">10그루</c:when>
					                  	<c:when test="${history.pointUse + user.point <= 9999}">100그루</c:when>
					                  	<c:when test="${history.pointUse + user.point <= 99999}">1000그루</c:when>
					                  	<c:when test="${history.pointUse + user.point >= 999999}">10000그루</c:when>
					                  </c:choose>를 심는 효과를 얻었습니다.
		                    </p>
		                </c:if>
		                <c:if test="${iValue == 2 || iValue == 4 || iValue == 6 || iValue == 8 || iValue == 10}">
			                    <p>
						                        총합 ${history.pointUse + user.point }의 포인트로<br>
						                        쓰레기 <c:choose>
						                    <c:when test="${history.pointUse + user.point eq 0 }">0kg</c:when>
						                  	<c:when test="${history.pointUse + user.point <= 999}">10kg</c:when>
						                  	<c:when test="${history.pointUse + user.point <= 9999}">100kg</c:when>
						                  	<c:when test="${history.pointUse + user.point <= 99999}">1t</c:when>
						                  	<c:when test="${history.pointUse + user.point >= 999999}">10t</c:when>
						                  </c:choose>을 줄이는 효과를 얻었습니다
			                    </p>
		                </c:if>
	                </c:forEach>
	                </c:forEach>
                </div>
                <div id="main-butn"><button onclick="location.href='myPage.do'">포인트 사용하기</button></div>
            </div>
        </main>
    </div>
    <footer>
		<jsp:include page="/common/footer.jsp"></jsp:include>
    </footer>
</body>
</html>