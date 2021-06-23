<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="css/loginRelation/putTogether.css" />
<link rel="stylesheet" href="css/common.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<c:if test="${not empty errMsg }">
		<p class="error">※${fn:escapeXml(errMsg)}</p>
	</c:if>
	<form:form action="/login" modelAttribute="login" method="post">
		<p>アカウントをお持ちの方はこちらからログインしてください</p>
		<div class = "btn">
		<p>
			ログインID
			<form:input path="loginId" /><br>
			<form:errors path="loginId" class="error"/>
		</p>
		<p>
			<span class="pass2">パスワード</span>
			<form:password path="password" /><br>
			<span class="pass2"><form:errors path="password" class="error"/></span>
		</p>
		</div>
		<br>
		<button class="btn login" class = "btn">ログイン</button>
	</form:form>
	<br>
	<br>
	<div class="clear">
	<form:form action="/signUp" modelAttribute="signUp" method="get">
	<br>
	アカウントをお持ちでない方は、こちらから登録してください<br>
		<br>
		<p class="btn2">
			<button type="submit" class="btn new-update">新規登録</button>
		</p>
	</form:form>
	</div>
</body>
</html>