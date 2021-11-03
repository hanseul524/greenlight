<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>challengeWriteForm</title>
<script src="../js/summernote/summernote-lite.js"></script>
<script src="../js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="../css/writeForm.css">
<link rel="stylesheet" href="../css/summernote/summernote-lite.css">
</head>
<script>
$(document).ready(function(){
    $(".header").load("../common/header.html");
    $(".footer").load("../common/footer.html");
    
    $('#summernote').summernote({
		  height: 300,                 		// 에디터 높이
		  minHeight: null,             		// 최소 높이
		  maxHeight: null,             		// 최대 높이
		  focus: true,                  	// 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '내용을 입력해주세요.'		// placeholder 설정
        
	});
  });
</script>
<body>
  <div class="header"></div>
  <div class="container">
    <form action="" method="post">
      <div class="write-form">
        <span class="write-left">챌린지 참여하기</span>
        <span class="write-right">하루 한장, 모바일 영수증 받기!</span>
        <div class="title-area">
          <input type="text" name="" id="" placeholder="제목을 입력해주세요.">
        </div>
        <textarea name="editordata" id="summernote"></textarea>
      </div>
    </form>
  </div>
  <div class="footer"></div>
</body>
</html>