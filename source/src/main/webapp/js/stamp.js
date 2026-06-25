'use strict';

//日付の表示(js)

const now = new Date();

const month = now.getMonth() + 1;
const day = now.getDate();
const weekdays = ["日", "月", "火", "水", "木", "金", "土"];

document.getElementById('today').textContent =
    `${month}月${day}日(${weekdays[now.getDay()]})`;
    
function inputText(button) {
	
	let isInvalid = true;
	const MAX_LENGTH = 100;
	let text = null;
	while (isInvalid) {
	  // ポップアップを出してテキストを入力させる
		text = window.prompt("その他：コメントを入力してください");
		
		// 「キャンセル」が押された場合や、何も入力されなかった場合は処理を中断
		if (text === null || text.trim() === "") {
			return false;
		} else if (text.length > MAX_LENGTH) {
			window.alert("文字数が多すぎます。100文字以内で入力してください。");
		} else {
		    isInvalid = false; // 正しい文字数ならループ終了
		}
	}
	// 入力されたテキストをフォームに乗せるための「隠し入力欄（hidden）」を作る
	let hiddenInput = document.createElement("input");
	hiddenInput.type = "hidden";
	hiddenInput.name = "text";
	hiddenInput.value = text;
	
	// ボタンがあるフォーム（<form method="POST" action="StampServlet">）に隠し入力欄を追加
	button.form.appendChild(hiddenInput);
	
	// trueを返して、そのままStampServletへ送信（Submit）を続行する
	return true;
}