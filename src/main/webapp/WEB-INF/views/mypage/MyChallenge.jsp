<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
    <c:forEach items="${cList }" var="challenge">
    <ul class="box">
      <li class="item">
		        <div class="box-inner">
		        <c:if test="${challenge.fileMain eq 'Y' }">
		          <div class="box-img">
		          	<img alt="" src="../../../resources/cuploadFiles/${challenge.fileName}">
		          </div>
		        </c:if>		        
		          <div class="contents-bottom">
		            <div class="box-user">
		              <div style="float: left; margin-right: 15px;">
		                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
		              </div>
		              <span style="color: #293e31a2; font-size: 13px;">${challenge.chWriter }<br>${challenge.writeDate }</span>
		            </div>
		            <div class="box-contents">
		            	<c:url var="cDetail" value="ChallengeDetail.do">
		            		<c:param name="chNo" value="${challenge.chNo }"></c:param>
		            	</c:url>
		              <a href="${cDetail }">
		                ${challenge.chTitle }
		              </a>
		            </div>
		            <br>
		            <hr>
		            <div style="padding-top: 10px;">
		              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;${challenge.replyCount }</span>
		              <span class="like"><i class="far fa-heart" style="color: red;"></i>&nbsp;&nbsp;${challenge.likeCount }</span>
		            </div>
		          </div>
		          </div>
		      </li>
	    </ul>
    </c:forEach>
	</div>
    <div class="page_wrap">
    <c:url var="before" value="ChallengeListView.do">
    	<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
    </c:url>
      <div class="page_nation">
      <c:if test="${pi.currentPage <= 1 }">
         <a class="arrow prev" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage > 1 }">
         <a class="arrow prev" href="${before }"></a>
      </c:if>
      <c:forEach var="p" begin="${pi.startNavi}" end="${pi.endNavi }">
      	<c:url var="pagenation" value="myChallenge.do">
      		<c:param name="page" value="${p }"></c:param>
      	</c:url>
      	<c:if test="${p eq pi.currentPage }">
         	<a href="#" class="active">${p }</a>
      	</c:if>
      	<c:if test="${p ne pi.currentPage }">
      		<a href="${pagenation }">${p }</a>
      	</c:if>
      </c:forEach>
      <c:url var="after" value="ChallengeListView.do">
      	<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
      </c:url>
      <c:if test="${pi.currentPage >= pi.maxPage }">
         <a class="arrow next" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage < pi.maxPage }">
         <a class="arrow next" href="${after }"></a>
      </c:if>
      </div>
    </div>
    
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>