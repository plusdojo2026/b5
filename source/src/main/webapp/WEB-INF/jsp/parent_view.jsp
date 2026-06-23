<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <div class="name">山田太郎くん</div>
</header>

<!-- メイン -->
<main>

<!-- 保護者のリアクション画面開始 -->    
  <!-- ★スタンプを付与した日を表示する -->
  <div class="update-date">（仮）6月18日</div>
  
  
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