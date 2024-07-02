package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;

	@Override
	public int registerBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int getTotalBoard() {
		return dao.totalCount();
	}

	@Override
	public List<BoardDTO> getPagingBoardList(int[] limit) {
		return dao.pagingBoardList(limit);
	}

	@Override
	public BoardDTO updateViewCountAndGetDetail(int seq) {
		dao.updateViewCount(seq);
		return dao.getDetail(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public List<BoardDTO> getSearchPagingBoardList(HashMap map) {
		return dao.boardSearchList(map);
	}

}
