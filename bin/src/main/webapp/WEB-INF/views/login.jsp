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
	<c:import url="header.jsp"></c:import>
	<div class="login-box">
		<c:if test="${not empty errMsg }">
			<p class="error">※${fn:escapeXml(errMsg)}</p>
		</c:if>
		<form:form action="/login" modelAttribute="login" method="post">
			<p>ログイン</p>
			<div class="btn">
				<p>
					<form:input path="loginId" class="txt" placeholder="ログインID" />
					<br>
						<span class="pass2">
							<form:errors path="loginId" class="txt error" />
						</span>
				</p>
				<p>
					<form:password path="password" class="txt" placeholder="パスワード" />
					<br>
						<span class="pass2">
							<form:errors path="password" class="txt error" />
						</span>
				</p>

				<button class="btn login">ログイン</button>

			</div>
		</form:form>
		<br> <!-- <br> -->
		<div class="clear">
			<form:form action="/signUp" modelAttribute="signUp" method="get">
				<br>
				<p>はじめての方はこちら<br>
				<p>
					<button type="submit" class="btn login">新規登録</button>
				<br>
				</p>
			</form:form>
		</div>
	</div>
</body>
</html>