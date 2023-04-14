<%@ page contentType="text/html; charset=UTF-8"%>
<% String id = (String)request.getSession().getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 홈페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/homepage_style.css">
</head>
<body>
	<div class="mainController">
	
		<div class="loginState">
			<p>환영합니다. <%=id%> 님</p>
			<a href="${pageContext.request.contextPath}/logout" style="margin-top:10px;">로그아웃하기</a>
		</div>
    	<div class="loginBox">
    		<a href="naverLogin">네이버 로그인</a> |
    		<a href="#">회원가입</a>
    	</div>
    	
    	<div class="normalLoginBox">
    		<a href="login">로그인</a> |
    		<a href="#">회원가입</a>
    	</div>
    </div>
</body>
</html>