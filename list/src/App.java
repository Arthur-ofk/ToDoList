import assets.DeleteTaskController;
import assets.AddTaskController;
import assets.DataBaseHandler;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    DataBaseHandler dbh = new DataBaseHandler();
    // java.util.Date utilDate = new java.util.Date();
    System.out.println("select an option(or type help to view all commands)");
    while (true) {
      // System.out.println("select an option(or type help to view all commands)");
      String option = sc.nextLine();

      switch (option.toLowerCase()) {
        case "":
          System.out.println("select an option(or type help to view  all commands)");
          break;

        case "add task":
          System.out.println("Enter Task Name(or short descr.)");
          String TaskName = sc.nextLine();
          System.out.println("Enter the deadline of Task(DD.MM.YYYY)");

          String TaskDate = sc.nextLine();

          System.out.println("Enter the Task");
          String TaskText = sc.next();
          AddTaskController ATController = new AddTaskController(TaskName, TaskDate, TaskText);
          ATController.signUp();
          option = null;
          break;
        case "delete task":
          System.out.println("Enter the Task Name You want to delete");
          String delete = sc.next();
          DeleteTaskController dtc = new DeleteTaskController(delete);
          dtc.DeleteTask(delete);
          break;
        case "show all tasks":

          dbh.GetAllTasks();
          break;
        case "help":
          System.out.println("List of all commands:");
          System.out.println("Add Task - adds a new task to list");
          System.out.println("Delete Task- remove a task from list");
          System.out.println("Show All Tasks - prints all the tasks in list");
          System.out.println("Close - exit the programm");
          break;
        case "sort":
          System.out.println("Insert argument of sorting(possible input:)");
          String argument = sc.next();

          dbh.SortTasks(argument);
          break;

        case "search":
          break;

        case " update":
          break;

        case "finish":
          break;

        default:

          System.out.println("Incorrect input");
          break;

      }

      // option = null;
    }

  }
}
