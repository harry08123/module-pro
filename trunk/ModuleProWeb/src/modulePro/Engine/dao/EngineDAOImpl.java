package modulePro.Engine.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import modulePro.Engine.vo.Figures;
import modulePro.Engine.vo.Modeling;
import modulePro.Engine.vo.SampleBean;

public class EngineDAOImpl extends SqlSessionDaoSupport implements EngineDAO{

	@Override
	public List<Modeling> getModelingList(Modeling modeling) {
		return getSqlSession().selectList("modulePro.Engine.getModelingList", modeling);
	}

	@Override
	public List<SampleBean> getFiguresList(Modeling modeling) {
		return getSqlSession().selectList("modulePro.Engine.getFiguresList", modeling);
	}

	@Override
	public int insertModeling(Modeling modeling) {
		return getSqlSession().insert("modulePro.Engine.insertModeling", modeling);
	}
	
	@Override
	public int updateModeling(Modeling modeling) {
		return getSqlSession().update("modulePro.Engine.updateModeling", modeling);
	}

	@Override
	public int deleteModelingLine(Modeling modeling) {
		return getSqlSession().update("modulePro.Engine.deleteModelingLine", modeling);
	}

	@Override
	public int deleteModeling(Modeling modeling) {
		return getSqlSession().delete("modulePro.Engine.deleteModeling", modeling);
	}

	@Override
	public int insertFigures(Figures figures) {
		return getSqlSession().insert("modulePro.Engine.insertFigures", figures);
	}

	@Override
	public int updateFigures(Figures figures) {
		return getSqlSession().update("modulePro.Engine.updateFigures", figures);
	}

	@Override
	public int deleteFigures(Figures figures) {
		return getSqlSession().delete("modulePro.Engine.deleteFigures",figures);
	}

	@Override
	public List<Figures> selectFigures(Figures figures) {
		return getSqlSession().selectList("modulePro.Engine.selectFigures",figures);
	}

	@Override
	public Map<String, String> getModel(Map<String, String> paramMap) {
		return getSqlSession().selectOne("modulePro.Engine.getModel", paramMap);
	}


}
