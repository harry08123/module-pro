package modulePro.Editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modulePro.Editor.service.EditorService;
import modulePro.Util.FileUpLoad;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class EditorController {
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private EditorService editorService;
	
	@RequestMapping("/editor.do")
	public String editor(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		List<Map<String, Object>> projectList = editorService.selectProjectList(paramMap);
		Map<String,Object> project = new HashMap<String, Object>();
		if(projectList.size()<1){
			editorService.insertEditorProject(paramMap);
			projectList = editorService.selectProjectList(paramMap);
		}
		project = projectList.get(0);
		model.addAttribute("project", project);
		
		List<Map<String,Object>> modelingList = editorService.selectModelingList(paramMap);
		model.addAttribute("modelingList", modelingList);
		
		return "editor/canvasTest";
	}
	
	@RequestMapping(value = "/updateEditorProject.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String updateEditorProject(@RequestParam Map<String, Object> paramMap, 
			ModelMap model,
			MultipartHttpServletRequest request) throws Throwable{
		paramMap.put("proUid", paramMap.get("mo_project"));
		
		String fileName = new FileUpLoad().fileUpLoad(request);
		paramMap.put("proFile", fileName);
		editorService.updateEditorProject(paramMap);
		
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("mo_project", paramMap.get("mo_project").toString());
		return "redirect:editor.do";
	}
	
	@RequestMapping("/selectModel.do")
	public @ResponseBody Map<String,Object> selectModel(@RequestParam Map<String,Object> paramMap) throws Throwable{
		return editorService.selectModelingList(paramMap).get(0);
	}
	
	@RequestMapping("/insertModelingInfo.do")
	public @ResponseBody Map<String,Object> insertModelingInfo(@RequestParam Map<String,Object> paramMap) throws Throwable{
		editorService.insertModelingInfo(paramMap);
		return paramMap;
	}
	
	@RequestMapping("/updateModelingInfo.do")
	public @ResponseBody Map<String,Object> updateModelingInfo(@RequestParam Map<String,Object> paramMap) throws Throwable{
		editorService.updateModelingInfo(paramMap);
		return paramMap;
	}
	
	@RequestMapping("/deleteModelingInfo.do")
	public @ResponseBody Map<String,Object> deleteModelingInfo(@RequestParam Map<String,Object> paramMap) throws Throwable{
		editorService.deleteModelingInfo(paramMap);
		editorService.deleteFigures(paramMap);
		return paramMap;
	}
	
	@RequestMapping("/popupProperties.do")
	public String popupProperties(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		model.addAttribute("paramMap", paramMap);
		
		List<Map<String,Object>> modelingList = editorService.selectModelingList(paramMap);
		model.addAttribute("model", modelingList.get(0));
		
		List<Map<String,Object>> figuresList = editorService.selectFiguresList(paramMap);
		model.addAttribute("figuresList", figuresList);
		return "editor/popupProperties";
	}
	
	@RequestMapping("/selectFigures.do")
	public @ResponseBody Map<String,Object> selectFigures(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		return editorService.selectFiguresList(paramMap).get(0);
	}
	
	@RequestMapping("/insertFigures.do")
	public String insertFigures(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		editorService.insertFigures(paramMap);
		
		model.addAttribute("figMoUid", paramMap.get("figMoUid"));
		model.addAttribute("figProjectUid", paramMap.get("figProjectUid"));
		return "redirect:popupProperties.do";
	}
	
	@RequestMapping("/updateFigures.do")
	public String updateFigures(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		editorService.updateFigures(paramMap);
		
		model.addAttribute("figMoUid", paramMap.get("figMoUid"));
		model.addAttribute("figProjectUid", paramMap.get("figProjectUid"));
		return "redirect:popupProperties.do";
	}
	
	@RequestMapping("/deleteFigures.do")
	public String deleteFigures(@RequestParam Map<String,Object> paramMap, 
			ModelMap model) throws Throwable{
		editorService.deleteFigures(paramMap);
		
		model.addAttribute("figMoUid", paramMap.get("figMoUid"));
		model.addAttribute("figProjectUid", paramMap.get("figProjectUid"));
		return "redirect:popupProperties.do";
	}
}
