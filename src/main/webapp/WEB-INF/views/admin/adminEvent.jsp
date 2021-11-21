<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<script type="text/javascript">
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
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="container">
    <div class="nav-admin">
      <i class="fas fa-user-circle fa-4x" style="color: gray; margin: 15px;"></i>
      <span>admin01</span>
      <div style="margin-left: 40px; font-size: 14px; font-weight: 500; color:#7ea18b;">
        관리자님, 안녕하세요. <br>
        오늘은 <span id="today" style="width:80px;"></span>일 입니다.
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
              <li><a href="adminSellAuctionView.do">판매관리</a></li>
            </ul>
          </li>
          <li class="li-area">
            <i class="far fa-calendar-check" style="margin-right: 10px;"></i><a href="AdminChList.do">챌린지 관리</a> 
          </li>
          <li class="li-area">
            <i class="fas fa-hand-holding-usd" style="margin-right: 10px;"></i><a href="#">기부관리</a>
          </li>
          <li class="li-area">
            <i class="fas fa-warehouse" style="margin-right: 10px;"></i><a href="#">매장관리</a>
             <ul>
              <li><a href="adminOnlineShop.do">온라인 매장 관리</a></li>
              <li><a href="adminOfflineShop.do">오프라인 매장 관리</a></li>
            </ul>
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
          <div class="con-title">
          <form action="" method="">
            <div>
              이벤트 당첨 관리 <br>
              <span>이번 이벤트 정답자 리스트입니다. 추첨을 해주세요.</span>
            </div>
            <button value=""  class="button" onclick="">추첨하기</button>
            <button value=""  class="button" onclick="">이벤트 오픈</button>
          </div>
          <div class="con-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Date</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>김유저</td>
                  <td>user01@naver.com</td>
                  <td>2021.11.20</td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>김유저</td>
                  <td>user01@naver.com</td>
                  <td>2021.11.20</td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>김유저</td>
                  <td>user01@naver.com</td>
                  <td>2021.11.20</td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>김유저</td>
                  <td>user01@naver.com</td>
                  <td>2021.11.20</td>
                </tr>
                <tr>
                  <td>01</td>
                  <td>user01</td>
                  <td>김유저</td>
                  <td>user01@naver.com</td>
                  <td>2021.11.20</td>
                </tr>
              </tbody>
            </table>
            </form>         
            <div class="page_wrap">
              <div class="page_nation">
                <a class="arrow prev" href="#"></a>
                <a href="#" class="active">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a class="arrow next" href="#"></a>
              </div>
            </div>

            <div class="con-title">
              <form action="" method="">
                <div>
                  당첨자 추첨 <br>
                  <span>당첨자 중 10%의 회원입니다. 포인트를 지급해주세요</span>
                </div>
                <button value=""  class="button" onclick="">포인트 지급</button>
              </div>
              <div class="con-list">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>Id</th>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Date</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>01</td>
                      <td>user01</td>
                      <td>김유저</td>
                      <td>user01@naver.com</td>
                      <td>2021.11.20</td>
                    </tr>
                    <tr>
                      <td>01</td>
                      <td>user01</td>
                      <td>김유저</td>
                      <td>user01@naver.com</td>
                      <td>2021.11.20</td>
                    </tr>
                    <tr>
                      <td>01</td>
                      <td>user01</td>
                      <td>김유저</td>
                      <td>user01@naver.com</td>
                      <td>2021.11.20</td>
                    </tr>
                    <tr>
                      <td>01</td>
                      <td>user01</td>
                      <td>김유저</td>
                      <td>user01@naver.com</td>
                      <td>2021.11.20</td>
                    </tr>
                    <tr>
                      <td>01</td>
                      <td>user01</td>
                      <td>김유저</td>
                      <td>user01@naver.com</td>
                      <td>2021.11.20</td>
                    </tr>
                  </tbody>
                </table>
                </form>         
                <div class="page_wrap">
                  <div class="page_nation">
                    <a class="arrow prev" href="#"></a>
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a class="arrow next" href="#"></a>
                  </div>
                </div>
            </div>
           </div>
          </div>
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
	
</script>
</body>
</html>