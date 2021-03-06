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

		<div class="left">
			<table border="1" class="historyListTable left">
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
							<td><label><b><a
										href="/logDetail?historyId=${history.historyId}" class="count">${history.rowNumber}回目</b></a>
							</label>
							<td><label> ${history.historyDate}</label></td>
							<td><c:choose>
									<c:when test="${history.mode == 1}">
										<label> 学習</label>
									</c:when>
									<c:otherwise>
										<label> ランキング</label>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${empty updateTimeList[status.index]}">
										<label>コメントは更新されていません</label>
									</c:when>
									<c:otherwise>
										<label>${updateTimeList[status.index]}</label>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
			</table>
	</form:form>
	</div>
	<br>
	<a href="logCategory" class="left back">戻る</a>
</body>
</html>