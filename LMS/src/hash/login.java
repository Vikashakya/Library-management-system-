package hash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class login {
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
	public static void Login()
	{
		final JFrame f=new JFrame("Login");
	    JLabel l1,l2;  
	    l1=new JLabel("Username"); 
	    l1.setBounds(30,15, 100,30);
	     
	    l2=new JLabel("Password");  
	    l2.setBounds(30,50, 100,30);    
	     
	     final JTextField F_user = new JTextField(); 
	    F_user.setBounds(110, 15, 200, 30);
	         
	     final JPasswordField F_pass=new JPasswordField();
	    F_pass.setBounds(110, 50, 200, 30);
	       
	    JButton login_but=new JButton("Login");
	    login_but.setBounds(130,90,80,25);
	    login_but.addActionListener(new ActionListener() {  
	         
	        public void actionPerformed(ActionEvent e){ 
	 
	        String username = F_user.getText(); 
	        String password = String.valueOf(F_pass.getPassword());
	         
	        if(username.equals(""))
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	        } 
	        else if(password.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter password"); 
	        }
	        else { 
	            
	            Connection connection=connect();  
	            try
	            {
	            Statement stmt = connection.createStatement();
	              stmt.executeUpdate("USE LIBRARY"); 
	              String st = ("SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'"); 
	              ResultSet rs = stmt.executeQuery(st); 
	              if(rs.next()==false) { 
	                  System.out.print("No user");  
	                  JOptionPane.showMessageDialog(null,"Wrong Username/Password!"); 
	 
	              }
	              else {
	                  f.dispose();
	                
	               
	                  String admin = rs.getString("ADMIN"); 
	                  
	                  String UID = rs.getString("UID"); 
	                  if(admin.equals("1")) { 
	                	  
	                      Admin.admin_menu(); 
	                  }
	                  else{
	                	  
	                	  
	                     User.user_menu(UID);
	                  }
	              
	              
	              }
	            }
	            catch (Exception ex) {
	                 ex.printStackTrace();
	        }
	        
	        }
	    }               
	    });
	 
	     
	    f.add(F_pass);
	    f.add(login_but);
	    f.add(F_user);  
	    f.add(l1);  
	    f.add(l2); 
	     
	    f.setSize(400,180);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
	 
	
}
