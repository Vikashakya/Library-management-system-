package hash;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.sql.Statement;
public class viewUser {
   public static void ViewUser()
   {
	   JFrame f = new JFrame("Users List");
       Connection connection = Connect.connect();
       String sql="select * from users"; 
       try {
           Statement stmt = connection.createStatement();
            stmt.executeUpdate("USE LIBRARY"); 
           stmt=connection.createStatement();
           ResultSet rs=stmt.executeQuery(sql);
           JTable book_list= new JTable();
           book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
           JScrollPane scrollPane = new JScrollPane(book_list);

           f.add(scrollPane); 
           f.setSize(800, 400); 
           f.setVisible(true);
           f.setLocationRelativeTo(null);
       } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1);
       }       
   }
}
