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
		<p>${fn:escapeXml(errMsg)}</p>
	</c:if>
	<form:form action="/login" modelAttribute="login">
		<p>アカウントをお持ちの方はこちらからログインしてください</p>
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
		<form:button>ログイン</form:button>
	</form:form>
	<br>
	<form action="/signUp" method="post">
		アカウントをお持ちでない方は、こちらから登録してください
		<p>
			<button type="submit">新規登録</button>
		</p>
	</form>
</body>
</html>