<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 로그인 테스트</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/naverLoginTest_style.css">
</head>
<body>
	<form class="infoForm" method="post">
    	<div class="infoContainer">
    		<div class="infoBox">
    			<div class="infoBox_inner">
	    			<div class="privacyBox">
	    				<input type="text" class="id" id="id" autocomplete="none"><br>
	    				<input type="password" class="pwd" id="pwd">
	    			</div>
	    			<div class="buttonBox">
	    				<input type="submit" class="submit" id="submit" value="로그인">
	    			</div>
	    			</div>
    			<div class="rememberIdBox">
    			<input type="checkbox" class="checkbox"> 아이디 저장
    		</div>
    		</div>
    		
    		<div class="socialBox">
    			<ul>
    				<li>
    					<a href="#" class="goNaver">네이버 로그인</a>
    				</li>
    			
    			</ul>
    		</div>
    		
    	</div>
    </form>
</body>
</html>