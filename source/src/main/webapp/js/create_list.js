'use strict';

//もちものリスト更新
function updateListItem() {
	const result = confirm(
		"もちものリストが児童、保護者の画面に反映されます。\n更新してよろしいですか？"
	);

	if (result) {
		const form = document.createElement('form');
		form.method = 'POST';
		form.action = 'CreateListServlet'; // 送信先のServle
		
		const typeInput = document.createElement('input');
		typeInput.type = 'hidden';
		typeInput.name = 'update_type';
		typeInput.value = 'item';
		form.appendChild(typeInput);
		
		// 画面の <ul> の中にあるすべての <li> を取得
		const lis = document.querySelectorAll(".item-body ul li");
		for (const li of lis) {
			const text = li.childNodes[0].textContent.trim();
			
			if (text !== "") {
				const input = document.createElement('input');
				input.type = 'hidden';
				input.name = 'item_name';
				input.value = text;
				form.appendChild(input);
			}
		}

		document.body.appendChild(form);
		form.submit();
	}
}

//しゅくだいリスト更新
function updateListHw() {
	const result = confirm(
		"しゅくだいリストが児童、保護者の画面に反映されます。\n更新してよろしいですか？"
	);

	if (result) {
		const form = document.createElement('form');
		form.method = 'POST';
		form.action = 'CreateListServlet';
		
		const typeInput = document.createElement('input');
		typeInput.type = 'hidden';
		typeInput.name = 'update_type';
		typeInput.value = 'hw';
		form.appendChild(typeInput);
		
		const lis = document.querySelectorAll(".hw-body ul li");
		
		for (const li of lis) {
			const text = li.childNodes[0].textContent.trim();
			if (text !== "") {
				const input = document.createElement('input');
				input.type = 'hidden';
				input.name = 'hw_name'; // しゅくだい用は "hw_name" で送る
				input.value = text;
				form.appendChild(input);
			}
		}

		document.body.appendChild(form);
		form.submit();
	}
}

//日付と曜日//
window.onload = function() {
	const now = new Date();
	const week = ["日","月","火","水","木","金","土"];
	const month = now.getMonth() + 1;
	const day = now.getDate();
	const dayOfWeek = week[now.getDay()];

	document.getElementById("today").innerHTML =
		month + "月" + day + "日（" + dayOfWeek + "）";
};



//削除ボタン（ゴミ箱）//
function deleteItem(button) {
	button.parentElement.remove();
}