<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>保護者の通知|できたねスタンプ</title>
		
					<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/parent_notice.css">
	</head>
	
	<body>
		<!-- ヘッダー -->
		<header class="header">
			山田太郎くん
		</header>
		
		<!-- メイン -->
		<main>
			<p>日付表示</p>
			
			<div class = "lists">
				<div class = "list">
					スタンプの内容1<br>
					リアクションボタン<br>
				</div>
				
				<div class = "list">
					スタンプの内容2<br>
					リアクションボタン<br>
				</div>
			</div>

			<p>持ち物リストが更新されました！</p>
			
		</main>
	
		<footer>
			<div class = "footer-icon">
				<ul classs = "footer-nav">
					<li><a href="/java/ParentNoticeServlet">べるまーく</a></li>
					<li><a href="/java/ParentViewServlet">めいぼまーく</a></li>
				</ul>
			</div>
		</footer>
	</body>
</html>