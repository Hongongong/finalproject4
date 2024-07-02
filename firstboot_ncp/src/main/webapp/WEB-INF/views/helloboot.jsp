<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="/jquery-3.7.1.min.js"></script>   
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax({
		url : "helloajax",
		type: "get",
		dataType:"json",
		success : function(server){
			$("#result").append(server.model);
		},
		error:function(error){
			alert(error);
		}
		});//ajax	
	})//on

});
</script>



</head>
<body>
<h1>helloboot.jsp 파일입니다</h1>
<h1>${model }</h1>

<img src="/images/html5.jpg" >

<input type=button id="ajaxbtn" value="ajax요청">
<div id="result">ajax 결과 = <br></div>

</body>
</html>