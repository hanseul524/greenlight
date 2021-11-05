<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChallengeOpen</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
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
    <form action="" method="post">
      <div>
        <input class="input-area" type="text" placeholder="주제를 입력해주세요.">
        <input class="input-btn" type="submit" value="오픈하기">
      </div>
    </form>
  </div>
</body>
</html>