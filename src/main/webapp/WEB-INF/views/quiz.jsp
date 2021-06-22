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
<body onload="countdown();">
<form:form >
<header>
  <h1>研修道場</h1>
  <nav>
    <form:button name="retired">リタイア</form:button>
  </nav>
  </header>
<h1>${mode}:${categoryName}</h1>

<c:forEach items="${quizList}" var="quiz">
  <p>${quiz.quizStatement}</p>
  <c:forEach items="${quiz.quizSelect}" var="select">
    <form:radiobuttons path="choiceId" items="${select.choice}"/>
  </c:forEach>
</c:forEach>

<p>残り時間</p>
<p>
  <span id="min"></span>分
  <span id="sec"></span>秒
</p>

<c:if test="${returnDisplay != 0}">
  <form:button name= "return">←前へ</form:button>>
</c:if>

<p>/${maxSize}</p>

<c:if test="${nextDisplay != 0}">
  <form:button name= "next">次へ→</form:button>>
</c:if>

<div><form:button name="finish">終了</form:button></div>

</form:form>
<script src="js/quiz.js"></script>
</body>
</html>