<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
<link rel="stylesheet" href="css/loginRelation/putTogether.css" />
<link rel="stylesheet" href="css/common.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<p>ユーザー情報を入力してください</p>
	<c:if test="${not empty errDuplicate}">
		<p class="error">※${fn:escapeXml(errDuplicate)}</p>
	</c:if>
	<form:form action="/signUp" modelAttribute="signUp" method="post">
		<p>
			<span class="login">ログインID</span>
			<form:input path="newLoginId" />
			<br>
		<div class="error2">
			<form:errors path="newLoginId" class="error" />
		</div>
		<p>
			<span class="pass">パスワード</span>
			<form:password path="newPassword" />
			<br>
		<div class="error2">
			<form:errors path="newPassword" class="error" />
		</div>
		<p>
			ユーザーネーム
			<form:input path="newUserName" />
			<br>
		<div class="error2">
			<form:errors path="newUserName" class="error" />
		</div>
		<p>
		<div class="btn3">
			<form:button class="btn new-update">新規登録</form:button>
		</div>
	</form:form>
	<br>
	<p class="clear">
		<a href="login" class="return">戻る</a>
	</p>

</body>
</html>