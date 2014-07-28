package modulePro.ModuleUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatisticsController {
	
	@RequestMapping(value="/statistics.do", method={RequestMethod.GET, RequestMethod.POST})
	public String newProcess(Model map,String string) throws Throwable{
		return "moduleUnit/statistics";
	}
}
