<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>保護者のリスト確認|できたねスタンプ</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/parent_view.css">

</head>
<body>

<!-- ヘッダー -->
<header class="header">
    <div class="name">"${studentData.name}"さん</div>
    <a href="LoginServlet" class="logout"><span class="logout-icon"><img src="${pageContext.request.contextPath}/images/p_logout2.png" width="30" height="30"></span></a>
</header>

<!-- メイン -->
<main>

<!-- 保護者のリアクション画面開始 -->    
  <!-- ★スタンプを付与した日を表示する -->
  <div class="update-date">6月30日(火)</div>
  
  
<!-- もちもの -->
<div class="lists">
	<div class="list">
		<div class="title">
			<img src="${pageContext.request.contextPath}/images/p_belongings.png" width="40" height="40">
			<h3>もちもの</h3>
		</div>
		<ul>
			<c:forEach var="item" items="${itemList}">
				<li>
					<label>
						<c:out value="${item.item_name}" />
					</label>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div class="list">
		<div class="title">
			<img src="${pageContext.request.contextPath}/images/p_homework.png" width="40" height="40">
			<h3>しゅくだい</h3>
		</div>
		<ul>
			<c:forEach var="hw" items="${hwList}">
				<li>
					<label>
						<c:out value="${hw.homework_name}" />
					</label>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>	
	
</main>
 
<!-- フッター開始 -->	
<footer>
 <div class = "footer-icon">
	<form action="ParentNoticeServlet" method="POST">  
        <button type="submit" name="button" value="notice">
         <img src= "${pageContext.request.contextPath}/images/p_notice1.png" width="30" height="30" alt = "通知画面">
        </button>
		
	</form>
	<form action="ParentViewServlet" method="POST">
		<button type="submit" name="button" value="lists">
		        <img src= "${pageContext.request.contextPath}/images/p_list2.png" width="30" height="30" alt = "リスト画面">
	    </button>
	</form>
	</div>
</footer>
<!-- フッター終了 -->
 

</body>
</html>  