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
	<input type="radio" disabled><label>${quiz.choice1}</label>
	<input type="radio" disabled><label>${quiz.choice2}</label>
	<input type="radio" disabled><label>${quiz.choice3}</label>
	<input type="radio" disabled><label>${quiz.choice4}</label>
</c:forEach>

</body>
</html>