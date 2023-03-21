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
	<div class="overlay"></div>
	
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
	
	<div class="modal">
		<input type="hidden" class="rnoSpace">
		<div class="modalTextBox">
			<p>비밀번호를 입력해주세요.</p>
		</div>
		<div class="modalPwdBox">
			
			<input type="password" class="modalPwdSpace" placeholder="비밀번호를 입력하세요.">
			<input type="button" class="pwdConfirm" onclick="pwdConfirm()" value="확인">
		</div>
		<div class="writeBox">
				아이디 : <input type="text" class="replyId ri" value="${replyId}"><br>
				패스워드 : <input type="password" class="replyPwd rp"><br>
				<span> 
				댓글 : <textarea class="replyComment rc"></textarea>
				<input type="button" class="update" onclick="replyUpdate()" value="수정"></span>		
			</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/selectPost.js"></script>
<script>
	window.onload = function(){
		getRepies();
	}
	var pno = ${po.pno};
	
	function getRepies(){ //댓글들 불러오기
		$.getJSON("/API_Utilise/reply/all/"+pno,function(data){
			var str = "";
			$(data).each(function(){
				str += 
				
					"<div class='writeBox' data-rno='"+this.rno+"'>"
				   +"아이디 : <input type='text' class='replyId2' value='"+this.replyId+"' readonly><br>"					
				   +"<span>" 
				   +"댓글 : <textarea class='replyComment2' readonly>"+this.replyComment+"</textarea>"
				   +"	<input type='button' data-rno='"+this.rno+"' class='updateBtn' onclick='update("+this.rno+");' value='수정'>"
				   +"	<input type='button' class='deleteBtn' value='삭제'>"
				   +"   <input type='button' class='replySubmit2' value='댓글추가'>"
				   +"</span>"
				   +"</div>"
			});
			
			$(".replyBox").html(str);
		});
		
	}//getRepies() end
	
	
	var replySubmit = document.querySelector(".replySubmit");
	replySubmit.addEventListener("click",function(){
			
		
		var replyId = document.getElementById("replyId").value;
		var replyPwd = document.getElementById("replyPwd").value;
		var replyComment = document.getElementsByClassName("replyComment")[0].value;
		
		console.log(pno+" "+replyId+" "+replyPwd+" "+replyComment);
		
		$.ajax({			
			
			url:"/API_Utilise/reply/add",
			type:"POST",
			headers:{
				"Content-Type":"application/json",
				"X-Http-Method-Override":"POST"
			},
			dataType:'text',
			data:JSON.stringify({
				pno:pno,
				replyId:replyId,
				replyPwd:replyPwd,
				replyComment:replyComment					
			}),
			success:function(){
				console.log("성공");
				clear();// 작성한 내용 삭제
				getRepies();
				
				
			},error:function(){
				console.log("실패");
			}
				
		});
		
	});
	
	function clear(){
		document.getElementById("replyId").value = '';
		document.getElementById("replyPwd").value = '';
		document.getElementsByClassName("replyComment")[0].value = '';
	}
	
</script>
</html>