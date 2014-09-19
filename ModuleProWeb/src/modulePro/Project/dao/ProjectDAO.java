package modulePro.Project.dao;

import java.util.List;
import java.util.Map;

import modulePro.Project.vo.Project;

public interface ProjectDAO {
	
	public int insertProject(Project pro);
	
	public Project selectProject(int proID);
	
	public List listProject(Map<String,Object> paramMap);
	
	public int listProjectCnt(String userID);
	
	public int updateProject(Project pro);

}
