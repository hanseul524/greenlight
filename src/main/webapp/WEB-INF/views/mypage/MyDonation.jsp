<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DonationBoard</title>
<link rel="stylesheet" href="../../../resources/css/mypage/mydonation.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.rawgit.com/theus/chart.css/v1.0.0/dist/chart.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container">
  			<div id="nav-section">
	           <ul id="nav nav-tabs">
				  <li class="nav-item"><a href="myPage.do" class="nav-link active">활동 기여도</a></li>
		       	  <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
		          <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
		          <li class="nav-item"><a href="myChallenge.do" class="nav-link active">내가 쓴 글</a></li>
		          <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
		          <li class="nav-item"><a href="myAcution.do" class="nav-link active">내 경매</a></li>
		          <li class="nav-item"><a href="myDonation.do" class="nav-link active">나의 기부 현황</a></li>
	           </ul>
	       </div>
	       <c:if test="${ empty dList }">
            	<h1 align="center">기부한 게시물이 없습니다.</h1>
            </c:if>
            <c:if test="${ not empty dList }">
    <c:forEach items="${dList }" var="donationBoard">
    	   <c:if test="${donationBoard.dtSuccess eq 'N' }">
			    <ul class="box">
			      <li class="item">
			        <div class="box-inner" style="width: 300px;height: 428px;border: 0.3px solid #7ea18b;float: left;margin: 30px;">
			        <c:if test="${donationBoard.fileMain eq 'Y' }">
			          <div class="box-img">
			          	<img alt="" src="${pageContext.request.contextPath}/resources/donationUploadFiles/${donationBoard.fileName}">
			          </div>
			        </c:if>		        
			          <div class="contents-bottom">
			            <div class="box-user" style="height: 50px;">
			              <div style="float: left; margin-right: 15px;">
			                <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
			              </div>
			              <span style="color: #293e31a2; font-size: 13px;">${donationBoard.writerId }</span><br>
			              <span style="color: #293e31a2; font-size: 13px;">${donationBoard.writeDate }</span>
			            </div>
			            <div class="box-contents">
			            	<c:url var="dBoardDetail" value="donationBoardDetail.do">
			            		<c:param name="boardNo" value="${donationBoard.boardNo }"></c:param>
			            	</c:url>
			              <a href="${dBoardDetail }">
			                ${donationBoard.dtSubject }
			              </a>
			              <div class="charts" style="background-color: rgb(240, 236, 236);  border-radius: 10px; margin-top: 2%;">
			              	<div class="charts__chart" style="width: ${(donationBoard.donationAmount / donationBoard.dtTargetAmount) * 100 }%; background-color: rgb(126, 187, 34); margin: 0; border-radius: 10px; z-index: 1;"></div>
			              </div>
			              <span style="font-size: 12px; position: relative; left: 87%;">${donationBoard.achievement }%</span>
			            </div>
			            <hr>
			            <div style="padding-top: 10px;">
			              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;${donationBoard.dtReplyCount }</span>
			            </div>
			          </div>
			          </div>
			      </li>
		    </ul>
	    </c:if>
    </c:forEach>
	</div>
    <div class="page_wrap">
    <c:url var="before" value="donationBoardList.do">
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
      	<c:url var="pagenation" value="donationBoardList.do">
      		<c:param name="page" value="${p }"></c:param>
      	</c:url>
      	<c:if test="${p eq pi.currentPage }">
         	<a href="#" class="active">${p }</a>
      	</c:if>
      	<c:if test="${p ne pi.currentPage }">
      		<a href="${pagenation }">${p }</a>
      	</c:if>
      </c:forEach>
      <c:url var="after" value="donationBoardList.do">
      	<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
      </c:url>
      <c:if test="${pi.currentPage >= pi.maxPage }">
         <a class="arrow next" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage < pi.maxPage }">
         <a class="arrow next" href="${after }"></a>
      </c:if>
	    </c:if>
      </div>
    </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>