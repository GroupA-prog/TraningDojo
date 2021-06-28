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
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/profile/profile.css">
</head>
<body>
	<c:import url="header.jsp" />
	<main>
		<div class="update-box">
			<h1>ユーザー情報変更</h1>
			<c:if test="${ isNotNowPassword }">
				<p class="error">現在のパスワードが異なります</p>
			</c:if>
			<c:if test="${ updateCompleted }">
				<h3>登録完了しました。</h3>
			</c:if>
			<form:form action="/profile" modelAttribute="editUserInfo">
				<div>
					<label>
						<span>ログインID</span>
						<form:errors path="userLoginId" cssClass="error"/><br>
						<form:input path="userLoginId" readOnly="true" class="input_area" />
					</label>
					<br>
					<label>
						<span>パスワード</span>
						<form:errors path="newPassword" cssClass="error" /><br>
						<form:password path="newPassword" showPassword="true" class="input_area" />
					</label>
					<br>
					<label>
						<span>ユーザーネーム</span>
						<form:errors path="newUserName" cssClass="error" /><br>
						<form:input path="newUserName" class="input_area" />
					</label>
					<br>
					<label>
						<span>パスワード(現在のパスワード)</span>
						<form:errors path="nowPassword" cssClass="error"/><br>
						<form:password path="nowPassword" class="input_area" />
					</label><br>
					<div class="form_btn">
						<form:button name="returnUserHome" class="btn login">戻る</form:button>
						<form:button name="confirm" class="btn login">変更</form:button>
					</div>
				</div>
			</form:form>

			<!--  <p class="clear">
				<a href="/userHome" class="return" class="flex"><span class="font">戻る</span></a>
			</p> -->
		</div>
	</main>
</body>
</html>