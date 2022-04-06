<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Border</title>

<script type="text/javascript">
	function movePage(pageNo) {
		location.href="<%=request.getContextPath()%>/borderList.do?pageNo="+pageNo;
	}
</script>

<style>
	table {
		broder-collapse: collapse;
		margin: 100px auto;
		width: 800px;
		heigth: auto;
	}
	
	table, th, td {
		border: 1px solid black;
	}
	
	tr {
		height: 34px;
	}
	
	.col1 {
		width: 65px;
	}
	.col2 {
		width: 385px;
	}
	.col3 {
		width: 85px;
	}
	
	a {
		color: black;
		text-decoration: none;
	}
	
</style>
</head>
<body>

<table>
	<tr>
		<th class="col1">번호</th>
		<th class="col2">제목</th>
		<th class="col3">닉네임</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>

	<c:forEach var="resultList" items="${resultList }">
		<tr align="center">
			<td>${resultList.borderid }</td>
			<td align="left"><a href="borderDetail.do?borderid=${resultList.borderid}"><c:forEach begin="1" end="${resultList.groupTab }" step="1">RE:</c:forEach>${resultList.title }</a></td>
			<th>${resultList.nickname }</th>
			<th>${resultList.writeday }</th>
			<th>${resultList.seecount }</th>
		</tr>
	</c:forEach>
	
 	<tr style="height:30px;">
		<td colspan="5" style="text-align:center;">
		<ui:pagination paginationInfo = "${paginationInfo }"
		type="image"
		jsFunction="movePage"/>
		<a href="borderWrite.do"><input type="button" value="글쓰기"></a>
	</tr>
</table>
</body>
</html>