package modulePro.Project;

import modulePro.Member.service.MemberService;
import modulePro.Member.vo.Member;
import modulePro.Project.service.ProjectService;
import modulePro.Project.vo.Project;
import modulePro.Util.PageNavigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProjectController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/message-context.xml");
	
	@Autowired
	private ProjectService proService;
	
	@Autowired
	private MemberService memService;
	
	@RequestMapping("/projectNew.do")
	public String newProcess(
			@RequestParam Map<String, Object> paramMap,
			ModelMap model,
			Principal principal,
			HttpSession session,
			Project pro,
			Member mem,
			HttpServletRequest request) throws Throwable{
		
		
		if (session.getAttribute("UserInfo") == null)
		{	
			mem = memService.getMemberInfo(principal.getName());
			System.out.println();
			session.setAttribute("UserInfo", mem);
			
		}else{
			mem = (Member)session.getAttribute("UserInfo");
		}
		pro.setUserID(mem.getUserID());
		pro.setProUser(mem.getUserName());
		
		model.addAttribute("pro",pro);
		
		//FlashMap에 저장되어 전달된 값을 가져온다.
		//redirectAttributes.addAttribute로 넘어온 값을 받기 위해서 경우
	    Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);  
	    if(flashMap !=null) {
	    	model.addAttribute("msg", (String)flashMap.get("msg"));
	    }  
		return "project/new";
	}
	
	@RequestMapping(value="/weightFactor.do", method={RequestMethod.GET, RequestMethod.POST})
	public String weightFactor(Model map,String string) throws Throwable{
		
		return "weightFactor";
	}
	
	@RequestMapping("/insertPro.do")
	public String insertProject(
			@ModelAttribute @Valid Project pro,
			BindingResult bindingResult,
			ModelMap model,
			RedirectAttributes redirectAttributes) throws Throwable{
		
		//에러발생시 반환.
        if(bindingResult.hasErrors()){
        	model.addAttribute("pro",new Project());
        	//model.addAttribute("pro",pro);
            return "project/new";
        }
		
		int result = proService.insertProject(pro);
		
		//redirect 시에는 Post로 넘길경우
		redirectAttributes.addFlashAttribute("msg", result+"건 등록되었습니다.");
		return "redirect:/projectNew.do";
	}
	
	@RequestMapping("/projectModify.do")
	public String modifyProject(
			@RequestParam("proID") int proID,
			Project pro,
			ModelMap model,
			HttpSession session) throws Throwable{
		
		Member mem = (Member)session.getAttribute("UserInfo");
		mem.setProID(proID);
		session.setAttribute("UserInfo", mem);
		
		pro = proService.selectProject(proID);
		model.addAttribute("pro", pro);
			  
		return "project/modify";
	}
	
	@RequestMapping("/updateProject.do")
	public String updateProject(
			@ModelAttribute @Valid Project pro,
			BindingResult bindingResult,
			ModelMap model,
			RedirectAttributes redirectAttributes) throws Throwable{
		
		//에러발생시 반환.
        if(bindingResult.hasErrors()){
        	model.addAttribute("pro",new Project());
        	//model.addAttribute("pro",pro);
            return "project/new";
        }
		
		int result = proService.insertProject(pro);
		
		//redirect 시에는 Post로 넘길경우
		redirectAttributes.addFlashAttribute("msg", "프로젝트가 수정되었습니다.");
		return "redirect:/projectModify.do";
	}
	
	
	@RequestMapping("/projectList.do")
	public String listProject(
			@RequestParam Map<String, Object> paramMap,
			@RequestParam(value="pageNo", required=true,defaultValue="1") int pageNo,
			ModelMap model,
			Principal principal,
			HttpServletRequest request) throws Throwable{
		
		String userId = principal.getName();
		
		/**
		 * 리스트 페이지 네비게이션 시작
		 */
		PageNavigation pageNavi = new PageNavigation();
		pageNavi.setCurrentPageNo(pageNo);
		int totalCnt = proService.listProjectCnt(userId);
		
		pageNavi.setNavigationInfo(totalCnt, pageNavi.getPageRowCnt(), pageNo, request);
		
		paramMap.put("listNum", pageNavi.getPageRowCnt());
		paramMap.put("pageNo", pageNavi.getCurrentPageNo());
		paramMap.put("userID", principal.getName());
		
		List<Project> list = proService.listProject(paramMap);
		
		/**
		 * 리스트 페이지 네비게이션 종료
		 */
		
		model.addAttribute("pro", list);
		model.addAttribute("pageNavigation", pageNavi);
		
		return "project/list";
	}
}
