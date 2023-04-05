<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 로그인 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/naverLogin_callback_style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>

	<div class="callbackContainer">
		<div class="myInfoBox">
			<a href="getMyInfo/${token}" class="getMyInfo">
				<span class="myInfo">
					<i class="fa-regular fa-user"></i>
					<p>회원정보</p>
				</span>
			</a>
		</div>
	</div>
</body>
</html>