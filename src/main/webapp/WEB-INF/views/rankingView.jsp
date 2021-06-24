<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランキング</title>
</head>
<body>
<h2><c:out value="${category.categoryName}"></c:out>のランキング</h2>
<div>
	<h2>${fn:escapeXml(myRankingData.score)}%</h2>
	<h2><span>${fn:escapeXml(myRankingData.rank)}</span>／${fn:escapeXml(rankingUserNum)}</h2>
	<table>
    <caption>ランキング</caption>
    <thead>
      <tr>
        <th>順位</th>
        <th>ユーザーネーム</th>
        <th>正答率</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${rankingList}" var="ranking">
        <tr>
          <td>${fn:escapeXml(ranking.rank)}</td>
          <td>${fn:escapeXml(ranking.userName)}</td>
          <td>${fn:escapeXml(ranking.score)}%</td>
        </tr>
      </c:forEach>
    </tbody>

    <!-- ↓↓さきちゃんに解答詳細ページのファイル名を聞く↓↓ -->

    <c:if test="${not empty session.answerList}">
			<a href="log_detail">解答の詳細を見る</a>
    </c:if>
  </table>
</div>
<!-- <c:if test="${empty session.answerList}">
	<a href="rankingCategory">戻る</a>
</c:if> -->
<a href="rankingCategory">戻る</a>
</body>
</html>