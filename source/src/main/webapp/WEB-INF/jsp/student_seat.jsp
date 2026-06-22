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
    <c:forEach var="s" items="${StudentsData}">
    	<label class="seat_card">
    		<input type="checkbox" name="student" value="${s.id}" style="display: none;">
			<span class="seat_btn">${s.name}</span>
		</label>
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

</body>
</html>