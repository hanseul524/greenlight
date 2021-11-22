<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
.popup-area {
  font-family: 'Noto Sans KR', sans-serif;
  width: 500px;
  height: 350px;
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
    <h3>이벤트 오픈하기</h3>
    <p>이벤트 오픈시 5일간 운영됩니다.</p>
      <div>
        <input class="input-area" type="text" placeholder="내용을 입력해주세요." id="eventQuestion">
        <input class="input-area" type="text" placeholder="정답을 입력해주세요." id="eventAnswer">
        <input class="input-btn" type="submit" value="오픈하기" onclick="registerEvent();" style="display : block; margin: 0 auto;">
      </div>
  </div>
 <script>
 	
 	function registerEvent(){
		 
 		var eventQuestion = $("#eventQuestion").val();
 		var eventAnswer = $("#eventAnswer").val();
 		
 		$.ajax({
 			url : "registerEvent.do",
 			type : "post",
 			data : {
 				"eventQuestion" : eventQuestion,
 				"eventAnswer" : eventAnswer
 			},
 			success : function(data){
 				if(data == "success"){
 					Swal.fire({ 
	                  icon: 'success',
	                  title: '이벤트 등록',
	                  text: '새로운 이벤트가 오픈되었습니다.',
	                  }).then(function(){
	                     window.close();
	                  })
 					}else{
 					  	  Swal.fire({
 					  	      icon: 'error',
 					  	      text: '이벤트 등록에 실패하셨습니다.'
 					  	  })
 					}	
 			},
 			error : function(){
 				console.log("ajax 실패")
 			}
 		})
 		
 	}
 
 </script>
</body>
</html>