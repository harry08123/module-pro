package modulePro.Engine.dao;

import java.util.List;
import java.util.Map;

import modulePro.Engine.vo.Figures;
import modulePro.Engine.vo.Modeling;
import modulePro.Engine.vo.SampleBean;

public interface EngineDAO {

	List<Modeling> getModelingList(Modeling modeling);

	List<SampleBean> getFiguresList(Modeling modeling);

	int insertModeling(Modeling modeling);
	
	int updateModeling(Modeling modeling);
	
	int deleteModelingLine(Modeling modeling);

	int deleteModeling(Modeling modeling);

	int insertFigures(Figures figures);

	int updateFigures(Figures figures);

	int deleteFigures(Figures figures);

	List<Figures> selectFigures(Figures figures);

	Map<String, String> getModel(Map<String, String> paramMap);

}
