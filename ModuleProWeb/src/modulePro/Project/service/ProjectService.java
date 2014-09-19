package modulePro.Project.service;

import java.util.List;
import java.util.Map;

import modulePro.Project.vo.Project;

public interface ProjectService {
	
	/***
	 * <pre>
	 * @methodName : insertProject
	 * @Author : LeeJungNam
	 * @Date : 2014. 9. 18. 오후 2:56:23
	 * @Comment : 프로젝트 등 
	 * </pre>
	 * @param pro
	 * @return
	 */
	public int insertProject(Project pro);
	
	/**
	 * <pre>
	 * @methodName : selectProject
	 * @Author : LeeJungNam
	 * @Date : 2014. 9. 19. 오전 9:49:10
	 * @Comment : 단일프로젝트 선택 
	 * </pre>
	 * @param proID 프로젝트 아이디
	 * @return
	 */
	public Project selectProject(int proID);
	
	/**
	 * 
	 * <pre>
	 * @methodName : listProject
	 * @Author : LeeJungNam
	 * @Date : 2014. 9. 19. 오전 9:49:49
	 * @Comment : 프로젝트 리스트
	 * </pre>
	 * @param paramMap
	 * @return
	 */
	public List<Project> listProject(Map<String,Object> paramMap);
	
	/**
	 * <pre>
	 * @methodName : listProjectCnt
	 * @Author : LeeJungNam
	 * @Date : 2014. 9. 19. 오전 9:50:29
	 * @Comment : 프로젝트 갯수
	 * </pre>
	 * @param userID
	 * @return
	 */
	public int listProjectCnt(String userID);
	
	/**
	 * 
	 * <pre>
	 * @methodName : updateProject
	 * @Author : LeeJungNam
	 * @Date : 2014. 9. 19. 오전 9:50:50
	 * @Comment : 프로젝트 업데이트 
	 * </pre>
	 * @param pro
	 * @return
	 */
	public int updateProject(Project pro);
}
