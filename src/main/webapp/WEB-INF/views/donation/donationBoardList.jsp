<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DonationBoard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/challenge/chList.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.rawgit.com/theus/chart.css/v1.0.0/dist/chart.css"/>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container">
    <c:forEach items="${dList }" var="donationBoard">
		    <ul class="box">
		      <li class="item">
		        <div class="box-inner">
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
		              <span style="font-size: 12px; position: relative; left: 90%;">${(donationBoard.donationAmount / donationBoard.dtTargetAmount) * 100 }%</span>
		            </div>
		            <hr>
		            <div style="padding-top: 10px;">
		              <span class="view"><i class="far fa-comment-alt"></i>&nbsp;&nbsp;${donationBoard.dtReplyCount }</span>
		            </div>
		          </div>
		          </div>
		      </li>
	    </ul>
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
      </div>
    </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>