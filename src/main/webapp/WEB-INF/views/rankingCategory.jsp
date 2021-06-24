<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランキングカテゴリ</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/ranking/ranking.css">
</head>
<body>
<c:import url="header.jsp"></c:import>
<main>
	<h1>カテゴリを選択</h1>
	<form:form action="rankingView" modelAttribute="rankingCategoryForm" method="get">
		<c:forEach items="${categoryList}" var="category">
			<div class="categoryBtn">
				<a href="rankingView?categoryId=${category.categoryId}">
					<span class="categoryNameLink"><c:out value="${category.categoryName}" /></span>
				</a>
			</div>
		</c:forEach>
	</form:form>
</main>
</body>
</html>