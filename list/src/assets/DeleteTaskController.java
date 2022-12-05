package assets;

import java.sql.SQLException;

public class DeleteTaskController {

    String TaskName;

    public DeleteTaskController(String TaskName) {

        this.TaskName = TaskName;
    }

    public void DeleteTask(String delete) throws ClassNotFoundException, SQLException {
        DataBaseHandler dbh = new DataBaseHandler();
        dbh.DeleteTask(delete);
    }

}
