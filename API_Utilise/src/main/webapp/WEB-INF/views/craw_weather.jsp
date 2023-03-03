<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 크롤링</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/craw_weather_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

</head>
<body>
	<div class="crawContainer">
		<div class="lolCrawTest">
			<span class="titleSpan"><h2>네이버 날씨 크롤링</h2></span>
			<div class="inputInfo">

				<input type="text" class="craw" placeholder="지역이름을 적어주세요.">
				<button type="button" class="submit">입력</button>
				<button type="button" class="delete">초기화</button>
			</div>

			<div class="content_craw">
				<!-- 이부분이 결과값이 나오는부분 -->
				<ul>
					<!-- 여기안에 자바스크립트가 비동기식으로 입력 -->
				</ul>
			</div>
			
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/craw_weather.js"></script>
</body>
</html>