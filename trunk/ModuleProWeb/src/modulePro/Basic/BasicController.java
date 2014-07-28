package modulePro.Basic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/basic")
public class BasicController {
	
	@RequestMapping(value="/header.do", method={RequestMethod.GET, RequestMethod.POST})
	public String header(
			Model map,
			String string,
			HttpServletRequest request,
			ModelMap model) throws Throwable{
		
		model.addAttribute("Availability", request.getParameter("Availability"));
		return "include/header";
	}
	
	@RequestMapping(value="/box_Menu.do", method={RequestMethod.GET, RequestMethod.POST})
	public String boxMenu(Model map,String string) throws Throwable{
		return "include/box_menu";
	}
}
