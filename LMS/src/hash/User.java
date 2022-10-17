package hash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
//import net.proteanit.sql.DbUtils;
import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class User {
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
	public static void user_menu(final String UID) {
	     
	     
	    JFrame f=new JFrame("User Functions"); 
	    
	    JButton view_but=new JButton("View Books");
	    view_but.setBounds(20,20,120,25);
	    view_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	            JFrame f = new JFrame("Books Available"); 
	           
	             
	             
	            Connection connection = connect();
	            String sql="select * from BOOKS"; 
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
	    );
	     
	    JButton my_book=new JButton("My Books");
	    my_book.setBounds(150,20,120,25);
	    my_book.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	               
	            JFrame f = new JFrame("My Books"); 
	            
	            int UID_int = Integer.parseInt(UID); 
	 
	            
	            Connection connection = connect(); 
	            
	            String sql="select distinct issued.*,books.bname,books.genre,books.price from issued,books " + "where ((issued.uid=" + UID_int + ") and (books.bid in (select bid from issued where issued.uid="+UID_int+"))) group by iid";
	            try {
	                Statement stmt = connection.createStatement();
	                
	                 stmt.executeUpdate("USE LIBRARY");
	                stmt=connection.createStatement();
	                
	                new ArrayList();
	  
	                
	                 
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
	    );
	     
	     
	     
	    f.add(my_book); 
	    f.add(view_but); 
	    f.setSize(300,300);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	    }
	
        
        
    
}
