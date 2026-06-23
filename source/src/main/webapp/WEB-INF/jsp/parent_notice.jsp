<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>保護者の通知|できたねスタンプ</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/parent_notice.css">
</head>
<body>


<!-- ヘッダー -->
<header class="header">
    <div class="name">"${studentData.name}"さん</div>
</header>
		
<!-- メイン -->
<main>

<!-- 保護者のリアクション画面開始 -->    
  <!-- ★スタンプを付与した日を表示する -->
  
<div class="lists">
<c:set var="beforTime" value=""/>
	<c:forEach var="log" items="${stLog}">	
		<c:if test="${log.created_at != beforTime}">
			<div class="update-date">${log.created_at}</div>
			<c:set var="beforTime" value="${log.created_at}"/>
		</c:if>
		<div class="list">
			<c:choose>
				<c:when test="${log.stamp_id == 1}">
					<img src="${pageContext.request.contextPath}/images/hatugen.png" width="80" height="80">積極的な発言をしました！<br>
				</c:when>
				<c:when test="${log.stamp_id == 2}">
					<img src="${pageContext.request.contextPath}/images/challenge.png" width="80" height="80">挑戦しました！<br>
				</c:when>
				<c:when test="${log.stamp_id == 3}">
					<img src="${pageContext.request.contextPath}/images/goal.png" width="80" height="80">達成しました！<br>
				</c:when>
				<c:when test="${log.stamp_id == 4}">
					<img src="${pageContext.request.contextPath}/images/kyouryoku.png" width="80" height="80">協力しました！<br>
				</c:when>
				<c:when test="${log.stamp_id == 5}">
					<img src="${pageContext.request.contextPath}/images/syusseki.png" width="80" height="80">元気に出席しました！<br>
				</c:when>
				<c:when test="${log.stamp_id == 6}">
					<img src="${pageContext.request.contextPath}/images/sonota.png" width="80" height="80">その他<br>
					<c:out value="${log.text}" />
				</c:when>
			</c:choose>
		</div>
		
		<form class="reaction-form" action="ParentNoticeServlet" method="POST">
			<input type="hidden" name="id" value="${log.id}">
			
			<c:choose>
				<%-- まだリアクションがされていない場合（値が空、または0などの条件） --%>
				<c:when test="${log.reaction_id == 0 || empty log.reaction_id}">
					<button type="submit" name="reaction_id" value="1" class="reaction-btn">
					<img src="${pageContext.request.contextPath}/images/good.png" width="30" height="30" alt="good"/>
				</button>
				<button type="submit" name="reaction_id" value="2" class="reaction-btn">
					<img src="${pageContext.request.contextPath}/images/pien.png" width="30" height="30" alt="pien"/>
				</button>
				<button type="submit" name="reaction_id" value="3" class="reaction-btn">
					<img src="${pageContext.request.contextPath}/images/bikkuri.png" width="30" height="30" alt="bikkuri"/>
				</button>
				<button type="submit" name="reaction_id" value="4" class="reaction-btn">
					<img src="${pageContext.request.contextPath}/images/nikkori.png" width="30" height="30" alt="nikkori"/>
				</button>
				</c:when>
				
				<%-- 既にリアクションされている場合 --%>
				<c:otherwise>
					<button type="button" class="reaction-btn" disabled>
						<img src="${pageContext.request.contextPath}/images/good.png" width="30" height="30" alt="good" class="reacted-icon"/>
					</button>
					<button type="button" class="reaction-btn" disabled>
						<img src="${pageContext.request.contextPath}/images/pien.png" width="30" height="30" alt="pien" class="reacted-icon"/>
					</button>
					<button type="button" class="reaction-btn" disabled>
						<img src="${pageContext.request.contextPath}/images/bikkuri.png" width="30" height="30" alt="bikkuri" class="reacted-icon"/>
					</button>
					<button type="button" class="reaction-btn" disabled>
						<img src="${pageContext.request.contextPath}/images/nikkori.png" width="30" height="30" alt="nikkori" class="reacted-icon"/>
					</button>
				</c:otherwise>
			</c:choose>
		</form>	
	</c:forEach>
</div>
	
    <p>持ち物リストが更新されました！</p>

<!-- 保護者のリアクション画面終了 --> 

</main>
        
<!-- フッター開始 -->	
<footer>
 <div class = "footer-icon">
	<form action="ParentNoticeServlet" method="POST">  
        <button type="submit" name="button" value="notice">
         <img src= "${pageContext.request.contextPath}/images/p_notice2.png" width="30" height="30" alt = "通知画面">
        </button>
		
	</form>
	<form action="ParentViewServlet" method="POST">
		<button type="submit" name="button" value="lists">
		        <img src= "${pageContext.request.contextPath}/images/p_list1.png" width="30" height="30" alt = "リスト画面">
	    </button>
	</form>
	</div>
</footer>
<!-- フッター終了 -->
 

</body>
</html>