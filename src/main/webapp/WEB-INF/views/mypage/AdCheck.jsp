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
    <title>출석체크</title>
    <link rel="stylesheet" href="../../../resources/css/mypage/mpadCheck.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <jsp:include page="/common/header.jsp"></jsp:include>
    </header>
    <div class="warper">
        <nav>
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
            </nav>
            <main>
                <h2 class='date_text' style="text-align: center; padding: 2rem 0"></h2>
                <div class='date_item rap'>
                    <div class="grid date_form date_head">
                    <div>일</div>
                    <div>월</div>
                    <div>화</div>
                    <div>수</div>
                    <div>목</div>
                    <div>금</div>
                    <div>토</div>
                    </div>
                    <div class="grid date_form dateSel"></div>
                </div>
                <div id="adCheck">
                    <input type="button" id="adCheck-butn" value="출석체크">
                </div>
            </main>
        </div>
    <footer>
        <jsp:include page="/common/footer.jsp"></jsp:include>
    </footer>
	
    <script type="text/javascript">
    function getDate(date) {
    	  return date.toLocaleDateString().replace(/\./g, "").split(" ");
    	}

    	const pad = (str) => str > 10 ? str : '0' + str;

    	  const ToDay = new Date();
    	  
    	  const nowMonth = ToDay.getMonth();
    	  
    	  const [y, m] = getDate(new Date(ToDay.setMonth(nowMonth)));

    	  const lastDay = getDate(new Date(y, m, 0)).pop() * 1;
    	  
    	  const day = new Date([y, m, 1].join("-")).getDay() * 1;
    	  
    	  const maxDay = Math.ceil((day + lastDay) / 7) * 7;

    	  var html = '';
			
    	  for (var i = 1; i <= maxDay; i++) {
    	    const diff = i - day;
    	    const d = diff <= lastDay && i > day ? diff : '';
    	    const tmpClass = !d ? 'background' : '';
    	    
    	    html += "<div class='dateSel '"+tmpClass+">"+d+"<br><br><p align='center'>출석</p>"+"</div>";
    	  }
    	  document.querySelector('.dateSel').innerHTML = html;
    	  document.querySelector('.date_text').innerText = y+'년 '+pad(m)+'월';
      </script>
</body>
</html>