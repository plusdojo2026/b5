<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席一覧|できたねスタンプ</title>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/stamp.css">
</head>
<body>
	<div class="seat_area">

   <table class="seat_table">

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
    
    <div class="bottom_area">
        <div class="teacher_desk">教卓</div>

        <button class="ok_btn">OK</button>
    </div>
    
    <script>

const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});

</script>
</body>
</html>

