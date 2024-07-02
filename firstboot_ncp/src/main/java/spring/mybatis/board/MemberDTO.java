package spring.mybatis.board;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	String id, name;
	int pw;
	String phone, email, regtime;

	public MemberDTO(String id, String name, int pw) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		System.out.println("MemberDTO 매개변수 있는 생성자 호출");
	}
	
	public MemberDTO() {
		// System.out.println("MemberDTO 기본 생성자 호출");
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : " + pw + " : " + phone + " : " + email + " : " + regtime;
	}
	
	
	
}
