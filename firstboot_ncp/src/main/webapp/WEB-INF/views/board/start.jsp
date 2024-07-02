<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="rces/jquery-3.7.1.min.js"></script>
<script>
	/* 자바스크립트 코드 */
	$(document).ready(function() {
		// id가 boardwritelink 인 태그를 클릭하면 href 이동 x (a태그 기본동작 취소)
		$("#boardwritelink").on('click', function(e) {
			let sessionid = <%=session.getAttribute("sessionid") %> // 표현문 태그(출력, 다른태그속성값 지정, 자바스크립트 변수값 표현)
			if(sessionid == null) {
				e.preventDefault();
			}
		}); // #boardwritelink onclick end
	}); // ready end
</script>
</head>
<body>
	<!-- 자바 코드 -->
	<%
	if(session.getAttribute("sessionid") != null) { %>
		<h1><%=session.getAttribute("sessionid") %></h1>
	<%
	} else {
	%>
		<h1>로그인한 적이 없습니다.</h1>
	<%
	} %>
	
	<h1>나의 게시판 프로젝트</h1>
	<h3>서비스는 다음과 같습니다.</h3>
	<h4>
		<ul>
			<li><a href="boardlist">게시물 목록 보기</a>(로그인 필요X)</li>
			<li><a href="boardwrite" id="boardwritelink">글쓰기</a>(로그인 필요)</li>
			<li><a href="boardlogin">로그인</a></li>
			<li><a href="boardlogout">로그아웃</a></li>
		</ul>
	</h4>
</body>
</html>