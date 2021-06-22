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
</head>
<body>
	<p>ユーザー情報を入力してください</p>
	<c:if test="${not empty errDuplicate}">
		<p>${fn:escapeXml(errDuplicate)}</p>
	</c:if>
	<form:form action="/signUp" modelAttribute="signUp" method="post">
		<p>
			ログインID
			<form:input path="newLoginId" />
			<form:errors path="newLoginId" cssStyle="color: red" />
		</p>
		<p>
			パスワード
			<form:password path="newPassword" />
			<form:errors path="newPassword" cssStyle="color: red" />
		</p>
		<p>
			ユーザーネーム
			<form:input path="newUserName" />
			<form:errors path="newUserName" cssStyle="color: red" />
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