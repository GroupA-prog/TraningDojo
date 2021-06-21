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
<link rel="stylesheet" type="style/css">
</head>
<body>
	<header>
		<th>研修道場</th>
		<button class="btn admin" href="">管理者</button>
		<button class="btn warning" href="">ログアウト</button>
	</header>



	<button class="btn quiz" href="">クイズ</button>
	<button class="btn ranking" href="">ランキング</button>
	<button class="btn history" href="">履歴</button>
	<button class="btn profile" href="">プロフィール</button>
</body>
</html>