
'use strict'

const now = new Date();

const month = now.getMonth() + 1;
const day = now.getDate();
const weekdays = ["にちようび", "げつようび", "かようび", "すいようび", "もくようび", "きんようび", "どようび"];

document.getElementById('today').textContent =
    `${month}がつ${day}にち(${weekdays[now.getDay()]})`;

document.getElementById('today2').textContent =
    `${month}がつ`+ "のがんばり";    
    
    
