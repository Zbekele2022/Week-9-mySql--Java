package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import projects.Project;
import projects.exception.DbException;
import provided.util.DaoBase;

/**
 * This class uses JDBC to perform CRUD operationson the project tables.
 * @author zbekele
 *
 */
// HOST, PASSWORD, PORT, SCHEMA, and USER. 
@SuppressWarnings("unused")
public class ProjectDao  extends DaoBase {
	
	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE= "material";
	private static final String PROJECT_TABLE="project";
	private static final String PROJECT_CATEGORY_TABLE= "project_category";
	private static final String STEP_TABLE = "step";
	private static final String conn = null;
	

public static Project insertProject(Project project) {
	
	// @formatter:off
	String sql = ""
		+ "INSERT INTO" + PROJECT_TABLE + " "
		+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
		+ "values"
		+ "(?,?,?,?,?)";
	// @formatter:on
	
	
Statement DbConnection;
try(Connection conn = DbConnection.getConnection()) {
	startTransaction(conn);
	
	try(PreparedStatement stmt = conn.prepareStatement(sql)) {	
	setParameter(stmt, 1, project.getProjectName().String.class);
	setParameter(stmt, 2, project.getEstimatedHours(),BigDecimal.class);
	setParameter(stmt, 3, project.getActualHours(),BigDecimal.class);
	setParameter(stmt, 4, project.getDifficulty(),Integer.class);
	setParameter(stmt, 5, project.getNotes(),String.class);

	stmt.executeUpdate();

	
	}
		catch(Exception e) {
		rollbackTransaction(conn);
		throw new DbException(e);
	}
	}
	catch(SQLException e) {
		throw new DbException(e);
				  
	}
}


private static void setParameter(PreparedStatement stmt, int i, Object estimatedHours, Class<BigDecimal> class1) {
	// TODO Auto-generated method stub
	
}


private static void startTransaction(Connection conn) {
	// TODO Auto-generated method stub	
}
private static void rollbackTransaction(Connection conn) {
	// TODO Auto-generated method stub	
}

	Integer project_ID = getLastInsertId(conn, PROJECT_TABLE);
	ProjectDao(conn);

	project.setproject_ID(project_ID);
	return project;
	
	}

	private Integer getLastInsertId(String conn2, String projectTable) {
		// TODO Auto-generated method stub
		return null;
	}
}







	

	







