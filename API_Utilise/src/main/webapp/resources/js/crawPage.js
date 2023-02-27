
$("document").ready(function(){

	$(".submit").click(function(){
		let craw1 = document.querySelector(".craw").value;
		console.log(craw1);
		$.ajax({
		
			url:"/API_Utilise/craw/craw_select.ajax",
			type:"post",
			data:{"user_id": craw1},
			dataType:"json",
			success:function(){
				console.log("성공");
			},error: function(){
				console.log("오류");
			}
		
		});
	});


});