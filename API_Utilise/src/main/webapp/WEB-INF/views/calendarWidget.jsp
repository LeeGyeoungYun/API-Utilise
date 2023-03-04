<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력 위젯 사용테스트 </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/crawPage_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crawPage.js"></script>
</head>
<body>
	<div class="crawContainer">
		<div class="lolCrawTest">
			<span class="titleSpan"><h2>달력 위젯 사용</h2></span>
			<div class="inputInfo">
				
				<input type="text" class="craw" placeholder="닉네임을 적어주세요.">
				<button type="button" class="submit">입력</button>
			</div>
			
			<div class="content_craw"><!-- 이부분이 결과값이 나오는부분 -->
				
			</div>
		</div>
	</div>
	
</body>
</html>