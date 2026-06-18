/**
 * 
 */
 
 /* 児童の座席選択 */
const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});