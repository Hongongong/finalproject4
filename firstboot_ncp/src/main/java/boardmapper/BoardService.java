package boardmapper;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	// 게시글 작성
	int registerBoard(BoardDTO dto);
	
	// 전체 게시글 개수
	int getTotalBoard();
	
	// 게시판 페이징 처리
	List<BoardDTO> getPagingBoardList(int[] limit);
	
	// 게시물 상세조회(게시물 조회 + 조회수 ++1)
	BoardDTO updateViewCountAndGetDetail(int seq);
	
	// 게시물 삭제
	int deleteBoard(int seq);
	
	// 게시물 수정
	int updateBoard(BoardDTO dto);
	
	// 게시물 검색 페이징처리
	List<BoardDTO> getSearchPagingBoardList(HashMap map);
}
