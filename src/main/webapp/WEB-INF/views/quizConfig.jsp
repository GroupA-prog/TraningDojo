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
</head>
<body>
	<header>
		<th>研修道場</th>
	</header>

	<h1>モードを選んでください</h1>
	<br>
	<form:radiobutton class="learning" />
	<label>学習</label>
	<form:radiobutton class="rank" />
	<label>ランキング</label>

	<br>
	<h2>カテゴリを選んでください</h2>
	<br>
	<form:select path="">
		<form =option item="" itemLabel="カテゴリ" itemValue="" />
	</form:select>
	<br>
	<h3>問題数を選んでください</h3>
	<br>
	<form:select path="">
		<form =option item="" itemLabel="" itemValue="" />
	</form:select>
	<button class="btn quiz" href="">START</button>
</body>
</html>