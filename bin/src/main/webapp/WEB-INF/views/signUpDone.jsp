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
	<c:import url="header.jsp"></c:import>
	<h1 class="DoneMsg">ご登録ありがとうございます</h1>
	<div class="margin">
		<span class="font">登録が完了しました。 <br> こちらからログインしてください</span> <br> <br>
		<c:if test="${not empty signUpErrMsg}">
			<p class="error">※${fn:escapeXml(signUpErrMsg)}</p>
		</c:if>
		<form:form action="/signUpDone" modelAttribute="signUpDone"
			method="post">
			<div class="btn">
				<p>
					ログインID
					<form:input path="loginId" class="txt"/>
					<br>
					<form:errors path="loginId" class="error" />
				<p>
					<span class="pass2">パスワード</span>
					<form:password path="password" class="txt"/>
					<br> <span class="pass2"><form:errors path="password"
							class="error" /></span>
			</div>
			<br>
			<div class="btn">
				<form:button class="btn login">ログイン</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>