<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席一覧|できたねスタンプ</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/stamp.css?v=9999">
 <script src="<%=request.getContextPath()%>/js/stamp.js?v=1"></script>

<link rel="stylesheet" type="text/css"
	  href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/stamp.css">
 

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

<!-- 児童のスタンプ獲得数画面開始 -->
<main>
  <!-- 日付の表示 -->

  <div class="calendar">
     <img src="${pageContext.request.contextPath}/images/calendar.png" width="50" height="50"><p id="today"></p>
  </div>


<div class="stamps">

<!-- ★↓選択した児童の名前(Servletとかと結びつける)↓ -->
<h2>児童のスタンプ獲得数を表示</h2>

 <!-- ★検索した児童のスタンプ保持数表示させる-->
  <div class="stamps">

   <div class="stamp1">
     <img src="${pageContext.request.contextPath}/images/hatugen.png" width="150" height="150" >
        <p>
        <strong>積極的な発言</strong><br>
        <span>仮３個</span>
        </p>
   </div>

   <div class="stamp2">
     <img src="${pageContext.request.contextPath}/images/challenge.png" width="150" height="150" >
        <p>
        <strong>挑戦</strong><br>
        <span>仮１個</span>
        </p>
   </div>

   <div class="stamp3">
    <img src="${pageContext.request.contextPath}/images/goal.png" width="150" height="150">
        <p>
        <strong>達成</strong><br>
        <span>仮１個</span>
        </p>
   </div>

   <div class="stamp4">
     <img src="${pageContext.request.contextPath}/images/kyouryoku.png" width="150" height="150">
        <p>
        <strong>協力</strong><br>
        <span>仮２個</span>
        </p>
   </div>

   <div class="stamp5">
     <img src="${pageContext.request.contextPath}/images/syusseki.png" width="150" height="150" >
        <p>
        <strong>出席</strong><br>
        <span>仮２１日</span>
        </p>
   </div>

   <div class="stamp6">
     <img src="${pageContext.request.contextPath}/images/sonota.png" width="150" height="150" >
        <p>
        <strong>その他</strong><br>
        <span>仮０個</span>
        </p>
   </div>
  </div>

</main>
<!-- 児童のスタンプ獲得数画面終了 -->

<input type="button" value="出席" id="attendBtn">


<!-- 児童の座席表 -->

<!-- 児童のスタンプ獲得数画面終了 -->


	<div class="seat_area">

</body>
</html>

