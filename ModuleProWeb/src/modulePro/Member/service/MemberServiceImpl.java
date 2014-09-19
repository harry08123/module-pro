
package modulePro.Member.service;


import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import modulePro.Member.dao.MemberDAO;
import modulePro.Member.vo.Member;

/**
 * 
 * <pre>
 * @Package : modulePro.Member.service
 * @Type : MemberServiceImpl.java
 * @Date : 2014. 7. 30. 오후 2:33:11
 * @Author LeeJungNam
 * @Comment :  
 * </pre>
 */
public class MemberServiceImpl implements UserDetailsService,MemberService{

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memDao) {
		this.memberDAO = memDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see modulePro.Member.service.MemberService#getMemberCnt(modulePro.Member.vo.Member)
	 */
	public int getMemberCnt(Member mem){
		return memberDAO.getMemberCnt(mem);
	}
	
	/*
	 * (non-Javadoc)
	 * @see modulePro.Member.service.MemberService#getMemberInfo(java.lang.String)
	 */
	public Member getMemberInfo(String userID){
		return memberDAO.getMemberInfo(userID);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//로그인 아이디로 패스워드를 가지고 온다.
		Member mem = new Member();
		mem.setUserID(username);
		String userPwd = memberDAO.getUserPwd(mem);
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		UserDetails user = new User(username,userPwd,roles);
		return user;
	}
	
	
}
