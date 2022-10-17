package hash;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
  public static Connection connect()
  {
	  try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=Vikas@123456789");
	        return con;
	    } 
	    catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
  }
}
