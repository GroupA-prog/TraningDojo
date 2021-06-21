<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>履歴カテゴリ選択画面</title>
</head>
<body>
	<h2>カテゴリを選択してください</h2>
	<form:form action="logCategory" modelAttribute="categoryList" method="get">
		<c:forEach var="category" items="${categoryList}">
			<a href="/logList?categoryId=category.categoryId">${fn:escapeXml(category.categoryName)}</a>
			<br>
		</c:forEach>
	</form:form>
</body>
</html>