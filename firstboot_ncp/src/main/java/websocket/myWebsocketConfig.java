package websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration // chatws 매핑 설정
@EnableWebSocket // 현재 설정으로 웹소켓 활성화 : ws:...
public class myWebsocketConfig implements WebSocketConfigurer {

	@Autowired
	ChatWebsockethandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler,"/chatws").setAllowedOrigins("*"); // ws:.../
	}

}
