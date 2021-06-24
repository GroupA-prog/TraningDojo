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
		<c:if test="${ isNotMatchPassword }">
			<p class="error">確認用パスワードが一致しません</p>
		</c:if>
		<form:form action="/profile" modelAttribute="editUserInfo">
			<div>
				<label>
					<span>ログインID</span>
					<form:input path="userLoginId" readonly="true" />
				</label>
				<br>
				<label>
					<span>パスワード</span>
					<form:password path="newPassword" readonly="true" showPassword="true" />
				</label>
				<br>
				<label>
					<span>ユーザーネーム</span>
					<form:input path="newUserName" readonly="true"/>
				</label>
				<br>
				<label>
					<span>新規パスワード(再入力)</span>
					<form:errors path="reNewPassword" cssClass="error"/><br>
					<form:password path="reNewPassword" />
				</label>
				<form:button name="update" >変更</form:button>
			</div>
		</form:form>


		<p class="clear">
			<a href="/profile" class="return"><span class="font">戻る</span></a>
		</p>
	</main>
</body>
</html>