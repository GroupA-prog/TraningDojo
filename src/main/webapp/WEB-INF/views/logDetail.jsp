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
	<h3 class="left">${loginUserInfo.userName}さんの履歴
		${category.categoryName}：${historyCount.rowNumber}回目</h3>

	<div class="main">
		<c:forEach var="list" items="${dispQuiz}" varStatus="status">
			<a href="#${list.rowNumber}" class="jump">Q${list.rowNumber}</a>

		</c:forEach>
		<form:form action="logList" modelAttribute="logDetail">
			<c:forEach var="list" items="${dispQuiz}">
				<p id="${list.rowNumber}">Q${list.rowNumber}.${list.quizStatment}</p>
				<form:input type="hidden" path="historyDetailId"
					value="${list.historyDetailId}"></form:input>
				<div class="select">
					<div>
						<label class="radio"><input type="radio" disabled ${list.checked1} class="test">1：<span id="${list.correct1}">${fn:escapeXml(list.choice1)}</span></label>
					</div>
					<div>
						<label class="radio"><input type="radio" disabled ${list.checked2}>2：<span id="${list.correct2}">${fn:escapeXml(list.choice2)}</span></label>
					</div>
					<div>
						<label class="radio"><input type="radio" disabled ${list.checked3}>3：<span id="${list.correct3}">${fn:escapeXml(list.choice3)}</span></label>
					</div>
					<div>
						<label class="radio"><input type="radio" disabled ${list.checked4}>4：<span id="${list.correct4}">${fn:escapeXml(list.choice4)}</span></label>
					</div>
				</div>
				<p>解説</p>
				<p>${fn:escapeXml(list.commentary)}</p>
				<p>コメント</p>
				<form:textarea path="comment" placeholder="${list.comment}" rows="6" cols="60"></form:textarea>
			</c:forEach>
			<br>
			<form:button type="submit" class="update">更新</form:button>
		</form:form>
	</div>

	<a href="logList?categoryId=${logSelectCategoryId}" class="back">戻る</a>
	<footer>
		<a href="#" id="page-top">↑</a>
	</footer>
</body>
</html>