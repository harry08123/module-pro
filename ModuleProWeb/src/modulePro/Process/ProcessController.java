package modulePro.Process;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProcessController {

	@RequestMapping(value="/newProcess.do", method={RequestMethod.GET, RequestMethod.POST})
	public String newProcess(Model map,String string) throws Throwable{
		return "process/new";
	}
	
	@RequestMapping(value="/processList.do", method={RequestMethod.GET, RequestMethod.POST})
	public String ProcessList(Model map,String string) throws Throwable{
		return "process/processList";
	}
	
	@RequestMapping(value="/weightFactor.do", method={RequestMethod.GET, RequestMethod.POST})
	public String weightFactor(Model map,String string) throws Throwable{
		
		return "weightFactor";
	}
}
