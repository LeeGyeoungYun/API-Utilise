
let submit = document.querySelector(".submit");
submit.addEventListener("click",function(){

	//console.log("click");
	let region = document.querySelector(".craw").value;
	
	$.ajax({
	
		url:"/API_Utilise/craw/craw_weater_select",
		type:"post",
		data:{"region":region},
		dataType:"json",
		success: function(data){
			console.log(data.size());
			
		},error: function(){
		
			console.log("오류");
		}
	
	});
	
});