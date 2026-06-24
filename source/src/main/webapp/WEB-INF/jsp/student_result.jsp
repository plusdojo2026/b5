<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="student_result">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student_result.css">
<title>がんばり｜できたねスタンプ</title>
</head>
<body>

<!-- ヘッダー -->   
<header class="student_header">
	
	<div class="sun">
		<img src="${pageContext.request.contextPath}/images/sun.png" width="150" height="150" alt="太陽の画像" class="sun_img">
	</div>
	
	<div class="cloud">
		<img src="${pageContext.request.contextPath}/images/cloud.png" width="220" height="170" alt="雲の画像" class="cloud_img">
	</div>
	
     <div class="result">
		<a href="${pageContext.request.contextPath}/StudentHomeServlet" class="sutudent_result">
			<img src="${pageContext.request.contextPath}/images/cloud2.png" width="250" height="200" alt="雲の画像" class="cloud_img">
		</a>
		
	</div>
</header>
<!-- ヘッダーここまで -->

<!-- メイン -->
<main class="student_main">
 <!-- 日付の表示とタイトル -->
  <div class="calendar">
     <img src="images/calendar2.png" width="50" height="50"><p id="today"></p>
  </div>

  <h1 id="today2"></h1>

  <!-- ★児童のスタンプ獲得履歴 -->
  <div class="stamps"> 
   <div class="stamp1">
     <img src="images/hatugen.png" width="${100 + (stampCounts[1] * 10)}" height="${100 + (stampCounts[1] * 10)}" >
        <p>
        <strong>はつげん</strong>
        </p> 
   </div> 

   <div class="stamp2">
     <img src="images/challenge.png" width="${100 + (stampCounts[2] * 10)}" height="${100 + (stampCounts[2] * 10)}">
        <p>
        <strong>チャレンジ</strong>
        </p> 
   </div> 

   <div class="stamp3">
    <img src="images/goal.png" width="${100 + (stampCounts[3] * 10)}" height="${100 + (stampCounts[3] * 10)}">
        <p>
        <strong>ゴール</strong>
        </p> 
   </div> 

   <div class="stamp4">
     <img src="images/kyouryoku.png" width="${100 + (stampCounts[4] * 10)}" height="${100 + (stampCounts[4] * 10)}">
        <p>
        <strong>きょうりょく</strong> 
        </p> 
   </div> 

   <div class="stamp5">
     <img src="images/syusseki.png" width="${100 + (stampCounts[0] * 10)}" height="${100 + (stampCounts[0] * 10)}" >
        <p>
        <strong>しゅっせき</strong> 
        </p>
   </div> 

   <div class="stamp6">
     <img src="images/sonota.png" width="100" height="100" >
        <p>
        <strong>そのた</strong>
        </p> 
   </div> 
  </div> 
</main>
<!-- メインここまで -->

<!-- フッター -->
<footer class="student_footer">
<div class="flower">
	<img src="images/sunflower.png" width="350" height="350" alt="花のイラスト" class="flower_img">
</div>
<img src="images/tuchi.png" width="1500" height="150" alt="土のイラスト" class="ground_img">

</footer>
<!-- フッターここまで -->

<!-- javascript開始 -->
<script src="${pageContext.request.contextPath}/js/student_result.js"></script>
<!-- javascript終了 -->

</body>
</html>