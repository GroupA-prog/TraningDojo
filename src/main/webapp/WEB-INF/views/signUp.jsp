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
	<!-- <div id="modal-overlay"></div> -->
	<div class="margin">
		<!--  <p>
			<span class="font">ユーザー情報を入力してください</span>
		</p>-->
		<p>新規登録</p>
		<div class="btn">
			<c:if test="${not empty errDuplicate}">
				<p class="error">※${fn:escapeXml(errDuplicate)}</p>
			</c:if>
			<form:form action="/signUp" modelAttribute="signUp" method="post">
				<p>
					<span class="new-user">　ログインID　　　</span>
					<form:input path="newLoginId" class="txt" />
				<!-- <div class="error2"> -->
				<br>
					<span class="pass2">
						<form:errors path="newLoginId" class="txt error" />
					</span>
				<!-- </div> -->
				</p>
				<p>
					<span class="new-user">　パスワード　　　</span>
					<form:password path="newPassword" class="txt" />

				<!-- <div class="error2"> -->
				<br>
					<form:errors path="newPassword" class="error" />
				<!-- </div> -->
				</p>
				<p>
					<span class="new-userName">ユーザーネーム　</span>
					<form:input path="newUserName" class="txt" />

				<!-- <div class="error2"> -->
				<br>
					<form:errors path="newUserName" class="error" />
				<!-- /div> -->
				</p>
				<p>
				<!-- <div class="btn3"> -->
					<form:button class="btn login">新規登録</form:button>
				<!-- </div> -->

			</form:form>
		</div>
		<p class="clear">
			<a href="login" class="return"><span class="font">戻る</span></a>
		</p>
	</div>
</body>
</html>