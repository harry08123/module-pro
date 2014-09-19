package modulePro.Project.dao;

import java.util.List;
import java.util.Map;

import modulePro.Project.vo.Project;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ProjectDAOImpl extends SqlSessionDaoSupport implements ProjectDAO{

	@Override
	public int insertProject(Project pro) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("modulePro.Project.insertProject",pro);
	}

	@Override
	public Project selectProject(int proID) {
		// TODO Auto-generated method stub
		return (Project)getSqlSession().selectOne("modulePro.Project.selectProject",proID);
	}

	@Override
	public List listProject(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("modulePro.Project.listProject", paramMap);
	}

	@Override
	public int listProjectCnt(String userID) {
		// TODO Auto-generated method stub
		return (Integer)getSqlSession().selectOne("modulePro.Project.listProjectCnt",userID);
	}

	@Override
	public int updateProject(Project pro) {
		// TODO Auto-generated method stub
		return getSqlSession().update("modulePro.Project.updateProject",pro);
	}
	
}
