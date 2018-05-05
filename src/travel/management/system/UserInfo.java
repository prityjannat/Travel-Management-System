/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Prity
 */
class UserInfo extends JFrame implements ActionListener{
    private Container c;
    private JLabel label;
    private Font f;
    private JLabel uid,uname,pname,date,cost,pacid,bookid;
    String UserName,Password,Status;
    private JButton back,log;
    private JLabel ui,un,pi,pn,pc,pd,bi;
    private int i=90;

 UserInfo()
 {
    this.UserName=UserName;
    this.Password=Password;
    this.Status=Status;
     
 initcomponents();
 }
 
 public void initcomponents()
 {
 c=this.getContentPane();
 c.setLayout(null);
 
 this.setTitle("User Details Pane");
 this.setSize(800, 400);
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 f=new Font("",Font.BOLD,20);
 label=new JLabel("User Details Information");
 label.setBounds(250, 20, 300, 30);
 label.setFont(f);
 label.setForeground(Color.pink);
 c.add(label);
 
 uid=new JLabel("UserId");
 uid.setBounds(25, 60, 50, 30);
 c.add(uid);
 
 uname=new JLabel("UserName");
 uname.setBounds(80, 60, 100, 30);
 c.add(uname);
 
 pname=new JLabel("PackageName");
 pname.setBounds(180, 60, 350, 30);
 c.add(pname);
 
 date=new JLabel("Date");
 date.setBounds(470, 60, 100, 30);
 c.add(date);
 
 cost=new JLabel("Cost");
 cost.setBounds(590, 60, 100, 30);
 c.add(cost);
 
 pacid=new JLabel("PackageId");
 pacid.setBounds(640, 60, 100, 30);
 c.add(pacid);
 
 bookid=new JLabel("BookId");
 bookid.setBounds(720, 60, 100, 30);
 c.add(bookid);
 
 back=new JButton("Main Menu");
 back.setBounds(200, 300, 100, 50);
 back.addActionListener(this);
 c.add(back);
 
 log=new JButton("Log Out");
 log.setBounds(315, 300, 100, 50);
 log.addActionListener(this);
 c.add(log);
 Dbshow();
 
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
        else{}
    }
    
    public void Dbshow()
    {
    String query="SELECT user.*,package.*,book.* FROM `user`,`package`,`book` WHERE user.UserId=book.UserId AND package.PackageId=book.PackageId";
    System.out.println(query);
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
  try{
  Class.forName("com.mysql.jdbc.Driver");
  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
   System.out.println("Connection Established");
   st=con.createStatement();
    System.out.println("Statement Created");
    rs=st.executeQuery(query);
     System.out.println("Result Recieved");
     
     while(rs.next())
     {
     String uid=rs.getString("UserId");
     String uname=rs.getString("UserName");
     String pacid=rs.getString("PackageId");
     String pacname=rs.getString("PackageName");
     String date=rs.getString("Date");
     int cost=rs.getInt("Cost");
     String bookid=rs.getString("BookId");
     
      System.out.println(uid+uname+pacid+pacname+date+cost+bookid);
      ui=new JLabel(""+uid);       
     ui.setBounds(25, i, 50, 30);
     c.add(ui);
     
     un=new JLabel(""+uname);
     un.setBounds(80, i, 100, 30);
     c.add(un);
     
     pn=new JLabel(""+pacname);
     pn.setBounds(180, i, 350, 30);
     c.add(pn);
     
     pd=new JLabel(""+date);
     pd.setBounds(440, i, 150, 30);
     c.add(pd);
     
     pc=new JLabel(""+cost);
     pc.setBounds(590, i, 100, 30);
     c.add(pc);
     
     bi=new JLabel(""+bookid);
     bi.setBounds(660, i, 100, 30);
     c.add(bi);
     
     pi=new JLabel(""+pacid);
     pi.setBounds(730, i, 100, 30);
     c.add(pi);
     i=i+40;
     }
  }catch(Exception e)
  {
  System.out.println(e);
  }
  
  finally{
      
      try{
      if(rs!=null)
      {
      rs.close();
        System.out.println("Result Closed");
      }
      if(st!=null)
      {
      st.close();
        System.out.println("Statement Closed");
      }
      if(con!=null)
      {
      con.close();
        System.out.println("Connection Closed");
      }
      }catch(Exception e)
      {
      System.out.println(e);
      }
    }
    
    }
    
}
