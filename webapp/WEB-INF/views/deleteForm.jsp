<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook3/gbc/delete" method="post">

		비밀번호: <input type="password" name="password">
		<button type="submit">확인</button>
		<input type="hidden" name="no" value="${param.no }">

	</form>

	<br>

	<a href="/guestbook3/gbc/addList">메인으로 돌악가기</a>

</body>
</html>