<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUp</title>
</head>
<body>
	<p>ユーザー情報を入力してください</p>
	<form:form action="/signUp" modelAttribute="signUpDone" method="post">
		<p>
			ログインID
			<form:input path="LoginId" />
		</p>
		<p>
			パスワード
			<form:password path="Password" />
		</p>
		<p>
			ユーザーネーム
			<form:input path="UserName" />
		</p>
		<p>
			<form:button>新規登録</form:button>
		</p>
	</form:form>
	<p>
		<a href="login">戻る</a>
	</p>

</body>
</html>