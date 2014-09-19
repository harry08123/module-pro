package modulePro.Member.dao;

import modulePro.Member.vo.Member;

public interface MemberDAO {	
	
	public int getMemberCnt(Member mem);
	
	public String getUserPwd(Member mem);
	
	public Member getMemberInfo(String userID);
}
