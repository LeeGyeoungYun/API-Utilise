<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/selectPost_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<title>${po.pno} 게시판 댓글 작성 페이지</title>
</head>
<body>
	<div class="postContainer">
	<form class="postForm">
		<div class="identiBox">
			<span class="identiSpan">아이디 : <input type="text" class="id" id="id" value="${po.postId}" readonly></span>
			
		</div>
		<div class="textBox">
			<p>글 내용 :</p><br>
			<textarea class="textSpace" readonly>${po.postComment}</textarea>
		</div>
	
	</form>
	
		<div class="replyForm">
			<div class="replyBox">
			
			</div>
			<div class="writeBox">
				아이디 : <input type="text" id="replyId" class="replyId" ><br>
				패스워드 : <input type="password" id="replyPwd" class="replyPwd" ><br>
				<span> 
				댓글 : <textarea class="replyComment"></textarea>
				<input type="button" class="replySubmit" value="작성"></span>		
			</div>
		</div>
	</div>
</body>

<script>
	window.onload = function(){
		
		
	}
</script>
</html>