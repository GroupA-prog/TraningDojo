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

<link rel="stylesheet" href="css/log/logList.css" />
<link rel="stylesheet" href="css/log/log.css" />
<link rel="stylesheet" href="css/common.css" />

<title>履歴一覧画面</title>
</head>
<header>
	<c:import url="header.jsp"></c:import>
</header>
<body>
	<form:form action="log" modelAttribute="logDetail" method="get">
		<h3 class="left">${category.categoryName}</h3>

		<c:if test="${empty history }">
			<p>履歴はまだありません
		</c:if>
		<div class="left">
			<table border="0" class="historyListTable left">
				<thead>
					<tr>
						<th></th>
						<th>クイズ挑戦日</th>
						<th>選択モード</th>
						<th>コメント更新日</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="history" items="${history}" varStatus="status">

						<tr>
							<td><a href="/logDetail?historyId=${history.historyId}"
								class="count">${history.rowNumber}回目</a></td>
							<td><a href="/logDetail?historyId=${history.historyId}"
								class="count">${history.historyDate}</a></td>
							<td><c:choose>
									<c:when test="${history.mode == 1}">
										<a href="/logDetail?historyId=${history.historyId}"
											class="count">学習</a>
									</c:when>
									<c:otherwise>
										<a href="/logDetail?historyId=${history.historyId}"
											class="count">ランキング</a>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${empty updateTimeList[status.index]}">
										<a href="/logDetail?historyId=${history.historyId}"
											class="count">コメントは更新されていません</a>
									</c:when>
									<c:otherwise>
										<a href="/logDetail?historyId=${history.historyId}"
											class="count">${updateTimeList[status.index]}</a>
									</c:otherwise>
								</c:choose></td>
						</tr>

					</c:forEach>
			</table>
		</div>
	</form:form>

	<br>
	<a href="logCategory" class="left back">戻る</a>
</body>
</html>