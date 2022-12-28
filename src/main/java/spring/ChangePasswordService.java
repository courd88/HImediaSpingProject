package spring;

public class ChangePasswordService {
	
	//회원 정보 관리 기능을 구현한 MemberDao를 필드로 정의
	private MemberDao memberDao;
	
	//setter 메서드를 통해서 의존 객체를 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//비밀번호 변경하는 메서드를 정의
	public void changePassword(String email, String oldPassword, String newPassword) {
		//매개변수로 전달된 이메일을 사용하는 사람 확인
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		//멤버의 패스워드를 변경
		member.changePassword(oldPassword, newPassword);
		
		//변경된 멤버의 정보 변환
		memberDao.update(member);
	}

}
