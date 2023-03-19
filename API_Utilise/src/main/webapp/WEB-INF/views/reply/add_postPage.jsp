<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add_postPage_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
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
			<input type="button" class="postSubmit" value="전송">
		</div>
	</form>
</body>

<script>
	window.onload = function(){
		
		var submitBtn = document.querySelector(".postSubmit");
		
		submitBtn.addEventListener("click",function(){
			
			var postId = document.getElementById("id").value;
			var postPwd = document.getElementById("pwd").value;
			var postComment = document.querySelector(".textSpace").value;			
			
			$.ajax({
				type:"POST",
				url:"/API_Utilise/add_post/add",
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType:"text",
				data:JSON.stringify({
					postId:postId, //아이디
					postPwd:postPwd, //비밀번호
					postComment:postComment //내용
				}),
				success:function(data){
					
					if(data == "success"){
						console.log("정보 저장 성공");
					}else{
						console.log("정보 저장 실패");
					}
					
				},error:function(){
					console.log("오류");			
				}
				
			});
		});
	}
</script>
</html>