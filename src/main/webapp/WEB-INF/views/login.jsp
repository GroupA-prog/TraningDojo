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
</head>
<body>
	<header>
		<h1><a href="">研修道場</a></h1>
	</header>
	<form action="">
		ログインID<input type="text"><br> パスワード<input type="password"><br>
		<input type="submit" value="ログイン">
	</form>
	<br>
	<form action="">
		アカウントをお持ちでない方は、こちらから登録してください<br> <input type="submit"
			value="新規登録">
	</form>

</body>
</html>