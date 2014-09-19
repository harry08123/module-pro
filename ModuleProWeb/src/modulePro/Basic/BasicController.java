package modulePro.Basic;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modulePro.Member.service.MemberService;
import modulePro.Member.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {
	
	@Autowired
	private MemberService memService;
	
	@RequestMapping("/header.do")
	public String header(
			String string,
			HttpServletRequest request,
			ModelMap model,
			Principal principal,
			HttpSession session) throws Throwable{
		
		Member mem = new Member();
		if (session.getAttribute("UserInfo") == null)
		{	
			mem = memService.getMemberInfo(principal.getName());
			session.setAttribute("UserInfo", mem);
			
		}else{
			mem = (Member)session.getAttribute("UserInfo");
		}
		
		model.addAttribute("mem", mem);
		model.addAttribute("Availability", request.getParameter("Availability"));
		return "include/header";
	}
	
	@RequestMapping("/box_Menu.do")
	public String boxMenu(Model map,String string) throws Throwable{
		return "include/box_menu";
	}
}
