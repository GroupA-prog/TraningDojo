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
<header class="title-continar">
	<span id="site-title">
		<c:choose>
			<c:when test="${ not empty loginUserInfo }"><a href="userHome">研修道場</a></c:when>
			<c:otherwise><a>研修道場</a></c:otherwise>
		</c:choose>
	</span>
</header>


<h1>${quizStatus.categoryName}の解答</h1>

<c:forEach items="${quizList}" var="quiz" varStatus="status">
  <pre>${status.count}.<c:out value="${quiz.quizStatment}" /></pre><br>
	<input type="radio" disabled <c:if test="${quiz.userAnswer == 1}">checked</c:if>>
	<label <c:if test="${quiz.correctAnswer == 1}">class="correct"</c:if> >${quiz.choice1}</label><br>
	<input type="radio" disabled <c:if test="${quiz.userAnswer == 2}">checked</c:if>>
	<label <c:if test="${quiz.correctAnswer == 2}">class="correct"</c:if> >${quiz.choice2}</label><br>
	<input type="radio" disabled <c:if test="${quiz.userAnswer == 3}">checked</c:if>>
	<label <c:if test="${quiz.correctAnswer == 3}">class="correct"</c:if> >${quiz.choice3}</label><br>
	<input type="radio" disabled <c:if test="${quiz.userAnswer == 4}">checked</c:if>>
	<label <c:if test="${quiz.correctAnswer == 4}">class="correct"</c:if>>${quiz.choice4}</label><br>
  <c:if test="${not empty quiz.commentary}">
    <p>解説</p>
    <pre>${quiz.commentary}</pre>
  </c:if>
</c:forEach>

</body>
</html>