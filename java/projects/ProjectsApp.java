
package projects;
 import java.math.BigDecimal;
 import java.util.List;
 import java.util.Objects;
 import java.util.Scanner;
 import projects.entity.project;
 import projects.exception.DbException;
 import projects.service.ProjectService;

 
 /**
  * This class is a menu driven application that accepts user input 
  * from the console. It then performs CRUD operations on the project tables.
  * @author zbekele
 * @param <project>
  *
  */

 public class ProjectsApp {
	private Scanner scanner = new Scanner(System.in);
	private projectService projectService = new projectService();

 
	// @formatter: off
	private List<String> operations = List.of(
			"1) Add a project"); 
		// @formatter: on  
		/**
		 * Entry point of java application
		 *  @param args unused.
		 */

 @SuppressWarnings("rawtypes")
public static void main(String[] args) {
	 new ProjectsApp().processUserSelections();	 
	 
 }
 
 /**
  * This method prints operations, gets a user menu selection, 
  * * and performs the required operation. It repeats until the user 
  * * requests that the application terminate.
  */
 private void processUserSelections() {
		boolean done = false;
		
	while(!done) {
		try {
		int selection = getUserSelection();
				
		switch(selection) {	
		case -1:
			done = exitMenu();
			break;
				
		case 1:
			createProject();
			break;
					
	default:
	System.out.println("\n" + selection + " is not a valid selection. Try again.");			}
		}
		
	catch(Exception e) {
	System.out.println("\nError: " + e + "  Try again");
			}
		}
	}
 
 /**
  * Gather user input a project row then call the project service to create the row.
  * */
 
//  * @return
//  */
 
/* Gather user input for a project row then call the project service to create the row.
 * 
 */
private void createProject() {
	 String projectName = getStringInput("Enter the project name");
	 BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
	 BigDecimal actualHours = getDecimalInput("Enter the actual hours");
	 Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
	 String notes = getStringInput("Enter the project notes");
	 
	 Project project = new Project();
	 
	 project.setProjectName(projectName);
	 project.setEstimatedHours(estimatedHours);
	 project.setActualHours(actualHours);
	 project.setDifficulty(difficulty);
	 project.setNotes(notes);
	 	 
 Project dbProject = projectService.addProject(project);
 System.out.println("You have successfully created project:" + dbProject);
 
 }

private Integer getIntInput(String prompt) {
	String input = getStringInput(prompt);	
	if(Objects.isNull(input)) {
		return null;
}
		try {
			return Integer.valueOf(input);
}
		catch(NumberFormatException e) {
		throw new DbException(input + " is not a valid number:");
	}
	}

private BigDecimal getDecimalInput(String prompt) {
	// TODO Auto-generated method stub
	String input = getStringInput(prompt);
		
	if(Objects.isNull(input)) {
	return null;
}
try {
	/* create the BigDecimal object and set it to two decimal places (the scale).*/
	return new BigDecimal(input).setScale(2);
}
catch(NumberFormatException e) {
throw new DbException(input + " is not a valid decimal number.");
}	
}

/**
 * called when the user wants to exit the application. It prints a message and returns
 * {@code true} to terminate the app.
 */
 private boolean exitMenu() {
	System.out.println("Exiting the menu.");
	return true;
}
 
 /**
  * This method prints available selections. it then gets the user's
  *  menu selection from the console and converts it to an int.
  * @return
  */
private int getUserSelection() {
	// TODO Auto-generated method stub
	printOperations();
	Integer input = getIntInput("Enter a menu selection");
	return Objects.isNull(input) ? -1 : input;
}
/**
 * prints a prompt on the console and then gets the user's input from the console.
 * If the user enters nothing, {@code null} is returned. Otherwise, the trimmed input is returned.
 * 
 * @param prompt the prompt to print
 * @return the user's input or {@code null}
 */
private String getStringInput(String prompt) {
	// TODO Auto-generated method stub
	System.out.print(prompt + " : ");
	String input = scanner.nextLine();
	return input.isBlank()? null : input.trim();
}
/**
 * print the menu selections, one per line.
 */
private void printOperations() {
	//The printOperations method does what it says.
	System.out.println("\n  you have successfull created menu project.These are the available selections.Press the Enter key to quit:");

 /* with lambda expression */
	operations.forEach(line -> System.out.println("  " + line));
	
	/* with enhanced for loop*/
	// for (String line: operations) {
	// System.out.println(" " + line);
	//}
}
 }
 

