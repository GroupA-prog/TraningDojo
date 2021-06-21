<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ設定画面</title>
<link rel="stylesheet" type="style/css">
</head>
<body>
	<header>
		<a>研修道場</a>
	</header>

	<form:form action="/quiz" method="GET">
		<h1>モードを選んでください</h1>
		<br>
		<form:radiobutton class="learning" path="mode" />
		<label>学習</label>
		<form:radiobutton class="rank" path="mode" />
		<label>ランキング</label>

		<br>
		<h2>カテゴリを選んでください</h2>
		<br>
		<form:select path="">
			<form:options item="${categoryName}" itemLabel="" itemValue="categoryId" />
		</form:select>
		<br>
		<h3>問題数を選んでください</h3>
		<br>
		<form:select path="">
			<form:options item="" itemLabel="" itemValue="" />
		</form:select>
		<button class="btn quiz" >START</button>
	</form:form>
</body>
</html>