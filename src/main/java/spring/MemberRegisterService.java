package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	
	//회원 정보를 다루는 DAO 객체를 필드로 선언
	private MemberDao memberDao;

	// 생성자를 통한 필드를 초기화
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//회원 등록을 처리하는 메서드
	//
	public Long regist(RegisterRequest req) {
		//이메일 중복 확인
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}
		
		//회원등록
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		
		return newMember.getId();
				
	}
	
	
	

}
