<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
function add() {
	location.href = "<c:url value='/mgmt.do'/>";
}

function view() {
	
	location.href = "<c:url value='/view.do'/>";
}

function setPwd(userid) {
	
	if(userid=="admin"){
		$('#password').val('manager');
	} else if(userid=="guest") {
		$('#password').val('guest');
	} else if(userid=="guest2") {
		$('#password').val('guest2');
	}
}

function check() {
	
	if($('#userid').val() == ''){
		alert("아이디를 입력하세요.");
		return false;
	}
	if($('#password').val() == '') {
		alert("패스워드를 입력하세요.");
		return false;
	}
	return true;
}
</script> 
</head>
<body> 

 <div class="container">
	<h1>메인화면</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
			<form class="form-inline" action="/login.do">
				<div class="form-group">
					<label for="id">ID:</label>
					<select class="form-control" id="userid" name="userid" onchange="setPwd(this.value);">
						<option value="">선택하세요</option>
						<option value="admin">관리자</option>
						<option value="guest">사용자</option>
						<option value="guest2">사용자2</option>
					</select>
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password">
				</div>
				<button type="submit" class="btn btn-default" onclick="return check()">로그인</button>
			</form>
		</div>
		<div class="panel-body">
			<form action="/search.do">
				<div class="form-group">
					<label for="searchName">제목(내용):</label>
					<input type="text" class="form-control" id="searchName">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>게시물번호</th>
							<th>제목</th>
							<th>조회수</th>
							<th>등록자</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="javascript:view()">1</a></td>
							<td><a href="javascript:view()">안녕하세요</a></td>
							<td>1</td>
							<td>관리자</td>
							<td>2018-12-15</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel-footer">
			<button type="button" class="btn btn-default" onclick="add();">등록</button>
		</div>
	</div>
</div>


</body>
</html>