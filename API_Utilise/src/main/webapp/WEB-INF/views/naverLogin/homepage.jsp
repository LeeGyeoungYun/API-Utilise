<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<p>환영합니다. ${username} 님</p>
			<c:if test="${username != null}">
				<a href="${pageContext.request.contextPath}/logout" style="margin-top:10px;">로그아웃하기</a>
			</c:if>
		</div>
    	<div class="loginBox">
    		<a href="naverLogin">네이버 로그인</a> |
    		<a href="#">회원가입</a>
    	</div>
    	
    	<div class="normalLoginBox">
    		<a href="login">로그인</a> |
    		<a href="#">회원가입</a>
    	</div>
    	
    	
    	<div class="countBox">
    		${count}
    	</div>
    </div>
</body>
</html>