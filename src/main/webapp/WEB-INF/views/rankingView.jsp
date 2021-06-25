<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/ranking/ranking.css">
<title>ランキング</title>
</head>
<body>
<c:import url="header.jsp"></c:import>
<main>
	<div class="rankingCategoryName"><h2><span>${category.categoryName}</span> のランキング</h2></div>

		<div id="contents">
			<div id="ranking">
				<c:choose>
					<c:when test="${empty rankingList}">
						<div class="noDataMsg"><h2>ランキングデータがありません</h2></div>
					</c:when>
					<c:otherwise>

						<c:choose>
							<c:when test="${empty myRankingData}">
								<div class="noMyDataMsg">
									<h2>あなたの記録はまだありません</h2>
									<h2>挑戦してみましょう</h2>
								</div>
							</c:when>
							<c:otherwise>
								<h3>- あなたの記録 -</h3>
								<h2>正答率： <span id="myScore">${fn:escapeXml(myRankingData.score)}</span>%</h2>
								<h2>
									<span id="myRank">${fn:escapeXml(myRankingData.rank)}</span>位 ／
									${fn:escapeXml(rankingUserNum)}位
								</h2>
							</c:otherwise>
						</c:choose>

						<table>
							<thead>
								<tr>
									<th>順位</th>
									<th>ユーザーネーム</th>
									<th>正答率</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${rankingList}" var="ranking" begin="0" end="${rankViewNum}" step="1" >
									<tr>
										<c:choose>
											<c:when test="${ranking.userId == 2}">
												<td class="myData">${fn:escapeXml(ranking.rank)}</td>
												<td class="myData">${fn:escapeXml(ranking.userName)}</td>
												<td class="myData">${fn:escapeXml(ranking.score)}%</td>
											</c:when>
											<c:otherwise>
												<td>${fn:escapeXml(ranking.rank)}</td>
												<td>${fn:escapeXml(ranking.userName)}</td>
												<td>${fn:escapeXml(ranking.score)}%</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>

			<%-- <c:if test="${not empty session.answerList}"> --%>
				<div class="answerBtn btn"><a href="log_detail"><span class="answerLink">解答の詳細を見る</span></a></div>
			<%-- </c:if> --%>


		</div>

		<c:if test="${empty session.answerList}">
		<a href="rankingCategory" class="back">戻る</a>
	</c:if>

</main>
</body>
</html>