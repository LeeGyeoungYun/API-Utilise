<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mapAPI_style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src=""></script>
<meta charset="UTF-8">
<title>지도API 활용 테스트</title>
</head>
<body>
	<div class="mapContainer">
		
		<div class="mapInfoBox"><!-- 맵정보를 적는곳 -->
			<span class="infoSpan">맵 가로크기: <input type="text" id="width" placeholder="맵 가로크기 설정"></span>
			<span class="infoSpan">맵 세로크기: <input type="text" id="height" placeholder="맵 세로크기 설정"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 형식:&nbsp; &nbsp;<input type="text" id="format" placeholder="맵 이미지형식 설정 : png8 or png"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 위도:&nbsp; &nbsp;<input type="text" id="mapX" placeholder="맵 위도"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 경도:&nbsp; &nbsp;<input type="text" id="mapY" placeholder="맵 경도"></span>
			<span class="infoSpan">데이터 버전: <input type="text" id="dataversion" placeholder="최신 데이터를 받기 위한 필수 부분 ex)201.3"></span>
			<br><br><br>
			<input type="button" class="submit" onclick="mapInfoSubmit()" value="전송">
			
			<span class="infoSpan">주소 : <input type="text" id="address" placeholder="주소"></span>
			<input type="button" class="submit2" onclick="mapInfoSubmit2()" value="전송">
		</div>
		
		<div class="mapBox"><!-- 맵이 나오는 공간 -->
			
			<img src="https://naveropenapi.apigw.ntruss.com/map-static/v2/raster-cors?w=300&h=300&center=127.141755,37.318835&X-NCP-APIGW-API-KEY-ID={{ztit815g97}}"/>
		</div>
	</div>
	
	<script>
		window.onload = function(){
			
		}
		
		function mapInfoSubmit2(){
			const addr = document.getElementById("address").value;
			
		$.ajax({
				
				url:"https://naveropenapi.apigw.ntruss.com/map-static/v2/raster-cors",
				type:"GET",
				headers:{
					"Content-Type":"application/json",
					"X-NCP-APIGW-API-KEY-ID":"fadlprzcjp",
					"X-NCP-APIGW-API-KEY" : "u1tf5Rtl5mceujBRskajSynOZMcGikkHHj9mfutI"
				},
				data:JSON.stringify({
					addr:addr
				}),
				success:function(response){
					console.log("성공");
				},error:function(){
					console.log("에러");
				}
				
			});
			
			
		}
		
		function mapInfoSubmit(){
			console.log("click");
			const width = document.getElementById("width").value;
			const height = document.getElementById("height").value;
			const format = document.getElementById("format").value;
			const mapX = document.getElementById("mapX").value;
			const mapY = document.getElementById("mapY").value;
			const dataversion = document.getElementById("dataversion").value;
			
			//console.log(width+" "+height+" "+format+" "+mapX+" "+mapY+" "+dataversion);
			$.ajax({
				
				url:"https://naveropenapi.apigw.ntruss.com/map-static/v2/raster-cors",
				type:"GET",
				headers:{
					"Content-Type":"application/json",
					"X-NCP-APIGW-API-KEY-ID":"fadlprzcjp",
					"X-NCP-APIGW-API-KEY" : "u1tf5Rtl5mceujBRskajSynOZMcGikkHHj9mfutI"
				},
				data:JSON.stringify({
					width:width,
					height:height,
					format:format,
					mapX:mapX,
					mapY:mapY,
					dataversion:dataversion
				}),
				success:function(response){
					console.log("성공");
				},error:function(){
					console.log("에러");
				}
				
			});
		}
	</script>

</body>
</html>