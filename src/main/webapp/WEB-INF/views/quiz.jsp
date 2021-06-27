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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<link rel="stylesheet" href="css/quiz/quiz.css">
<link rel="stylesheet" href="css/common.css">
</head>
<body>

<header class="title-continar">
	<span id="site-title">
		<c:choose>
			<c:when test="${ not empty loginUserInfo }"><a href="userHome">研修道場</a></c:when>
			<c:otherwise><a href="/login">研修道場</a></c:otherwise>
		</c:choose>
	</span>
	<%-- <c:if test="${ not empty loginUserInfo }">--%>
		<nav>
			<ul>
				<li><a id="retired">リタイア</a></li>
			</ul>
		</nav>
	<%-- </c:if>--%>
</header>

<form:form action="quiz" modelAttribute="quiz">

<h1>${quizStatus.mode}:${quizStatus.categoryName}</h1>
<div class="main">
  <c:forEach items="${quizListHarf}" var="quiz" varStatus="status">

    <pre>${quizStatus.quizIndex * 5 + status.count}.<c:out value="${quiz.quizStatment}" /></pre><br>
    <div class="select">
	  <form:radiobutton path="choiceId${status.count}"  label="${quiz.choice1}" value="1"/><br>
	  <form:radiobutton path="choiceId${status.count}"  label="${quiz.choice2}" value="2"/><br>
	  <form:radiobutton path="choiceId${status.count}"  label="${quiz.choice3}" value="3"/><br>
	  <form:radiobutton path="choiceId${status.count}"  label="${quiz.choice4}" value="4"/><br>
	  <form:radiobutton path="choiceId${status.count}"  cssStyle="display:none" value="0"/><br>
    </div>
  </c:forEach>
</div>


<div class="pageCon">
	<span class="timeLimit">
	<c:if test="${not empty quizStatus.time}">
	    <p>残り時間</p>
	    <p>
	      <span id="min"></span>分
	      <span id="sec"></span>秒
	    </p>
	  </c:if>
	</span>

  <c:if test="${not empty returnDisplay}">
    <form:button name= "return">←前へ</form:button>
  </c:if>

  <p>${quizStatus.nowSize}/${quizStatus.quizNum}</p>

  <c:if test="${empty nextDisplay}">
    <form:button name= "next">次へ→</form:button>
  </c:if>
</div>

<input type="button" id="finish-btn" value="終了">


<%--モーダルウィンドウ --%>
<div id="modal-retired" class="modal">
  <div class="modal-content">
      <h2>解答を破棄して終了しますか？</h2>
	    <input type="button" name="finish" id="finish" onclick="location.href='retired'" value="はい">
	    <input type="button" id="closeRetired" value="いいえ">
  </div>
</div>


<div id="modal" class="modal">
  <div class="modal-content">
      <h2>解答を保存して終了しますか？</h2>
	    <form:button name="finish">はい</form:button>
	    <input type="button" id="closeBtn" value="いいえ">
  </div>
</div>

<div id="timeup" class="modal">
  <div class="modal-content">
      <h2>TimeUp!!</h2>
	    <input type="button" id="timebtn" value="OK">
  </div>
</div>


</form:form>
<script src="js/quiz.js"></script>
</body>
</html>