<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ設定画面</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/quizConfig/quizConfig.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
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

	<form:form action="/quiz" modelAttribute="quizConfig" method="POST">
		<h1>モードを選んでください</h1>


		<label class="learningLabel"><form:radiobutton
				class="learning" path="mode" value="1" onclick="changeBtn();"
				checked="checked" />学習</label>

		<label class="rankLabel"><form:radiobutton class="rank"
				path="mode" value="2" onclick="changeBtn();" />ランキング</label>


		<h2>カテゴリを選んでください</h2>

		<div class="category">
			<form:select path="categoryId" value="categoryName"
				class="learningNum" id="lea">
				<form:options items="${categoryAll}" itemLabel="categoryName"
					itemValue="categoryId" />
			</form:select>


			<form:select path="rankCategoryId" class="rankNum" id="ran">
				<form:options items="${categoryName}" itemLabel="categoryName"
					itemValue="categoryId" />
			</form:select>
		</div>



		<h3 id="numEx">問題数を選んでください</h3>

		<form:select path="quizNum" class="num" id="num">
			<form:option value="" label="選んでください"></form:option>
		</form:select>
		<p class="error" id="studyError">${studyError}</p><br>

		<p class="error" id="rankError">${rankError}</p><br>
		<form:button class="btn quiz">START</form:button>
	</form:form>

	<script src="js/quizConfig.js"></script>
</body>
</html>