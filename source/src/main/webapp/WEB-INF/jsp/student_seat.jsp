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
    href="<%=request.getContextPath()%>/css/student_seat.css">
</head>

<body>
<c:if test="${not empty errorMessage}">
	<p class="error-msg" style="color: red; font-weight: bold; text-align: center;">
		${errorMessage}
	</p>
</c:if>
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
    		<input type="checkbox" name="student" value="${s.id}" style="display: none;" <c:if test="${stamp_id == '1'}">checked</c:if>>
			<span class="seat_btn">${s.name}</span>
		</label>
    </c:forEach>
</div>

<!-- ==================================================
     OKボタンを押すと、選択した児童が誰なのかををサーブレットへ送信
=================================================== -->
<div class="okArea">
    <!-- フォーム送信ボタン -->
    <input type="submit" name="submit" value="キャンセル" class="ok_btn">
    <input type="submit" name="submit" value="OK" class="ok_btn">
</div>


</form>

</body>
</html>