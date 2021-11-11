<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/auction/auctionDetail.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><!-- alert 코드 -->
<title>경매 디테일</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
<div class="content">
      
      <p>천연목재로 만든 칫솔</p>
      <div class="slide">
        <div id="slide">
          <c:forEach items="${auctionImage }" var="auctionImage" varStatus="status">
          	<input type="radio" name="pos" id="pos${status.count }" <c:if test="${status.count eq 1 }">checked</c:if>>
          </c:forEach>
          <ul>
          <c:forEach items="${auctionImage }" var="auctionImage" varStatus="index">
            <li><img src="${pageContext.request.contextPath }/resources/auctionImage/${auctionImage.fileName }" class="img"></li>
          </c:forEach>
          </ul>
          <p class="pos">
          <c:forEach items="${auctionImage }" var="auctionImage" varStatus="status">
            <label for="pos${status.count }"></label>
           </c:forEach>
          </p>
        </div>
      </div>
      <div class="info">
        <div class="time">
          <input type="hidden" id="hidden" value="${user.point }">
          <span style="font-size:18px; color:rgb(80, 80, 80);">현재가</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:24px;" id="price"><c:if test="${ empty auctionUser }">${auctionHistory.auctionPrice }</c:if><c:if test="${not empty auctionUser }">${auctionUser.point }</c:if></span><span style="font-size: 18px; color:rgb(80, 80, 80)">P</span>
          <%-- <input type="hidden" id="point" value="${auction.auctionPrice }"> --%>
          <div class="time-box">
            <p id="time"></p>
          </div>
        </div>
        <div class="auction-number">
          <div class="auction-content">
            <p>경 매 번 호 &nbsp;&nbsp;: </p>
          </div>
          <div class="auction-content2">
            <p>&nbsp;&nbsp;${auctionHistory.auctionNo }</p>
          </div>
        </div>
        <div class="auction-number">
          <div class="auction-content">
            <p>경 매 시 간 &nbsp;&nbsp;: </p>
          </div>
          <div class="auction-content2">
            <p style="color:black;">&nbsp;&nbsp;${auctionHistory.auctionTime }시간</p>
          </div>
        </div>
        <div class="auction-pre">
          <p>
            <br>
            회원이 보유한 포인트가 없을 시 입찰을 할 수 없으며, <br>
            포인트를 충전하고 싶으신 분은 우측 상단에서<br>
            포인트 충전을 해주시길 바랍니다. <br><br>
            
            현 최고입찰자는 다음 최고 입찰자가 나오기 전까지는<br>
            다음 입찰을 할 수 없습니다.<br><br>
            
            한 번 입찰시 최고금액에서 50P를 추가한 금액이<br> 
            입찰이 되며 입찰 한도수는 제한이 없으나<br>
            무분별한 입찰은 제한해 주시길 바랍니다.            
          </p>
        </div>
        <c:if test="${ not empty user }">
	        <div class="auction-button">
	            <div class="button" type="submit">입 찰</div>
	        </div>
        </c:if>    
        <!-- <div class="auction-check">
        </div> -->
      </div>
    </div>
<script>

	auctionTimer('${auctionHistory.auctionStart}', '${auctionHistory.auctionTime}');

	$(document).on("click", ".button", function(e){
	    e.preventDefault;
	    var userPoint = parseInt('${user.point }') + parseInt('${user.chargePoint }');
	    var price = parseInt($("#price").text())+50;
	    var user = '${user.userId }';
	    var userHistory = '${auctionHistory.userId}'
	    var auctionUser = '${auctionUser.userId }'
	    console.log(userHistory);
	    console.log("userPoint : " + userPoint)
	    console.log(user + ", " + auctionUser);
	    if(user == userHistory){
	    	swal({
		        icon: "error",
		        text : "본인경매는 입찰할 수 없습니다."
		      }).then((result) => {
	        	  if(result){
			        	location.href="auctionDetail.do?auctionNo="+${auctionHistory.auctionNo};	        		  
		        	  }
		          });
	    }else if(user == auctionUser){
	    	swal({
		        icon: "error",
		        text : "현재 최고입찰자입니다."
		      }).then((result) => {
	        	  if(result){
			        	location.href="auctionDetail.do?auctionNo="+${auctionHistory.auctionNo};	        		  
		        	  }
		          });
	    }else if(userPoint > price){
	      swal({
	          title: "입찰을 진행하시겠습니까 ?",
	          buttons: {
	          cancel: true,
	          confirm: true
	        },
	      }).then((value) => {
	        if(value){
	          swal({
	            icon: "success",
	            text : "입찰이 완료되었습니다.",
	          }).then((result) => {
	        	  if(result){
		        	location.href="insertAuctionUser.do?userId="+user+"&auctionNo="+${auctionHistory.auctionNo }+"&point="+price;	        		  
	        	  }
	          });
	          /* location.href="디테일 페이지 재확인" */
	        }else{
	          console.log("취소")
	          return false;
	        }
	   })

	    }else{
	      swal({
	        icon: "error",
	        text : "보유하신 포인트가 부족합니다."
	      });
	    }
	  })
  		
  		function auctionTimer(timer, auctionTime){
  			var x = setInterval(function(){
				var now = new Date();
				var year = now.getFullYear();
				var month = now.getMonth();
				var day = now.getDate();
				var hours = now.getHours();
				var minutes = now.getMinutes();
				var seconds = now.getSeconds();
				
			/* ----------------------------------------------------------- */	
				
				var sttDt = timer;
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				var sttMonth = sttDt[1]-1;
				var sttDay = sttDt[2];
				var sttHour = sttDt[3];
				var sttHours = parseInt(sttHour) + parseInt(auctionTime);
				var sttMinutes = sttDt[4];
				var sttSeconds = sttDt[5];
				
				/* var sttDt = "2021-11-11";
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				var sttMonth = sttDt[1]-1;
				var sttDay = sttDt[2];
				
				// 관리자가 경매 진행할 시간 입력하기
				var sttHours = 17; // 시
				var sttMinutes = 48; // 분
				var sttSeconds = 00; // 초  */
				
			/* ----------------------------------------------------------- */
				
				var date1 = new Date(year, month, day, hours, minutes, seconds);
				var date2 = new Date(sttYear, sttMonth, sttDay, sttHours, sttMinutes, sttSeconds);
				
				var elapsedMSec = date2.getTime() - date1.getTime();
				var elapsedMSec = elapsedMSec / 1000; // 초
				
				var hours = Math.floor(elapsedMSec/3600);
				var mins = Math.floor((elapsedMSec - hours*3600)/60);
				var secs = elapsedMSec - hours*3600 - mins*60;
				
	            if (hours.toString().length==1) hours = "0" + hours;
	            if (mins.toString().length==1) mins = "0" + mins;  
	            if (secs.toString().length==1) secs = "0" + secs;
				
				 if(hours < 0){
					/* $("#time").hide(); */
					$("#time").html("마감되었습니다.")
					result();
					clearInterval(x);
				}else{
					$("#time").html("남은 시간 " + hours + " : " + mins + " : " + secs);
					/* console.log(hours <= 0 && mins <= 0 && secs <= 0); */
				}
			
			},1000);
			
			 function result(){
//				 location.href="insertAuctionSuccessFul.do?auctionNo="+${auctionHistory.auctionNo }+"&userId="+${auctionHistory.userId };
				 location.href="insertAuctionSuccessFul.do?auctionNo="+${auctionHistory.auctionNo };
			}
		}
        
  
</script>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>