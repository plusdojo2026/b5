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

window.onload = function() {

    const now = new Date();

    const week = ["日","月","火","水","木","金","土"];

    const month = now.getMonth() + 1;
    const day = now.getDate();
    const dayOfWeek = week[now.getDay()];

    document.getElementById("today").innerHTML =
        month + "月" + day + "日（" + dayOfWeek + "）";
};

function addItem() {

    const input = document.getElementById("itemText");

    const text = input.value;

    if(text === ""){
        alert("もちものを入力してください");
        return;
    }

    const ul = document.querySelector(".item-body ul");

    const li = document.createElement("li");

    li.innerHTML = text + " <button>🚮</button>";

    ul.appendChild(li);

    input.value = "";
}

function addHw() {

    const input = document.getElementById("hwText");

    const text = input.value;

    if(text === ""){
        alert("しゅくだいを入力してください");
        return;
    }

    const ul = document.querySelector(".hw-body ul");

    const li = document.createElement("li");

    li.innerHTML = text + " <button>🚮</button>";

    ul.appendChild(li);

    input.value = "";
}