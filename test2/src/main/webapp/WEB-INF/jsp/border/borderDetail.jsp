<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>목록 상세보기</title>
<script>

function init() {
	if("${result.nickname}" != "${userid}") {
		$("#modify").hide();
		$(".delete").hide();
	}
}

function modifyDo() {
	
	location.href="borderModify.do?borderid=${result.borderid}"
}

function deleteDo() {
	location.href="borderDelete.do?borderid=${result.borderid}&group_tab=${result.group_tab}"
}

</script>

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
<body onload="init()">

<table class="mytable">
	<tr>
		<td class="td1">작성자</td>
		<td class="td2">${result.nickname }</td>
	</tr>
	<tr>
		<td class="td1">제목</td>
		<td><input type="text" class="td2" name="title" readonly value="${result.title }"></td>
	</tr>
	<tr>
		<td class="td1 td3">내용</td>
		<td><textarea class="td2 mytextarea" name="mytextarea" readonly>${result.bordertext }</textarea></td>
	</tr>
	<tr>
		<td class="td1">파일</td>
		<td><a href="${result.fileurl }">파일 다운로드</a></td> <!-- <img src>는 이미지 바로보기 --> <!-- <a href>는 다운로드 받기 -->
	</tr>
	<tr>
		<td colspan="2" class="td4">
		<!-- javascript로 사용자에게 안보여지게 처리필요. -->
			<input id = "modify" type="button" value="수정" onclick="modifyDo()">
			<input class = "delete" type="button" value="삭제" onclick="deleteDo()">
			<a href="borderReply.do?borderid=${result.borderid }"><input type="button" value="답글"></a>
			<a href="borderList.do"><input type="button" value="목록보기"></a>
		</td>
	</tr>
</table>

</body>
</html>