<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン｜できたねスタンプ</title>
</head>

<body>

<h1>ログイン / ユーザー登録</h1>
<p>あなたの立場を選んで、ログインしてください。</p>

<form action="LoginServlet" method="POST" class="login_form">
	<div class="type_select">
		<label class="type_option">
			<input type="radio" name="user_type" value="teacher" checked>
			<img src="" alt="教師のアイコン" class="type">
			<span class="type_text">教師</span>
		</label>

		<label class="type_option">
			<input type="radio" name="user_type" value="student">
			<img src="" alt="児童のアイコン" class="type">
			<span class="type_text">児童</span>
		</label>

		<label class="type_option">
			<input type="radio" name="user_type" value="parent">
			<img src="" alt="保護者のアイコン" class="type">
			<span class="type_text">保護者</span>
		</label>
	</div>

	<div class="input_area">
		<div class="input_group">
			<div class="input_icon">
				<img src="" alt="IDアイコン">
			</div>
			<div class="input_text">
				<label for="login_id">ログインID</label>
				<input type="text" id="login_id" name="login_id" placeholder="IDを入力してください。">
			</div>
		</div>
		<div class="input_group">
			<div class="input_icon">
				<img src="" alt="パスワードアイコン">
			</div>
			<div class="input_text">
				<label for="login_pass">パスワード</label>
				<input type="text" id="login_pass" name="login_pass" placeholder="パスワードを入力してください。">
			</div>
		</div>
		<button type="submit" class="submit_button">ログイン</button>
	</div>
</form>

</body>
</html>