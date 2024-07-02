package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
	
	// 실행할 sql 메소드와 메소드 이름이 같아야함

	int insertBoard(BoardDTO dto);
	//////////////////////
	int totalCount();
	
	List<BoardDTO> pagingBoardList(int[] limit);
	//////////////////////
	int updateViewCount(int seq);
	
	BoardDTO getDetail(int seq);
	//////////////////////
	int deleteBoard(int seq);
	//////////////
	int updateBoard(BoardDTO dto);
	
	List<BoardDTO> boardSearchList(HashMap map);
	
	int boardSearchCount(HashMap map);
	
}
