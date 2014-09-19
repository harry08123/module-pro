package modulePro.Member;

import java.util.Map;

import modulePro.Member.service.MemberService;
import modulePro.Member.vo.Member;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = Logger.getLogger(MemberController.class);
	
	@RequestMapping("/memberLogin.do")
	public String memberLogin(
			@RequestParam Map<String,Object> paramMap, 
			ModelMap model,
			Throwable locale) throws Exception{
	
		//logger.info("Welcome home! The client locale is {}.", locale);
		Member mem = new Member();
		mem.setUserID(paramMap.get("username").toString());
		mem.setPassword(paramMap.get("password").toString());
		
		int result = memberService.getMemberCnt(mem);
		
		if (result > 0){
			return "redirct:/newProcess.do";
		}else {
			model.put("message", "아이디 또는 비밀번호가 틀렸습니다.");
			return "login";
		}
	}

}
