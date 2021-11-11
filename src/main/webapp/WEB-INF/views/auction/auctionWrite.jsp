<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/auction/auctionWrite.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common/header.jsp"></jsp:include>
<div class="content">
        <div class="auction"><span>A</span>&nbsp;&nbsp;<span>U</span>&nbsp;&nbsp;<span>C</span>&nbsp;&nbsp;<span>T</span>&nbsp;&nbsp;<span>I</span>&nbsp;&nbsp;<span>O</span>&nbsp;&nbsp;<span>N</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>A</span>&nbsp;&nbsp;<span>P</span>&nbsp;&nbsp;<span>P</span>&nbsp;&nbsp;<span>L</span>&nbsp;&nbsp;<span>Y</span></div>
        <div class="div-apply">
            <div>
                <p style="text-align: center; font-size: 20px;">경매에 참여해주셔서 감사합니다.</p>
                <p style="text-align: center; font-size: 16px; margin-top:0px; margin-bottom: 20px;">유착 시 물품이 반송됩니다.</p>
            </div>
            <form action="auctionApply.do" class="needs-validation" method="post" enctype="multipart/form-data" id="form">
                <fieldset style ="border : 0px;">
                    <legend style="width:100%;" style="padding:0px;"><p>상품 이름</p>
                        <div class="div-auction">
                            <input type="text"  class="auction-input" placeholder="ex) 천연목재로 만든 칫솔" name="auctionTitle" id="auctionTitle">
                            <div class="feedback" id="title-feedback">상품 이름은 필수로 입력해주시기 바랍니다.</div>
                        </div>
                    </legend>
                </fieldset>
                <fieldset style ="border : 0px; margin-top:25px; display:inline-block">
                    <legend style="width:100%; height: 120px;"><p>경매 시간</p>
                        <div class="div-auction">
                            <input type="text"  class="auction-input" placeholder="ex) 5 (5시간)" name="auctionTime" id="auctionTime">
                            <div class="feedback" id="time-feedback">숫자로 적어주세요.</div>
                        </div>
                    </legend>
                </fieldset>
                <fieldset style ="border : 0px; margin-top:25px; display:inline-block; margin-left:50px;">
                    <legend style="width:100%; height: 120px;"><p>시작 입찰가</p>
                        <div class="div-auction">
                            <input type="text"  class="auction-input" placeholder="최소금액은 1000P입니다." name="auctionPrice" id="auctionPrice">
                            <div class="feedback" id="price-feedback">숫자로 적어주세요.</div>
                        </div>
                    </legend>
                </fieldset>
                <div class="mainImage">
                    <span>대표 이미지</span>
                    <label for="file">파일찾기</label>
                    <input type="file" id="file" accept="image/*" name="uploadFiles" onchange="setThumbnail(event);">
                    <div id="image_container"></div>
                </div>
                <div id='image_preview'>
                    <span>상품 이미지</span>
                    <label for="btnAtt">파일찾기</label>
                    <input type='file' id='btnAtt' accept="image/*" name="uploadFiles" multiple='multiple' />
                    <div id='att_zone'
                      data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
                </div>
                <input type="submit" value="경매 등록" class="insert">
            </form>
            </div>
    </div>
<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"></jsp:include>
    <script>

        $("#title-feedback").hide();
        $("#time-feedback").hide();
        $("#price-feedback").hide();

        function insertAuction(){
            $("#form").submit();
        }

        $("#image_container").hide();

        function setThumbnail(event) {
        $("#image_container").show();
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector("div#image_container").appendChild(img);
		};
		reader.readAsDataURL(event.target.files[0]);
	}

