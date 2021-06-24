<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ</title>
</head>
<body>
<h1>カテゴリを選択</h1>

<form:form action="rankingView" modelAttribute="rankingCategoryForm" method="get">
	<c:forEach items="${categoryList}" var="category">
		<div><a href="rankingView?categoryId=${category.categoryId}"><c:out value="${category.categoryName}"></c:out></a></div>
	</c:forEach>
</form:form>
</body>
</html>