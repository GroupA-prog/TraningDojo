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
<body>
	<c:import url="header.jsp"></c:import>
	<div class="margin">
		<p>
			<span class="font">この入力内容で登録してもよろしいでしょうか？</span>
		</p>
		<c:if test="${not empty errDuplicate}">
			<p class="error">※${fn:escapeXml(errDuplicate)}</p>
		</c:if>
		<c:if test="${ isNotMatchPassword }">
			<p><span class="error">${fn:escapeXml(isNotMatchPasswordMsg)}</span></p>
		</c:if>
		<form:form action="/signUpConfirm" modelAttribute="signUp" method="post">
			<p class="new-user-config">
				<span class="login">　　ログインID　　　</span>
				<form:input path="newLoginId" class="txt" readonly="true"/>
				<br>
			<!-- <div class="error2"> -->
				<form:errors path="newLoginId" class="error" />
			<!-- </div> -->
			</p>
			<p>
			<p class="new-user-config">
				<span class="pass">　　パスワード　　　</span>
				<form:password path="newPassword" class="txt" showPassword="true" readonly="true" />
				<br>
			<!-- <div class="error2"> -->
				<form:errors path="newPassword" class="error" />
			<!-- </div> -->
			<p>
			</p>
			<p class="new-user-config">
				<span class="passre">パスワード(確認用)　</span>
				<form:password path="newPasswordRe" class="txt" />
			</p>
			<p>
			<p class="new-user-config">
				<span class="user">　ユーザーネーム　　 </span>
				<form:input path="newUserName" class="txt" readonly="true" />
				<br>
			<!-- <div class="error2"> -->
				<form:errors path="newUserName" class="error" />
			<!-- </div> -->
			<p>
			<p>
			<!-- <div class="btn3"> -->
				<form:button class="btn login">新規登録</form:button>
			<!-- </div> -->
		</form:form>
		<p class="clear">
			<a href="login" class="return"><span class="font">戻る</span></a>
		</p>
	</div>
</body>
</html>