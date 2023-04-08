
function loginCheck(){

	//alert("클릭");
	var id = document.getElementById("id").value;
	var pwd = document.getElementById("pwd").value;
	var rememberId = document.getElementsByClassName("checkbox")[0].checked; //체크 여부확인 만약 체크되어있으면 true
																			 //없으면 false
	console.log(id+"  "+pwd+"  "+rememberId);
	
	return false;
	
}