<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Challenge Detail</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/challenge/chDetail.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container">
    <div class="category">
      <span class="menubar"><a href="#">참여하기</a></span>
      <span class="menubar"><a href="#">지난 챌린지</a></span>
      <span class="menubar"><a href="#">지난 챌린지</a></span>
      <span class="menubar"><a href="#">All</a></span>
    </div>
    <div class="contents">
	     <input type="hidden" value="1" name="categoryNo">
	     <input type="hidden" value=${challenge.chNo } name="chNo" id="chNo">
	      <div class="user-div">
	        <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
	        <span class="id-div" style="margin: 10px; font-weight: 300;">${challenge.chWriter }</span>
	        <span class="date-div" style="margin: 10px; font-weight: 300;">${challenge.writeDate }</span>
	        <span style="float: right; margin: 10px; font-weight: 300;">
	        	<c:url var="cModify" value="ChallengeModify.do">
	        		<c:param name="chNo" value="${challenge.chNo}"></c:param>
	        	</c:url>
	        	<a href="${cModify }">수정 /</a>
	        	
	        	<c:url var="cDelete" value="ChallengeDelete.do">
	        		<c:param name="chNo" value="${challenge.chNo }"></c:param>
	        		<c:param name="fileName" value="${challenge.fileName }"></c:param>
	        	</c:url>
	        	<a href="${cDelete }">삭제</a>
<!-- 				<a href="#" onclick="alertBtn();">삭제</a> -->
	        </span>
	      </div>
	      <div class="title-div">
	        <p>${challenge.chTitle }</p>
	      </div>
	      <div class="img-div">
	      <c:forEach items="${cList }" var="chImg" varStatus="index">
	      	<div class="img-area">
		        <img class="img-con" src="${pageContext.request.contextPath }/resources/cuploadFiles/${chImg.fileName}">
	      	</div>
	      	<br>
	      </c:forEach>
	      </div>
	      <div class="con-div">
	        <p> ${challenge.chContents }</p>
	      </div>
	      <div class="con2-div">
	        <hr>
	      </div>
	      <div class="comm-div">
	        <span style="font-size: 20px; font-weight: 600;">Comments</span>
	        <hr>
	        <div class="comm-user-div">
	          <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
	          <input class="user-text" type="text" name="replyContents" id="" placeholder="댓글을 입력해주세요.">
	          <input type="submit" value="등록">
	        </div>
	        <div class="comm-area">
	          <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
	          <div class="comm-inner-area"> <!-- 댓글 목록 영역 -->
	           		
	          </div>
	        </div>
	      </div>
    </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
// 	function alertBtn() {
		
// 		var chNo = $("#chNo").val();
// 		var fileName = $("#fileName").val();
		
// 		console.log(chNo);
// 		console.log(fileName);
		
// 		Swal.fire({
// 			  title: '글을 삭제하시곘습니까?',
// 			  text: "삭제를 한 후 다시 복구시킬 수 없습니다.",
// 			  icon: 'warning',
// 			  showCancelButton: true,
// 			  confirmButtonColor: '#3085d6',
// 			  cancelButtonColor: '#d33',
// 			  confirmButtonText: '삭제',
// 			  cancelButtonText: '취소'
// 			}).then((result){
// 			  if (result.isConfirmed) {
// 			    Swal.fire(
// 			      '삭제되었습니다!',
// 			      '글이 삭제 되었습니다.',
// 			      'success'
// 			    ).function() {
// 			    	location.href='ChallengeDelete.do?chNo='+chNo+'&fileName='+fileName;
// 			    };
// 			  }
// 			})
// 		}
</script>
</body>
</html>