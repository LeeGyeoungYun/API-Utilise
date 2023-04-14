<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 테스트</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/naverLoginTest_style.css">
</head>
<body>
	<form class="infoForm" method="post" action="${pageContext.request.contextPath}/login_ok">
    	<div class="infoContainer">
    		<div class="infoBox">
    			<c:if test="${param.errorCode==1}">
    			<p style="color:red; font-size:20px;">계정이 일치하지 않습니다.</p>
    			</c:if>
    			<div class="infoBox_inner">
	    			<div class="privacyBox">
	    				<input type="text" class="username" name="username" value="${username}" autocomplete="none"><br>
	    				<input type="password" name="password" class="password">
	    			</div>
	    			<div class="buttonBox">
	    				<input type="submit" class="submit" value="로그인">
	    			</div>
	    			</div>
    			<div class="rememberIdBox">
    			<input type="checkbox" name="checkbox" class="checkbox" ${check}> 아이디 저장
    		</div>
    		</div>
    	</div>
    	</form>
    	
    	
    	
</body>
</html>