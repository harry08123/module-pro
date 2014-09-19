package modulePro.AHP;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modulePro.Util.PageNavigation;

@Controller
public class AhpController {
	
	@RequestMapping("/AHP.do")
	public String ReadOfWrite(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Exception{
	
		//String value = "";

	      // IE Download directory (HKEY_CURRENT_USER)
		/*
	      value = WinRegistry.readString(WinRegistry.HKEY_CURRENT_USER,"Software\\Microsoft\\Internet Explorer","Download Directory");
	      System.out.println("IE Download directory = " + value);

	      // Query for Acrobat Reader installation path (HKEY_LOCAL_MACHINE)
	      value = WinRegistry.readString(
	          WinRegistry.HKEY_LOCAL_MACHINE,
	          "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\AcroRd32.exe",
	          "");
	      System.out.println("Acrobat Reader Path = " + value);
*/

	      /*
	         this code is broken under win7 64 :-(  20130112

	      // Loop through installed JRE and print the JAVA_HOME value
	      // HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Java Runtime Environment
	      java.util.Map res1 = WinRegistry.readStringValues(
	          WinRegistry.HKEY_LOCAL_MACHINE,
	          "SOFTWARE\\Wow6432Node\\JavaSoft\\Java Runtime Environment");
	      System.out.println("1:" + res1.toString());
	      */

		  // on 64bit Windows, you need Wow6432Node to access 32bit related information
		  //   "SOFTWARE\\Wow6432Node\\Microsoft\\Windows NT\\CurrentVersion"
	/*      java.util.List res2 = WinRegistry.readStringSubKeys(
	          WinRegistry.HKEY_CURRENT_USER,
	          "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion");
	      System.out.println(res2.toString());
/*
	      WinRegistry.createKey(
	          WinRegistry.HKEY_CURRENT_USER, "SOFTWARE\\rgagnon.com");
	      WinRegistry.writeStringValue(
	          WinRegistry.HKEY_CURRENT_USER,
	          "SOFTWARE\\rgagnon.com",
	          "HowTo",
	          "java");
*/
//	      WinRegistry.deleteValue(
//	          WinRegistry.HKEY_CURRENT_USER,
//	          "SOFTWARE\\rgagnon.com", "HowTo");
//	      WinRegistry.deleteKey(
//	          WinRegistry.HKEY_CURRENT_USER,
//	          "SOFTWARE\\rgagnon.com\\");

	    //  System.out.println("Done." );
	      
	      return "ahp";
	  }
	
	@RequestMapping("/photo.do")
	public String photo(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Exception{
	      
	      return "photo";
	}
	
	@RequestMapping("/ahp2.do")
	public String ahp2(@RequestParam Map<String,Object> paramMap, ModelMap model) throws Exception{
	      
	      return "ahp2";
	}
}
