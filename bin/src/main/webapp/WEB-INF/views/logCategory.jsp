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
<link rel="stylesheet" href="css/log/logCategory.css" />
<link rel="stylesheet" href="css/log/log.css" />
<link rel="stylesheet" href="css/common.css" />
<title>履歴カテゴリ選択画面</title>
</head>
<header>
	<c:import url="header.jsp"></c:import>
</header>
<body>
	<div class="left">
		<h3>カテゴリを選択してください</h3>
		<form:form action="log" modelAttribute="logList" method="get">
			<c:forEach var="category" items="${categoryList}">
				<a href="/logList?categoryId=${fn:escapeXml(category.categoryId)}" class="link">${fn:escapeXml(category.categoryName)}</a>
				<br>
			</c:forEach>
		</form:form>
	</div>
</body>
</html>