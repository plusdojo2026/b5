'use strict';

//日付の表示(js)

const now = new Date();

const month = now.getMonth() + 1;
const day = now.getDate();

document.getElementById('today').textContent =
    `${month}月${day}日`;