/* ------------------------------------------------------------------------- */
    imageView = function imageView(att_zone, btn){

    var attZone = document.getElementById(att_zone);
    var btnAtt = document.getElementById(btn)
    var sel_files = [];

    // 이미지와 체크 박스를 감싸고 있는 div 속성
    var div_style = 'display:inline-block;position:relative;'
                + 'width:120px;height:120px;margin:5px;z-index:1';
    // 미리보기 이미지 속성
    var img_style = 'width:100%;height:100%;z-index:none';
    // 이미지안에 표시되는 체크박스의 속성
    var chk_style = 'width:20px;height:20px;position:absolute;font-size:12px;'
                + 'right:0px;bottom:100px;z-index:999;background-color:rgba(255,255,255,0.5);color:rgb(255, 50, 50);border:none;';

    btnAtt.onchange = function(e){
    var files = e.target.files;
    var fileArr = Array.prototype.slice.call(files)
    for(f of fileArr){
        imageLoader(f);
    }
    }  


    // 탐색기에서 드래그앤 드롭 사용
    attZone.addEventListener('dragenter', function(e){
    e.preventDefault();
    e.stopPropagation();
    }, false)

    attZone.addEventListener('dragover', function(e){
    e.preventDefault();
    e.stopPropagation();
    
    }, false)

    attZone.addEventListener('drop', function(e){
    var files = {};
    e.preventDefault();
    e.stopPropagation();
    var dt = e.dataTransfer;
    files = dt.files;
    for(f of files){
        imageLoader(f);
    }
    
    }, false)



/*첨부된 이미리즐을 배열에 넣고 미리보기 */
imageLoader = function(file){
  sel_files.push(file);
  var reader = new FileReader();
  reader.onload = function(ee){
    let img = document.createElement('img')
    img.setAttribute('style', img_style)
    img.src = ee.target.result;
    attZone.appendChild(makeDiv(img, file));
  }
  
  reader.readAsDataURL(file);
}

    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
    makeDiv = function(img, file){
    var div = document.createElement('div')
    div.setAttribute('style', div_style)
    
    var btn = document.createElement('input')
    btn.setAttribute('type', 'button')
    btn.setAttribute('value', 'X')
    btn.setAttribute('style', 'margin-top')   
    btn.setAttribute('delFile', file.name);
    btn.setAttribute('style', chk_style);
    btn.onclick = function(ev){
        var ele = ev.srcElement;
        var delFile = ele.getAttribute('delFile');
        for(var i=0 ;i<sel_files.length; i++){
        if(delFile== sel_files[i].name){
            sel_files.splice(i, 1);      
        }
        }
        
        dt = new DataTransfer();
        for(f in sel_files) {
        var file = sel_files[f];
        dt.items.add(file);
        }
        btnAtt.files = dt.files;
        var p = ele.parentNode;
        attZone.removeChild(p)
    }
    div.appendChild(img)
    div.appendChild(btn)
    return div
    }
    }
    ('att_zone', 'btnAtt')

    $("form").on("submit", function(){
                    var auctionTitle = $("#auctionTitle").val();
                    var auctionTime = $("#auctionTime").val();
                    var auctionPrice = $("#auctionPrice").val();
                    var titleReg = /^[0-9]+$/;
                    var timeReg = /^[0-9]+$/;
                    var priceReg = /^[0-9]+$/;



                    if(auctionTitle == ""){
                        $("#title-feedback").show();
                        $("#title-feedback").html("제목을 입력해주시기 바랍니다.");
                        $("#title-feedback").css("color", "red");
                        $("#auctionTitle").focus();
                        return false;
                    }else{
                        $("#title-feedback").hide();
                    }

                    if(auctionTime == ""){
                        $("#time-feedback").show();
                        $("#time-feedback").html("시간을 입력해주시기 바랍니다.");
                        $("#time-feedback").css("color", "red");
                        $("#auctionTime").focus();
                        return false;
                    }else{
                        $("#time-feedback").hide();
                    }

                    if(!timeReg.test(auctionTime)){
                        $("#time-feedback").show();
                        $("#time-feedback").html("숫자로만 입력해주시기 바랍니다.");
                        $("#time-feedback").css("color", "red");
                        $("#auctionTime").focus();
                        return false;
                    }else{
                        $("#time-feedback").hide();
                    }

                    if(auctionPrice == ""){
                        $("#price-feedback").show();
                        $("#price-feedback").html("가격을 입력해주시기 바랍니다.");
                        $("#price-feedback").css("color", "red");
                        $("#auctionPrice").focus();
                        $("#auctionTime").focus();
                        return false;
                    }else{
                        $("#price-feedback").hide();
                    }

                    if(!priceReg.test(auctionPrice)){
                        $("#price-feedback").show();
                        $("#price-feedback").html("숫자로만 입력해주시기 바랍니다.");
                        $("#price-feedback").css("color", "red");
                        $("#auctionPrice").focus();
                        return false;
                    }else{
                        $("#price-feedback").hide();
                    }
                    
                    if(auctionPrice < 1000){
                        $("#price-feedback").show();
                        $("#price-feedback").html("최소금액은 천원입니다.");
                        $("#price-feedback").css("color", "red");
                        $("#auctionPrice").focus();
                        return false;
                    }else{
                        $("#price-feedback").hide();
                    }

                    
                })

    </script>
</body>
</html>