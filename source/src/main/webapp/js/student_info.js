'use strict';

//日付の表示(js)

const now = new Date();

const month = now.getMonth() + 1;
const day = now.getDate();
const weekdays = ["日", "月", "火", "水", "木", "金", "土"];

document.getElementById('today').textContent =
    `${month}月${day}日(${weekdays[now.getDay()]})`;