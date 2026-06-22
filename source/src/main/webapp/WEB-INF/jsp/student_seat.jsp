<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席表｜できたねスタンプ</title>
</head>
<body>
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
<form method="POST" action="StampServlet">
<c:forEach var="s" items="${StudentsData}">
	<input type="checkbox" name="student" value="${s.id}">
	<label for="name">${s.name}</label>
</c:forEach>
<input type="submit" value="OK">
</form>

</body>
</html>