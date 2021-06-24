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
<link rel="stylesheet" href="css/log/.css" />
<link rel="stylesheet" href="css/common.css" />
<title>履歴一覧画面</title>
</head>
<header>
	<c:import url="header.jsp"></c:import>
</header>
<body>
	<form:form action="log" modelAttribute="logDetail" method="get">
		<h3>${category.categoryName}</h3>

		<c:forEach var="history" items="${history}" varStatus="count">

			<label> <a href="/logDetail?historyId=${history.historyId}">
					${history.rowNumber}回目 </a>
			</label>
			<label> ${history.historyDate}</label>
			<c:choose>
				<c:when test="${history.mode} == 1"><label>　学習モード</label></c:when>
				<c:otherwise><label>　ランキングモード</label></c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${not empty updateNull}"><label>　${updateNull}</label></c:when>
				<c:otherwise><label>　${updateTime}</label></c:otherwise>
			</c:choose>
			<br>
			<br>
		</c:forEach>
	</form:form>
	<a href="logCategory">戻る</a>
</body>
</html>