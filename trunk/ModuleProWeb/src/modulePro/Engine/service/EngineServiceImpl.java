package modulePro.Engine.service;

import java.util.List;
import java.util.Map;

import modulePro.Engine.dao.EngineDAO;
import modulePro.Engine.vo.Figures;
import modulePro.Engine.vo.Modeling;
import modulePro.Engine.vo.SampleBean;

public class EngineServiceImpl implements EngineService{
	
	private EngineDAO engineDAO;
	
	public void setengineDAO(EngineDAO engineDAO){
		this.engineDAO = engineDAO;
	}

	@Override
	public List<Modeling> getModelingList(Modeling modeling) {
		return engineDAO.getModelingList(modeling);
	}

	@Override
	public List<SampleBean> getFiguresList(Modeling modeling) {
		return engineDAO.getFiguresList(modeling);
	}

	@Override
	public int insertModeling(Modeling modeling) {
		return engineDAO.insertModeling(modeling);
	}
	
	@Override
	public int updateModeling(Modeling modeling) {
		return engineDAO.updateModeling(modeling);
	}

	@Override
	public int deleteModelingLine(Modeling modeling) {
		return engineDAO.deleteModelingLine(modeling);
	}

	@Override
	public int deleteModeling(Modeling modeling) {
		return engineDAO.deleteModeling(modeling);
	}

	@Override
	public int insertFigures(Figures figures) {
		return engineDAO.insertFigures(figures);
	}

	@Override
	public int updateFigures(Figures figures) {
		return engineDAO.updateFigures(figures);
	}

	@Override
	public int deleteFigures(Figures figures) {
		return engineDAO.deleteFigures(figures);
	}

	@Override
	public List<Figures> selectFigures(Figures figures) {
		return engineDAO.selectFigures(figures);
	}

	@Override
	public Map<String, String> getModel(Map<String, String> paramMap) {
		return engineDAO.getModel(paramMap);
	}


}
