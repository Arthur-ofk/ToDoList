package assets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskController {
    DataBaseHandler dbh = new DataBaseHandler();

    public void AddTask(String TaskName, String taskDate, String TaskText, Boolean IsFinished)
            throws ClassNotFoundException, SQLException {
        String insert = "INSERT INTO " + Const.TASKS_TABLE + "(" +
                Const.TASK_NAME + "," + Const.TASK_DATE + "," + Const.TASK_TEXT + "," + Const.IS_FINISHED + ")"
                + "VALUES(? , ? , ? , ?)";
        PreparedStatement prSt = dbh.getDbConnection().prepareStatement(insert);

        prSt.setString(1, TaskName);
        prSt.setString(2, taskDate);
        prSt.setString(3, TaskText);
        prSt.setBoolean(4, IsFinished);

        prSt.executeUpdate();

    }

    public void GetAllTasks() throws ClassNotFoundException, SQLException {
        String q = "-";
        String querry = "SELECT * FROM todo.tasks";
        java.sql.Statement statement = dbh.getDbConnection().createStatement();
        ResultSet resultset = statement.executeQuery(querry);
        while (resultset.next()) {
            System.out.println(q.repeat(10));
            int idtasks = resultset.getInt("idtasks");
            String TaskName = resultset.getString("TaskName");
            System.out.println(TaskName);
            String TaskDate = resultset.getString("TaskDate");
            System.out.println(TaskDate);
            String TaskText = resultset.getString("TaskText");
            System.out.println(TaskText);
            System.out.println(q.repeat(10));

        }

    }
    // DELETE TASK

    public void DeleteTask(String delete) throws ClassNotFoundException, SQLException {

        String insert = "DELETE FROM  todo.tasks WHERE TaskName = " + "'" + delete + "'";

        PreparedStatement prSt = dbh.getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }

    public void SearchTask(String searchBy, String sArg) throws ClassNotFoundException, SQLException {
        String q = "-";
        String querry = "SELECT * fROM todo.tasks  WHERE " + " " + searchBy + " " + "=" + " " + "'" + sArg + "'";
        java.sql.Statement statement = dbh.getDbConnection().createStatement();
        ResultSet resultset = statement.executeQuery(querry);
        if (resultset.next()) {
            while (resultset.next()) {
                System.out.println(q.repeat(10));
                String TaskName = resultset.getString("TaskName");
                System.out.println("TaskName :" + TaskName);
                String TaskDate = resultset.getString("TaskDate");
                System.out.println("TaskDeadline" + TaskDate);
                String TaskText = resultset.getString("TaskText");
                System.out.println("TaskText" + TaskText);
                Boolean IsFinished = resultset.getBoolean("IsFinished");
                System.out.println("IsFinished" + IsFinished);
                System.out.println(q.repeat(10));

            }
        } else {
            System.out.println("item not found");

        }
    }

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
        PreparedStatement prSt = dbh.getDbConnection().prepareStatement(order);
        prSt.execute();
        GetAllTasks();

    }
}
