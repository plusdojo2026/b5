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
			<p>日付表示</p>
			
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
					<li><a href="/java/ParentNoticeServlet">べるまーく</a></li>
					<li><a href="/java/ParentViewServlet">めいぼまーく</a></li>
				</ul>
			</div>
		</footer>
	</body>
</html>