<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>                                                                <%--岩本 --%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>教師のリスト作成｜できたねスタンプ</title>
<link rel="stylesheet"href="<%= request.getContextPath() %>/css/create_list.css?v=2">	
<script src="../../js/create_list.js"></script>	
</head>

<body>
<main>
 <section>
 		<h2>月　日（　）</h2>
 		<h3>児童の持ち物と宿題を管理しましょう</h3>
</section>
<section class="list-area">
<%----------------------------------------もちもの ----------------------------%>
	<div class="item-list">   
	   
		<div class="item-header" >       				<%-----------緑 ---------------------%>
			<h3>もちものリスト</h3>
		</div>
		
		<div class="item-body">							<%-----------白------------------- --%>
		<ul>
			<li>
					きゅうしょくセット
					<button>🚮</button>
			</li>
			
			<li>
					えのぐセット
					<button>🚮</button>
			</li>
			
			<li>
					すいとう（氷いっぱい）
					<button>🚮</button>
			</li>
		</ul>
		<div class=item-inpt>
		<input type="text" placeholder="もちものを入力">
		<button>追加</button>
</div>
		</div>
</div>

<%--------------------------------しゅくだい -----------------------------%>
<div class="hw-list">    
              
        <div class="hw-header" >       				<%-----------青---------------------%>
		<h3>しゅくだいリスト</h3>
		</div>
		
		<div class="hw-body">							<%-----------白------------------- --%>
		<ul>
				<li>
						かんじドリル
						<button>🚮</button>
				</li>
		</ul>
		<ul>
				<li>
						けいさんドリル
						<button>🚮</button>
				</li>
		</ul>
		<div class=hw-inpt>
		<input type="text" placeholder="しゅくだいを入力">
		<button>追加</button>
		</div>
		</div>
</div>		
</section>

<%--------------------------------リスト更新 -----------------------------%>
<section>
<div class="update-list">           
		<h3>リスト更新について</h3>

		<p>
		「リスト更新ボタンを押すと、児童と保護者の画面に最新の内容が反映されます。」
		</p>
		
		<button onclick="updateList()"><%--クリックされたらupdatelist()を実行してね--%>
		リスト更新
		</button>
		</div>
</section>
   </main>
</body>
</html>
