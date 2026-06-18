<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>保護者のリスト確認|できたねスタンプ</title>
		
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/parent_view.css">
	</head>
	
	<body>
		<!-- ヘッダー -->
		<header class="header">
			山田太郎くん
		</header>
		
		<!-- メイン -->
		<main>
			<!-- 日付の表示 -->
		  	<div class="calendar">
		    	<img src="${pageContext.request.contextPath}/images/calendar.png" width="50" height="50"><p id="today"></p>
		  	</div>
			
		<!-- もちもの -->
		<div class = "lists">
			<div class = "list">
				<h3>もちもの</h3>
				<ul>
					<li>きゅうしょくセット</li>
					<li>えのぐセット</li>
					<li>すいとう（氷いっぱい）</li>
				</ul>
			</div>
	
		<!-- しゅくだい -->
			<div class = "list">
				<h3>しゅくだい</h3>
				<ul>
					<li>かんじドリル</li>
					<li>けいさんドリル</li>
				</ul>
			</div>
		</div>	
			
		</main>
	
		<footer>
			<div class = "footer-icon">
				<ul class = "footer-nav">
					<li><a href="/java/ParentNoticeServlet"><img src= "${pageContext.request.contextPath}/images/p_notice1.png" width="150" height="150" alt = "通知画面"></a></li>
					<li><a href="/java/ParentViewServlet"><img src= "${pageContext.request.contextPath}/images/p_list2.png" width="150" height="150" alt = "リスト画面"></a></li>
				</ul>
			</div>
		</footer>
	</body>
</html>