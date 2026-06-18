//更新//
function updateList() {

    const result = confirm("児童、保護者の画面に反映されます。\n更新してよろしいですか？");

    if(result){

        const now = new Date();

        const hour = now.getHours().toString().padStart(2, "0");
        const minute = now.getMinutes().toString().padStart(2, "0");

        document.getElementById("lastUpdate").innerHTML =
            "最終更新：" + hour + ":" + minute;

        alert("リストを更新しました！");
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
//もちもの追加//
function addItem() {

    const input = document.getElementById("itemText");

    const text = input.value;
    
     if(text.trim() === ""){
        return;
    }

    const ul = document.querySelector(".item-body ul");

    const li = document.createElement("li");

    li.innerHTML =
    text +
    ' <button onclick="deleteItem(this)">🚮</button>';
    
    ul.appendChild(li);

    input.value = "";
}

//しゅくだい追加//
function addHw() {

    const input = document.getElementById("hwText");

    const text = input.value;
    
      if(text.trim() === ""){
        return;
    }

    const ul = document.querySelector(".hw-body ul");

    const li = document.createElement("li");

    li.innerHTML =
    text +
    ' <button onclick="deleteItem(this)">🚮</button>';
    
    ul.appendChild(li);

    input.value = "";
}
//削除ボタン（ゴミ箱）//
function deleteItem(button) {

    button.parentElement.remove();

}