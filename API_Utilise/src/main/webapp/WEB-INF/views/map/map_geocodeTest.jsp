<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/map_geocodeTest_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<meta charset="UTF-8">
<title>Map Geocode Test</title>
<body>
	<div class="geocodeContainer">
		주소: <input type="text" class="address" placeholder="주소" autocomplete="none">
		<br><br><br>
		
		<a href="goGeocode"><input type="button" id="address_Submit" class="address_Submit" onclick="addrSub()" value="전송">
		</a>
		<div class="dab"></div>
	</div>
	
	

 	
		


</body>
</html>