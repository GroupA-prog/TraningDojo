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
			<c:if test="${ isNotMatchPassword }">
				<p class="error">確認用パスワードが一致しません</p>
			</c:if>
			<form:form action="/profile" modelAttribute="editUserInfo">
				<div>
					<label>
						<span>ログインID</span>
						<form:input path="userLoginId" readonly="true" class="input_area"  />
					</label>
					<br>
					<label>
						<span>パスワード</span>
						<form:password path="newPassword" readonly="true" showPassword="true" class="input_area" />
					</label>
					<br>
					<label>
						<span>ユーザーネーム</span>
						<form:input path="newUserName" readonly="true" class="input_area" />
					</label>
					<br>
					<label>
						<span>新規パスワード(再入力)</span>
						<form:password path="reNewPassword" class="input_area" />
						<c:if test="${ errorReNewPassword }">
							<br><form:errors path="reNewPassword" cssClass="error"/><br>
						</c:if>
					</label>
					<div class="form_btn">
						<form:button name="returnProfile" class="btn login">戻る</form:button>
						<form:button name="update" class="btn login">変更</form:button>
					</div>
				</div>
			</form:form>


			<!-- <p class="clear">
				<a href="/profile" class="return"><span class="font">戻る</span></a>
			</p> -->
		</div>
	</main>
</body>
</html>