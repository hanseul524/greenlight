<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
        오늘은 <span id="today" style="width:80px;">2021.11.01</span>일 입니다.
      </div>
      <div class="nav-inner">
        <ul>
          <li class="li-area">
            <i class="fas fa-user-cog" style="margin-right: 10px;"></i><a href="userList.do">회원관리</a>
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
          <div class="con-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Address</th>
                  <th>Point</th>
                  <th>Date</th>
                  <th><input type="checkbox" id="chk_all"></th>
                </tr>
              </thead>
              <tbody>
			  <c:forEach items="${uList }" var="user">
                <tr>
                  <td>${user.count }</td>
                  <td>${user.userId }</td>
                  <td>${user.userName }</td>
                  <td>${user.userEmail }</td>
                  <td>${user.userAddr }</td>
                  <td>${user.point}</td>
                  <td>${user.regDate }</td>
                  <td><input type="checkbox" name="chk" class="del-chk" value="${user.userId }"></td>
                </tr>
			  </c:forEach>
              </tbody>
            </table>
            <div class="page_wrap">
			    <c:url var="before" value="userList.do">
			    	<c:param name="page" value="${upi.currentPage - 1 }"></c:param>
			    </c:url>
			      <div class="page_nation">
			      <c:if test="${upi.currentPage <= 1 }">
			         <a class="arrow prev" href="#"></a>
			      </c:if>
			      <c:if test="${upi.currentPage > 1 }">
			         <a class="arrow prev" href="${before }"></a>
			      </c:if>
			      <c:forEach var="p" begin="${upi.startNavi}" end="${upi.endNavi }">
			      	<c:url var="pagenation" value="userList.do">
			      		<c:param name="page" value="${p }"></c:param>
			      	</c:url>
			      	<c:if test="${p eq upi.currentPage }">
			         	<a href="#" class="active">${p }</a>
			      	</c:if>
			      	<c:if test="${p ne upi.currentPage }">
			      		<a href="${pagenation }">${p }</a>
			      	</c:if>
			      </c:forEach>
			      <c:url var="after" value="userList.do">
			      	<c:param name="page" value="${upi.currentPage + 1 }"></c:param>
			      </c:url>
			      <c:if test="${upi.currentPage >= upi.maxPage }">
			         <a class="arrow next" href="#"></a>
			      </c:if>
			      <c:if test="${upi.currentPage < upi.maxPage }">
			         <a class="arrow next" href="${after }"></a>
			      </c:if>
			      </div>
			 </div>
              <div class="btn-area">
                <button onclick="delUser();">선택 탈퇴</button>
              </div>
           </div>
          </div>
      </div>
    </div>
  </div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>