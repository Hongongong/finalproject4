package boardmapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberMybatisController {

		@Autowired
		@Qualifier("memberServiceImpl")
		MemberService service;
		
		@GetMapping("boardlogin")
		String loginform() {
			
			return "board/loginform";
			
		} // loginform() end
		
		@PostMapping("boardlogin")
		String loginprocess(String id, int pw, HttpSession session) {
			
			MemberDTO dto = service.oneMember(id);
			if(dto != null) {
				if(dto.getPw() == pw) {
					// 세션에 id 저장(로그인 정보 유지)
					session.setAttribute("sessionid", dto.getId());
				}
//				else { // 암호 틀림
//					
//				} // if-else end
			}
//			else { // 가입정보 x
//				"회원가입부터 하세요."
//			} // if-else end
			
			return "board/start";
		} // loginprocess() end
		
		@RequestMapping("/boardlogout")
		String logout(HttpSession session) {
			if(session.getAttribute("sessionid") != null) {
				session.removeAttribute("sessionid");				
			}
			return "board/start";
		}
}
