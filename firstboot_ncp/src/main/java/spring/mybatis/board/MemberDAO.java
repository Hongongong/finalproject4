package spring.mybatis.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 직접 데이터가 존재하는 곳에 접근하는 객체
// SQL-MAPPING.xml 정의 sql들 6개 - 각각 실행 메소드 6개 정의
@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession session;

	// @Autowired 하면 set 메소드 필요없음
//	public void setSession(SqlSession session) {
//		this.session = session;
//	}
	
	// 전체 회원 List 형태 조회
	List<MemberDTO> memberList() {
		List<MemberDTO> list = session.selectList("a.memberList"); // a. 은 지금은 중복 없기때문에 안붙여도됨
		return list;
	}
	
	// 1명 회원 조회
	MemberDTO oneMember(String id) {
		MemberDTO dto = session.selectOne("oneMember", id);
		return dto;
	}

	// 회원 수 조회
	int memberCount() {
		int count = session.selectOne("memberCount");
		return count;
	}

	// 회원 추가
	int intsertMember(MemberDTO dto) {
		int insertrows = session.insert("insertMemberDTO", dto);
		// session.commit(); // 자동 커밋 설정 상태이므로 생략
		return insertrows;
	}

	// 회원정보 수정
	int updateMember(MemberDTO dto) {
		return session.update("updateMember", dto);
	}
	

	// 회원삭제
	int deleteMember(String id) {
		return session.delete("deleteMember", id);
	}
	
	// 페이징 처리 리스트
	List<MemberDTO> memberPagingList(int[] limit) {
		return session.selectList("memberPagingList", limit);
	}
	
	// 암호검색리스트
	List<MemberDTO>searchMemberList(int[] pw_array) {
		return session.selectList("searchMemberList", pw_array);
	}
	
	// 조건(컬럼명, 값)에 맞는 검색 리스트 - HashMap
	List<MemberDTO> searchMemberList2(HashMap map) {
		return session.selectList("searchMemberList2", map);
	}
	
	// name 변수값 존재여부에 따른 검색리스트
	List<MemberDTO> searchMemberList3(MemberDTO dto) {
		return session.selectList("searchMemberList3", dto); // dto.getName() 있으면 where
	}
	
	List<MemberDTO> searchMemberList4(MemberDTO dto) {
		return session.selectList("searchMemberList4", dto);
	}
	
}
