/**
 * 
 */
 
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
    
 /* 児童の座席選択 */
const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});