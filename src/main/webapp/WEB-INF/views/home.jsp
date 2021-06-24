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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<header>
		<form action="/admin" method="GET">
			<button type="submit" class="btn admin">管理者</button>
		</form>
		<form action="/logout" method="GET">
			<button type="submit" class="btn warning">ログアウト</button>
		</form>
	</header>
	<p>${loginUserInfo.userName}さんのホーム</p>


	<form action="/quizConfig" method="GET">
		<button type="submit" class="btn quiz">クイズ</button>
	</form>
	<form action="/ranking" method="GET">
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