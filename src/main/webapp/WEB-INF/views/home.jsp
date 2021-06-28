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
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<!--
	<header class="title-continar">
		<span id="site-title"> <c:choose>
				<c:when test="${ not empty loginUserInfo }">
					<a href="userHome">研修道場</a>
				</c:when>
				<c:otherwise>
					<a href="/login">研修道場</a>
				</c:otherwise>
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
	 -->
	<c:import url="header.jsp"></c:import>
	<div id="background-image">
		<h1 class="home">${loginUserInfo.userName}さんのホーム</h1>
		<div style="display: inline-flex">
			<form action="/quizConfig" method="GET">
				<button type="submit" class="btn quiz">
					<img src="css/img/quiz.png" width="200px"
						onmouseover="this.src='css/img/quiz_hover.png'"
						onmouseout="this.src='css/img/quiz.png'">
				</button>
			</form>
			<!--  <p class="quizEx">学習・ランキングの二種類のモードで学習できます</p>-->
			<form action="/rankingCategory" method="GET">
				<button type="submit" class="btn ranking">
					<img src="css/img/ranking.png" width="200px"
						onmouseover="this.src='css/img/ranking_hover.png'"
						onmouseout="this.src='css/img/ranking.png'">
				</button>
			</form>

			<!--  <p class="rankEx">ランキングモードでの成績を確認できます</p>-->
		</div>
		<br>
		<div style="display: inline-flex">
			<form action="/logCategory" method="GET">
				<button type="submit" class="btn history">
					<img src="css/img/log.png" width="200px"
						onmouseover="this.src='css/img/log_hover.png'"
						onmouseout="this.src='css/img/log.png'">
				</button>
			</form>
			<!--  <p class="hisEx">過去に解いた問題を確認できます</p>-->
			<form action="/profile" method="GET">
				<button type="submit" class="btn profile">
					<img src="css/img/profile.png" width="200px"
						onmouseover="this.src='css/img/profile_hover.png'"
						onmouseout="this.src='css/img/profile.png'">
				</button>
			</form>
			<!--  <p class="proEx">プロフィールを変更できます</p>-->
		</div>


		<select name="radarCategory" id="radarCategory" class="radarCategory">
			<option Label="選択してください">
				<c:forEach var="category" items="${parentCategory}">
					<option value="${category.categoryId}">${category.categoryName}</option>
				</c:forEach>
		</select>
		<div class="wrapper">
			<div id="radar" class="radar"></div>
		</div>


		<script src="js/home.js"></script>
	</div>
</body>
</html>