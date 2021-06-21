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
</head>
<body>
	<header>
		<a>研修道場</a>
		<form action="/admin" method="GET">
			<button type="submit" class="btn admin">管理者</button>
		</form>
		<form action="/logout" method="GET">
			<button  type="submit" class="btn warning">ログアウト</button>
		</form>
	</header>


	<form action="/quiz" method="GET">
		<button type="submit" class="btn quiz">クイズ</button>
	</form>
	<form action="/ranking" method="GET">
		<button type="submit" class="btn ranking">ランキング</button>
	</form>
	<form action="/history" method="GET">
		<button type="submit" class="btn history">履歴</button>
	</form>
	<form action="/profile" method="GET">
		<button type="submit" class="btn profile">プロフィール</button>
	</form>
</body>
</html>