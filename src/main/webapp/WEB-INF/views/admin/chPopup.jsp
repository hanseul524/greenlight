<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChallengeOpen</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.popup-area {
  font-family: 'Noto Sans KR', sans-serif;
  width: 400px;
  height: 250px;
  margin: 0 auto;
  text-align: center;
}
h3 {
  font-size: 40px;
  margin-bottom: 0;
  color: #293e31f6;
}
p {
  margin-top: 0;
  font-weight: 300;
}
.input-area {
  width: 300px;
  height: 60px;
  outline: none;
  background: transparent;
  border: 0;
  border-bottom: 1px solid gray;
  font-size: 20px;
  margin: 20px;
  color: lightgray;
  font-weight: 300;
}
.input-btn {
  padding: 10px 30px 10px 30px;
  border: 0;
  border-radius: 10px;
  background: #819789c4;
  box-shadow: 0 ;
}
</style>
</head>
<body>
  <div class="popup-area">
    <h3>챌린지 오픈하기</h3>
    <p>챌린지 오픈시 한달간 운영됩니다.</p>
      <div>
        <input class="input-area" type="text" name="chOpen" id="chOpen" placeholder="주제를 입력해주세요.">
        <input class="input-btn" type="button" onclick="caStart();" value="오픈하기">
      </div>
  </div>
  
  <script>
  	function caStart() {
  		var chCategory = $("#chOpen").val();
  		console.log(chCategory);
  		
  		$.ajax({
  			url : "ChOpen.do",
  			type : "post",
  			data : { "chCategory" : chCategory },
  			success : function(data) {
  				if(data == "success") {
  					$("#chOpen").val("");
  					
  					Swal.fire({ 
						icon: 'success',
						title: '카테고리 등록',
						text: '새로운 챌린지가 오픈되었습니다.',
						}).then(function(){
							window.close();
						})
  				}
  			},
  			error : function() {
  				alert("카테고리 등록 실패");
  			}
  		})
  	}
  </script>
</body>
</html>