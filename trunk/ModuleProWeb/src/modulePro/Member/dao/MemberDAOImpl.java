package modulePro.Member.dao;

import modulePro.Member.vo.Member;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/**
 * 
 * <pre>
 * @Package : modulePro.Member.dao
 * @Type : MemberDAOImpl.java
 * @Date : 2014. 7. 30. 오후 1:41:26
 * @Author LeeJungNam
 * @Comment : 
 * </pre>
 */
public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO{
	
	public int getMemberCnt(Member mem){
		return (Integer)getSqlSession().selectOne("modulePro.MemberInfo.MemberCnt",mem);
	}
	
	public String getUserPwd(Member mem) {
		// TODO Auto-generated method stub
		return (String)getSqlSession().selectOne("modulePro.MemberInfo.getUserPwd",mem);
	}

	
	@Override
	public Member getMemberInfo(String userID) {
		// TODO Auto-generated method stub
		return (Member)getSqlSession().selectOne("modulePro.MemberInfo.getMemberInfo", userID);
	}
}
