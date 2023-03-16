<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/postPage_style.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<title>댓글 폼 페이지</title>
</head>
<body>
	<div class="replyContainer">
		<div class="writeBox">
			<a href="add_post"><button type="button" class="writeButton">글 작성</button></a>
		</div>
		<div class="readBox">
			<div class="space space1">
				<a href="post/all"><input type="button" class="innerBtn" value="게시물 전체보기"></a>
				<br><br>
				<c:forEach var="p" items="${po}">
					<a href="selectPost?pno=${p.pno}"><input type="button" class="move" value="게시판이동"></a>
				</c:forEach>
				
			</div>
		</div>
	</div>
	
<script>
	
</script>
</body>
</html>