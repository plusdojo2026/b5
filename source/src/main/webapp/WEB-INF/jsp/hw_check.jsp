<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>                                                                       <%--岩本 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿題チェック</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/hw_check.css">
<script src="<%=request.getContextPath()%>/js/check_hw.js?v=1"></script>
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

<main class="hw-check-main">

    <!-- 左側 -->
    <div class="hw-list-area">
        <section class="hw-title">
            <h1>宿題チェック</h1>
            <p>宿題を選択して提出物のチェックができます</p>
        </section>
        <div class="date-select">
            <label>日付</label>
            <select>
                <option>2026年6月20日</option>
            </select>
        </div>
        <div class="hw-list-box">
            <ul class="hw-list">
                <li class="hw-item">
                    けいさんドリル（P84～98）
                </li>
            </ul>
        </div>
    </div>

    <!-- 右側 -->
    <div class="student-check-area">
        <h2 class="selected-hw">
              6月19日（金）けいさんドリル（P84～98）
        </h2>
        <div class="student-box">
            <h3 class="student-title">
                児童名一覧（全体を一括選択済み）
            </h3>
            <p class="student-guide">
                →未提出の児童の選択を外して完了をクリック
            </p>
            <div class="student-list">
                <label class="student-item">
                    <input type="checkbox" checked>
                    山田 太郎
                </label>
                <label class="student-item">
                    <input type="checkbox" checked>
                    鈴木 花子
                </label>
            </div>
        </div>
        <button class="complete-btn">
            完了
        </button>
    </div>
</main>
</body>
</html>