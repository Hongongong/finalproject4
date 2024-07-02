package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// 직접 데이터가 존재하는 곳에 접근하는 객체
// SQL-MAPPING.xml 정의 sql들 6개 - 각각 실행 메소드 6개 정의
@Repository
@Mapper
public interface MemberDAO {
	
	// sql 메소드와 메소드명 동일해야함
	
	// 전체 회원 List 형태 조회
	List<MemberDTO> memberList();
	
	// 1명 회원 조회
	MemberDTO oneMember(String id);

	// 회원 수 조회
	int memberCount();

	// 회원 추가
	int intsertMemberDTO(MemberDTO dto);

	// 회원정보 수정
	int updateMember(MemberDTO dto);

	// 회원삭제
	int deleteMember(String id);
	
	// 페이징 처리 리스트
	List<MemberDTO> memberPagingList(int[] limit);
	
	// 암호검색리스트
	List<MemberDTO> searchMemberList(int[] pw_array);
	
	// 조건(컬럼명, 값)에 맞는 검색 리스트 - HashMap
	List<MemberDTO> searchMemberList2(HashMap map);
	
	// name 변수값 존재여부에 따른 검색리스트
	List<MemberDTO> searchMemberList3(MemberDTO dto);
	
	List<MemberDTO> searchMemberList4(MemberDTO dto);
	
}
