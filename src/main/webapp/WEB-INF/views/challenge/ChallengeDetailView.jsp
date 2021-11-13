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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
	        <span style="font-size: 20px; font-weight: 600;">Comments</span> <span id="rCount"></span>
	        <c:if test="${userId ne null }">
		        <c:choose>
	   				<c:when test="${chlike.likeCk eq 0}"> <!-- likeCk가0이면 빈하트-->
						<a href="#" onclick="addHeart();"><i class="far fa-heart fa-2x" style="color:red;"></i></a>
	    			</c:when>
	   				<c:otherwise> <!-- likeCk가1이면 빨간 하트-->
						<a href="#" onclick="delHeart();"><i class="fas fa-heart fa-2x" style="color:red;"></i></a>
	    			</c:otherwise>
				</c:choose>
	        </c:if>
	        <c:if test="${userId eq null }">
	        	<a href="#" onclick="loginCk();"><i class="far fa-heart fa-2x" style="color:red;"></i></a>
	        </c:if>
	        
	        <hr> 
	        <div class="comm-user-div">
	          <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
	          <input class="user-text" type="text" name="replyContents" id="replyContents" placeholder="댓글을 입력해주세요.">
	          <button id="submitBtn">등록</button>
	        </div>
	        <div class="comm-area" id="replyArea">
	          
	          <div class="comm-inner-area" id="replyArea"> <!-- 댓글 목록 영역 -->
	           	
	          </div>
	        </div>
	      </div>
    </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
	//좋아요를 눌렀을 때 아이디 값이 없을때
	function loginCk() {
		Swal.fire({ 
			icon: 'warning',
			title: '로그인이 필요합니다.',
			text: '로그인 후 이용해주세요.',
			}).then(function(){
				location.href="loginView.do";				
			})
	}
	//좋아요 update하는 함수
	function addHeart() {
		var chNo = '${challenge.chNo}';
		
		$.ajax({
			url : "addLike.do",
			type : "post",
			data : {
				"chNo" : chNo
			},
			success : function(data) {
				console.log(data)
				Swal.fire({ 
					icon: 'success',
					title: '좋아요',
					text: '좋아요 성공!',
					}).then(function (){
						location.reload();
					})
			},
			error : function() {
				alert("좋아요 실패~");
			}
		})
	}
	
	// 좋아요 delete
	function delHeart() {
		var chNo = '${challenge.chNo}';
		
		$.ajax({
			url : "removeLike.do",
			type : "post",
			data : {
				"chNo" : chNo
			},
			success : function(data) {
				Swal.fire({ 
					icon: 'success',
					title: '좋아요 취소',
					text: '좋아요 취소 성공!',
					}).then(function(){
						location.reload();
					})
			},
			error : function() {
				alert("취소 실패~");
			}
		})
	}
	
	// 댓글 쓰기
    getReplyList();
	$("#submitBtn").on("click", function() {
		var chNo = '${challenge.chNo}';
		var replyContents = $("#replyContents").val();
		$.ajax({
			url : "addReply.do",
			type : "post",
			data : {
				"chNo" : chNo,
				"replyContents" : replyContents
			},
			success : function(data) {
				console.log(data)
				if(data == "success") {
					getReplyList();//댓글 리스트 불러오기
					$("#replyContents").val("");
					Swal.fire({ 
						icon: 'success',
						title: '댓글 등록',
						text: '등록이 완료되었습니다.',
						});
				}else{
					alert("댓글 등록 실패!");
				}
			},
			error : function() {
				alert("submit 오류");
			}
		})
	});
	
	// 댓글 리스트 불러오기
	function getReplyList() {
		var chNo = '${challenge.chNo}';
		$.ajax({
			url : "replyList.do",
			type : "get",
			data : { "chNo" : chNo },
			dataType : "json",
			
			success : function(data) {
				console.log(data)
				var $rdiv = $("#replyArea div");
				$rdiv.html("");
				var $innerdiv;
				var $rWriter;
				var $rContent;
				var $rDate;
				var $btnArea;
				var $icon;
				
				$("#rCount").text(data.length);
				if(data.length > 0) {
					for(var i in data) {
						$innerdiv = $("<div id='replyDiv' style='border: 1px solid yellow; vertical-align:middle; align-items:center; padding: 10px;'><hr>");
						$icon = $("<i class='fas fa-user-circle fa-3x' style='color: gray;'>");
						$rWriter = $("<span>").text(data[i].replywriter);
						$rContent = $("<span>").text(data[i].replyContents);
						$rDate = $("<span>").text(data[i].replyDate);
						$btnArea = $("<span style='float:right;'>")
						.append("<a href='#' onclick='modifyReply(this,"+chNo+","+data[i].replyNo+",\""+data[i].replyContents+"\");'>수정 /</a>")
						.append("<a href='#' onclick='deleteReply(this,"+chNo+","+data[i].replyNo+");'> 삭제</a>")
						
						$innerdiv.append($icon);
						$innerdiv.append($rWriter);
						$innerdiv.append($rContent);
						$innerdiv.append($rDate);
						$innerdiv.append($btnArea);
						$rdiv.append($innerdiv);
						
					}
				}
			}
		});
	}
	// 댓글 수정 영역
	function modifyReply(obj, chNo, replyNo, replyContents) {
// 		$(obj).focus();
		var offset = $(obj).offset();
		$('html, body').animate({scrollTop : offset.top}, 600);
		
		$divModify = $("<div>");
		$divModify.append("<input type='text' id='modifyReply' size='70' value='"+replyContents+"'>");
		$divModify.append("<div><button onclick='modifyReplyOk("+chNo+","+replyNo+")'>수정하기</button></div>");
		$(obj).parent().after($divModify);
	}
	
	// 댓글 수정 ajax
	function modifyReplyOk(chNo, replyNo) {
		var updateContent = $("#modifyReply").val();
		$.ajax({
			url : "modifyReply.do",
			type : "post",
			data : {
				"chNo" : chNo,
				"replyNo" : replyNo,
				"replyContents" : updateContent
			},
			success : function(data) {
				if(data == "success") {
					getReplyList();
					Swal.fire({ 
						icon: 'success',
						title: '댓글 수정', 
						text: '수정이 완료되었습니다.', 
						});
				}else {
					alert("댓글 수정 실패");
				}
			},
			error : function() {
				alert("ajax 실패");
			}
		});
	}
	
	// 댓글 삭제
	function deleteReply(obj, chNo, replyNo) {
		var offset = $(obj).offset();
		$('html, body').animate({scrollTop : offset.top}, 600);
		$.ajax({
			url : "deleteReply.do",
			type : "get",
			data : {
				"chNo" : chNo,
				"replyNo" : replyNo
			},
			success : function(data) {
				if(data == "success") {
					Swal.fire({ 
						icon: 'success', // Alert 타입 
						title: '댓글 삭제', // Alert 제목 
						text: '삭제가 완료되었습니다.', // Alert 내용 
						});
					getReplyList();
				}else {
					alert("댓글 삭제 실패");
				}
			}
		});
	}
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