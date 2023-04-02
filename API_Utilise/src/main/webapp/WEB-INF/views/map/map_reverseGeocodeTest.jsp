<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/map_reverseGeocodeTest_style.css">
<title>지도 Reverse GecodeTest API 활용 테스트</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
</head>
<body>
	<div class="reverseGeocodeContainer">
		
		위도 : <input type="text" class="address" id="latitude" placeholder="위도" autocomplete="none"><br>
		경도 : <input type="text" class="address" id="longitude" placeholder="경도" autocomplete="none"><br>
		<br><br><br>
		
		<a href="goReverseGeocode"><input type="button" class="address_Submit" value="전송"></a>
	</div>
	
	<script>
	
		function goReverseGeocoding(){
			var latitude = document.getElementById("latitude").value;
			var longitude = document.getElementById("longitude").value;
			//console.log(latitude+" "+longitude);
			
			$.ajax({
				
				url:"/API_Utilise/goReverseGeocoding/"+longitude+"/"+latitude,
				type:"get",
				dataType:"JSON",
				success:function(response){
					console.log("성공");
					console.log(response);
					
				},error:function(){
					console.log("실패");
				}
				
			});
		}
	</script>
</body>
</html>