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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
    	 <input type="hidden" value="${userId }" id="userId">
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
	        <span>${challenge.chTitle }</span>
	      <c:if test="${userId eq 'admin' }">
	      	<c:if test="${challenge.chConfirm eq 'N'}">
		        <button onclick="chConfirm();">승인하기</button>
	      	</c:if>
	      	<c:if test="${challenge.chConfirm eq 'Y' }">
		        <button onclick="chMessage();">승인완료</button>
	      	</c:if>
	      </c:if>
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
						  <input type="checkbox" id="checkbox" name="likeChk"/>
					      <label for="checkbox">
					        <svg id="heart-svg" viewBox="467 392 58 57" xmlns="http://www.w3.org/2000/svg">
					          <g id="Group" fill="none" fill-rule="evenodd" transform="translate(467 392)">
					            <path d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z" id="heart" fill="#AAB8C2"/>
					            <circle id="main-circ" fill="#E2264D" opacity="0" cx="29.5" cy="29.5" r="1.5"/>
					  
					            <g id="grp7" opacity="0" transform="translate(7 6)">
					              <circle id="oval1" fill="#9CD8C3" cx="2" cy="6" r="2"/>
					              <circle id="oval2" fill="#8CE8C3" cx="5" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp6" opacity="0" transform="translate(0 28)">
					              <circle id="oval1" fill="#CC8EF5" cx="2" cy="7" r="2"/>
					              <circle id="oval2" fill="#91D2FA" cx="3" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp3" opacity="0" transform="translate(52 28)">
					              <circle id="oval2" fill="#9CD8C3" cx="2" cy="7" r="2"/>
					              <circle id="oval1" fill="#8CE8C3" cx="4" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp2" opacity="0" transform="translate(44 6)">
					              <circle id="oval2" fill="#CC8EF5" cx="5" cy="6" r="2"/>
					              <circle id="oval1" fill="#CC8EF5" cx="2" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp5" opacity="0" transform="translate(14 50)">
					              <circle id="oval1" fill="#91D2FA" cx="6" cy="5" r="2"/>
					              <circle id="oval2" fill="#91D2FA" cx="2" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp4" opacity="0" transform="translate(35 50)">
					              <circle id="oval1" fill="#F48EA7" cx="6" cy="5" r="2"/>
					              <circle id="oval2" fill="#F48EA7" cx="2" cy="2" r="2"/>
					            </g>
					  
					            <g id="grp1" opacity="0" transform="translate(24)">
					              <circle id="oval1" fill="#9FC7FA" cx="2.5" cy="3" r="2"/>
					              <circle id="oval2" fill="#9FC7FA" cx="7.5" cy="2" r="2"/>
					            </g>
					          </g>
					        </svg>
					      </label>
						<div class="likeCount">${challenge.likeCount }</div>
	    			</c:when>
	   				<c:otherwise> <!-- likeCk가1이면 빨간 하트-->
						<input type="checkbox" id="checkbox" name="likeChk" checked />
					      <label for="checkbox">
					        <svg id="heart-svg" viewBox="467 392 58 57" xmlns="http://www.w3.org/2000/svg">
					          <g id="Group" fill="none" fill-rule="evenodd" transform="translate(467 392)">
					            <path d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z" id="heart" fill="#AAB8C2"/>
					            <circle id="main-circ" fill="#E2264D" opacity="0" cx="29.5" cy="29.5" r="1.5"/>
					            </g>
					            
					          </g>
					        </svg>
					      </label>
						<div class="likeCount">${challenge.likeCount }</div>
	    			</c:otherwise>
				</c:choose>
	        </c:if>
	        <c:if test="${userId eq null }">
	        	<input type="checkbox" id="checkbox" name="likeChks"/>
					<svg id="heart-svg" viewBox="467 392 58 57" xmlns="http://www.w3.org/2000/svg" onclick="loginCk();">
					    <g id="Group" fill="none" fill-rule="evenodd" transform="translate(467 392)">
					    <path d="M29.144 20.773c-.063-.13-4.227-8.67-11.44-2.59C7.63 28.795 28.94 43.256 29.143 43.394c.204-.138 21.513-14.6 11.44-25.213-7.214-6.08-11.377 2.46-11.44 2.59z" id="heart" fill="#AAB8C2"/>
					    </g>
					</svg>
	        	<div class="likeCount">${challenge.likeCount }</div>
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
	//챌린지 승인
	function chConfirm() {
		var chNo = '${challenge.chNo}';
		var userId = '${challenge.chWriter}';
		console.log(chNo);
		
		Swal.fire({
			  title: '승인하시겠습니까?',
			  text: "승인시 회원에게 100포인트를 지급힙니다!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '승인하기'
			}).then((result) => {
			  if (result.isConfirmed) {
				$.ajax({
					url : "challengeConfirm.do",
					type : "post",
					data : { 
						"chNo" : chNo,
						"userId" : userId
						},
					success : function(data) {
						if(data == "success") {
						    Swal.fire(
						      '승인이 되었습니다!',
						      '회원의 게시글을 승인했습니다.',
						      'success'
						    )
						}
					},
					error : function() {
						alert("승인 실패");
					}
				});
			  }
			})
	}
	function chMessage() {
		Swal.fire({ 
			icon: 'warning',
			title: '이미 승인된 챌린지 입니다.',
			text: '승인완료는 취소할 수 없습니다.',
			})
	}
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
	
	// 좋아요 함수
	$("input:checkbox[name='likeChk']").click (function() {
		
		
	    if($("input:checkbox[name='likeChk']").prop("checked") == false) {
			console.log("하트누름");
			var chNo = '${challenge.chNo}';
			
			$.ajax({
				url : "removeLike.do",
				type : "post",
				data : {
					"chNo" : chNo
				},
				success : function(data) {
					location.reload();
				},
				error : function() {
					alert("취소 실패~");
				}
			})
		}
	    if($("input:checkbox[name='likeChk']").prop("checked") == true) {
			console.log("하트취소");
			var chNo = '${challenge.chNo}';
			
			$.ajax({
				url : "addLike.do",
				type : "post",
				data : {
					"chNo" : chNo
				},
				success : function(data) {
					location.reload();
				},
				error : function() {
					alert("좋아요 실패~");
				}
			})
		}
		
		
	})
	
	$("input:checkbox[name='likeChks']").click (function() {
		Swal.fire({ 
			icon: 'warning',
			title: '로그인이 필요합니다.',
			text: '로그인 후 이용해주세요.',
			}).then(function(){
				location.href="loginView.do";				
		})
			
	})

	// 댓글 리스트 불러오기
	function getReplyList() {
		var chNo = '${challenge.chNo}';
		var userId = '${userId}';
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
						$innerdiv = $("<div id='replyDiv' style='border-top: 1px solid rgb(219, 219, 219); vertical-align:middle; align-items:center; padding: 10px;'>");
						$icon = $("<i class='fas fa-user-circle fa-3x' style='color: gray; margin-right: 30px; margin-bottom: 20px;'>");
						$rWriter = $("<span style='font-size: 10px; display: block;  position: relative; left:74px;'>").text(data[i].replywriter);
						$rContent = $("<span style='line-height: 30px; position: relative; bottom: 8px;'>").text(data[i].replyContents);
						$rDate = $("<span style='float: right; margin-right: 15px; position: relative; top:15px;'>").text(data[i].replyDate);
						$rdiv.append($innerdiv);
						$innerdiv.append($rWriter);
						$innerdiv.append($icon);
						$innerdiv.append($rDate);
						if(userId == data[i].replywriter){
							$btnArea = $("<span style='float:right; position: relative; top:15px;'>")
							.append("<a href='#' onclick='modifyReply(this,"+chNo+","+data[i].replyNo+",\""+data[i].replyContents+"\");'>수정 /</a>")
							.append("<a href='#' style='margin-right:15px;' onclick='deleteReply(this,"+chNo+","+data[i].replyNo+");'> 삭제</a>")
							$innerdiv.append($btnArea);
						}
						$innerdiv.append($rContent);
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