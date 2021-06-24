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
</head>
<body>


<h1>${quizStatus.categoryName}の解答</h1>

<c:forEach items="${quizList}" var="quiz" varStatus="status">
  <p>${status.count}.<c:out value="${quiz.quizStatment}" /></p><br>
	<input type="radio" >
</c:forEach>
</body>
</html>