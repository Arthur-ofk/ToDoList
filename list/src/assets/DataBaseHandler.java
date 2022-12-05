package assets;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.xdevapi.Statement;

public class DataBaseHandler extends Configs {

  Connection dbConnection;

  public Connection getDbConnection() throws ClassNotFoundException,
      SQLException {
    String connectionString = "jdbc:mysql://" + dbHost + ":"
        + dbPort + "/" + dbName;

    Class.forName("com.mysql.cj.jdbc.Driver");
    dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    return dbConnection;
  }

  public void AddTask(String TaskName, String taskDate, String TaskText) throws ClassNotFoundException, SQLException {
    String insert = "INSERT INTO " + Const.TASKS_TABLE + "(" +
        Const.TASK_NAME + "," + Const.TASK_DATE + "," + Const.TASK_TEXT + ")"
        + "VALUES(? , ? , ?)";
    PreparedStatement prSt = getDbConnection().prepareStatement(insert);

    prSt.setString(1, TaskName);
    prSt.setString(2, taskDate);
    prSt.setString(3, TaskText);

    prSt.executeUpdate();

  }

  public void GetAllTasks() throws ClassNotFoundException, SQLException {
    String q = "-";
    String querry = "SELECT * FROM todo.tasks";
    java.sql.Statement statement = getDbConnection().createStatement();
    ResultSet resultset = statement.executeQuery(querry);
    while (resultset.next()) {
      System.out.println(q.repeat(10));
      String TaskName = resultset.getString("TaskName");
      System.out.println(TaskName);
      String TaskDate = resultset.getString("TaskDate");
      System.out.println(TaskDate);
      String TaskText = resultset.getString("TaskText");
      System.out.println(TaskText);
      System.out.println(q.repeat(10));
    }

  }

  public void DeleteTask(String delete) throws ClassNotFoundException, SQLException {

    String insert = "DELETE FROM  todo.tasks WHERE TaskName = " + "'" + delete + "'";
    PreparedStatement prSt = getDbConnection().prepareStatement(insert);
    prSt.executeUpdate();
  }

  public void SearchTask(String searchBy)

  public void SortTasks(String argument) throws ClassNotFoundException, SQLException {
    switch (argument) {
      case "name":
        argument = "TaskName";
        break;
      case "date":
        argument = "TaskDate";
        break;
    }

    String order = "SELECT * FROM tasks ORDER BY" + " " + argument;
    PreparedStatement prSt = getDbConnection().prepareStatement(order);
    prSt.execute();
    GetAllTasks();

  }
}
