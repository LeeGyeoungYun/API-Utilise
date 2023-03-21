

function update(number){
	console.log("수정버튼 클릭");
	console.log(number);
	document.querySelector(".overlay").style.visibility = 'visible';
	document.querySelector(".modal").style.visibility = 'visible';
	document.querySelector(".rnoSpace").value= number;
}

$(".overlay").click(function (){ //모달창 끄기
	closeModal();
});

function closeModal(){
	document.querySelector(".overlay").style.visibility = 'hidden';
	document.querySelector(".modal").style.visibility = 'hidden';
	document.querySelector(".modalPwdSpace").value = '';
	
	document.querySelector(".ri").value = '';
	document.querySelector(".rp").value = '';
	document.querySelector(".rc").value = '';
}

function pwdConfirm(){
	const rno = document.querySelector(".rnoSpace").value;
	let pwd = document.querySelector(".modalPwdSpace").value;
	
	if(pwd.trim() == ''|| pwd.length ==0){
		alert("비밀번호를 비어있습니다. 다시 입력해주세요.");
		document.querySelector(".modalPwdSpace").focus();
		return false;
	}
	
	$.ajax({
		type:"POST",
		url:"/API_Utilise/pwdConfirm_ok",
		data:{"rno":rno,"pwd":pwd},
		dataType:"json",
		success:function(data){
			
			let msg = Object.keys(data);
			if(msg =='success'){
				console.log("성공");
				let obj = data.success;
				document.querySelector(".ri").value = obj.replyId;
				document.querySelector(".rp").value = obj.replyPwd;
				document.querySelector(".rc").value = obj.replyComment;
				
			}else{
				console.log("실패");
				alert("비밀번호가 일치하지 않습니다.");
				document.querySelector(".modalPwdSpace").value = '';
				document.querySelector(".modalPwdSpace").focus();
			}
			
			
		},error:function(){
			console.log("에러");
		}
	});
	
}

function replyUpdate(){
	const rno = document.querySelector(".rnoSpace").value;
	var replyId = document.querySelector(".ri").value;
	var replyPwd = document.querySelector(".rp").value;
	var replyComment = document.querySelector(".rc").value;
	
	$.ajax({
		url:"/API_Utilise/reply/update/"+rno,
		type:"PUT",
		headers:{
			"Content-Type":"application/json",
			"X-Http-Method-Override":"PUT"
		},
		data:JSON.stringify({
			rno:rno,
			replyId:replyId,
			replyPwd:replyPwd,
			replyComment,replyComment
		}),
		success:function(){
			console.log("성공");
			closeModal();
			getRepies();
			
		},error:function(){
			console.log("에러");
		}
		
		
	});
}//replyUpdate() end


