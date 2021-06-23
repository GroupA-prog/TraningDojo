<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録完了画面</title>
<link rel="stylesheet" href="css/loginRelation/putTogether.css" />
</head>
<body>
	<h1 class="DoneMsg">ご登録ありがとうございます</h1>
	登録が完了しました
	<br> こちらからログインしてください
	<br>
	<br>
	<c:if test="${not empty signUpErrMsg}">
		<p class="error">※${fn:escapeXml(signUpErrMsg)}</p>
	</c:if>
	<form:form action="/signUpDone" modelAttribute="signUpDone" method="post">
		<div class="btn">
			<p>
				ログインID
				<form:input path="loginId" />
				<br>
				<form:errors path="loginId" class="error" />
			<p>
				パスワード
				<form:password path="password" />
				<br>
				<form:errors path="password" class="error" />
		</div>
		<br>
		<div class = "btn">
		<form:button class="loginbtn" >ログイン</form:button>
		</div>
	</form:form>
</body>
</html>