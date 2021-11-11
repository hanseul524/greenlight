<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet"> <!-- 폰트 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jquery -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> <!-- 부트스트랩 -->
    <title>포인트 내역</title>
    <link rel="stylesheet" href="../../../resources/css/mypage/mpPointHistory.css">
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
           <div>
               <h2>포인트 획득/사용 내역</h2>
           </div>
           <div id="point-table-section">
               <table align="center" id="point-table">
                   <tr>
                       <th class="table-th">일시</th>
                       <th class="table-th">내용</th>
                       <th class="table-th">지급 포인트</th>
                       <th class="table-th">사용 포인트</th>
                   </tr>
                   <c:if test="${empty point }">
		                   <tr>
		                       <td colspan="4"  class="table-td">포인트 획득 내역이 없습니다</td>
		                   </tr>
                   </c:if>
                   <c:if test="${ not empty point }">
	                   <c:forEach items="${point }" var="point" varStatus="index">
		                   <tr>
		                       <td  class="table-td">${point.pointDate }</td>
		                       <td  class="table-td">${point.pointContents }</td>
		                       <td  class="table-td">+${point.pointPayment }</td>
		                       <td  class="table-td">-${point.pointUse }</td>
		                   </tr>
	                   </c:forEach>
                   </c:if>
               </table>
               <div id="point-pageing">
                   [이전] 1 2 3 4 5 [다음]
               </div>
           </div>
       </main>
    </div>
    <footer>
        <jsp:include page="/common/footer.jsp"></jsp:include>
    </footer>
</body>
</html>