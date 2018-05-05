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
 class BuyTicket extends JFrame implements ActionListener{
     private JLabel LabelTitle,RoutDate,RoutName,SerialNo,RoutCost,Id,Name,Date,Cost;
     private JButton book,pay,back,log;
     private JTextField id,serial;
     private String UserName,Password,Status;
     private Container c;
     private Font f;
     private int i=90,b=1;
     private JComboBox <String> packageList;
     
     
    BuyTicket(String UserName, String Password, String Status) {
       initcomponents();
       this.UserName= UserName;
       this.Password= Password;
       this.Status= Status;
       
    }
    
    public void initcomponents()
    {
        c=this.getContentPane();
        c.setLayout(null);
        
       this.setTitle("Book Ticket Now");
       this.setSize(700,500);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
  
       f=new Font(" ",Font.BOLD,14);
       
       LabelTitle=new JLabel("Booking List :-)");
       LabelTitle.setBounds(250, 20, 200, 30);
       LabelTitle.setForeground(Color.red);
       LabelTitle.setFont(f);
       c.add(LabelTitle);
       
        SerialNo=new JLabel("Serial Number");
       SerialNo.setBounds(50, 50, 250, 50);
       c.add(SerialNo);
       
          RoutName=new JLabel("Name");
       RoutName.setBounds(120, 50, 250, 50);
       RoutName.setForeground(Color.blue);
       c.add(RoutName);
       
       RoutDate=new JLabel("Date");
       RoutDate.setBounds(390, 50, 250, 50);
       c.add(RoutDate);
       
       RoutCost=new JLabel("COst");
       RoutCost.setBounds(550, 50, 250, 50);
       c.add(RoutCost);
       
       serial=new JTextField("SerialNo");
       serial.setBounds(200, 320, 100, 40);
       c.add(serial);
       
       id=new JTextField("UserId");
       id.setBounds(315, 320, 100, 40);
       c.add(id);
       
       book=new JButton("Book Now");
       book.setBounds(430, 320, 100, 40);
       book.addActionListener(this);
       c.add(book);
       
       pay=new JButton("Payment");
       pay.setBounds(430, 380, 150, 50);
       pay.addActionListener(this);
       c.add(pay);
       
       back=new JButton("Main Menu");
       back.setBounds(200, 380, 100, 50);
       back.addActionListener(this);
       c.add(back);
        
       log=new JButton("Log Out");
       log.setBounds(315, 380, 100, 50);
       log.addActionListener(this);
       c.add(log);
       DbPackage();
       
         }
    public void actionPerformed(ActionEvent e)
    {
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
    
    else if(clickbutton.equals(book.getText()))
    {

    DbBookNow(b);
    JOptionPane.showMessageDialog(this,"Hello "+UserName+",Your ticket has been booked.plz pay within 24 hours . Your booking id is: "+b);
    b=b+1;
    }
    
    else if(clickbutton.equals(pay.getText()))
    {
        Payment p=new Payment(UserName,Password,Status);
        p.setVisible(true);
        this.setVisible(false);
    }
    else{}
    
    }

 public void DbPackage()
 {
 String query="SELECT `PackageId`,`PackageName`,`Date`,`Cost` FROM `Package`;";
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
     System.out.println("Result Received");
     
     while(rs.next())
     {
     String pId=rs.getString("PackageId");
     String pName=rs.getString("PackageName");
     String date=rs.getString("Date");
     int cost=rs.getInt("Cost");
     
          System.out.println(pId+pName+date+cost);
          
          Id=new JLabel(""+pId);
        Id.setBounds(50, i, 200, 30);
        c.add(Id);
        
        Name=new JLabel(""+pName);
        Name.setBounds(120, i, 300, 30);
        c.add(Name);
        
        Date=new JLabel(""+date);
        Date.setBounds(390, i, 200, 30);
        c.add(Date);
        
        Cost=new JLabel(""+cost);
        Cost.setBounds(550, i, 200, 30);
        c.add(Cost);
        
       i=i+40;
     }
     
   
     }
     catch(Exception e)
     {}
     finally{
     try{
         if(rs!=null)
         {
         rs.close();
         System.out.println("Result closed");
         
         }
         
         if(st!=null)
         {
         st.close();
         System.out.println("Statement closed");
         
         }
         if(con!=null)
         {
         con.close();
         System.out.println("Connection closed");
         }
     
     
     }catch(Exception e)
     {}
     
     
     }
     
 }
 
 public void DbBookNow(int BookId)
 {
 String query="INSERT INTO book VALUES('"+BookId+"','"+id.getText()+"','"+serial.getText()+"')";
 System.out.println(query);
 Connection con=null;
 Statement st=null;
 ResultSet rs=null;
 
 System.out.println(query);
 
 try{
 
     Class.forName("com.mysql.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
     System.out.println("Connection Established");
     st=con.createStatement();
     System.out.println("Statement Created");
//     rs=st.executeQuery(query);
    st.execute(query);
     
 
 }catch(Exception e)
 {}
 
 finally{
 try{
 
 if(st!=null)
 {
     st.close();
 System.out.println("Statement closed");
 }
 if(con!=null)
     
 {
     con.close();
 System.out.println("Connection closed");
 }
 
 }catch(Exception e)
 {}
 
 
 }
 
 
 }

  
    }
    

