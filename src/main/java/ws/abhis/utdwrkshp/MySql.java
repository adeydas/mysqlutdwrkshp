package ws.abhis.utdwrkshp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySql {
	  private String     server;//   = "<database_host>"; //usually localhost
	  private String     port;//     = "3306"; //database port, usually 3306
	  private String     url;  //    = "jdbc:mysql://" + server + ":" + port + "/<database_name>";
	  private String     userid;//   = "<user_id>"; //database user id
	  private String     password;// = "<password>"; //database password
	  private Connection con;
	  
	  public MySql(String server, String port, String databaseName, String userId, String password) {
		  this.server = server;
		  this.port = port;
		  this.url = "jdbc:mysql://" + this.server + ":" + this.port + "/" + databaseName;
		  this.userid = userId;
		  this.password = password;
	  }
	  
	  private void openConn() throws Throwable {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(url, userid, password);

	  }

	  public void closeConn() throws Throwable {

	    con.close();

	  }

	  public ResultSet runQuery(String query) throws Throwable {
	    this.openConn();

	    Statement statement = con.createStatement();

	    ResultSet rs = statement.executeQuery(query);
	    return rs;

	  }
	  
	  public void runUpdate(String query) throws Throwable {
		  this.openConn();
		  
		  Statement statement = con.createStatement();
		  statement.executeUpdate(query);
	  }

}
