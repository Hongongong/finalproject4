<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#deletebtn").on('click', function() {
			let userpw = prompt("글 암호를 입력하세요");
			let dbpw = $("input:hidden").val();
			if(userpw == dbpw) {
				location.href = "boarddelete?seq=${ detaildto.seq }";
			} else {
				alert("암호를 확인하세요.");
			}
		}) // deletebtn onclick end
		
		$("#updatebtn").on('click', function() {
			let userpw = prompt("글 암호를 입력하세요");
			let dbpw = $("input:hidden").val();
			if(userpw == dbpw) {
				$("form").attr("action", "boardupdate");
				$("form").attr("method", "post");
				$("form").submit(); // form 태그 내부 모든 input name 변수 이름 전달
			} else {
				alert("암호를 확인하세요.");
			}
		}) // updatebtn onclick end
		
	}); // ready end
</script>
</head>
<body>
	<h1>상세 게시물 보기 화면입니다.</h1>
	<form action="" method="">
		<table border="3">
			<tr><td>번호</td><td><input type="text" value="${ detaildto.seq }" name="seq" readonly></td></tr>
			<tr><td>제목</td><td><input type="text" value="${ detaildto.title }" name="title"></td></tr>
			<tr><td>내용</td><td><textarea name="content" rows=5 cols=50>${ detaildto.content }</textarea></td></tr>
			<tr><td>작성자</td><td><input type="text" value="${ detaildto.writer }" name="writer" readonly></td></tr>
			<tr><td>조회수</td><td><input type="text" value="${ detaildto.viewcount }" name="writer" readonly></td></tr>
			<tr><td>작성시간</td><td><input type="text" value="${ detaildto.writingtime }" name="writer" readonly></td></tr>
			<tr><td colspan="2"><input type="button" value="수정버튼" id="updatebtn"><input type="button" value="삭제버튼" id="deletebtn"></td></tr>
		</table>
		<input type="hidden" name="pw" value=${ detaildto.pw }>
	</form>

</body>
</html>