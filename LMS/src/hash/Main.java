package hash;
import java.sql.*;
//import net.proteanit.sql.DbUtils;
 
public class Main {
	
	
	
    public static void create()
    {
    	try {
    	
    		Connection connection=Connect.connect();
    		ResultSet resultSet = connection.getMetaData().getCatalogs();
    		while (resultSet.next()) {
    	          String databaseName = resultSet.getString(1);
    	          System.out.println(databaseName);
    	          if(databaseName.equals("library")) {
    	           
    	              Statement stmt = connection.createStatement();
    	              
    	              String sql = "DROP DATABASE library";
    	              stmt.executeUpdate(sql);
    	          }
    	        }
    		Statement stmt = connection.createStatement();
            
            String sql = "CREATE DATABASE LIBRARY"; 
            stmt.executeUpdate(sql); 
            stmt.executeUpdate("USE LIBRARY"); 
            String sql1 = "CREATE TABLE USERS(UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(30), PASSWORD VARCHAR(30), ADMIN BOOLEAN)";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate("INSERT INTO USERS(USERNAME, PASSWORD, ADMIN) VALUES('admin','admin',TRUE)");
            stmt.executeUpdate("CREATE TABLE BOOKS(BID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, BNAME VARCHAR(50), GENRE VARCHAR(20), PRICE INT)");
            stmt.executeUpdate("CREATE TABLE ISSUED(IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, UID INT, BID INT, ISSUED_DATE VARCHAR(20), RETURN_DATE VARCHAR(20), PERIOD INT, FINE INT)");
            stmt.executeUpdate("INSERT INTO BOOKS(BNAME, GENRE, PRICE) VALUES ('War and Peace', 'Mystery', 200),  ('The Guest Book', 'Fiction', 300), ('The Perfect Murder','Mystery', 150), ('Accidental Presidents', 'Biography', 250), ('The Wicked King','Fiction', 350)");
             
      resultSet.close();
    		
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
    public static void main(String[] args) {
         
        
       //create();
        login.Login();
        
        
    }
}
