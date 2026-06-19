<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席一覧|できたねスタンプ</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stamp.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/student_info.css">      
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
	<div class="seat_area">

   <table id="seat_map" class="seat_table">

    <tr>
        <td><input type="button" value="伊藤" class="seat_btn"></td>
        <td><input type="button" value="佐々木" class="seat_btn"></td>
        <td><input type="button" value="田中" class="seat_btn" ></td>
        <td><input type="button" value="浜田" class="seat_btn" ></td>
        <td><input type="button" value="宮本" class="seat_btn" ></td>
        <td><input type="button" value="山崎" class="seat_btn" ></td>
    </tr>

    <tr>
        <td><input type="button" value="井上" class="seat_btn" ></td>
        <td><input type="button" value="斎藤" class="seat_btn" ></td>
        <td><input type="button" value="高橋" class="seat_btn" ></td>
        <td><input type="button" value="畑野" class="seat_btn" ></td>
        <td><input type="button" value="三浦" class="seat_btn" ></td>
        <td><input type="button" value="山本" class="seat_btn" ></td>
    </tr>

    <tr>
        <td><input type="button" value="石井" class="seat_btn" ></td>
        <td><input type="button" value="小林" class="seat_btn" ></td>
        <td><input type="button" value="鈴木" class="seat_btn" ></td>
        <td><input type="button" value="橋本" class="seat_btn" ></td>
        <td><input type="button" value="松本" class="seat_btn" ></td>
        <td><input type="button" value="山田" class="seat_btn" ></td>
    </tr>

    <tr>
        <td><input type="button" value="池田" class="seat_btn "></td>
        <td><input type="button" value="木村" class="seat_btn "></td>
        <td><input type="button" value="清水" class="seat_btn" ></td>
        <td><input type="button" value="中村" class="seat_btn" ></td>
        <td><input type="button" value="藤本" class="seat_btn" ></td>
        <td><input type="button" value="山口" class="seat_btn" ></td>
    </tr>
	
	<tr>
        <td><input type="button" value="阿部" class="seat_btn" ></td>
        <td><input type="button" value="加藤" class="seat_btn" ></td>
        <td><input type="button" value="佐藤" class="seat_btn" ></td>
        <td><input type="button" value="中島" class="seat_btn" ></td>
        <td><input type="button" value="藤田" class="seat_btn" ></td>
        <td><input type="button" value="森田" class="seat_btn" ></td>
    </tr>
</table>

    </div>
    <!-- 教卓 -->
        <div class="teacher_desk">教卓</div>
        
	<!-- OKボタン -->
	<div class="okArea">
        <button id="ok_btn">OK</button>
    </div>
    
    <script>

    'use strict';

  //日付の表示(js)

  const now = new Date();

  const month = now.getMonth() + 1;
  const day = now.getDate();
  const weekdays = ["日", "月", "火", "水", "木", "金", "土"];

  document.getElementById('today').textContent =
      `${month}月${day}日(${weekdays[now.getDay()]})`;
    
    /* 児童の座席選択 */
    window.onload = function(){

       const attendBtn = document.getElementById("attendBtn");
       const seat_map = document.getElementById("seat_map");
       const okBtn = document.getElementById("okBtn");

       // 出席ボタン
       attendBtn.onclick = function(){
           seat_map.style.display = "block";
       };

       // OKボタン
       okBtn.onclick = function(){
           seat_map.style.display = "none";
       };

   };
    
const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});

</script>
</body>
</html>

