<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${userid } <br>
${userpw } <br>
<%=request.getSession().getAttribute("user_id").toString() %> 님이 로그인했습니다.
<input type="button" value="가자" onclick="location = 'borderList.do'">
</body>
</html>