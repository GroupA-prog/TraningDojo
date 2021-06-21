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
	<header>
		<h1>
			<a href="" class="systemName">研修道場</a>
		</h1>
	</header>
	<form action="login">
		<p>アカウントをお持ちの方はこちらからログインしてください</p>
		<p>
			ログインID<input type="text">
		</p>
		<p>
			パスワード<input type="password">
		</p>
		<br>
		<button class="btn login">ログイン</button>
	</form>
	<br>
	<form action="insert">
		アカウントをお持ちでない方は、こちらから登録してください
		<p>
			<button class="btn new-update">新規登録</button>
		</p>
	</form>
</body>
</html>