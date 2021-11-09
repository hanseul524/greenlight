<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminPage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
      $(".header").load("header.html");
      $(".footer").load("footer.html");

      $('div > ul > li').click(function() {
        if ( $(this).hasClass('active') ) {
          $(this).find(' > ul').stop().slideUp(300);
          $(this).removeClass('active');
        }
        else {
          $(this).find(' > ul').stop().slideDown(300);
          $(this).addClass('active');
        }
      });
    });
</script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container">
    <div class="nav-admin">
      <i class="fas fa-user-circle fa-4x" style="color: gray; margin: 15px;"></i>
      <span>admin01</span>
      <div style="margin-left: 40px; font-size: 14px; font-weight: 500; color:#7ea18b;">
        관리자님, 안녕하세요. <br>
        오늘은 2021.11.01일 입니다.
      </div>
      <div class="nav-inner">
        <ul>
          <li class="li-area">
            <i class="fas fa-user-cog" style="margin-right: 10px;"></i><a href="#">회원관리</a>
          </li>
          <li class="li-area">
            <i class="fas fa-coins" style="margin-right: 10px;"></i><a href="#">경매관리</a> 
            <ul>
              <li><a href="adminAuctionView.do">재고관리</a></li>
              <li><a href="#">판매관리</a></li>
            </ul>
          </li>
          <li class="li-area">
            <i class="far fa-calendar-check" style="margin-right: 10px;"></i><a href="#">챌린지 관리</a> 
            <ul>
              <li><a href="#">승인관리</a></li>
              <li><a href="#">챌린지등록</a></li>
            </ul>
          </li>
          <li class="li-area">
            <i class="fas fa-hand-holding-usd" style="margin-right: 10px;"></i><a href="#">기부관리</a>
          </li>
          <li class="li-area">
            <i class="fas fa-warehouse" style="margin-right: 10px;"></i><a href="#">매장관리</a>
          </li>
          <li class="li-area">
            <i class="fas fa-gifts" style="margin-right: 10px;"></i><a href="#">이벤트관리</a> 
            <ul>
              <li><a href="#">이벤트 생성</a></li>
              <li><a href="#">당첨자 관리</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
      <div class="contents">
        <form action="" method="post">
          <div class="con-title">
            <div>전체 회원 목록</div>
            <input type="text" placeholder="검색하실 아이디를 입력하세요.">
            <input type="button" name="name" value="search">
          </div>
        </form>
        <form action="" method="get">
          <div class="con-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Address</th>
                  <th>Date</th>
                  <th><input type="checkbox" name="" id=""></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>일용자</td>
                  <td>user01@iei.com</td>
                  <td>서울시 중구</td>
                  <td>2021.11.02</td>
                  <td><input type="checkbox" name="" id=""></td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>일용자</td>
                  <td>user01@iei.com</td>
                  <td>서울시 중구</td>
                  <td>2021.11.02</td>
                  <td><input type="checkbox" name="" id=""></td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>일용자</td>
                  <td>user01@iei.com</td>
                  <td>서울시 중구</td>
                  <td>2021.11.02</td>
                  <td><input type="checkbox" name="" id=""></td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>일용자</td>
                  <td>user01@iei.com</td>
                  <td>서울시 중구</td>
                  <td>2021.11.02</td>
                  <td><input type="checkbox" name="" id=""></td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>일용자</td>
                  <td>user01@iei.com</td>
                  <td>서울시 중구</td>
                  <td>2021.11.02</td>
                  <td><input type="checkbox" name="" id=""></td>
                </tr>
              </tbody>
            </table>
            <div class="page_wrap">
              <div class="page_nation">
                 <a class="arrow prev" href="#"></a>
                 <a href="#" class="active">1</a>
                 <a href="#">2</a>
                 <a href="#">3</a>
                 <a href="#">4</a>
                 <a href="#">5</a>
                 <a href="#">6</a>
                 <a href="#">7</a>
                 <a href="#">8</a>
                 <a href="#">9</a>
                 <a href="#">10</a>
                 <a class="arrow next" href="#"></a>
              </div>
              <div class="btn-area">
                <input type="submit" value="선택탈퇴">
              </div>
           </div>
          </div>
        </form>
      </div>
    </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
	todayDate();
	
	function todayDate(){
		  var today = new Date();
		
		  var year = today.getFullYear();
		  var month = ('0' + (today.getMonth() + 1)).slice(-2);
		  var day = ('0' + today.getDate()).slice(-2);
		
		  var dateString = year + '.' + month  + '.' + day;
		
		  $("#today").html(dateString);
	}
</script>
</body>
</html>