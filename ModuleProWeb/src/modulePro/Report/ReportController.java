package modulePro.Report;

import java.util.HashMap;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller	
public class ReportController {

	protected static Logger logger = Logger.getLogger("controller");
	/**
	* Retrieves the download file in XLS format
	* 
	* @return
	*/
	@RequestMapping(value = "/download/pdf.do", method = RequestMethod.GET)
	public ModelAndView doSalesReportPDF(ModelAndView modelAndView) 
	{
		
		logger.debug("Received request to download PDF report");
		 
		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		//SalesDAO dataprovider = new SalesDAO();
		 
		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		//JRDataSource datasource  = dataprovider.getDataSource();
		 
		// In order to use Spring's built-in Jasper support, 
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		//parameterMap.put("datasource", datasource);
		 
		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		//modelAndView = new ModelAndView("pdfReport", parameterMap);
		modelAndView = new ModelAndView("pdfReport", parameterMap);
		 
		// Return the View and the Model combined
		return modelAndView;
	}
	
	@RequestMapping("/reportView.do")
	public String reportView(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Throwable{
		return "reportView";
	}
}
