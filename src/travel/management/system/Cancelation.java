
package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Prity
 */
public class Cancelation extends JFrame implements ActionListener{
    
    private String UserName,Password,Status;
    private Container c;
    private JLabel label,ticket;
    private Font f,f1;
    private JTextField t1;
    private JButton cancel,back,log;

 

    Cancelation(String UserName, String Password, String Status) {
        
        this.UserName=UserName;
        this.Password=Password;
        this.Status=Status;
        
        initcomponents();
       
    }
    
    public void initcomponents()
    {
    c=this.getContentPane();
    c.setLayout(null);
    
    this.setTitle("Cancel Pane");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    f=new Font("",Font.BOLD,25);
    label=new JLabel("Cancel Your Ticket");
    label.setBounds(120, 20, 350, 50);
    label.setForeground(Color.green);
    c.add(label);
    
    f1=new Font("",Font.BOLD,18);
    ticket=new JLabel("BokingId");
    ticket.setBounds(30, 120, 100, 50);
    ticket.setFont(f1);
    c.add(ticket);
    
    t1=new JTextField();
    t1.setBounds(130, 130, 100, 30);
    c.add(t1);
    
    cancel=new JButton("Cancel");
    cancel.setBounds(250, 120, 100, 50);
    cancel.addActionListener(this);
    c.add(cancel);
    
    back=new JButton("Main Menu");
    back.setBounds(20, 300, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(200, 300, 100, 50);
    log.addActionListener(this);
    c.add(log);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        String clickbutton=e.getActionCommand();
        
        if(clickbutton.equals(back.getText()))
        {
        UserHome us=new UserHome(UserName,Password,Status);
        us.setVisible(true);
        this.setVisible(false);
        
        }
        else if(clickbutton.equals(log.getText()))
        {
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);
        
        }
        
        else if(clickbutton.equals(cancel.getText()))
        {
          DBshow();
          JOptionPane.showMessageDialog(null, "Canceled");
        }
        else{}
    }
    public void DBshow()
    {
    String query="DELETE FROM `book` WHERE book.BookId='"+t1.getText()+"'";
    System.out.println(query);
    Connection con=null;
    Statement st=null;
    
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    System.out.println("Connection Established");
    st=con.createStatement();
    System.out.println("Statement Created");
    st.execute(query);
    
    }catch(Exception e)
    {
    System.out.println(e);
    }
    
    finally{
    try{
    if(con!=null)
    {
    con.close();
    System.out.println("Connection Closed");
    }
    if(st!=null)
    {
    st.close();
    System.out.println("Statement Closed");
    }
    
    
    }catch(Exception e)
    {
    System.out.println(e);
    }
    
    }
    }

   

   
    
}
