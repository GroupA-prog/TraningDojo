<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/home/home.css" />
<link rel="stylesheet" href="css/style.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
</head>
<body>
	<header class="title-continar">
	<span id="site-title">
		<c:choose>
			<c:when test="${ not empty loginUserInfo }"><a href="userHome">研修道場</a></c:when>
			<c:otherwise><a href="/login">研修道場</a></c:otherwise>
		</c:choose>
	</span>
	<c:if test="${ not empty loginUserInfo }">
		<nav>
			<ul>
				<c:if test="${ loginUserInfo.role == 1 }">
					<li><a href="/admin">管理者</a></li>
				</c:if>
				<li><a href="/logout">ログアウト</a></li>
			</ul>
		</nav>
	</c:if>
</header>
	<h1 class="home">${loginUserInfo.userName}さんのホーム</h1>

	<form action="/quizConfig" method="GET">
		<button type="submit" class="btn quiz">クイズ</button>
	</form>
	<form action="/rankingCategory" method="GET">
		<button type="submit" class="btn ranking">ランキング</button>
	</form>
	<form action="/logCategory" method="GET">
		<button type="submit" class="btn history">履歴</button>
	</form>
	<form action="/profile" method="GET">
		<button type="submit" class="btn profile">プロフィール</button>
	</form>

	<span id="radar"></span>
	<select name="radarCategory" id="radarCategory">
		<option Label="選択してください">
			<c:forEach var="categoryName" items="${parentCategory}">
				<option value="${categoryName.categoryId}">${categoryName.categoryName}</option>
			</c:forEach>
	</select>
	<script src="js/home.js"></script>
</body>
</html>