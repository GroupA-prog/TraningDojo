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
<title>履歴詳細画面</title>
<link rel="stylesheet" href="css/log/logDetail.css" />
<link rel="stylesheet" href="css/common.css" />
</head>
<header>
<c:import url="header.jsp"></c:import>
</header>
<body>
	<h3>〇〇さんの履歴 ${category.categoryName}：${historyCount.rowNumber}回目</h3>

	<c:forEach var="list" items="${dispQuiz}">
		<a href="#${list.rowNumber}">Q${list.rowNumber}</a>
	</c:forEach>
	<form:form action="logList" modelAttribute="logDetail">
		<c:forEach var="list" items="${dispQuiz}">
			<p id="${list.rowNumber}">Q${list.rowNumber}</p>
			<p>${list.quizStatment}</p>
			<form:input type="hidden" path="historyDetailId" value="${list.historyDetailId}"></form:input>
			<input type="radio"
				disabled ${list.checked1} class="${list.correct1}">1：${fn:escapeXml(list.choice1)}
			<input type="radio"
				disabled ${list.checked2} class="${list.correct2}">2：${fn:escapeXml(list.choice2)}
			<input type="radio"
				disabled ${list.checked3} class="${list.correct3}">3：${fn:escapeXml(list.choice3)}
			<input type="radio"
				disabled ${list.checked4} class="${list.correct4}">4：${fn:escapeXml(list.choice4)}
			<p>解説</p>
			<p>${fn:escapeXml(list.commentary)}</p>
			<p>コメント</p>
			<form:textarea path="comment" placeholder="${list.comment}" rows="4" cols="40"></form:textarea>

		</c:forEach>

		<form:button type="submit">更新</form:button>
	</form:form>

	<a href="logList?categoryId=${logSelectCategoryId}">戻る</a>
	<footer>
		<a href="#" id="page-top">TOPへ</a>
	</footer>
</body>
</html>