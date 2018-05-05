/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Prity
 */
public class Login extends JFrame implements ActionListener{
    
    private Container c;
    private JLabel title,user,pass;
    private  Font f;
    private JTextField UserName;
    private JPasswordField jpass;
    private JButton login,close;
    private JPanel panel1;
    private JRadioButton r1,r2;
    private ButtonGroup grp;
    private boolean flag;
    
    
    
    public Login()
    {
        initcomponent();
    }

   
    
    public void initcomponent()
    {
        
        c= this.getContentPane();
        c.setLayout(null);
      
         this.setTitle("Travel Agency Mnagement SYstem");
         this.setSize(500,400);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
     //      panel1 = new JPanel();
        //   panel1.setLayout(null);
   
          f= new Font("Arial",Font.BOLD,12);
         title=new JLabel("Welcome To Travel Agency MAnagement System");
         title.setBounds(120, 25, 300, 50);
         title.setFont(f);
         c.add(title);
         
         user=new JLabel("User Name");
         user.setBounds(25, 80, 80, 50);
         c.add(user);
         
         pass=new JLabel("Password");
         pass.setBackground(Color.red);
         pass.setBounds(25, 130, 80, 50);
         c.add(pass);
         
    
         UserName=new JTextField();
         UserName.setBounds(100, 95, 80, 25);
         c.add(UserName);
         
         jpass=new JPasswordField();
         jpass.setBounds(100, 145, 80, 25);
         c.add(jpass);
         
         login=new JButton("Login");
          login.setBounds(100,220,80,35);
          login.addActionListener(this);
          c.add(login);
          
          close=new JButton("Close");
          close.setBounds(220,220,80,35);
          close.addActionListener(this);
          c.add(close);
         
          r1=new JRadioButton("User");
          r1.setBounds(300,80,100,50);
          r1.setSelected(true);
          c.add(r1);
          
          r2=new JRadioButton("Admin");
          r2.setBounds(300, 120, 100, 50);
          c.add(r2);
          
          grp=new ButtonGroup();
          grp.add(r1);
          grp.add(r2);
          
       //  this.add(panel1);
          
    }

 
    public void actionPerformed(ActionEvent e) {
       
        String clickbutton=e.getActionCommand();
        
        if(clickbutton.equals(login.getText()))
        {
            System.out.println("Login"); 
               flag=true;
               check();
        }
           else if(clickbutton.equals(close.getText()))
           {
             System.out.println("Close");
             System.exit(0);
           }
           else{}
    }
    
    public void check()
    {
    String query="SELECT `UserName` , `UserId` , `Password` , `Status` FROM `User`;";
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    System.out.println(query);
    
    try{
       Class.forName("com.mysql.jdbc.Driver");
      // System.out.println("");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
     //  System.out.println("Connection establish");
       st=con.createStatement();
    //   System.out.println("Statement Created");
       rs=st.executeQuery(query);
      // System.out.println("Received from database");
       
       while(rs.next())
       {
        String id=rs.getString("UserId");
       String name=rs.getString("UserName");
       String password=rs.getString("Password");
       String Status=rs.getString("Status");
       
       if(name.equals(UserName.getText()))
       {
            flag=false;
            
            if(password.equals(jpass.getText()))
            {
            if(r1.isSelected() && Status.equals(r1.getText()))
            {
                UserHome us = new UserHome(name,password,Status);
                
                
                this.setVisible(false);
                us.setVisible(true);
                
            }
            else if(r2.isSelected() && Status.equals(r2.getText()))
            {
               AdminHome ad = new AdminHome(name,password,Status);
               ad=new AdminHome();
               this.setVisible(false);
               ad.setVisible(true);
            }
                else if(r1.isSelected() && Status.equals(r2.getText()))
               {
                   
              JOptionPane.showMessageDialog(this,"Select Valid User");
            }
            else if(r2.isSelected() && Status.equals(r1.getText()))
            {
              JOptionPane.showMessageDialog(this,"Select Valid User");
            }
            
           }
            
        
     
               else 
            {
            JOptionPane.showMessageDialog(this, "Invalid password");
            }           
           }
}
              if(flag)
              {
        JOptionPane.showMessageDialog(this,"Invalid User Name");
      }
    }catch(Exception ex)
    {
    System.out.println(""+ex.getMessage());
    }
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
 
    }catch(Exception ex)
    {
    System.out.println(ex);
    }
    
    
    
    }
    
    
    }
    
    
    
}
