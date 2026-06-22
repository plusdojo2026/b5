<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- JSTLのforEachタグを使うための設定 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>座席表｜できたねスタンプ</title>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/student_seat.css?v=123456">
</head>

<body>
<input type="button" value="出席" id="attendBtn">

<!-- ======================================================
     座席表フォーム
     OKボタンを押したときに選択した児童情報を、StudentSeatServletへ送信する
====================================================== -->
<form method="POST" action="StudentSeatServlet">

<!-- ==================================================
     座席エリア
     生徒一覧をカード形式で表示する
=================================================== -->
<div class="seat_area">

    <!--
        StudentsDataの中身を1件ずつ取り出す
        var="s"
        → 取り出した生徒1人分をsとして扱う
        例)s.id   → 生徒ID
       		 s.name → 生徒名
    -->
    
    
<!-- 生徒1人分の座席カード -->
	<c:forEach var="s" items="${StudentsData}">
    	<button type="button"
            class="seat_btn"
            data-id="${s.id}">
        ${s.name}
    	</button>
	</c:forEach>
    
</div>

<!-- ==================================================
     OKボタンを押すと、選択した児童が誰なのかををサーブレットへ送信
=================================================== -->
<div class="okArea">
    <!-- フォーム送信ボタン -->
    <input type="submit"
           value="OK"
           class="ok_btn">
</div>


</form>
<script src="<%=request.getContextPath()%>/js/student_seat.js?v=1"></script>
</body>
</html>