<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/mypage/userInfo.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div style="width: 1200px; height: 900px; margin:0 auto;">
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
		<form action="modifyInfo.do" id="loginForm" class="needs-validation" method="post">
			<div class="col-md-5" style="display: inline-block;">
				<label for="inputId" class="form-label">아이디</label>
				<input type="text" class="form-control" name="userId" id="inputId" value="${user.userId }" readonly>
			</div>
			<div class="col-md-5" style="display: inline-block; margin-left: 9%;">
				<label for="inputId" class="form-label">이름</label>
				<input type="text" class="form-control" name="userName" id="inputName" value="${user.userName }" readonly>
			</div>
			<div class="col-md-5" style="display: inline-block; margin-top: 2%;">
				<label for="inputPwd" class="form-label">비밀번호</label>
				<input type="password" class="form-control" name="userPwd" id="inputPwd" placeholder="비밀번호는 영문 숫자 특수문자 조합으로 8~15글자로 입력해주세요.">
				<div class="invalid-feedback">비밀번호는 영문 숫자 특수문자 조합으로 8~15글자로 입력해주세요.</div>
			</div>
			<div class="col-md-5" style="display: inline-block; margin-top: 2%; margin-left: 9%;">
				<label for="inputPwdCheck" class="form-label">비밀번호 확인</label>
				<input type="password" class="form-control" id="inputPwdCheck" placeholder="비밀번호와 일치하게 입력해주세요.">
				<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>
			</div>
			<div class="col-md-5" style="margin-top: 2%;">
				<label for="inputEmail" class="form-label">이메일</label>
				<input type="text" class="form-control" name="userEmail" id="inputEmail" value="${user.userEmail }" readonly>
			</div>
			<div>
				<div class="col-md-5" style="margin-top: 2%;">
					<p>전화번호</p>
					<!-- <button style="position: relative; bottom: 3px; border-color: rgb(211, 207, 207);" type="button" class="btn btn-default btn-sm" onclick="" id="phoneBtn">휴대폰 인증</button> -->
					<input type="text" name="userPhone" class="form-control" id="userPhone" name="userPhone" style="width: 50%; display: inline-block;" value="${user.userPhone }" readonly>
					<input type="button" class="btn btn-default btn-sm" id="phoneBtn" style="position: relative; bottom: 3px; border-color: rgb(211, 207, 207);" value="휴대폰 인증">
					<input type="text" id="inputCertifiedNumber" placeholder="인증번호를 입력하세요." class="form-control" style="width: 50%; display: none;">
					<input type="button" value="확인" class="btn btn-default btn-sm" id="checkBtn" style="border-color: rgb(211, 207, 207); display: none;">
					<input type="hidden" id="checkPhone" value="checkPhone">
				</div>
			</div>
			<c:forTokens items="${user.userAddr }" delims="/" var="addr" varStatus="status">
			<c:if test="${status.index eq 0 }">
			<div>
				<div class="col-3" style="margin-top: 2%; display: inline-block;">
					<label for="inputAddress" style="display: block;"class="form-label">주소</label>
					<input type="text" class="form-control" id="inputAddress" name="post" style="width: 50%; display: inline; float: left; background-color: white;" value="${addr }" onclick="sample6_execDaumPostcode()" readonly>
					<button style="margin-left: 2%; position: relative; top: 3px; display: inline; border-color: rgb(211, 207, 207);" onclick="sample6_execDaumPostcode()" type="button" class="btn btn-default btn-sm">우편번호 검색</button>
				</div>
			</div>
			</c:if>
			<c:if test="${status.index eq 1 }">
			<div class="col-5" style="margin-top: 2%; display: inline-block;">
				<label for="inputAddress2" class="form-label">도로명 주소</label>
				<input type="text" class="form-control" id="inputAddress2" name="addrOne" style="background-color: white;" value="${addr }"  readonly>
			</div>
			</c:if>
			<c:if test="${status.index eq 2 }">
			<div class="col-5" style="margin-top: 2%; display: inline-block; margin-left: 9%;">
				<label for="inputAddress3" class="form-label">상세주소</label>
				<input type="text" class="form-control" id="inputAddress3" name="addrTwo" value="${addr }">
			</div>
			</c:if>
			</c:forTokens>
			<div align="center" style="height: 80px; width: 500px; margin:0 auto;">
                <div class="col-12" style="margin-top: 5%; float: left;">
                    <button type="button" onclick="join();" class="btn btn-lg" style="background-color: blue; color: white;">가입하기</button>
                    <button type="button" onclick="deleteUser();" class="btn btn-lg" style="background-color: red; color: white;">탈퇴하기</button>
                </div>
            </div>
		</form>
		</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script>
	    $("#inputPwd").blur(function(){
	    	var checkPwd = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
			var userPwd = $("#inputPwd").val();
			if(!checkPwd.test(userPwd)){
				$("#inputPwd").addClass("is-invalid");
				return false;
			}else{
				$("#inputPwd").removeClass("is-invalid");
				$("#inputPwd").addClass("is-valid");
				return true;
			}
	    });
	    $("#inputPwdCheck").blur(function(){
	    	var checkPwd2 = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
			var reCheckPwd2 = $("#inputPwdCheck").val();
			if(!checkPwd2.test(reCheckPwd2) || reCheckPwd2 ==""){
				$("#inputPwdCheck").addClass("is-invalid");
				return false;
			}else{
				$("#inputPwdCheck").removeClass("is-invalid");
				$("#inputPwdCheck").addClass("is-valid");
				return true;
			}
	    });
		
	
		 function join(){
			 if($("#inputId").val() == ""){
				 $("#inputId").addClass("is-invalid");
				 return false; 
			 }else if($("#inputName").val() == ""){
				 $("#inputname").addClass("is-invalid");
				 return false;
			 }else if($("#inputPwd").val() == ""){
				 $("#inputPwd").addClass("is-invalid");
				 return false;
			 }else if($("#inputPwdCheck").val() == ""){
				 $("#inputPwdCheck").addClass("is-invalid");
				 return false;
			 }else if($("#inputEmail").val() == ""){
				 $("#inputEmail").addClass("is-invalid");
				 return false;
			 }else if($("#inputAddress").val() == ""){
				 $("#inputAddress").addClass("is-invalid");
				 return false;
			 }else if($("#inputAddress2").val() == ""){
				 $("#inputAddress2").addClass("is-invalid");
				 return false;
			 }else if($("#inputAddress3").val() == ""){
				 $("#inputAddress3").addClass("is-invalid");
				 return false;
			 }else{
				 $("#loginForm").submit();
			 }
		 }
		 
		// 주소 api
			function sample6_execDaumPostcode() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 각 주소의 노출 규칙에 따라 주소를 조합한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								var addr = ''; // 주소 변수
								var extraAddr = ''; // 참고항목 변수

								//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
									addr = data.roadAddress;
								} else { // 사용자가 지번 주소를 선택했을 경우(J)
									addr = data.jibunAddress;
								}

								// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
								if (data.userSelectedType === 'R') {
									// 법정동명이 있을 경우 추가한다. (법정리는 제외)
									// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									if (data.bname !== ''
											&& /[동|로|가]$/g.test(data.bname)) {
										extraAddr += data.bname;
									}
									// 건물명이 있고, 공동주택일 경우 추가한다.
									if (data.buildingName !== ''
											&& data.apartment === 'Y') {
										extraAddr += (extraAddr !== '' ? ', '
												+ data.buildingName
												: data.buildingName);
									}
									// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraAddr !== '') {
										extraAddr = ' (' + extraAddr + ')';
									}
									// 조합된 참고항목을 해당 필드에 넣는다.
									document.getElementById("inputAddress3").value = extraAddr;

								} else {
									document.getElementById("inputAddress3").value = '';
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								document.getElementById("inputAddress").value = data.zonecode;
								document.getElementById("inputAddress2").value = addr;
								// 커서를 상세주소 필드로 이동한다.
								document.getElementById("inputAddress3").focus();
							}
						}).open();
			}
		function deleteUser(){
			if(confirm("정말 탈퇴하실 건가요?")){
				if($("#inputPwd").val() == ${user.userPwd} && $("#inputPwdCheck").val() == ${user.userPwd}){
					alert("다시 찾아오실 때까지 기다리겠습니다!")
					location.href='userDelete.do?userId=${user.userId }';
				}else{
					alert("비밀번호를 확인 바랍니다.")
				}
			}else{
				alert("탈퇴 안해주셔서 감사합니다!");
			}
		}
	</script>
</body>

</html>