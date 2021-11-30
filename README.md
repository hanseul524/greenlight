<h1>:deciduous_tree:GREEN LIGHT</H1>
<p>팀원 : 권승택, 송성근, 윤현석, 정한슬</p>
<H2>:calendar:수행기간</H2>
<p>2021년 10월 11일 ~ 11월 24일</p>
<H2>:book:Contents</H2>
<ol>
  <li><a href="#">개요</a></li>
  <li><a href="#">설계의 주안점</a></li>
  <li><a href="#">개발환경</a></li>
  <li><a href="#">프로젝트 기능구현</a></li>
  <li><a href="#">주요기능</a></li>
  <li><a href="#">Document</a></li>
</ol>
<H2>:file_folder:개요</H2>
<p>
‘그린라이트’는 다함께 녹색 미래를 만들자는 다짐을 담아,
사용자들이 적극적으로 실천할 수 있는 동기부여를 주고 더 나아가 환경 보호에 힘을 보탤 수 있는 사이트입니다.
</p>
<H2>:computer:설계의 주안점</H2>
<ol>
  <li>출석체크시 포인트 지급, 7일 연속 출석 체크시 추가 포인트 지급 구현</li>
  <li>관리자가 챌린지 오픈 시 챌린지 글 작성, 승인시 포인트 지급 구현</li>
  <li>중고경매 게시판에서 관리자가 글 작성시 setInterval을 이용한 타이머 기능 구현, 회원의 보유 포인트로 경매 참여 기능 구현</li>
  <li>카카오 지도 API를 이용한 오프라인 매장 위치 확인, 원하는 매장 검색 후 매장 상세보기 구현</li>
  <li>아임포트API를 이용한 포인트 결제와 환불 기능 구현</li>
  <li>기부 게시판에서 포인트로 기부 가능, 사이트에서 지급한 포인트를 우선순위로 사용하는 기능 구현</li>
</ol>
<H2>:hammer:개발환경</H2>
<span><img src="https://img.shields.io/badge/Java-blue?style=flat-square&logo=Java&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Visual Studio Code-9cf?style=flat-square&logo=Visual Studio Code&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Eclipse IDE-blueviolet?style=flat-square&logo=Eclipse IDE&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Html-red?style=flat-square&logo=HTML5&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/CSS-blue?style=flat-square&logo=CSS3&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/JavaScript-brightgreen?style=flat-square&logo=JavaScript&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/jQuery-lightgray?style=flat-square&logo=jQuery&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Spring-brightgreen?style=flat-square&logo=Spring&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/MyBatis-black?style=flat-square&logo=&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Oracle-orange?style=flat-square&logo=Oracle&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Apache Tomcat-red?style=flat-square&logo=Apache Tomcat&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Bootstrap-blueviolet?style=flat-square&logo=Bootstrap&logoColor=white"/></span>&nbsp;
<span><img src="https://img.shields.io/badge/Github-black?style=flat-square&logo=GitHub&logoColor=white"/></span>&nbsp;
<H2>프로젝트 기능구현</H2>
<p>권승택</p>
<li>회원가입</li>
<ul>
  <li>유효성 검사, 아이디 중복체크</li>
  <li>휴대폰 본인인증</li>
  <li>카카오 주소 api를 통한 주소검색</li>
  <li>카카오 소셜 로그인 - 카카오 소셜로그인 유효성 검사를 통한 소셜로그인 기능 구현</li>
</ul>
<li>포인트 충전/ 환불</li>
<ul>
  <li>아임포트 api를 통한 포인트 충전 기능구현</li>
  <li>결제 취소는 충전한 포인트만 가능하다.</li>
  <li>아임포트 api를 통해 토큰을 발급 받고 결제 고유 아이디를 통한 결제 취소 기능 구현</li>
  <li>포인트 결제 환불은 충전 포인트가 환불할 금액보다 많거나 같은때 가능하도록 기능 구현</li>
</ul>
<li>기부 게시판</li>
<ul>
  <li>관리자 페이지에서 관리자만이 기부 게시글 작성이 가능하다.</li>
  <li>관리자는 종료된 기부, 진행중인 기부 게시글의 리스트를 확인할 수 있다.</li>
  <li>사용자는 기부게시판에서 현재 진행중인 기부 게시글을 확인할 수 있으며 기부 달성률, 제목, 작성일, 댓글수를 볼 수 있다.</li>
  <li>기부 게시글 디테일 페이지에선 제목, 내용, 첨부 이미지, 달성률, 기부 순위, 댓글을 확인 할 수 있다.</li>
  <li>기부는 사용자가 보유하고 있는 포인트 내에서 가능하며 로그인 하지 않은 회원이 기부 버튼을 클릭시 로그인 페이지로 이동한다.</li>
  <li>기부는 페이지에서 지급된 포인트가 우선으로 차감되며 이후에 부족한 포인트는 충전 포인트에서 차감된다.</li>
  <li>기부 후에는 달성률, 기부 순위는 즉시 변동됩니다.</li>
