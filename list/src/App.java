import assets.TaskController;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    try (Scanner sc = new Scanner(System.in)) {
      {
        TaskController tc = new TaskController();
        // java.util.Date utilDate = new java.util.Date();
        System.out.println("select an option(or type help to view all commands)");
        while (true) {

          String option = sc.nextLine();

          switch (option.toLowerCase()) {
            case "":
              System.out.println("select an option(or type help to view all commands)");
              option = null;
              break;

            case "add task":
              System.out.println("Enter Task Name(or short descr.)");
              String TaskName = sc.nextLine();
              System.out.println("Enter the deadline of Task(YYYY-MM-DD)");

              String TaskDate = sc.nextLine();
              System.out.println("Is this task finished?(true or false)");
              Boolean IsFinished = sc.nextBoolean();

              System.out.println("Enter the Task");
              String TaskText = sc.next();
              tc.AddTask(TaskName, TaskDate, TaskText, IsFinished);

              option = null;
              break;
            case "delete task":
              System.out.println("Enter the Task Name You want to delete");
              String delete = sc.next();
              // DeleteTaskController dtc = new DeleteTaskController(delete);
              tc.DeleteTask(delete);
              break;
            case "show all tasks":

              tc.GetAllTasks();
              break;
            case "help":
              System.out.println("List of all commands:");
              System.out.println("Add Task - adds a new task to list");
              System.out.println("Delete Task- remove a task from list");
              System.out.println("Show All Tasks - prints all the tasks in list");
              System.out.println("Close - exit the programm");
              break;
            case "sort":
              System.out.println("Insert argument of sorting(possible input:name,date)");
              String argument = sc.next();

              tc.SortTasks(argument);
              break;

            case "search":
              System.out.println("search by:");
              System.out.println("1)TaskName");
              System.out.println("2)TaskDate");
              String searchBy = sc.nextLine();

              System.out.println(" insert argument");
              String sArg = sc.nextLine();
              tc.SearchTask(searchBy, sArg);

              break;

            case " update":
              System.out.println("select task to update");
              tc.GetAllTasks();

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
  }
}
