package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	//멤버 Id를 관리하는 필드 생성
	//멤버 생성시 마다 중복된 아이디 거르기
	private static long nextId = 0;
	
	//멤버 정보를 저장하는 맵 객체를 정의
	// 멤버 정보의 이메일을 키로 사용
	private Map<String, Member> map = new HashMap<>();
	
	// 이메일을 사용해서 멤버 조회
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		this.nextId ++;
		member.setId(this.nextId);
		map.put(member.getEmail(), member);

	}
	//멤버 정보를 최신화
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() {
		return map.values();
				
	}
	
	

}
