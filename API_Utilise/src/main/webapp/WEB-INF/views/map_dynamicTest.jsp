<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ztit815g97&callback=initMap"></script>
</head>
<body>
<div id="mm" style="width:600px;height:600px; margin:100px 0 0 100px;"></div>

<script>

var map = null;
var marker= null;
function initMap() {
    map = new naver.maps.Map('mm', {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        size: new naver.maps.Size(800,800),
        zoom: 16
    });
    marker = new naver.maps.Marker({
    	position : new naver.maps.LatLng(37.3595704, 127.105399),
    	map:map,
    	icon:{
    		url:"${pageContext.request.contextPath}/resources/image/보노보노.jpg",//마커할 아이콘선택
    		size : new naver.maps.Size(30,30),//아이콘 크기 선택 		
    		origin: new naver.maps.Point(0, 0),//아이콘 그림 원점 선택 
            anchor: new naver.maps.Point(11, 23)//지도 위에 놓이는 마커의 위치와 일치시킬 아이콘의 기준 위치
    	}
    	
    });
}
</script>
</body>
</html>