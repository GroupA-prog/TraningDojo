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

<header>
  <h1>研修道場</h1>
  <nav>
    <button id="retired" >リタイア</button>
  </nav>
</header>

<form:form action="quiz" modelAttribute="quiz">
<h1>${mode}:${categoryName}</h1>

<c:forEach items="${quizListHarf}" var="quiz" varStatus="status">
  <p><c:out value="${quiz.quizStatment}" /></p>
  <form:radiobutton path="choiceId${status.count}" label="${quiz.choice1}" value="1"/><br>
  <form:radiobutton path="choiceId${status.count}" label="${quiz.choice2}" value="2"/><br>
  <form:radiobutton path="choiceId${status.count}" label="${quiz.choice3}" value="3"/><br>
  <form:radiobutton path="choiceId${status.count}" label="${quiz.choice4}" value="4"/><br>
  </c:forEach>


<c:if test="${not empty time}">
  <p>残り時間</p>
  <p>
    <span id="min"></span>分
    <span id="sec"></span>秒
  </p>
</c:if>

<c:if test="${not empty returnDisplay}">
  <form:button name= "return">←前へ</form:button>
</c:if>

<p>${nowSize}/${quizNum}</p>

<c:if test="${empty nextDisplay}">
  <form:button name= "next">次へ→</form:button>
</c:if>

<div><form:button name="finish">終了</form:button></div>

</form:form>
<script src="js/quiz.js"></script>
</body>
</html>