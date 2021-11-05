<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Challenge Detail</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/challenge/chDetail.css" type="text/css">
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
      <div class="user-div">
        <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
        <span class="id-div" style="margin: 10px; font-weight: 300;">user01</span>
        <span class="date-div" style="margin: 10px; font-weight: 300;">2021.10.28</span>
        <span style="float: right; margin: 10px; font-weight: 300;"><a href="#">수정 /</a><a href="#">삭제</a></span>
      </div>
      <div class="title-div">
        <p>‘우리의 서식지 남극을 지켜주세요!’ 멸종위기 남극 동물 5종</p>
      </div>
      <div class="img-div">
        <img class="img-con" src="../img/21.jpg" alt="">
        <img class="img-con" src="../img/3456.jpg" alt="">
      </div>
      <div class="con-div">
        <p> 얼음으로 뒤덮인 대륙 남극, 그곳의 주인은 인간이 아닙니다. 
          혹독한 추위를 이겨내며 지금까지 꿋꿋하게 생존해온 바다 
          동물들이야 말로 남극의 주인이라고 할 수 있죠. 하지만 
          심각한 기후변화와 크릴 조업 등 인류의 개발활동으로 인해 
          남극은 위험에 처해있습니다. 특히 다수의 펭귄 종과 물개, 
          고래와 같은 남극 생물들이 멸종위기에 처해 있죠. 지금 보호하지 
          않으면 다시는 볼 수 없을지도 모를 다섯 종의 남극 
          생물을 소개합니다.</p>
      </div>
      <div class="con2-div">
        <hr>
      </div>
      <div class="comm-div">
        <span style="font-size: 20px; font-weight: 600;">Comments</span>
        <hr>
        <div class="comm-user-div">
          <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
          <input class="user-text" type="text" name="" id=""placeholder="댓글을 입력해주세요.">
          <input type="submit" value="등록">
        </div>
        <div class="comm-area">
          <i class="fas fa-user-circle fa-3x" style="color: gray;"></i>
          <div class="comm-inner-area">
            댓글 영역
          </div>
        </div>
      </div>
    </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>