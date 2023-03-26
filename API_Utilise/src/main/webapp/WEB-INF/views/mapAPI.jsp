<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mapAPI_style.css">
<meta charset="UTF-8">
<title>지도API 활용 테스트</title>
</head>
<body>
	<div class="mapContainer">
		
		<div class="mapInfoBox"><!-- 맵정보를 적는곳 -->
			<span class="infoSpan">맵 가로크기: <input type="text" class="width" placeholder="맵 가로크기 설정"></span>
			<span class="infoSpan">맵 세로크기: <input type="text" class="height" placeholder="맵 세로크기 설정"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 형식:&nbsp; &nbsp;<input type="text" class="format" placeholder="맵 이미지형식 설정 : png8 or png"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 위도:&nbsp; &nbsp;<input type="text" class="mapX" placeholder="맵 위도"></span>
			<span class="infoSpan">&nbsp; &nbsp;맵 경도:&nbsp; &nbsp;<input type="text" class="mapY" placeholder="맵 경도"></span>
			<span class="infoSpan">데이터 버전: <input type="text" class="dataversion" placeholder="최신 데이터를 받기 위한 필수 부분 ex)201.3"></span>
			<br><br><br>
			<input type="button" class="submit" onclick="submit()" value="전송">
		</div>
		
		<div class="mapBox"><!-- 맵이 나오는 공간 -->
		
		</div>
	</div>
	
	<script>
		
	</script>
</body>
</html>