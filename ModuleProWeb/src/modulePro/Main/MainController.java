package modulePro.Main;

import java.util.HashMap;
import java.util.Map;

import modulePro.Report.dao.SalesDAO;
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller	
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping("/dashboard.do")
	public String dashboard(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Throwable{
		return "dashboard";
	}
	
	@RequestMapping("/detail.do")
	public String detail(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Throwable{
		return "detail";
	}
	
	@RequestMapping("/index.do")
	public String login(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Throwable{
		return "login";
	}
	

	

}
