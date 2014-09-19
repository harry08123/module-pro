package modulePro.Member.service;

import modulePro.Member.vo.Member;
/**
 * 
 * <pre>
 * @Package : modulePro.Member.service
 * @Type : MemberService.java
 * @Date : 2014. 7. 30. 오후 2:34:54
 * @Author LeeJungNam
 * @Comment : 멤버관련 서비스
 * </pre>
 */
public interface MemberService {
	
	/** 
	 * <pre>
	 * @methodName : getMemberCnt
	 * @Author : LeeJungNam
	 * @Date : 2014. 7. 30. 오후 2:34:31
	 * @Comment : 해당 멤버가 존재하는지 확인하기 위한 메소도
	 * </pre>
	 * @param mem
	 * @return
	 */
	public int getMemberCnt(Member mem);
	
	/**
	 * <pre>
	 * @methodName : getMemberInfo
	 * @Author : LeeJungNam
	 * @Date : 2014. 7. 30. 오후 2:34:27
	 * @Comment : 로그인 후 UserId로 유저정보를 가져온다. (수정 필요) 
	 * </pre>
	 * @param UserID
	 * @return
	 */
	public Member getMemberInfo(String UserID);
}
