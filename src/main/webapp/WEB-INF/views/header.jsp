<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<header class="title-continar">
	<span id="site-title">家計簿管理システム</span>
	<c:if test="${ not empty loginUserInfo }">
		<nav>
			<ul>
				<li><a href="/logout">ログアウト</a></li>
			</ul>
		</nav>
	</c:if>
</header>