<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席表｜できたねスタンプ</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/student_seat.css?v=9999">
</head>
<body>
<input type="button" value="出席" id="attendBtn">


<!-- 生徒の座席はデータベースから引っ張ってくる -->
<form method="POST" action="StudentSeatServlet">

<div class="seat_area">

<c:forEach var="s" items="${StudentsData}">
    <label class="seat_card">
        <input type="checkbox" name="student" value="${s.id}">
        <span>${s.name}</span>
    </label>
</c:forEach>

</div>

<div class="okArea">
    <input type="submit" value="OK" class="ok_btn">
</div>

</form>
</body>
</html>