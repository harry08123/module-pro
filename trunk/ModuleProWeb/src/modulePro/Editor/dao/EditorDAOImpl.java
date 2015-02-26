package modulePro.Editor.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EditorDAOImpl extends SqlSessionDaoSupport implements EditorDAO{
	
	@Override
	public int updateEditorProject(Map<String, Object> paramMap) {
		return getSqlSession().update("modulePro.Editor.updateEditorProject", paramMap);
	}
	
	@Override
	public int insertEditorProject(Map<String, Object> paramMap) {
		return getSqlSession().insert("modulePro.Editor.insertEditorProject", paramMap);
	}
	
	@Override
	public List<Map<String, Object>> selectProjectList(Map<String, Object> paramMap) {
		return getSqlSession().selectList("modulePro.Editor.selectProjectList", paramMap);
	}

	@Override
	public List<Map<String, Object>> selectModelingList(Map<String, Object> paramMap) {
		return getSqlSession().selectList("modulePro.Editor.selectModelingList", paramMap);
	}
	
	@Override
	public int insertModelingInfo(Map<String, Object> paramMap) {
		return getSqlSession().insert("modulePro.Editor.insertModelingInfo",paramMap);
	}

	@Override
	public int updateModelingInfo(Map<String, Object> paramMap) {
		return getSqlSession().update("modulePro.Editor.updateModelingInfo",paramMap);
	}

	@Override
	public int deleteModelingInfo(Map<String, Object> paramMap) {
		return getSqlSession().delete("modulePro.Editor.deleteModelingInfo",paramMap);
	}

	@Override
	public List<Map<String, Object>> selectFiguresList(Map<String, Object> paramMap) {
		return getSqlSession().selectList("modulePro.Editor.selectFiguresList", paramMap);
	}

	@Override
	public int insertFigures(Map<String, Object> paramMap) {
		return getSqlSession().insert("modulePro.Editor.insertFigures",paramMap);
	}

	@Override
	public int updateFigures(Map<String, Object> paramMap) {
		return getSqlSession().update("modulePro.Editor.updateFigures",paramMap);
	}

	@Override
	public int deleteFigures(Map<String, Object> paramMap) {
		return getSqlSession().delete("modulePro.Editor.deleteFigures",paramMap);
	}

}
