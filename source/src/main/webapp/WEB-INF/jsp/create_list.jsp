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
        </ul>    
    </nav>
   <div class="right">
      <a href="LoginServlet" class="login"><span class="login-icon"><img src="${pageContext.request.contextPath}/images/login.png" width="25" height="25"></span>ログイン</a> 
      <a href="" class="logout"><span class="logout-icon"><img src="${pageContext.request.contextPath}/images/logout.png" width="30" height="30"></span>ログアウト</a> 
      <a href="StudentInfoServlet"><span class="reaction"><img src="${pageContext.request.contextPath}/images/reaction.png" width="45" height="45"></span></a> 
   </div>
 </header>
<!-- ヘッダーここまで -->
	
	<main>
		<section>
			<h2 id="today"></h2><!--日付 -->
			<h3>児童の持ち物と宿題を管理しましょう</h3>
		</section>
		<section class="list-area">
		
<%--もちもの --%>
			<div class="item-list">

				<div class="item-header">
					<h3>もちもの</h3>
				</div>
				<div class="item-body">
					<ul>
						<li>きゅうしょくセット
							<button onclick="deleteItem(this)">
    						<img src="images/gomibako.png" width="15" height="15">
							</button>
						</li>
						<li>えのぐセット
							<button onclick="deleteItem(this)">
    						<img src="images/gomibako.png" width="15" height="15">
							</button>
						</li>
						<li>すいとう（氷いっぱい）
							<button onclick="deleteItem(this)">
    						<img src="images/gomibako.png" width="15" height="15">
							</button>
						</li>
					</ul>
					<div class=item-input>
						<input type="text" id="itemText" placeholder="もちものを入力">
						<button onclick="addItem()">追加</button>
					</div>
<%--もちもの更新 --%>					
					<div class="item-update">
    						<p id="lastUpdateItem">
        						最終更新：--
    						</p>
    				<button onclick="updateListItem()">
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
						<li>かんじドリル
							<button onclick="deleteItem(this)">
    						<img src="images/gomibako.png" width="15" height="15">
							</button>
						</li>
						<li>けいさんドリル
							<button onclick="deleteItem(this)">
    						<img src="images/gomibako.png" width="15" height="15">
							</button>
						</li>
					</ul>
					<div class=hw-input>
						<input type="text" id="hwText" placeholder="しゅくだいを入力">
						<button onclick="addHw()">追加</button>
					</div>
<%--しゅくだい更新 --%>								
					<div class="hw-update">
    				<p id="lastUpdateHw">
        					最終更新：--
    				</p>
    				<button onclick="updateListHw()">
        					🔄 リスト更新
    				</button>
					</div>
				</div>
			</div>
		</section>
	</main>
</body>
</html>