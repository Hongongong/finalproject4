package spring.mybatis.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// sql 호출, sql 실행결과 - main
public class MybatisMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = 
				builder.build(Resources.getResourceAsReader("mybatis/service/mybatis-config.xml"));
	
		SqlSession session = factory.openSession(true); // DML 자동 COMMIT
		
		MemberDAO dao = new MemberDAO();
		// dao.setSession(session); // dao는 session 주입받음
		
		MemberServiceImpl service = new MemberServiceImpl();
		// service.setDao(dao); // service는 dao 주입받음
/*
		// 전체회원리스트 조회
		System.out.println("=====전체회원조회결과=====");
		List<MemberDTO> list = service.memberList();
		for(MemberDTO listdto : list) {
			System.out.println(listdto);
		}
		
		// id로 1명 조회
		System.out.println("=====회원1명조회결과=====");
		MemberDTO dto = service.oneMember("mybatis1");
		System.out.println(dto);
		
		// 전체회원수 조회
		System.out.println("=====전체회원수조회결과=====");
		int membercount = service.memberCount();
		System.out.println(membercount + "명");
		
		// 회원가입
		System.out.println("=====회원가입결과=====");
		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis2");
		insertdto.setName("김강산");
		insertdto.setPw(2222);
		insertdto.setEmail("kang@san.com");
		insertdto.setPhone("010-2345-5555");
		
		String insertresult = service.registerMember(insertdto);
		System.out.println(insertresult);
		
		// 회원정보 수정
		System.out.println("=====회원정보수정결과=====");
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mybatis1");
		updatedto.setPw(3333);
		updatedto.setEmail("Lee@mem.com");
		
		String updateresult = service.modifyMember(updatedto);
		System.out.println(updateresult);
		
		// 회원탈퇴
		String deleteresult = service.deleteMember("test1");
		System.out.println(deleteresult);

		// 페이징 처리 리스트
		// 12명 - 5명씩 1페이지 - 1 2 3
		int page = 1; // 현재 사용자가 선택한 페이지번호
		int membercount = 5; // 한페이지에 보여줄 멤버수
		int start = (page - 1) * membercount;
		int[] limit = {start, membercount};
		
		List<MemberDTO> list = service.memberPagingList(limit);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
	
		// 암호 검색 리스트
		int[] pw_array = {1111, 2222, 3333, 4444, 5555};
		List<MemberDTO> list2 = service.searchMemberList(pw_array);
		for(MemberDTO dto : list2) {
			System.out.println(dto);
		}
		
		// 검색 리스트 - 2개 파라미터(컬럼명, 값)
		// HashMap 사용
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colname", "name");
		map.put("colvalue", "%길%");
		List<MemberDTO> list3 = service.searchMemberList2(map);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		
		// name 변수값 존재여부에 따른 검색리스트
		MemberDTO dto = new MemberDTO();
		//dto.setName("%길%");
		List<MemberDTO> list4 = service.searchMemberList3(dto);
		for(MemberDTO dto4 : list4) {
			System.out.println(dto4);
		}
*/
		MemberDTO dto = new MemberDTO();
		dto.setName("길");
		dto.setId("db");
		List<MemberDTO> list5 = service.searchMemberList4(dto);
		for(MemberDTO dto5 : list5) {
			System.out.println(dto5);
		}
		
	}

}
