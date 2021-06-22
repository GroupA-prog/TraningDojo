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
	<header>
		<a>研修道場</a>
	</header>

	<form:form action="/quiz" modelAttribute="quizConfig" method="POST">
		<h1>モードを選んでください</h1>
		<br>
		<form:radiobutton class="learning" path="mode" value="1"
			onclick="changeBtn();" checked="checked" />
		<label class="learningLabel">学習</label>
		<form:radiobutton class="rank" path="mode" value="2"
			onclick="changeBtn();" />
		<label class="rankLabel">ランキング</label>

		<br>
		<h2>カテゴリを選んでください</h2>
		<br>


		<form:select path="categoryId" value="categoryName"
			class="learningNum" id="lea">
			<form:options items="${categoryAll}" itemLabel="categoryName"
				itemValue="categoryId" />
		</form:select>


		<form:select path="categoryId" class="rankNum" id="ran">
			<form:options items="${categoryName}" itemLabel="categoryName"
				itemValue="categoryId" />
		</form:select>


		<br>
		<h3>問題数を選んでください</h3>
		<br>
		<form:select path="quizNum" class="num" id="num">
			<form:option value="" label="選んでください"></form:option>
		</form:select>

		<form:button class="btn quiz">START</form:button>
	</form:form>

	<script src="js/quizConfig.js"></script>
</body>
</html>