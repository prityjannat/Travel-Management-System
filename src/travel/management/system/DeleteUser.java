
package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Prity
 */
class DeleteUser extends JFrame implements ActionListener {
    private Container c;
    private JLabel label,uid;
    private Font f;
    private JTextField tuid;
    private JButton back,log,cancel;
   //   private String UserName,Password,Status;

 /*  public DeleteUser()
   {
        
        this.UserName= UserName;
        this.Password=Password;
        this.Status=Status;  
  
   }  */


    DeleteUser() {
       initcomponents();
    }
   public void initcomponents()
   {
   this.setTitle("Delete User Pane");
   this.setSize(400, 400);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   c=this.getContentPane();
   c.setLayout(null);
   
   f=new Font("",Font.BOLD,20);
   label=new JLabel("User Delete");
   label.setBounds(150, 20, 200, 30);
   label.setFont(f);
   label.setForeground(Color.green);
   c.add(label);
   
   uid=new JLabel("UserId");
   uid.setBounds(50, 120, 100, 50);
   c.add(uid);
   
   tuid=new JTextField();
   tuid.setBounds(130,130, 100, 30);
   c.add(tuid);
   
   back=new JButton("Main Menu");
   back.setBounds(20, 300, 100, 50);
   back.addActionListener(this);
   c.add(back);
   
   log=new JButton("Log Out");
   log.setBounds(200, 300, 100, 50);
   log.addActionListener(this);
   c.add(log);
   
   cancel=new JButton("Cancel");
   cancel.setBounds(250, 120, 100, 50);
   cancel.addActionListener(this);
   c.add(cancel);
   
   }

    @Override
    public void actionPerformed(ActionEvent e) {
      String clickbutton=e.getActionCommand();
      
      if(clickbutton.equals(back.getText()))
      {
       AdminHome ad=new AdminHome();
       ad.setVisible(true);
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
      Dbshow();
      JOptionPane.showMessageDialog(null, "Canceled");
          
      }
      else{}
    }
    public void Dbshow()
    {
    String query="DELETE FROM `user` WHERE user.UserId='"+tuid.getText()+"'";
    System.out.println(query);
    Connection con=null;
    Statement st=null;
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    System.out.println("Connection Established");
    st=con.createStatement();
    System.out.println("Statement Creatd");
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
