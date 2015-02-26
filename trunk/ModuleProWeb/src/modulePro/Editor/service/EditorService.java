package modulePro.Editor.service;

import java.util.List;
import java.util.Map;


public interface EditorService {
	
	int updateEditorProject(Map<String, Object> paramMap);
	
	int insertEditorProject(Map<String, Object> paramMap);
	
	List<Map<String, Object>> selectProjectList(Map<String, Object> paramMap);
	
	List<Map<String, Object>> selectModelingList(Map<String, Object> paramMap);

	int insertModelingInfo(Map<String, Object> paramMap);

	int updateModelingInfo(Map<String, Object> paramMap);

	int deleteModelingInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> selectFiguresList(Map<String, Object> paramMap);

	int insertFigures(Map<String, Object> paramMap);

	int updateFigures(Map<String, Object> paramMap);

	int deleteFigures(Map<String, Object> paramMap);

}
