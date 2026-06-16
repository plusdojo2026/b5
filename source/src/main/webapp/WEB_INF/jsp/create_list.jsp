<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>                                                                <%--岩本 --%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>教師のリスト作成｜できたねスタンプ</title>
</head>
<body>

<main>
 <h1>持ち物リスト作成</h1>
 <h1>宿題リスト作成</h1>
 
 <section>
 		<h2>月　日（　）</h2>
 		<h3>児童の持ち物と宿題を管理しましょう</h3>
</section>


<section>
<%---------------------------もちもの ----------------------------%>
	<div>
			<h3>もちものリスト</h3>
			<button>追加</button>
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
</div>


<%----------------------しゅくだい -----------------------------%>
<div>
		<h3>しゅくだいリスト</h3>
		<button>追加</button>
		
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
</div>		
</section>


<section>
		<h3>リスト更新について</h3>

		<p>
		「リスト更新ボタンを押すと、児童と保護者の画面に最新の内容が反映されます。」
		</p>
		
		<button>リスト更新</button>
</section>

   </main>
</body>
</html>

