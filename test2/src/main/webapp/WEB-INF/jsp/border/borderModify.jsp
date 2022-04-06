<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>목록 상세보기</title>
<style>
	.mytable
		{
			border: 1px solid black;
			width: 800px;
			margin: 50px auto 0px auto;
		}
		
		.mytable .td1
		{
			width: 100px;
		}
		.mytable .td2
		{
			width: 700px;
		}
		.mytable .td3
		{
			vertical-align: 0px;
		}
		.mytable .td4
		{
			text-align: center;
		}
		.mytable .mytextarea
		{
			height: 500px;
			resize: none;
		}
</style>
</head>
<body>

<form action="borderModifyReq.do" method="post">
	<input type="hidden" name="borderid" value="${result.borderid }">
	<table class="mytable">
		<tr>
			<td class="td1">작성자</td>
			<td class="td2">${result.nickname }</td>
		</tr>
		<tr>
			<td class="td1">제목</td>
			<td><input type="text" class="td2" name="title" value="${result.title }"></td>
		</tr>
		<tr>
			<td class="td1 td3">내용</td>
			<td><textarea class="td2 mytextarea" name="bordertext">${result.bordertext }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" class="td4">
			<!-- javascript로 사용자에게 안보여지게 처리필요. -->
				<input type="submit" value="변경">
				<input type="button" value="삭제">
				<a href="borderReply.do?borderid=${result.borderid }"><input type="button" value="답글"></a>
				<a href="borderList.do"><input type="button" value="목록보기"></a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>