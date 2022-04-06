<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main3</title>
</head>
<body>


${userNo } <br>
<c:forEach var="result" items="${resultList}" varStatus="status">
${result.user_id } <br>
${result.user_pw }
</c:forEach>
${userPw }
</body>
</html>