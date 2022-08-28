package projects.service;
import projects.Project;
import projects.dao.ProjectDao;

/**
 * 
 * @author zbekele
 *
 */

public class ProjectService {
 private ProjectDao projectDao = new ProjectDao();

 /**
  * @param project The {@link Project} object.
  * @return the project object with newly generated primary key value.
  */
public Project addProject(Project project) {
 return ProjectDao.insertProject(project);	
}

}

