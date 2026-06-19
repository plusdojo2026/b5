/**
 * 
 */
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
    attendanceBtn.onclick = function(){
        seatArea.style.display = "block";
    };

    // OKボタン
    okBtn.onclick = function(){
        seat_map.style.display = "none";
    };

};
    
 /* 児童の座席選択 */
const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});