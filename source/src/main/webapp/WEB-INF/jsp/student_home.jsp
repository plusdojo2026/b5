<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム（児童）｜できたねスタンプ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student_home.css">
</head>
<body>

<header class="student_header">
	
	<div class="sun">
		<img src="${pageContext.request.contextPath}/images/sun.png" alt="太陽の画像" class="sun_img">
	</div>
	
	<div class="date">
		<img src="${pageContext.request.contextPath}/images/cloud.png" alt="雲の画像" class="cloud_img">
		<p class="date_text">6がつ11にち<br>もくようび</p>
	</div>
		<div class="result">
		<a href="${pageContext.request.contextPath}/StudentResultServlet" class="sutudent_result">
			<img src="${pageContext.request.contextPath}/images/cloud3.png" alt="雲の画像" class="cloud_img">
			<span class="result_text"></span>
		</a>
	</div>
</header>
<main class="student_main">
<section>
<%---------------------------もちもの ----------------------------%>
<div class="list1">
	<h3>もちものリスト</h3>
	<ul>
		<c:forEach var="item" items="${itemList}">
			<li><c:out value="${item.item_name}" /></li>
		</c:forEach>
	</ul>
</div>

<%----------------------しゅくだい -----------------------------%>
<div class="list2">
	<h3>しゅくだいリスト</h3>
	<ul>
		<c:forEach var="hw" items="${hwList}">
			<li><c:out value="${hw.homework_name}" /></li>
		</c:forEach>
	</ul>
</div>	
</section>
</main>

<!-- フッター -->
<footer class="student_footer">
<div class="flower">
	<img src="${pageContext.request.contextPath}/images/flower${flowerLevel}.gif" width="332" height="332" alt="クラスの花（レベル${flowerLevel}）" class="flower_img">
</div>

<img src="${pageContext.request.contextPath}/images/tuchi2.png" width="1500" height="360" alt="土のイラスト" class="ground_img">
</footer>
<!-- フッターここまで -->


</body>
</html>