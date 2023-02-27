<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크롤링 테스트페이지 </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/crawPage_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crawPage.js"></script>
</head>
<body>
	<div class="crawContainer">
		<div class="lolCrawTest">
			<span class="titleSpan"><h2>op.gg 크롤링 테스트</h2></span>
			<div class="inputInfo">
				
				<input type="text" class="craw">
				<button type="button" class="submit">입력</button>
			</div>
			
			<div class="content_craw"><!-- 이부분이 결과값이 나오는부분 -->
				
			</div>
		</div>
	</div>
</body>
</html>