package modulePro.Editor.service;

import java.util.List;
import java.util.Map;

import modulePro.Editor.dao.EditorDAO;


public class EditorServiceImpl implements EditorService{

	private EditorDAO editorDAO;
	
	public void setEditorDAO(EditorDAO editorDAO){
		this.editorDAO = editorDAO;
	}
	
	@Override
	public List<Map<String, Object>> selectProjectList(Map<String, Object> paramMap) {
		return editorDAO.selectProjectList(paramMap);
	}
	
	@Override
	public List<Map<String, Object>> selectModelingList(Map<String, Object> paramMap) {
		return editorDAO.selectModelingList(paramMap);
	}

	@Override
	public int insertModelingInfo(Map<String, Object> paramMap) {
		return editorDAO.insertModelingInfo(paramMap);
	}

	@Override
	public int updateModelingInfo(Map<String, Object> paramMap) {
		return editorDAO.updateModelingInfo(paramMap);
	}

	@Override
	public int deleteModelingInfo(Map<String, Object> paramMap) {
		return editorDAO.deleteModelingInfo(paramMap);
	}

	@Override
	public List<Map<String, Object>> selectFiguresList(Map<String, Object> paramMap) {
		return editorDAO.selectFiguresList(paramMap);
	}

	@Override
	public int insertFigures(Map<String, Object> paramMap) {
		return editorDAO.insertFigures(paramMap);
	}

	@Override
	public int updateFigures(Map<String, Object> paramMap) {
		return editorDAO.updateFigures(paramMap);
	}

	@Override
	public int deleteFigures(Map<String, Object> paramMap) {
		return editorDAO.deleteFigures(paramMap);
	}

	@Override
	public int updateEditorProject(Map<String, Object> paramMap) {
		return editorDAO.updateEditorProject(paramMap);
	}

	@Override
	public int insertEditorProject(Map<String, Object> paramMap) {
		return editorDAO.insertEditorProject(paramMap);
	}

}
