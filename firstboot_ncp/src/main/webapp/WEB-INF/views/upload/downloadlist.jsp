<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.7.1.min.js"></script>   
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>다운로드 목록을 보여드립니다. </h1>
<c:forEach items="${filearray }" var="filename">
<h1> <a href="filedownloadresult?filename=${filename }" > ${filename }</a> 파일 다운로드</h1>
</c:forEach>


</body>
</html>