<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--岩本 --%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>教師のリスト作成｜できたねスタンプ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/create_list.css">
<script src="<%=request.getContextPath()%>/js/create_list.js?v=1"></script>
</head>

<body>
<!-- ヘッダー -->
 <header class="header">
   <a href="StampServlet"><img src="${pageContext.request.contextPath}/images/logo.png" width="100" height="100"></a>
   <div class="left">
      <h1>できたねスタンプ</h1>
      <p>児童のがんばりを記録しよう</p>
   </div>
    <nav class="nav">
        <ul>
            <li><a href="StampServlet">スタンプ一覧</a></li>
            <li><a href="CreateListServlet">リスト作成</a></li>
            <li><a href="HwCheckServlet">宿題チェック</a></li>
            <li><a href="StudentInfoServlet">スタンプ数/リアクション</a></li>
        </ul>    
    </nav>
   <div class="right">
      <a href="LoginServlet" class="logout"><span class="logout-icon"><img src="${pageContext.request.contextPath}/images/logout.png" width="30" height="30"></span>ログアウト</a> 
   </div>
 </header>
<!-- ヘッダーここまで -->
	
	<main>
		<section>
			<h2 id="today"></h2><h3>児童の持ち物と宿題を管理しましょう</h3>
		</section>
		<section class="list-area">
			<%--もちもの --%>
			<div class="item-list">

				<div class="item-header">
					<h3>もちもの</h3>
				</div>
				<div class="item-body">
					<ul>
						<c:forEach var="item" items="${itemList}">
							<li><c:out value="${item.item_name}" />
								<button type="button" onclick="deleteItem(this)">
									<img src="${pageContext.request.contextPath}/images/gomibako.png" width="15" height="15">
								</button>
							</li>
						</c:forEach>
					</ul>
					
					<div class="item-input">
						<input type="text" id="itemText" placeholder="もちものを入力">
						<button type="button" onclick="addItem()">追加</button>
					</div>
					
					<br>
					
					<%--もちもの更新 --%>
					<div class="item-update">
						<button type="button" onclick="updateListItem()">
							🔄 リスト更新
						</button>
					</div>
				</div>
			</div>
			
			<%--しゅくだい --%>
			<div class="hw-list">

				<div class="hw-header">
					<h3>しゅくだい</h3>
				</div>

				<div class="hw-body">
					<ul>
						<c:forEach var="hw" items="${hwList}">
							<li><c:out value="${hw.homework_name}" />
								<button type="button" onclick="deleteItem(this)">
									<img src="${pageContext.request.contextPath}/images/gomibako.png" width="15" height="15">
								</button>
							</li>
						</c:forEach>
					</ul>
					
					<div class="hw-input">
						<input type="text" id="hwText" placeholder="しゅくだいを入力">
						<button type="button" onclick="addHw()">追加</button>
					</div>
					
					<br>
					
					<%--しゅくだい更新 --%>
					<div class="hw-update">
						<button type="button" onclick="updateListHw()">
							🔄 リスト更新
						</button>
					</div>
				</div>
			</div>
		</section>
	</main>
</body>
<script>
'use strict';
//もちもの追加//
function addItem() {
	const input = document.getElementById("itemText");
	const text = input.value;
	
	if(text.trim() === ""){
		return;
	}

	const ul = document.querySelector(".item-body ul");
	const li = document.createElement("li");

	li.innerHTML = text + ' <button onclick="deleteItem(this)"><img src="${pageContext.request.contextPath}/images/gomibako.png" width="15" height="15"></button>';
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

	li.innerHTML = text + ' <button onclick="deleteItem(this)"><img src="${pageContext.request.contextPath}/images/gomibako.png" width="15" height="15"></button>';
	ul.appendChild(li);
	
	input.value = "";
}
</script>

</html>