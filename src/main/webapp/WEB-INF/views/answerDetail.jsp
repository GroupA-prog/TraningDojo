<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/quiz/quiz.css">

</head>
<body>
<c:import url="header.jsp"></c:import>

<h1>${quizStatus.categoryName}の解答</h1>
<div class="main">
	<c:forEach items="${quizList}" var="quiz" varStatus="status">
	  <pre>${status.count}.<c:out value="${quiz.quizStatment}" /></pre><br>
	  <div class="select">
			<input type="radio" disabled <c:if test="${quiz.userAnswer == 1}">checked</c:if>>
			<label <c:if test="${quiz.correctAnswer == 1}">class="correct"</c:if> >${quiz.choice1}</label><br>
			<input type="radio" disabled <c:if test="${quiz.userAnswer == 2}">checked</c:if>>
			<label <c:if test="${quiz.correctAnswer == 2}">class="correct"</c:if> >${quiz.choice2}</label><br>
			<input type="radio" disabled <c:if test="${quiz.userAnswer == 3}">checked</c:if>>
			<label <c:if test="${quiz.correctAnswer == 3}">class="correct"</c:if> >${quiz.choice3}</label><br>
			<input type="radio" disabled <c:if test="${quiz.userAnswer == 4}">checked</c:if>>
			<label <c:if test="${quiz.correctAnswer == 4}">class="correct"</c:if>>${quiz.choice4}</label><br>
	  </div>
	  <pre>解説</pre>
	  <c:if test="${not empty quiz.commentary}">
	    <pre>${quiz.commentary}</pre>
	  </c:if>
	  <c:if test="${not empty quiz.commentary}">
	    <pre>解説はまだありません</pre>
	  </c:if>
	</c:forEach>
</div>
<c:if test="${quizStatus.modeId == 2 }">
  <a href="rankingView?categoryId=${quizStatus.categoryId}">戻る</a>
</c:if>

</body>
</html>