<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user/login.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<form action="login.do" method="post">
		<div class="page-container">
			<div class="login-form-container shadow">
				<div class="login-form-right-side" style="position: relative;">
					<img
						style="height: 100%; width: 100%; position: absolute; right: 0px; border-radius: 10px 0 0 10px;"
						src="${pageContext.request.contextPath}/resources/img/loginImg.jpg"
						alt="">
				</div>
				<!-- 로그인 입력창 -->
				<div class="login-form-left-side login-div">
					<div class="login-input-container">
						<div class="login-input-wrap input-id">
							<i class="far fa-envelope" style="color: #607a6a;"></i>
							<input placeholder="ID를 입력하세요." type="text" name="userId">
						</div>
						<div class="login-input-wrap input-password">
							<i class="fas fa-key" style="color: #607a6a;"></i>
							<input placeholder="PASSWORD를 입력하세요." type="password" name="userPwd">
						</div>
					</div>
					<div class="login-btn-wrap">
						<button type="submit" class="login-btn">Login</button>
						<a href="#" style="width: 95px; height: 35px;">
							<img src="${pageContext.request.contextPath}/resources/img/kakao.png" style="margin: 0 0 0; height: 100%; width: 100%;">
						</a>
						<span style="margin-top: 10px;">
							<a style="cursor: pointer;" onclick="idFind();">아이디 찾기</a> / <a style="cursor: pointer;" onclick="pwdFind();">비밀번호 찾기</a></span> <span style="margin-top: 10px;"><a href="enrollView.do">회원가입</a>
						</span>
					</div>
				</div>
	</form>
	
	<!-- 아이디 찾기 -->
	<form action="#">
		<div class="login-form-left-side idFind-div" align="center" style="display: none;">
			<div class="login-input-container">
				<div class="login-input-wrap input-id">
					<i class="fas fa-signature" style="color: #607a6a;"></i>
					<input placeholder="이름을 입력하세요." id="idFindName" type="text">
				</div>
				<div class="login-input-wrap input-password">
					<i class="far fa-envelope" style="color: #607a6a;"></i>
					<input style="width: 200px;" id="idFindEmail" placeholder="EMAIL을 입력하세요." type="text">
					<button type="button" class="btn btn-default btn-sm" onclick="emailCertification();">인증하기</button>
				</div>
				<div class="login-input-wrap email-accredit" style="display: none;">
					<i class="far fa-envelope" style="color: #607a6a;"></i>
					<input placeholder="인증코드를 작성하세요." id="inputIdCode" type="text">
				</div>
				<div class="login-btn-wrap Find-btn" style="display: none;">
					<input type="hidden" id="idFindCode">
					<button type="button" onclick="idFindCheck();" class="login-btn">아이디 찾기</button>
				</div>
			</div>
		</div>
	</form>
	<!-- 비밀번호 찾기 -->
	<form action="#">
		<div class="login-form-left-side pwdFind-div" align="center" style="display: none;">
			<div class="login-input-container">
				<div class="login-input-wrap input-id">
					<i class="fas fa-signature" style="color: #607a6a;"></i>
					<input placeholder="ID를 입력하세요." id="inputUserId" type="text">
				</div>
				<div class="login-input-wrap input-password">
					<i class="far fa-envelope" style="color: #607a6a;"></i>
					<input style="width: 200px;" id="pwdFindEmail" placeholder="EMAIL을 입력하세요." type="text">
					<button type="button" class="btn btn-default btn-sm" onclick="pwdEmailCertification();">인증하기</button>
				</div>
				<div class="login-input-wrap email-accredit" style="display: none;">
					<i class="far fa-envelope" style="color: #607a6a;"></i>
					<input placeholder="인증코드를 작성하세요." id="inputPwdCode" type="text">
				</div>
				<div class="login-btn-wrap Find-btn" style="display: none;">
					<input type="hidden" id="pwdFindCode">
					<button type="button" onclick="pwdFindCheck();" class="login-btn">비밀번호 찾기</button>
				</div>
			</div>
		</div>
	</form>
	<!-- 비밀번호 변경 -->
	<div class="login-form-left-side pwd-change" style="display: none;">
		<div class="login-input-container">
			<div class="login-input-wrap input-id">
				<i class="far fa-envelope" style="color: #607a6a;"></i>
				<input placeholder="ID를 입력하세요." type="text" id="changeUserId" readonly="readonly">
			</div>
			<div class="login-input-wrap input-password">
				<i class="fas fa-key" style="color: #607a6a;"></i>
				<input placeholder="변경할 비밀번호 영문 숫자 특수문자 조합으로 8~15 사이로 입력하세요." type="password" id="inputUserPwd">
			</div>
			<div class="login-input-wrap input-password">
				<i class="fas fa-key" style="color: #607a6a;"></i>
				<input placeholder="비밀번호를 다시 입력하세요." type="password" id="userRePwd">
			</div>
			<div class="login-btn-wrap Find-btn" style="display: none;">
				<button type="button" onclick="changePwd();" class="login-btn">비밀번호 변경</button>
			</div>
		</div>
	</div>
