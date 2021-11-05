<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet"> <!-- 폰트 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jquery -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> <!-- 부트스트랩 -->
    <title>회원 정보</title>
    <link rel="stylesheet" href="mpuserInfo.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        
    </header>
    <div class="warper">
        <nav>
            <div id="nav-section">
                <ul id="nav nav-tabs">
                     <li class="nav-item"><a href="myPage.do" class="nav-link active">활동 기여도</a></li>
                 	 <li class="nav-item"><a href="myPageAdCheck.do" class="nav-link active">출석체크</a></li>
	                 <li class="nav-item"><a href="myPageInfo.do" class="nav-link active">회원 정보</a></li>
	                 <li class="nav-item"><a href="#" class="nav-link active">내가 쓴 글</a></li>
	                 <li class="nav-item"><a href="myPagePoint.do" class="nav-link active">포인트 내역</a></li>
	                 <li class="nav-item"><a href="#" class="nav-link active">내 경매</a></li>
	                 <li class="nav-item"><a href="#" class="nav-link active">나의 기부 현황</a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div id="member-modify">
                <h2>회원정보 수정</h2>
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="" id="info-id"></td>
                    </tr>
                </table>
            </div>
        </main>
        </div>
    <footer>
        
    </footer>
</body>
</html>