/**
 * 
 */
 'use strict';
 
 window.onload = function() {
//日付と曜日//
    const now = new Date();

    const week = ["日","月","火","水","木","金","土"];

    const month = now.getMonth() + 1;
    const day = now.getDate();
    const dayOfWeek = week[now.getDay()];

    document.getElementById("today").innerHTML =
        month + "月" + day + "日（" + dayOfWeek + "）";
 
 /* 児童の座席選択 */
    const attendBtn = document.getElementById("attendBtn");
    const seat_map = document.getElementById("seat_map");
    const okBtn = document.getElementById("ok_btn");

	// 出席ボタン
    attendBtn.onclick = function(){
        seat_map.style.display = "block";
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