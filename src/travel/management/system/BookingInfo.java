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
public class BookingInfo extends JFrame implements ActionListener {
    
    private String UserName,Password,Status;
    private Container c;
    private JLabel label,name,status,uid,uname,pid,pname,pdate,pcost,bid;
    private Font f;
    private JButton back,log;
    private JLabel ui,un,pi,pn,pd,pc,bi;
    private int i=120;
    
 
    

    BookingInfo(String UserName, String Password, String Status) {
        this.UserName=UserName;
        this.Password=Password;
        this.Status=Status;
        
        initcomponents();
       
    }
    
    public void initcomponents()
    {
    c=this.getContentPane();
    c.setLayout(null);
    
    this.setTitle("Information Pane");
    this.setSize(900, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    f=new Font("",Font.BOLD,20);
    label=new JLabel("Your Current Information Page");
    label.setBounds(250, 20, 320, 30);
    label.setForeground(Color.orange);
    label.setFont(f);
    c.add(label);
    
    name=new JLabel("Name: "+this.UserName);
    name.setBounds(30, 40, 100, 50);
    c.add(name);
    
    status=new JLabel("Status:"+this.Status);
    status.setBounds(150, 40, 100, 50);
    c.add(status);
    
    uid=new JLabel("UserID");
    uid.setBounds(25, 90, 50, 30);
    c.add(uid);
    
    uname=new JLabel("UserName");
    uname.setBounds(80, 90, 100, 30);
    c.add(uname);
    
    pname=new JLabel("PackageName");
    pname.setBounds(180,90, 100, 30);
    c.add(pname);
    
    pdate=new JLabel("Date");
    pdate.setBounds(470, 90, 350, 30);
    c.add(pdate);
    
    pcost=new JLabel("Cost");
    pcost.setBounds(590, 90, 100, 30);
    c.add(pcost);
    
    pid=new JLabel("PackageId");
    pid.setBounds(640, 90, 100, 30);
    c.add(pid);
    
    bid=new JLabel("BookId");
    bid.setBounds(720, 90, 100, 30);
    c.add(bid);
    
    back=new JButton("Main Menu");
    back.setBounds(20, 300, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(200, 300, 100, 50);
    log.addActionListener(this);
    c.add(log);
    showDB();
    }

   
   public void actionPerformed(ActionEvent e) {
       String clickbutton=e.getActionCommand();
       
   if(clickbutton.equals(log.getText()))
   {
   Login l=new Login();
   l.setVisible(true);
   this.setVisible(false);
   
   }
   else if(clickbutton.equals(back.getText()))
   {
   UserHome us=new UserHome(UserName,Password,Status);
   us.setVisible(true);
   this.setVisible(false);
         
   
   }
   else{}
   
    }
   public void showDB()
   {
   String query="SELECT user.*,package.*,book.* FROM `user`,`package`,`book` where `user`.`UserName`='"+this.UserName+"' and user.UserId=book.UserId and package.PackageId=book.PackageId";
   
//    String query="select * from user";
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   
   System.out.println(query);
   
   try{
   Class.forName("com.mysql.jdbc.Driver");
   System.out.println();
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
   st=con.createStatement();
   System.out.println("Statement Created");
   rs=st.executeQuery(query);
   System.out.println("Result Received");
   
   while(rs.next())
   {
   String Uname=rs.getString("user.UserName");
   int Uid=rs.getInt("user.UserId");
   String Ustatus=rs.getString("Status");
   String Pid=rs.getString("PackageId");
   String Pname=rs.getString("PackageName");
   String Pdate=rs.getString("Date");
   int Pcost=rs.getInt("Cost");
   int Bid=rs.getInt("BookId");
   
   System.out.println(Uname+Uid+Ustatus+Pid+Pname+Pdate+Pcost+Bid);
   
  ui=new JLabel(""+Uid);
  ui.setBounds(25,i , 50, 30);
  c.add(ui);
  
  un=new JLabel(""+Uname);
  un.setBounds(80, i, 100, 30);
  c.add(un);
  
  pn=new JLabel(""+Pname);
  pn.setBounds(180, i, 350, 30);
  c.add(pn);
  
  pd=new JLabel(""+Pdate);
  pd.setBounds(440, i, 150, 30);
  c.add(pd);
  
  pc=new JLabel(""+Pcost);
  pc.setBounds(590, i, 100, 30);
  c.add(pc);
  
   pi=new JLabel(""+Pid);
  pi.setBounds(660, i, 100, 30);
  c.add(pi);
  
  bi=new JLabel(""+Bid);
  bi.setBounds(730, i, 100, 30);
  c.add(bi);
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
