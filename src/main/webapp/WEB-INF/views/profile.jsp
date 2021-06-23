<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更</title>
<link rel="stylesheet" href="css/common.css" />
</head>
<body>
	<c:import url="header.jsp" />
	<main>
		<h1>ユーザー情報変更</h1>
		<form:form action="/profile" modelAttribute="editUserInfo">
			<div>
				<label>
					<p>ログインID</p>
					<form:errors path="userLoginId" cssClass="error"/><br>
					<form:input path="userLoginId" readOnly="true" />
				</label>
				<br>
				<label>
					<p>パスワード</p>
					<form:errors path="newPassword" cssClass="error" /><br>
					<form:password path="newPassword" />
				</label>
				<br>
				<label>
					<p>ユーザーネーム</p>
					<form:errors path="newUserName" cssClass="error" /><br>
					<form:input path="newUserName" />
				</label>
				<br>
				<form:button name="confirm" >変更</form:button>
			</div>
		</form:form>


		<p class="clear">
			<a href="login" class="return"><span class="font">戻る</span></a>
		</p>
	</main>
</body>
</html>