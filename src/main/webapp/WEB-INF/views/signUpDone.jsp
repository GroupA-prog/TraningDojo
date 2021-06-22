<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpDone</title>
</head>
<body>
	<header>
		<h1>
			<a href="">研修道場</a>
		</h1>
	</header>
	<h1 class="DoneMsg">ご登録ありがとうございます</h1>
	登録が完了しました
	<br> こちらからログインしてください
	<br>
	<br>
	<form:form action="/login" modelAttribute="login" method="post">
		<p>
			ログインID
			<form:input path="loginId" />
		</p>
		<p>
			パスワード
			<form:password path="password" />
		</p>
		<p>
			<form:button>ログイン</form:button>
		</p>
	</form:form>
</body>
</html>