</div>
</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
		function idFind() {
			$(".login-div").css("display", "none");
			$(".idFind-div").css("display", "block");
			$(".pwdFind-div").css("display", "none");
		}
		function pwdFind() {
			$(".login-div").css("display", "none");
			$(".idFind-div").css("display", "none");
			$(".pwdFind-div").css("display", "block");
		}
		
		/* 아이디 찾기 이메일 전송 */
		function emailCertification(){
			var userEmail = $("#idFindEmail").val();
			var userName = $("#idFindName").val();
			var key;
			$.ajax({
				url : "checkId.do",
				type : "post",
				data : { "userEmail" : userEmail,
						"userName" : userName},
				success : function(result){
					if(result == 0){
						 Swal.fire({
	                         icon: 'error',
	                         title: '인증오류',
	                         text: '가입시 등록한 이름 및 이메일이 일치하지 않습니다.'
	                     })
					}else{
						key = result;
						$("#idFindCode").val(key);
						Swal.fire(
	                            '발송 성공!',
	                            '인증코드가 발송 되었습니다.',
	                            'success'
	                        )
	                        $(".email-accredit").css("display", "block"),
							$(".Find-btn").css("display", "block");
					}
				}
			});
		}
		// 아이디 찾기 버튼 이벤트
		function idFindCheck(){
			var userEmail = $("#idFindEmail").val();
			var userName = $("#idFindName").val();
			var checkCode = $("#idFindCode").val();
			var inputCode = $("#inputIdCode").val();
			if(checkCode == inputCode){
				$.ajax({
					url : "findId.do",
					type : "post",
					data : {"userEmail" : userEmail, "userName" : userName},
					success : function(userId){
						Swal.fire(
	                            '인증 완료',
	                            '회원의 아이디는 ' + userId + ' 입니다.',
	                            'success'
	                        ),
	                        $(".idFind-div").hide();
							$(".login-div").show();
							$(".email-accredit").hide();
					}
				});
			}else{
				Swal.fire({
                    icon: 'error',
                    title: '인증오류',
                    text: '인증코드와 입력하신 입력코드가 일치하지 않습니다.'
                })
			}
		}
		
		// 비밀번호 찾기 이메일 인증
		function pwdEmailCertification(){
			var userId = $("#inputUserId").val();
			var userEmail = $("#pwdFindEmail").val();
			var key;
			$.ajax({
				url : "checkUserPwd.do",
				type : "post",
				data : { "userId" : userId,
						"userEmail" : userEmail},
				success : function(result){
					if(result == 0){
						 Swal.fire({
	                         icon: 'error',
	                         title: '인증오류',
	                         text: '가입시 등록한 아이디 및 이메일이 일치하지 않습니다.'
	                     })
					}else{
						key = result;
						$("#pwdFindCode").val(key);
						Swal.fire(
	                            '발송 성공!',
	                            '인증코드가 발송 되었습니다.',
	                            'success'
	                        ),
	                        $("#changeUserId").val(userId);
	                        $(".email-accredit").css("display", "block"),
							$(".Find-btn").css("display", "block");
					}
				}
			});
		}
		
		// 비밀번호 찾기 버튼 이벤트
		function pwdFindCheck(){
			var userEmail = $("#pwdFindEmail").val();
			var userId = $("#inputUserId").val();
			var checkCode = $("#pwdFindCode").val();
			var inputCode = $("#inputPwdCode").val();
			if(checkCode == inputCode){
				Swal.fire(
                           '인증 완료',
                           '비밀번호 변경페이지로 이동합니다. ',
                           'success'
                       ),
                    $(".idFind-div").hide();
					$(".login-div").hide();
					$(".pwdFind-div").hide();
					$(".email-accredit").hide();
					$(".pwd-change").show();
			}else{
				Swal.fire({
                    icon: 'error',
                    title: '인증오류',
                    text: '인증코드와 입력하신 입력코드가 일치하지 않습니다.'
                })
			}
		}
		
		
		// 비밀번호 입력 블러 이벤트
		$("#inputUserPwd").blur(function(){
			var checkPwd = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
			var userPwd = $("#inputUserPwd").val();
			if(!checkPwd.test(userPwd)){
				Swal.fire({
                    icon: 'error',
                    title: '사용 불가',
                    text: '비밀번호는 영문 숫자 특수문자 조합으로 8~15글자 사이로 입력해주세요.'
                })
				return false;
			}else{
				Swal.fire(
                        '사용 가능',
                        '사용 가능한 비밀번호입니다.',
                        'success'
                    )
				return true;
			}
		});
		
		// 비밀번호 재입력 블러 이벤트
		$("#userRePwd").blur(function(){
			var checkPwd2 = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
	    	var userPwd = $("#inputUserPwd").val();
			var reCheckPwd2 = $("#userRePwd").val();
			if(!checkPwd2.test(reCheckPwd2) || reCheckPwd2 != userPwd){
				Swal.fire({
                    icon: 'error',
                    title: '비밀번호 불일치',
                    text: '비밀번호가 일치하지 않습니다.'
                })
				return false;
			}else{
				Swal.fire(
                        '사용 가능',
                        '비밀번호가 일치합니다. ',
                        'success'
                    )
				return true;
			}
	    });
		
		// 비밀번호 변경
		function changePwd(){
			var userId = $("#changeUserId").val();
			var userPwd = $("#inputUserPwd").val();
			var userRePwd = $("#userRePwd").val();
			if(userPwd == ""){
				Swal.fire({
                    icon: 'error',
                    title: '사용 불가',
                    text: '비밀번호는 영문 숫자 특수문자 조합으로 8~15글자 사이로 입력해주세요.'
                })
                 return false;
			}else if(userRePwd == ""){
				Swal.fire({
                    icon: 'error',
                    title: '사용 불가',
                    text: '비밀번호를 재입력 해주세요.'
                })
			}else{
				$.ajax({
					url : "userPwdUpdate.do",
					type : "post",
					data : {"userId" : userId, "userPwd" : userPwd},
					success : function(result){
						if(result != 0){
							Swal.fire(
			                        '변경 완료',
			                        '비밀번호 변경 완료.',
			                        'success'
			                    )
		                    $(".idFind-div").hide();
							$(".login-div").show();
							$(".pwdFind-div").hide();
							$(".email-accredit").hide();
							$(".pwd-change").hide();
						}else{
							Swal.fire({
			                    icon: 'error',
			                    title: '비밀번호 변경 오류',
			                    text: '관리자에게 문의하세요.'
			                })
						}
					}
				});
			}
		}
	</script>
</body>
</html>