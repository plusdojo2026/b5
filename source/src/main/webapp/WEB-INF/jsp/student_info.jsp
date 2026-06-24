<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student_info.css">
<title>児童情報 | できたねスタンプ</title>
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


<!-- 児童のスタンプ獲得数画面開始 -->
<main>
  <!-- 日付の表示 -->
  <div class="calendar">
     <img src="${pageContext.request.contextPath}/images/calendar.png" width="50" height="50"><p id="today"></p>
  </div>
  
<!-- ★↓選択した児童の名前(Servletとかと結びつける)↓ -->
<h2>選択した児童のスタンプ獲得数を表示します</h2>
<div class="select-area">
	<form action="StudentInfoServlet" method="GET">
		<label class="selectbox">
			<select id="studentselect" name="student_id" onchange="this.form.submit()">
				<option value="" disabled <c:if test="${empty selectedStudentId}">selected</c:if>>児童を選択</option>
				
				<c:forEach var="student" items="${studentList}">
					<option value="${student.id}" <c:if test="${student.id == selectedStudentId}">selected</c:if>>
						${student.name}
					</option>
				</c:forEach>
			</select>
		</label>
	</form>
</div>
  
 <!-- ★検索した児童のスタンプ保持数表示させる-->
  <div class="stamps"> 
   <div class="stamp1">
     <img src="${pageContext.request.contextPath}/images/hatugen.png" width="150" height="150" >
        <p>
        <strong>積極的な発言</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[1] : 0}個</span> 
        </p> 
   </div> 

   <div class="stamp2">
     <img src="${pageContext.request.contextPath}/images/challenge.png" width="150" height="150" >
        <p>
        <strong>挑戦</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[2] : 0}個</span>
        </p> 
   </div> 

   <div class="stamp3">
    <img src="${pageContext.request.contextPath}/images/goal.png" width="150" height="150">
        <p>
        <strong>達成</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[3] : 0}個</span>
        </p> 
   </div> 

   <div class="stamp4">
     <img src="${pageContext.request.contextPath}/images/kyouryoku.png" width="150" height="150">
        <p>
        <strong>協力</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[4] : 0}個</span>
        </p> 
   </div> 

   <div class="stamp5">
     <img src="${pageContext.request.contextPath}/images/syusseki.png" width="150" height="150" >
        <p>
        <strong>出席</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[0] : 0}日</span>
        </p>
   </div> 

   <div class="stamp6">
     <img src="${pageContext.request.contextPath}/images/sonota.png" width="150" height="150" >
        <p>
        <strong>その他</strong><br>
        <span class="stamplog">${stampCounts != null ? stampCounts[5] : 0}個</span>
        </p> 
   </div> 
  </div> 
<!-- 児童のスタンプ獲得数画面終了 -->


<!-- 保護者からのリアクション画面開始 -->
 <h2>保護者からのリアクションを確認できます</h2>
	<div class="reactions">
	   <dive class="reaction1">
	    <img src="${pageContext.request.contextPath}/images/nikkori.png" width="100" height="100">
	        <p class="tuuchi">
	        <strong>（仮）６月１２日の積極的な発言スタンプにリアクションしました</strong><br>
	        <span class="date"><img src="${pageContext.request.contextPath}/images/clock.png" width="20" height="20">（仮）6月14日14：30</span> 
	        </p> 
	   </dive>   
	</div> 
</main>
<!-- 保護者からのリアクション画面終了 -->


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