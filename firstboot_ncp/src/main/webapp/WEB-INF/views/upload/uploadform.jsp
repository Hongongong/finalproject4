<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.7.1.min.js"></script>
</head>
<body>
<h1>파일 전송</h1>
<form action="fileupload" method="post" enctype="multipart/form-data">
작성자 : <input type=text name="name"><br>
설명 : <input type=text name="description"><br>
업로드파일1 : <input type=file name="file1" accept="image/*"><br>
<!-- accept="image/*"  multiple="multiple"-->
업로드파일2 : <input type=file name="file2"><br>
<input type=submit value="전송">
</form>

업로드파일 미리보기<div id="preview"></div>
<script>
//<input type=file --> File객체 취급 --> result변수-->FileReader
$("input[name^=file]").on('change', function(e){
	var reader = new FileReader();
	reader.readAsDataURL(e.target.files[0]);
	
	reader.onload = function(e){
		var img = document.createElement("img");
		img.setAttribute("src",e.target.result);
		$("#preview").html(img);
	}//onload
	
});//onchange
</script>

</body>
</html>





