'use strict';

/*座席ボタンクリック*/
const seats = document.querySelectorAll(".seat_btn");

seats.forEach(seat => {

    seat.addEventListener("click", function(){

        this.classList.toggle("selected");

    });

});
