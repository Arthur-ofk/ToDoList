package assets;

import java.sql.Connection;

import java.sql.DriverManager;
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

}
