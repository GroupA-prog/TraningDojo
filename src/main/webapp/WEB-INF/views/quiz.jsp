<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ画面</title>
</head>
<body>
<form:form >
<header>
  <h1>研修道場</h1>
  <nav>
    <form:button name="retired">リタイア</form:button>
  </nav>
  </header>
<h1>:</h1>




<form:radiobuttons path="choiceId"/>


<form:button name= "return">←前へ</form:button>>
<p></p>
<form:button name= "next">次へ→</form:button>>

<div><form:button name="finish">終了</form:button></div>

</form:form>
</body>
</html>