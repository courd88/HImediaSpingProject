package spring;

import java.util.Collection;

//모든 멤버 정보를 조회해서 > Mamberdao
//멤버 하나하나 정보를 출력 > MemberPrinter
public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	//의존 객체를 생성자를 통해 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	//모든 멤버 정보를 출력하는 메서드 정의
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
	// members.forEach(m -> printer.print(m)); 밑에 for랑 같은내용 다른방식
		// 			    	~~~~~~~~~~~~~~~~ 람다식
		for (Member member : members) {
			printer.print(member);
			
		}
				
	}
	

}
