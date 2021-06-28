<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<header class="title-continar">
	<span id="site-title">
		<c:choose>
				<c:when test="${ not empty loginUserInfo }"><a href="userHome"><img src="css/img/logo (2).png" width="150px"></a></c:when>
			<c:otherwise><a href="/login"><img src="css/img/logo (2).png"></a></c:otherwise>
		</c:choose>
	</span>
	<c:if test="${ not empty loginUserInfo }">
		<nav>
			<ul>
				<c:if test="${ loginUserInfo.role == 1 }">
					<li><a href="/admin">管理者</a></li>
				</c:if>
				<li><a href="/logout">ログアウト</a></li>
			</ul>
		</nav>
	</c:if>
</header>