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
          <span style="font-size:18px; color:rgb(80, 80, 80);">현재가</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:24px;" id="price">${auction.auctionPrice }</span><span style="font-size: 18px; color:rgb(80, 80, 80)">P</span>
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
            <p>&nbsp;&nbsp;${auction.auctionNo }</p>
          </div>
        </div>
        <div class="auction-number">
          <div class="auction-content">
            <p>경 매 시 간 &nbsp;&nbsp;: </p>
          </div>
          <div class="auction-content2">
            <p style="color:black;">&nbsp;&nbsp;${auction.auctionTime }시간</p>
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
        <div class="auction-button">
          <form action="../../portfolio/jacket.html" class="form">
            <div class="button" type="submit">입 찰</div>
            <input type="hidden" id="hidden" value="13000">
          </form>
        </div>
        <!-- <div class="auction-check">
          
        </div> -->
      </div>
    </div>
<script>

	auctionTimer('${auction.varRegDate}', '${auction.auctionTime}');

	$(document).on("click", ".button", function(e){
	    e.preventDefault;
	    var userPoint = $("#hidden").val();
	    var price = $("#price").html();
	    if(userPoint > price){
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
	          });
	          console.log(userPoint);
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
				
				console.log(timer)
				
				var sttDt = timer;
				sttDt = sttDt.split("-");
				var sttYear = sttDt[0];
				console.log(sttYear);
				var sttMonth = sttDt[1]-1;
				console.log(sttMonth);
				var sttDay = sttDt[2];
				console.log(sttDay);
				var sttHour = sttDt[3];
				var sttHours = parseInt(sttHour.substr(0, 2)) + parseInt(auctionTime);
				console.log(sttHours);
				var sttMinutes = sttDt[4];
				console.log(sttMinutes);
				var sttSeconds = sttDt[5];
				console.log(sttSeconds);
				
				var date1 = new Date(year, month, day, hours, minutes, seconds);
				var date2 = new Date(sttYear, sttMonth, sttDay, sttHours, sttMinutes, sttSeconds);
				console.log(date1);
				console.log(date2);
				
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
					clearInterval(x);
				}else{
					$("#time").html("남은 시간 " + hours + " : " + mins + " : " + secs);
					/* console.log(hours <= 0 && mins <= 0 && secs <= 0); */
				}
			
			},1000);
			
			 function result(){
				$(".time").html("경매가 마감하였습니다.");
			}
		
		}
        
  
</script>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
</body>
</html>