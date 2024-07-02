package spring.mybatis.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	// dao - 1개 sql 실행 단위 메소드
	
	@Autowired
	SqlSession session;

	int registerBoard(BoardDTO dto) {
		int insertrows = session.insert("insertBoard", dto);
		return insertrows;
	}
	//////////////////////
	int getTotalCount() {
		return session.selectOne("totalCount");
	}
	
	List<BoardDTO> getPagingBoardList(int limit[]) {
		return session.selectList("pagingBoardList", limit);
	}
	//////////////////////
	int updateViewCount(int seq) {
		return session.update("updateViewCount", seq);
	}
	
	BoardDTO getDetail(int seq) {
		return session.selectOne("getDetail", seq);
	}
	//////////////////////
	int deleteBoard(int seq) {
		return session.delete("deleteBoard", seq);
	}
	//////////////
	int updateBoard(BoardDTO dto) {
		return session.update("updateBoard", dto);
	}
	
}
