<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시글 목록 보기</h1>
	<br><br>
	<table border="1" align="center">
		<tr>
			<th>번호</th>
			<th width="300">제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>첨부파일</th>
		</tr>
		<c:forEach items="${mList }" var="member">
			<tr>
				<td>${member.memberId }</td>
				<td>${member.memberPwd }</td>
				<td>${member.memberName }</td>
				<td>${member.memberEmail }</td>
				<td>${member.memberPhone }</td>
				<td>${member.memberAddr }</td>
			</tr>
		</c:forEach>
</body>
</html>