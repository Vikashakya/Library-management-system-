package hash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Admin {
	
	public static void admin_menu() {
		JFrame f=new JFrame("Admin Functions"); 
	    JButton create_but=new JButton("Create/Reset");
	    create_but.setBounds(450,60,120,25);
	    create_but.addActionListener(new ActionListener()
	    		{	
	    	     public void actionPerformed(ActionEvent e){
		            
		            create.Create(); 
		         }
	    		}
	    );
	   
	    
	    JButton view_but=new JButton("View Books");
	    view_but.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            
	            Books.view_books();    
	    }
	    }
	    );
	    view_but.setBounds(20,20,120,25);
	    
	    
	    JButton users_but=new JButton("View Users");
	    users_but.setBounds(150,20,120,25);
	    users_but.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	viewUser.ViewUser();
	               
	    }
	    }
	    );
	    
	    
	    JButton issued_but=new JButton("View Issued Books");
	    issued_but.setBounds(280,20,160,25);
	    issued_but.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	               viewIssuedBook.ViewIssuedBook();
	    }
	    }
	    );
	    
	    
	    JButton add_user=new JButton("Add User"); 
	    add_user.setBounds(20,60,120,25); 
	    add_user.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	 addUser.AddUser();
	    }
	    }
	    );
	    
	    JButton add_book=new JButton("Add Book");
	    add_book.setBounds(150,60,120,25); 
	    add_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	              addBook.Addbook();
	    }
	    }
	    );
	    
	    
	    JButton issue_book=new JButton("Issue Book"); 
	    issue_book.setBounds(450,20,120,25); 
	    issue_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	               issueBook.IssueBook();
	    }
	    }
	    );
	    
	    
	    JButton return_book=new JButton("Return Book"); 
	    return_book.setBounds(280,60,160,25); 
	    return_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	               returnBook.ReturnBook();
	    }
	    }
	    );
	    
	    
	    f.add(create_but);
	    f.add(return_book);
	    f.add(issue_book);
	    f.add(add_book);
	    f.add(issued_but);
	    f.add(users_but);
	    f.add(view_but);
	    f.add(add_user);
	    f.setSize(600,600);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	    
	    
	}
}