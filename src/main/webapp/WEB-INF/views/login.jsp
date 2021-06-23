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
</head>
<body>
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
			パスワード
			<form:password path="password" /><br>
			<form:errors path="password" class="error"/>
		</p>
		</div>
		<br>
		<button class="loginbtn" class = "btn">ログイン</button>
	</form:form>
	<br>
	<br>
	<div class="clear">
	<form:form action="/signUp" modelAttribute="signUp" method="get">
	アカウントをお持ちでない方は、こちらから登録してください<br>
		<br>
		<p class="btn2">
			<button type="submit" class="signupbtn">新規登録</button>
		</p>
	</form:form>
	</div>
</body>
</html>