package modulePro.Project.service;

import java.util.List;
import java.util.Map;

import modulePro.Project.dao.ProjectDAO;
import modulePro.Project.vo.Project;

public class ProjectServiceImpl implements ProjectService{

	private ProjectDAO proDao;
	
	public void setProDao(ProjectDAO proDao) {
		this.proDao = proDao;
	}

	@Override
	public int insertProject(Project pro) {
		// TODO Auto-generated method stub
		return proDao.insertProject(pro);
	}

	@Override
	public Project selectProject(int proID) {
		// TODO Auto-generated method stub
		return proDao.selectProject(proID);
	}

	@Override
	public List<Project> listProject(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (List<Project>)proDao.listProject(paramMap);
	}

	@Override
	public int listProjectCnt(String userID) {
		// TODO Auto-generated method stub
		return proDao.listProjectCnt(userID);
	}

	@Override
	public int updateProject(Project pro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
