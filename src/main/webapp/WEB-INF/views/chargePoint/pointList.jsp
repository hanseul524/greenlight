<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 충전 리스트</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chargePoint/chargePointList.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
  <div class="container" style="width: 1200px; margin: 0 auto; padding: 20px;">
  	<div class="contents" style="margin: 0 auto; width:80%;">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>결제금액</th>
                  <th>결제일</th>
                  <th>결제현황</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${cpList }" var="cPoint" varStatus="index">
                <tr>
                  <td>${cPoint.rowNum }</td>
                  <td>${cPoint.chargeMoney }</td>
                  <td>${cPoint.chargeDate }</td>
                  <td>
                  	<c:if test="${cPoint.refund eq 'N'}" ><a href="#" style="text-decoration: none;">결제완료</a></c:if>
              		<c:if test="${cPoint.refund ne 'N'} ">취소완료</c:if>
                  </td>
                </tr>
                <input type="hidden" value="${cPoint.chargeNo }">	
              </c:forEach>
              </tbody>
            </table>
       		<button onclick="popUp();" class="btn" style="position: relative; left: 90%; background-color: rgb(211, 207, 207);">충전하기</button>	
          </div>
      	</div>
            <div class="page_wrap">
    <c:url var="before" value="chargeList.do">
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
      	<c:url var="pagenation" value="chargeList.do">
      		<c:param name="page" value="${p }"></c:param>
      	</c:url>
      	<c:if test="${p eq pi.currentPage }">
         	<a href="#" class="active">${p }</a>
      	</c:if>
      	<c:if test="${p ne pi.currentPage }">
      		<a href="${pagenation }">${p }</a>
      	</c:if>
      </c:forEach>
      <c:url var="after" value="chargeList.do">
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

<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
    var IMP = window.IMP;
	IMP.init("imp85681928");
	function popUp() {
	      window.open('/cpPopView.do', '_blank', 
	      'top=250, left=500, height=300, width=500,toolbar=no, menubar=no, location=no, status=no, scrollbars=no, resizable=no');
	    }
	function requestPay() {
	      // IMP.request_pay(param, callback) 결제창 호출
	      IMP.request_pay({ // param
	          pg: "html5_inicis",
	          pay_method: "card",
	          merchant_uid: "ORD20180131-0000011",
	          name: "노르웨이 회전 의자",
	          amount: 64900,
	          buyer_email: "gildong@gmail.com",
	          buyer_name: "홍길동",
	          buyer_tel: "010-4242-4242",
	          buyer_addr: "서울특별시 강남구 신사동",
	          buyer_postcode: "01181"
	      }, function (rsp) { // callback
	          if (rsp.success) {
	              // 결제 성공 시 로직,
	          } else {
	              // 결제 실패 시 로직,
	          }
	      });
	    }
</script>
</body>
</html>