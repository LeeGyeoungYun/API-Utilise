<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add_postPage_style.css">
<title>게시물 작성 페이지</title>
</head>
<body>
	
	<form class="postContainer">
		<div class="identiBox">
			<span class="identiSpan">아이디 : <input type="text" class="id" id="id" placeholder="아이디를 입력해주세요." autocomplete="off"></span>
			<span class="identiSpan">비밀번호 : <input type="password" class="pwd" id="pwd" placeholder="비밀번호를 입력해주세요." autocomplete="off"></span>
		</div>
		<div class="textBox">
			<p>글 내용 :</p><br>
			<textarea class="textSpace"></textarea>
		</div>
	
		<div class="submitBox">
			<input type="submit" class="postSubmit" value="전송">
		</div>
	</form>
</body>
</html>