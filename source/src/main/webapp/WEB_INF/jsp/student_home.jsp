<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム（児童）｜できたねスタンプ</title>
</head>
<body>

<header class="student_header">
	
	<div class="sun">
		<img src="" alt="太陽の画像" class="sun_img">
	</div>
	
	<div class="date">
		<img src="" alt="雲の画像" class="cloud_img">
		<p class="date_text">6がつ11にち<br>もくようび</p>
	</div>
		<div class="result">
		<a href="student_result.jsp" class="sutudent_result">
			<img src="" alt="雲の画像" class="cloud_img">
			<span class="result_text">がんばりをみてみよう</span>
		</a>
	</div>
</header>
<main class="student_main">
<section>
<%---------------------------もちもの ----------------------------%>
<div>
	<h3>もちものリスト</h3>
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
</main>
<footer class="student_footer">
<div class="flower">
	<img src="" alt="花のイラスト" class="flower_img">
</div>
<img src="" alt="土のイラスト" class="ground_img">
</footer>
</body>
</html>