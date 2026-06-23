<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stamp.css">
<title>座席一覧|できたねスタンプ</title>
</head>
<body>

<!-- ヘッダー -->
 <header class="header">
   <a href="StampServlet"><img src="${pageContext.request.contextPath}/images/logo.png" width="100" height="100"></a>
   <div class="left">
      <h1>できたねスタンプ</h1>
      <p>児童のがんばりを記録しよう</p>
   </div>
    <nav class="nav">
        <ul>
            <li><a href="StampServlet">スタンプ一覧</a></li>
            <li><a href="CreateListServlet">リスト作成</a></li>
            <li><a href="HwCheckServlet">宿題チェック</a></li>
        </ul>    
    </nav>
   <div class="right">
      <a href="LoginServlet" class="login"><span class="login-icon"><img src="${pageContext.request.contextPath}/images/login.png" width="25" height="25"></span>ログイン</a> 
      <a href="" class="logout"><span class="logout-icon"><img src="${pageContext.request.contextPath}/images/logout.png" width="30" height="30"></span>ログアウト</a> 
      <a href="StudentInfoServlet"><span class="reaction"><img src="${pageContext.request.contextPath}/images/reaction.png" width="45" height="45"></span></a> 
   </div>
 </header>
<!-- ヘッダーここまで -->

<!-- 日付の表示 -->
<main>
  <div class="calendar">
     <img src="${pageContext.request.contextPath}/images/calendar.png" width="50" height="50"><p id="today"></p>
  </div>

<!-- スタンプ付与 -->
<h2>該当のスタンプをクリックしてください</h2>

<form method="POST" action="StampServlet">
	<div class="stamps">
		<button type="submit" name="stamp_id" value="2" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/hatugen.png" width="150" height="150">
			<h3><strong>積極的な発言</strong></h3>
			<div class="detail">
			<p>自分の考えを<br>発表できたときに</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>

		<button type="submit" name="stamp_id" value="3" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/challenge.png" width="150" height="150">
			<h3><strong>挑戦</strong></h3>
			<div class="detail">
			<p>新しいことに<br>挑戦したときに</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>

		<button type="submit" name="stamp_id" value="4" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/goal.png" width="150" height="150">
			<h3><strong>達成</strong></h3>
			<div class="detail">
			<p>目標達成したとき<br>がんばったときに</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>

		<button type="submit" name="stamp_id" value="5" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/kyouryoku.png" width="150" height="150">
			<h3><strong>協力</strong></h3>
			<div class="detail">
			<p>友達と協力して<br>解決できたときに</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>

		<button type="submit" name="stamp_id" value="0" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/syusseki.png" width="150" height="150">
			<h3><strong>出席</strong></h3>
			<div class="detail">
			<p>元気に授業に<br>出席したとき</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>
		
		<button type="submit" name="stamp_id" value="6" class="stamp_btn">
			<img src="${pageContext.request.contextPath}/images/sonota.png" width="150" height="150">
			<h3><strong>その他</strong></h3>
			<div class="detail">
			<p>テキストで<br>伝えたいときに</p>
			<img src="${pageContext.request.contextPath}/images/right.png" width="30" height="30" >
			</div>
		</button>
	</div>
</form>
</main>
<!-- 児童のスタンプ獲得数画面終了 -->

<!-- フッター開始 -->
<footer>
  <p class="copyright">&copy; パンの耳</p>
</footer>
<!-- フッター終了 -->

<!-- javascript開始 -->
<script src="${pageContext.request.contextPath}/js/student_info.js"></script>
<!-- javascript終了 -->

</body>
</html>

