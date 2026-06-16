<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webapp/css/common.css">
<link rel="stylesheet" href="/webapp/css/student_info.css">
<title>児童情報 | できたねスタンプ</title>
</head>
<body>


<!-- ヘッダー -->
 <header>
   <div>
      <h1>できたねスタンプ</h1>
      <p>児童のがんばりを記録しよう</p>
   </div>
    <nav>
        <ul>
            <li><a href="StampServlet">スタンプ一覧</a></li> 
            <li><a href="CreateListServlet">リスト作成</a></li>
            <li><a href="HwCheckServlet">宿題チェック</a></li>
        </ul>    
    </nav>
    <!-- ↓画像アイコンの挿入↓ -->
    <a href="LoginServlet">ログイン</a> 
    <a href="">ログアウト</a> 
    <a href="StudentInfoServlet">履歴と通知</a> 
 </header>
<!-- ヘッダーここまで -->


<!-- 児童のスタンプ獲得数画面開始 -->
 <main>
  <!-- 日付の表示(js) -->
  <p id="today"></p>
  
  <h2>〇〇くんのスタンプ獲得数</h2>

  <div>
     <img src="" >
        <p>
        <strong>積極的な発言</strong><br>
        <span>個</span> 
        </p> 
   </div> 

   <div>
     <img src="" >
        <p>
        <strong>挑戦</strong><br>
        <span>個</span> 
        </p> 
   </div> 

   <div>
    <img src="" >
        <p>
        <strong>達成</strong><br>
        <span>個</span> 
        </p> 
   </div> 

   <div>
     <img src="" >
        <p>
        <strong>協力</strong><br>
        <span>個</span> 
        </p> 
   </div> 

   <div>
     <img src="" >
        <p>
        <strong>出席</strong><br>
        <span>個</span> 
        </p> 
   </div> 

   <div>
     <img src="" >
        <p>
        <strong>その他</strong><br>
        <span>個</span> 
        </p> 
   </div> 
<!-- 児童のスタンプ獲得数画面終了 -->


<!-- 保護者からのリアクション画面開始 -->
 <h2>保護者からのリアクションを確認できます</h2>
 
 </main>
<!-- 保護者からのリアクション画面終了 -->


<!-- フッター開始 -->
<footer>
  <p class="copyright">&copy; パンの耳</p>
</footer>
<!-- フッター終了 -->

<!-- javascript開始 -->
<script src="/webapp/js/student_info.js"></script>
<!-- javascript終了 -->

</body>
</html>