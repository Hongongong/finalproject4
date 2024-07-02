<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
		let websocket;
		
		$("#enterbtn").on('click', function() {
			websocket = new WebSocket("ws://localhost:8080/chatws"); // 아직 서버에 매핑 전
		
			websocket.onopen = function() { console.log("웹소켓연결성공"); } // 서버 연결시 자동호출
			websocket.onclose = function() { console.log("웹소켓연결해제성공"); } // 서버 연결 해제시 자동호출
			websocket.onmessage = function(server) {
				console.log("웹소켓으로부터 수신 성공");
				
				if(server.data.indexOf($("#nickname").val()) >= 0) {
					$("#chatarea").append("<div class='me'>" + server.data + "</div>");					
					$('.me').css("color", "aqua");
				} else {					
					$("#chatarea").append("<div class='other'>" + server.data + "</div>");										
					$('.other').css("color", "white");
				}
			} // 메세지 주고받을때마다 자동호출
			
			$("#status").html($("#nickname").val() + " 님 입장하셨습니다.<br>");
			
		}); // 입장버튼, enterbtn onclick
		
		$("#exitbtn").on('click', function() {
			
			websocket.close();
			$("#status").html($("#nickname").val() + " 님 퇴장하셨습니다.<br>");
			
		}); // 퇴장버튼, exitbtn onclick

		$("#sendbtn").on('click', function() {
			websocket.send($("#nickname").val() + " : " +  $("#message").val());
		}); // 전송버튼, sendbtn onclick
		
		
		
	}); // ready end
</script>
</head>
<body>
	닉네임 : <input type=text name="nickname" id="nickname" value="${ param.id }">
	<input type=button id="enterbtn" value="입장버튼">
	<input type=button id="exitbtn" value="퇴장버튼">
	
	<h1>채팅영역</h1>
	<div id="chatarea" style="border: 2px solid silver; background-color: black; color:white">
		채팅내용 표시공간<br>
	</div>
	
	대화입력 : <input type="text" id="message">
	<input type="button" id="sendbtn" value="전송">
	
	<div>
		현재상태 : <p id="status"></p>
	</div>
</body>
</html>