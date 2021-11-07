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
							<i class="far fa-envelope" style="color: #607a6a;"></i> <input
								placeholder="ID를 입력하세요." type="text" name="userId">
						</div>
						<div class="login-input-wrap input-password">
							<i class="fas fa-key" style="color: #607a6a;"></i> <input
								placeholder="PASSWORD를 입력하세요." type="password" name="userPwd">
						</div>
					</div>
					<div class="login-btn-wrap">
						<button type="submit" class="login-btn">Login</button>
						<a href="#" style="width: 95px; height: 35px;"> <img
							src="${pageContext.request.contextPath}/resources/img/kakao.png"
							style="margin: 0 0 0; height: 100%; width: 100%;">
						</a> <span style="margin-top: 10px;"><a
							style="cursor: pointer;" onclick="idFind();">아이디 찾기</a> / <a
							style="cursor: pointer;" onclick="pwdFind();">비밀번호 찾기</a></span> <span
							style="margin-top: 10px;"><a href="enrollView.do">회원가입</a></span>
					</div>
				</div>
	</form>
	
	<!-- 아이디 찾기 -->
		<form action="#">
	<div class="login-form-left-side idFind-div" align="center"
		style="display: none;">
			<div class="login-input-container">
				<div class="login-input-wrap input-id">
					<i class="fas fa-signature" style="color: #607a6a;"></i> <input
						placeholder="이름을 입력하세요." type="text">
				</div>
				<div class="login-input-wrap input-password">
					<i class="far fa-envelope" style="color: #607a6a;"></i> <input
						style="width: 200px;" placeholder="EMAIL을 입력하세요." type="text">
					<button type="button" class="btn btn-default btn-sm" onclick="emailAccredit();">인증하기</button>
				</div>
				<div class="login-input-wrap email-accredit" style="display: none;">
					<i class="far fa-envelope" style="color: #607a6a;"></i> <input
						placeholder="인증코드를 작성하세요." type="text">
				</div>
				<div class="login-btn-wrap Find-btn" style="display: none;">
					<button type="submit" class="login-btn">아이디 찾기</button>
				</div>
			</div>
	</div>
		</form>
	<!-- 비밀번호 찾기 -->
	<form action="#">
		<div class="login-form-left-side pwdFind-div" align="center"
			style="display: none;">
			<div class="login-input-container">
				<div class="login-input-wrap input-id">
					<i class="fas fa-signature" style="color: #607a6a;"></i> <input
						placeholder="ID를 입력하세요." type="text">
				</div>
				<div class="login-input-wrap input-password">
					<i class="far fa-envelope" style="color: #607a6a;"></i> <input
						style="width: 200px;" placeholder="EMAIL을 입력하세요." type="text">
					<button type="button" class="btn btn-default btn-sm" onclick="emailAccredit();">인증하기</button>
				</div>
				<div class="login-input-wrap email-accredit" style="display: none;">
					<i class="far fa-envelope" style="color: #607a6a;"></i> <input
						placeholder="인증코드를 작성하세요." type="text">
				</div>
				<div class="login-btn-wrap Find-btn" style="display: none;">
					<button type="submit" class="login-btn">비밀번호 찾기</button>
				</div>
			</div>
		</div>
	</form>
	</div>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>

	<script>
		function idFind() {
			$(".login-div").css("display", "none");
			$(".idFind-div").css("display", "block");
			$(".pwdFind-div").css("display", "none");
		}
		function emailAccredit() {
			$(".email-accredit").css("display", "block");
			$(".Find-btn").css("display", "block");
		}
		function pwdFind() {
			$(".login-div").css("display", "none");
			$(".idFind-div").css("display", "none");
			$(".pwdFind-div").css("display", "block");
		}
	</script>
</body>
</html>