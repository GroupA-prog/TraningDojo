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

</head>
<body>
	<header>
		<a>研修道場</a>
	</header>

	<form:form action="/quizConfig" modelAttribute="quizConfig" method="POST">
		<h1>モードを選んでください</h1>
		<br>
		<form:radiobutton class="learning" path="mode" value="1" onclick="changeBtn();" />
		<label class="learningLabel">学習</label>
		<form:radiobutton class="rank" path="mode" value="2" onclick="changeBtn();" checked="checked"/>
		<label class="rankLabel">ランキング</label>

		<br>
		<h2>カテゴリを選んでください</h2>
		<br>


		<form:select path="categoryId" class="learningNum" id="lea">
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
		<form:select path="categoryId" class="num">
			<form:options item="" itemLabel="4" itemValue="4" />
		</form:select>

	</form:form>
	<button class="btn quiz">START</button>
	 <script src="js/quizConfig.js"></script>
</body>
</html>