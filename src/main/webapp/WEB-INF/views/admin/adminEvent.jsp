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
  <style>
  button {
  	float: right;
  	padding: 7px 12px 7px 12px;
  	margin: 5px;
  	border: 1px solid rgba(128, 128, 128, 0.61);
  	border-radius: 5px;
  	font-weight: 300;
  	font-size: 14px;
	}
	button:hover {
  		background-color: #819789c4;
	}
  </style>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="container">
    <div class="nav-admin">
      <i class="fas fa-user-circle fa-4x" style="color: gray; margin: 15px;"></i>
      <span>admin</span>
      <div style="margin-left: 40px; font-size: 14px; font-weight: 500; color:#7ea18b;">
        관리자님, 안녕하세요. <br>
        오늘은 <span id="today" style="width:80px;"></span>일 입니다.
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
            <i class="fas fa-hand-holding-usd" style="margin-right: 10px;"></i><a href="adminDonationBoardList.do">기부관리</a>
          </li>
          <li class="li-area">
            <i class="fas fa-warehouse" style="margin-right: 10px;"></i><a href="#">매장관리</a>
             <ul>
              <li><a href="adminOnlineShop.do">온라인 매장 관리</a></li>
              <li><a href="adminOfflineShop.do">오프라인 매장 관리</a></li>
            </ul>
          </li>
          <li class="li-area">
            <i class="fas fa-gifts" style="margin-right: 10px;"></i><a href="adminEventPage.do">이벤트관리</a> 
          </li>
        </ul>
      </div>
    </div>
      <div class="contents">
          <div class="con-title">
            <div style="width: 670px;">
              이벤트 당첨 관리 <br>
              <span>이번 이벤트 정답자 리스트입니다. 추첨을 해주세요.</span>
            </div>
            <button value=""  class="button" onclick="eventRaffle();">추첨하기</button>
            <button value=""  class="button" onclick="eventOpen();">이벤트 오픈</button>
          </div>
          <div class="con-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>NO</th>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>POINT</th>
                  <th>JOIN_DATE</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${aList eq null }">
              	<tr>
                  <td colspan="5" align="center">현재 정답자가 없습니다.</td>
                </tr>
              </c:if>
              <c:if test="${aList ne null }">
              <c:forEach items="${aList }" var="eventAnswer" varStatus="status">
                <tr>
                  <td>${eventAnswer.eventNo }</td>
                  <td>${eventAnswer.userId }</td>
                  <td>${eventAnswer.userName }</td>
                  <td>${eventAnswer.point }</td>
                  <td>${eventAnswer.joinDate }</td>
                </tr>
              </c:forEach>
              </c:if>
              </tbody>
            </table>
            <div class="page_wrap">
              <c:url var="before" value="adminEventPage.do">
			    	<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
			    </c:url>
			      <div class="page_nation">
			      <c:if test="${pi.currentPage <= 1 }">
			         <a class="arrow prev" href="#"></a>
			      </c:if>
			      <c:if test="${pi.currentPage > 1 }">
			         <a class="arrow prev" href="${before }"></a>
			      </c:if>
			      <c:forEach var="p" begin="${pi.startNavi}" end="${pi.endNavi }">
			      	<c:url var="pagenation" value="adminEventPage.do">
			      		<c:param name="page" value="${p }"></c:param>
			      	</c:url>
			      	<c:if test="${p eq pi.currentPage }">
			         	<a href="#" class="active">${p }</a>
			      	</c:if>
			      	<c:if test="${p ne pi.currentPage }">
			      		<a href="${pagenation }">${p }</a>
			      	</c:if>
			      </c:forEach>
			      <c:url var="after" value="adminEventPage.do">
			      	<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
			      </c:url>
			      <c:if test="${pi.currentPage >= pi.maxPage }">
			         <a class="arrow next" href="#"></a>
			      </c:if>
			      <c:if test="${pi.currentPage < pi.maxPage }">
			         <a class="arrow next" href="${after }"></a>
			      </c:if>
			   	  </div>
            </div>

            <div class="con-title">
                <div style="width: 670px;">
                  당첨자 추첨 <br>
                  <span>당첨자 중 10%의 회원입니다. 포인트를 지급해주세요</span>
                </div>
                <button value=""  class="button" onclick="pointPayments(event)">포인트 지급</button>
              </div>
              <div class="con-list">
                <table class="table table-hover">
                  <thead>
                    <tr>
	                  <th>NO</th>
	                  <th>ID</th>
	                  <th>NAME</th>
	                  <th>POINT</th>
	                  <th>JOIN_DATE</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:if test="${wList eq null }">
                  	 <tr>
	                  <td colspan="5" align="center">추첨을 해주시기 바랍니다.</td>
                    </tr>
                  </c:if>
                  <c:if test="${wList ne null }">
                  <c:forEach items="${wList }" var="eventWinner" varStatus="status">
                    <tr>
	                  <td>${eventWinner.eventNo }</td>
	                  <td>${eventWinner.userId }</td>
	                  <td>${eventWinner.userName }</td>
	                  <td>${eventWinner.point }</td>
	                  <td>${eventWinner.joinDate }</td>
                    </tr>
                  </c:forEach>
                  </c:if>
                  </tbody>
                </table>
                <div class="page_wrap">
                  <c:url var="before" value="adminEventPage.do">
			    	<c:param name="page" value="${api.currentPage - 1 }"></c:param>
			    </c:url>
			      <div class="page_nation">
			      <c:if test="${api.currentPage <= 1 }">
			         <a class="arrow prev" href="#"></a>
			      </c:if>
			      <c:if test="${api.currentPage > 1 }">
			         <a class="arrow prev" href="${before }"></a>
			      </c:if>
			      <c:forEach var="p" begin="${api.startNavi}" end="${api.endNavi }">
			      	<c:url var="pagenation" value="adminEventPage.do">
			      		<c:param name="page" value="${p }"></c:param>
			      	</c:url>
			      	<c:if test="${p eq api.currentPage }">
			         	<a href="#" class="active">${p }</a>
			      	</c:if>
			      	<c:if test="${p ne api.currentPage }">
			      		<a href="${pagenation }">${p }</a>
			      	</c:if>
			      </c:forEach>
			      <c:url var="after" value="adminEventPage.do">
			      	<c:param name="page" value="${api.currentPage + 1 }"></c:param>
			      </c:url>
			      <c:if test="${api.currentPage >= api.maxPage }">
			         <a class="arrow next" href="#"></a>
			      </c:if>
			      <c:if test="${api.currentPage < api.maxPage }">
			         <a class="arrow next" href="${after }"></a>
			      </c:if>
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
	
	var eventWinner = new Array();
	eventWinner = '${wList }';
	
	function eventRaffle(){
		location.href="eventRaffle.do";
	}
	
	function pointPayments(e){
		e.preventDefault;
		e.stopPropagation;
		location.href="eventWinnerPayments.do";
	}
	
    function eventOpen() {
        window.open('/adminEventWriteView.do', '_blank', 
        'top=250, left=500, height=350, width=550,toolbar=no, menubar=no, location=no, status=no, scrollbars=no, resizable=no');
      }
	
</script>
</body>
</html>