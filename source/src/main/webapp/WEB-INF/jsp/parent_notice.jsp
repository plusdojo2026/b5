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
			<!-- 日付の表示 -->
		  	<div class="calendar">
		    	<img src="${pageContext.request.contextPath}/images/calendar.png" width="50" height="50"><p id="today"></p>
		  	</div>
			
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
				<ul class = "footer-nav">
					<li><a href="/java/ParentNoticeServlet"><img src= "${pageContext.request.contextPath}/images/p_notice2.png" alt = "通知画面"></a></li>
					<li><a href="/java/ParentViewServlet"><img src= "${pageContext.request.contextPath}/images/p_list1.png" alt = "リスト画面"></a></li>
				</ul>
			</div>
		</footer>
		
		<!-- javascript開始 -->
		<script src="${pageContext.request.contextPath}/js/parent_notice.js"></script>
		<!-- javascript終了 -->
	</body>
</html>