<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChallengeList</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/challenge/chList.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container">
    <div class="category">
      <span class="menubar"><a href="ChallengeListView.do?check=recent">참여하기</a></span>
      <span class="menubar"><a href="ChallengeListView.do?check=prev">지난 챌린지</a></span>
      <span class="menubar"><a href="ChallengeListView.do?check=prevprev">지난 챌린지</a></span>
      <span class="menubar"><a href="ChallengeListView.do?check=all">All</a></span>
	  <input type="text" name="search-title" id="search-title" placeholder="제목을 입력해주세요.">
	  <button>search</button>
      <span class="write-btn"><a href="ChallengeWriteview.do">write</a></span>
    </div>
	    <div class="category-area">
	      <span>${category.chCategory }</span>
	    </div>
    <c:forEach items="${cList }" var="challenge">
	    <input type="hidden" value="${challenge.categoryNo }" name="categoryNo">
		    <ul class="box">
		      <li class="item">
		        <div class="box-inner">
		        <c:if test="${challenge.fileMain eq 'Y' }">
		          <div class="box-img">
		          	<img alt="" src="${pageContext.request.contextPath}/resources/cuploadFiles/${challenge.fileName}">
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
    	<c:param name="check" value="${check }"></c:param>
    </c:url>
      <div class="page_nation">
      <c:if test="${pi.currentPage <= 1 }">
         <a class="arrow prev" href="#"></a>
      </c:if>
      <c:if test="${pi.currentPage > 1 }">
         <a class="arrow prev" href="${before }"></a>
      </c:if>
      <c:forEach var="p" begin="${pi.startNavi}" end="${pi.endNavi }">
      	<c:url var="pagenation" value="ChallengeListView.do">
      		<c:param name="page" value="${p }"></c:param>
      		<c:param name="check" value="${check }"></c:param>
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
      	<c:param name="check" value="${check }"></c:param>
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

<script>
	$("input:button[name='button']").on("click", function() {
		var categoryNo = $(this).val();
		$.ajax({
			url : "ChallengeListView.do",
			type : "post",
			data : { "categoryNo" : categoryNo },
			success : function(data) {
				
			},
			error : function() {
				alert("ajax 오류");
			}
		})
	});
</script>
</body>
</html>