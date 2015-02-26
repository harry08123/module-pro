package modulePro.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import modulePro.Engine.service.EngineService;
import modulePro.Engine.vo.Modeling;
import modulePro.Engine.vo.SampleBean;
import modulePro.Engine.vo.Sampleform;
import modulePro.Engine.vo.SimulationFields;
import modulePro.Editor.vo.Project;

@Controller
public class EngineController {
	
	@Autowired
	private EngineService engineService;
	
	public static HashMap<String, SimulationFields[]> simulationArr = new HashMap<String, SimulationFields[]>();
	
	@RequestMapping("/runSimulator.do")
	public @ResponseBody Map<String, Object> runSimulator(Project project, 
			Modeling modeling,
			@RequestParam Map<String, String> paramMap){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		project.setProIterNum(Integer.parseInt(paramMap.get("proIterNum")));
		project.setProStartTime(Integer.parseInt(paramMap.get("proStartTime")));
		project.setProLifeTime(Integer.parseInt(paramMap.get("proLifeTime")));
		project.setProTd(Integer.parseInt(paramMap.get("proTd")));
		
		modeling.setMoProject(Integer.parseInt(paramMap.get("mo_project")));
		if(null != paramMap.get("moUid")){
			System.out.println(paramMap.get("moUid"));
			modeling.setMoUid(Integer.parseInt(paramMap.get("moUid")));
		}
		
		SampleEngine sampleEngine = new SampleEngine();
		List<Modeling> modelingList = engineService.getModelingList(modeling);
		Vector<Modeling> modelingVector = new Vector<Modeling>(modelingList.size());
		ArrayList<SampleBean> sampleBeanList = new ArrayList<SampleBean>();
		modelingVector.addAll(modelingList);
		for(int i=0; i<modelingList.size(); i++){
			List<SampleBean> figuresList = engineService.getFiguresList(modelingVector.get(i));
			SampleBean[] sampleBeanArr = new SampleBean[figuresList.size()];
			for(int j=0; j<sampleBeanArr.length; j++){
				sampleBeanArr[j] = figuresList.get(j);
			}
			modelingVector.get(i).setSamplesList(sampleBeanArr);
			sampleBeanList.addAll(figuresList);
		}
		
		Sampleform sampleform = sampleEngine.engineCore(project, sampleBeanList, simulationArr);
		
		Double density = new Double(0);
		if("rect".equals(modelingList.get(0).getMoType())){
			double mo_width = Double.parseDouble(modelingList.get(0).getMo_width());
			double mo_height = Double.parseDouble(modelingList.get(0).getMo_height());
			double mo_persons = Double.parseDouble(modelingList.get(0).getMo_persons());
			density = mo_width*mo_height/mo_persons;
		}else{
			double mo_rardius = Double.parseDouble(modelingList.get(0).getMo_rardius());
			double mo_persons = Double.parseDouble(modelingList.get(0).getMo_persons());
			density = mo_rardius*mo_rardius*Math.PI/mo_persons;
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+density);
		
		resultMap.put("totAvailability", (double)sampleform.getTotAvailability());
		resultMap.put("density", density);
		
		return resultMap;
	}
}