</ul>
<p>송성근</p>
<li>경매</li>
<ul>
  <li>사용자는 경매 신청하여 관리자 승인시 경매등록이 가능하다.</li>
  <li>관리자는 사용자가 신청한 경매를 등록하면 현 시간부로 사용자가 신청한 시간까지 경매가 진행된다.</li>
  <li>경매는 현재 입찰가와 남은 경매시간을 확인 할 수 있다.</li>
  <li>비회원은 입찰을 할 수 없으며 현재 최고 입찰자, 경매 신청자, 보유포인트 부족한 사용자는 경매 신청이 불가하다.</li>
  <li>남은시간이 00:00:00이 되면 경매가 즉시 종료되며 관리자는 포인트 지급을 누르면 낙찰자에게는 포인트가 회수되고 판매자에게는 포인트가 지급된다.</li>
</ul>
<li>이벤트</li>
<ul>
  <li>관리자 페이지에서 관리자는 이벤트 등록을 할 수 있다.</li>
  <li>이벤트는 등록한 날짜로부터 5일후 20:00까지 진행되며 비회원은 이벤트에 참여 할 수 없다.</li>
  <li>이벤트는 정답시 100P를 획득하며 한번 정답을 맞 출 경우 다시 참여 할 수 없다.</li>
  <li>이벤트 정답자는 관리자의 추첨을 통해 전체 정답자 인원 중 10%를 추첨해 500P를 얻을 수 있다.</li>
</ul>
<li>지도</li>
<ul>
  <li>관리자 페이지에서 관리자는 온라인 매장, 오프라인 매장을 등록, 수정, 삭제를 할 수 있다.</li>
  <li>로그인, 비로그인 구분없이 사용자는 온라인매장 게시판에서 매장이름, 매장설명, 대표사진을 확인 할 수 있으며, 사진 클릭시 매장의 링크로 이동된다.</li>
  <li>로그인, 비로그인 구분없이 사용자는 오프라인 매장 지도에서 전체조회 및 검색을 통해 조회할 수 있으며 매장의 인포윈도우 클릭시 매장의 디테일 페이지로 이동된다.</li>
  <li>오프라인 매장 디테일 페이지에서는 매장의 이름, 주소, 링크, 상세지도를 확인할 수 있으며 링크 클릭 시 매장의 사이트로 이동된다.</li>
</ul>
<p>윤현석</p>
<li>마이페이지</li>
<ul>
  <li>활동기여도 - 회원이 현재 보유한 포인트와 회원이 현재까지 사용한 포인트의 총 합을 나타내줌</li>
  <li>출석체크 - 이번달의 달력이 출력되고 출석체크 시 달력에 표시가 되며 포인트를 지급하고 7일 연속 출석체크 시 더 많은 포인트를 지급</li>
  <li>회원 정보 - 회원이 가입할때 입력한 정보가 출력되고 현재 비밀번호를 입력 후 정보를 변경 가능하다.</li>
  <li>내가 쓴 글 - 회원이 챌린지 게시판에 올린 챌린지 게시물을 리스트로 출력</li>
  <li>포인트 내역 - 회원의 포인트 적립, 사용 포인트가 출력된다.</li>
  <li><p>내 경매</p>
    <ul>
      <li>내가 올린 경매 - 회원이 신청한 경매의 리스트가 출력된다.</li>
      <li>내가 입찰한 경매 - 회원이 입찰한 경매의 리스트가 출력된다. </li>
    </ul>
  </li>
  <li>나의 기부 현황 - 회원이 기부한 기부 게시물의 리스트가 출력된다.</li>
</ul>
<p>정한슬</p>
<li>챌린지 게시판</li>
<ul>
  <li>에디터 summernote API 사용</li>
  <li>사용자는 현재 진행중인 챌린지, 지난 챌린지, 전체 카테고리 별로 게시글을 확인할 수 있고 현재 진행중인 챌린지에서만 글을 작성할 수 있다.</li>
  <li>글은 제목으로 검색이 가능하고 전체 게시물 조회를 할 수 있다.</li>
  <li>글 상세 조회 시 댓글 작성,수정,삭제가 가능하고, 좋아요를 누를 수 있다.</li>
  <li>관리자는 챌린지 승인을 통해 사용자에게 포인트를 지급할 수 있다.</li>
</ul>
<li>관리자 페이지</li>
<ul>
  <li>회원관리 페이지에서는 전체 회원 조회가 가능하고 아이디를 통해 검색할 수 있다.</li>
  <li>선택한 회원을 탈퇴시킬 수 있다.</li>
  <li>챌린지 관리 페이지에서는 챌린지 전체 조회가 가능하고 타이틀을 클릭시 글 상세 페이지로 이동한다.</li>
  <li>관리자의 승인/미승인 상태 표시로 체크할 수 있고 미승인 글은 승인하기를 통해 승인 후 포인트 지급을 할 수 있다.</li>
  <li>관리자는 한달에 한 번 챌린지 오픈을 통해 주제를 입력하고 오픈시 현재 진행중인 챌린지가 변경된다.</li>
</ul>
