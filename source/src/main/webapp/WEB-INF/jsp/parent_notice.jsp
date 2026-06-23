<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>保護者の通知|できたねスタンプ</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/parent_notice.css">
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

  <!-- 教師からのスタンプの通知 -->
    <div class = "lists">
        <div class = "list">
            <img src= "${pageContext.request.contextPath}/images/hatugen.png" width="80" height="80">(仮)積極的な発言<br>
        </div>
        
    <form class="reaction-form">
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/good.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/pien.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/bikkuri.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/nikkori.png" width="30" height="30"/>
	</form>   
        
        <div class = "list">
            <img src= "${pageContext.request.contextPath}/images/challenge.png" width="80" height="80">(仮)挑戦<br>
        </div>
    </div>

	<form class="reaction-form">
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/good.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/pien.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/bikkuri.png" width="30" height="30"/>
	<input type="image" alt="リアクションボタン" name="button" value="reaction" src="${pageContext.request.contextPath}/images/nikkori.png" width="30" height="30"/>
	</form>
	
    <p>持ち物リストが更新されました！</p>

<!-- 保護者のリアクション画面終了 --> 

</main>
        
<!-- フッター開始 -->	
<footer>
 <div class = "footer-icon">
	<form action="ParentNoticeServlet" method="POST">  
        <button type="submit" name="button" value="notice">
         <img src= "${pageContext.request.contextPath}/images/p_notice2.png" width="30" height="30" alt = "通知画面">
        </button>
		
	</form>
	<form action="ParentViewServlet" method="POST">
		<button type="submit" name="button" value="lists">
		        <img src= "${pageContext.request.contextPath}/images/p_list1.png" width="30" height="30" alt = "リスト画面">
	    </button>
	</form>
	</div>
</footer>
<!-- フッター終了 -->
 

</body>
</html>