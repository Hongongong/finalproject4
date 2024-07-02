package boardmapper;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	// 회원리스트 조회
	List<MemberDTO> memberList();
	// 해당 id 회원 조회
	MemberDTO oneMember(String id);
	// 전체회원수 조회
	int memberCount();
	// 회원 가입(dto id - select 기존 있는지 확인 + insert)
	String registerMember(MemberDTO dto);
	// 회원정보 수정
	String modifyMember(MemberDTO dto);
	// 회원 탈퇴
	String deleteMember(String id);
	// 페이징 처리 리스트
	List<MemberDTO> memberPagingList(int[] limit);
	// 암호 검색 리스트
	List<MemberDTO> searchMemberList(int[] pw_array);
	// 조건 검색 리스트 - HashMap
	List<MemberDTO> searchMemberList2(HashMap<String, String> map);
	// name 변수값 존재여부에 따른 검색리스트
	List<MemberDTO> searchMemberList3(MemberDTO dto);
	
	List<MemberDTO> searchMemberList4(MemberDTO dto);
}
