<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력 위젯 사용테스트 </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/calendarWidget_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>
	<div class="crawContainer">
		<div class="lolCrawTest">
			<span class="titleSpan"><h2>달력 위젯 사용</h2></span>
			<div class="inputInfo">
				
				<input class="calendar" name="publeYear" autocomplete="off" readonly="readonly">
				<input type="button" class="submit" value="전송">
			</div>
			
			<div class="content_craw">
				<!-- 이부분에서 켈런더 선택값 출력 -->
				
				
			</div>
			
		</div>
	</div>
<script>

	$(".submit").click(function(){
		
		let cal1Val = document.querySelector(".calendar").value;
		let cr = document.querySelector(".content_craw");
		
		let h = document.createElement('h2');
		h.innerText = cal1Val;
		cr.append(h);
		
	});
	
	const config = { // 달력 위젯 출력형식을 바꿔주는 것
			
			dateFormat : 'yy-mm-dd'
	};
	
	$(function() {
		  $( "[name='publeYear']" ).datepicker(config); // $(선택자).datepicker(); -> 선택자로 선택한 input에 달력위젯으로 사용
		  let cal1Val = document.querySelector(".calendar").value;
		  
		  
		  
		  
		  
		  
	});
</script>
</body>
</html>