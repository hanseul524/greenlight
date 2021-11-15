<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 충전</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<style>
.popup-area {
  font-family: 'Noto Sans KR', sans-serif;
  width: 400px;
  height: 250px;
  margin: 0 auto;
  text-align: center;
  padding-top: 100px;
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
   <c:forTokens items="${userOne.userAddr }" delims="/" var="addr" varStatus="status">
   		<c:if test="${status.index eq 0 }">
   			<input type="hidden" id="addr1" value="${addr }">
   		</c:if>
   		<c:if test="${status.index eq 1 }">
   			<input type="hidden" id="addr2" value="${addr }">
   		</c:if>
   		<c:if test="${status.index eq 2 }">
   			<input type="hidden" id="addr3" value="${addr }">
   		</c:if>
   </c:forTokens>
   <input type="hidden" id="name" value="${userOne.userName }">
   <input type="hidden" id="email" value="${userOne.userEmail }">
   <input type="hidden" id="phone" value="${userOne.userPhone }">
   <h3>포인트를 충전하세요</h3>
   <p>충전포인트와 충전금액은 동일합니다.</p>
     <div>
       <input class="input-area" id="price" type="number" placeholder="금액을 입력하세요.">
     </div>
       <input class="input-btn" type="button" onclick="requestPay();" value="결제하기">
   <script>
   	var inputPrice;
   	var userAddr = $("#addr3").val();
   	console.log(userAddr);
   	var userName = $("#name").val();
   	console.log(userName);
   	var userEmail = $("#email").val();
   	console.log(userEmail);
   	var userPhone = $("#phone").val();
   	console.log(userPhone);
   	var IMP = window.IMP;
	IMP.init("imp85681928");
   	function requestPay() {
   		inputPrice = $("#price").val();
   	// IMP.request_pay(param, callback) 결제창 호출
	      IMP.request_pay({ // param
	          pg: "html5_inicis",
	          pay_method: "card",
	          /* merchant_uid: "ORD20180131-0000011", */
	          name: "포인트 충전",
	          amount: inputPrice,
	          buyer_email: userEmail,
	          buyer_name: userName,
	          buyer_tel: userPhone,
	          buyer_addr: userAddr,
	      }, function (rsp) { // callback
	          if (rsp.success) {
	        	  $.ajax({
	        		  url : "chargePoint.do",
	        		  type : "post",
	        		  data : {
	        			  "chargeMoney" : inputPrice,
	        			  "imp_uid" : rsp.imp_uid
	        		  },
	        		  success : function(result){
	        			  if(result >2){
	        				  Swal.fire(
		                                '충전완료',
		                                '포인트 충전이 완료되었습니다.',
		                                'success'
	                                    ).then(function(){
	                                    	opener.parent.location.reload();
	    									window.close();
	                                    })
	        			  }else{
	        				  Swal.fire({
									icon : 'error',
									title : '포인트 충전 실패',
									text : '포인트 충전에 실패하였습니다.', 
								}).then(function(){
									opener.parent.location.reload();
									window.close();
                                })
	        			  }
	        		  },
	        		  fail : function(){
	        			  Swal.fire({
	        				  	icon : 'error',
								title : '포인트 충전 실패',
								text : '포인트 충전에 실패하였습니다.', 
							}).then(function(){
                          	window.close();
                          })
	        		  }
	        	  });
	          } else {
	              // 결제 실패 시 로직,
	          }
	      });
	    }
   </script>
 </div>
</html>