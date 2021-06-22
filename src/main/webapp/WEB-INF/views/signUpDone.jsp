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
		<p>${fn:escapeXml(signUpErrMsg)}</p>
	</c:if>
	<form:form action="/signUpDone" modelAttribute="signUpDone" method="post">
		<p>
			ログインID
			<form:input path="loginId" />
			<form:errors path="loginId" cssStyle="color: red"/>
		</p>
		<p>
			パスワード
			<form:password path="password" />
			<form:errors path="loginId" cssStyle="color: red"/>
		</p>
		<br>
		<form:button class="loginbtn">ログイン</form:button>
	</form:form>
</body>
</html>