<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>座席表｜できたねスタンプ</title>
</head>
<body>

<form method="POST" action="StudentSeatServlet">
<c:forEach var="s" items="${StudentsData}">
	<input type="checkbox" name="student" value="${s.id}">
	<label for="name">${s.name}</label>
</c:forEach>
<input type="submit" value="OK">
</form>

</body>
</html>