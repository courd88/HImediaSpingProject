package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	//회원 정보를 조회해서  > MemberDao
	//출력 기능을 구현 >MemberPrinter
	
	//의존객체를 필드로 추가
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	//setter 메서드를 통해서 의존객체를 주입
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	//이메일과 일치하는 회원의 정보를 출력하는 메서드
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 회원 정보가 없습니다");
			return;
		}
		printer.print(member);
	}

}
