

var content_craw = document.querySelector(".content_craw");
var now = new Date();
var week = new Array('일','월','화','수','목','금','토');	
			
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
			console.log(data);	
			for(var i=0;i<10;i++){
				
				showChart(data,i);
				
			}
			
			
			
		},error: function(){
		
			console.log("오류");
		}
	
	});
	
});


function showChart(data,item){

	let content = document.createElement('li');
	content.className='week_item';
	
	let day = data[item].split(",")[0];
	let date = data[item].split(",")[1];
	let am_weather = (data[item].split(",")[2]).split(" ")[0];
	let pm_weather = (data[item].split(",")[2]).split(" ")[1];
	let lowest = data[item].split(",")[3].substring(4);
	let highest = data[item].split(",")[4].substring(4);
	
	if(am_weather == '맑음'){
		am_weather = `<li class="sunny icon"></li>`
	}else if(am_weather == '흐림'){
		am_weather = `<li class="cloudy icon"></li>`
	}else if(am_weather == '구름많음'){
		am_weather = `<li class="cloud icon"></li>`
	}
	
	if(pm_weather == '맑음'){
		pm_weather = `<li class="sunny icon"></li>`
	}else if(pm_weather == '흐림'){
		pm_weather = `<li class="cloudy icon"></li>`
	}else if(pm_weather == '구름많음'){
		pm_weather = `<li class="cloud icon"></li>`
	}
	
	//console.log(day+" "+date+" "+am_weather+" "+pm_weather+" "+lowest+" "+highest);
	
	
	content.innerHTML = `
		<div class="day_date">
							<div class="cell_date">
								<span class="date_inner"> 
									<strong class="day"> ${day} </strong>						
									<span class="date">${date}</span>
								</span>
							</div>

							<div class="cell_weather">
								<span class="weather_inner"> 								
									<strong class="time">오전</strong> 
									${am_weather}			
								</span> 
								<span class="weather_inner"> 
									<span class="weather_inner">
										<strong class="time">오후</strong> 
										${pm_weather}
									</span>
								</span>
							</div>

							<div class="cell_temperature">
								<span class="temperature_inner"> 
									<span class="lowest">${lowest}</span>
									<span class="bar">/</span> 
									<span class="highest">${highest}</span>
								</span>
							</div>					
						</div>
	`;			
	content_craw.appendChild(content);
	
	
}