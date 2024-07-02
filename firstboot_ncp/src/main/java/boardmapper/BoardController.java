package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	// 시작화면
	// "/" 로 매핑 = start.jsp
	@RequestMapping("/")
	String start() {
		return "board/start";
	}
	
	// 글작성 폼 보여주기
	@GetMapping("/boardwrite")
	String writeform() {
		return "board/writeform";
	}
	
	// 글작성 수행
	@PostMapping("/boardwrite")
	// jsp form에서 title, contents, writer, pw 전달받음
	ModelAndView writeprocess(BoardDTO dto) {
		
		int insertrow = service.registerBoard(dto);

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("insertrow", insertrow);
		mv.setViewName("board/start");
		
		return mv;
	}
	
	// 게시글 목록
	@RequestMapping("/boardlist")
	// 매개변수 : 사용자가 입력한 페이지 번호, 미입력시 1로 처리
	ModelAndView boardlist(@RequestParam(value="pagenum", required=false, defaultValue="1") int pagenum) {

		int pagecount = 3;
		int start = (pagenum - 1) * pagecount;
		int limit[] = {start, pagecount};
		
		int totalboard = service.getTotalBoard();
		List<BoardDTO> boardlist = service.getPagingBoardList(limit);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("boardlist", boardlist);
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	// 게시물 상세보기
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq) {
		
		BoardDTO dto = service.updateViewCountAndGetDetail(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("detaildto", dto);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	// 게시물 삭제
	@RequestMapping("/boarddelete")
	String boarddelte(int seq) {
		
		int delete = service.deleteBoard(seq); // 삭제 컬럼 개수 반환
		
		// boardlist 컨트롤러 메소드 호출(리스트 화면으로 이동)
		return "redirect:/boardlist";
	}
	
	// 게시물 수정
	@RequestMapping("/boardupdate")
	String boardupdate(BoardDTO dto) {
		
		int update = service.updateBoard(dto); // 수정 컬럼 개수 반환
		
		// boardlist 컨트롤러 메소드 호출(리스트 화면으로 이동)
		return "redirect:/boardlist";
	}
	
	// 게시물 검색
	@RequestMapping("/boardserchlist")
	ModelAndView boardsearchlist(@RequestParam(value="pagenum", required=false, defaultValue="1") int pagenum, 
								String searchitem, String searchword) {

		int pagecount = 3;
		int start = (pagenum - 1) * pagecount;
		int limit[] = {start, pagecount};
		
		HashMap map = new HashMap();
		if(searchitem.equals("all")) {
			map.put("searchcolname", null);			
		} else {			
			map.put("searchcolname", searchitem);			
		}
		map.put("searchvalue", "%" + searchword + "%");
		map.put("limit", limit);
		
		List<BoardDTO> boardsearchlist = service.getSearchPagingBoardList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardsearchlist", boardsearchlist);
		
		mv.setViewName("board/searchlist");
		
		return mv;
	}
	
}
