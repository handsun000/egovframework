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
function back() {
	location.href = "<c:url value='/list.do'/>";
}
</script>
</head> 
<body> 


<div class="container">
	<h1>상세화면</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
			<label for="">안녕하세요</label>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" method="post" action="">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="idx">게시물아이디:</label>
			    <div class="col-sm-10 control-label" style="text-align:left;">
			      게시물 아이디
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="title">제목:</label>
			    <div class="col-sm-10 control-label" style="text-align:left;">
			      제목
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="write">등록자/등록일:</label>
			    <div class="col-sm-10 control-label" style="text-align:left;">
			      등록자/등록일
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="contents">내용:</label>
			    <div class="col-sm-10 control-label" style="text-align:left;">
			      내용
			    </div>
			  </div>
			</form>
		</div>
		<div class="panel-footer">
			<button type="button" class="btn btn-default">수정</button>
			<button type="button" class="btn btn-default">삭제</button>
			<button type="button" class="btn btn-default" onclick="back();">목록</button>
		</div>
	</div>
	<div class="well well-sm">작성자/작성일<br/>내용</div>
	<div class="well well-lg">
		<form class="form-horizontal" method="post" action="/reply.do">
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">작성자/작성일:</label>
				<div class="col-sm-10 control-label" style="text-align:left;">
					<input type="text" class="form-control" id="writer" name="writer" placeholder="등록자를 입력하세요" maxlength="15" style="float:left; width:30%">
					<input type="text" class="form-control" id="indate" name="indate" placeholder="등록일를 입력하세요" maxlength="10" style="float:left; width:30%">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="reply">댓글:</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="reply" name="reply" maxlength="300"></textarea>
				</div>
			</div>
			<button type="submit" class="btn btn-default">작성</button>
			*댓글은 수정이나 삭제를 할 수 없습니다.
		</form>
	</div>
</div>


</body>
</html>