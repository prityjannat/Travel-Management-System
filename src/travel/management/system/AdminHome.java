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
import javax.swing.*;

/**
 *
 * @author Prity
 */
public class AdminHome extends JFrame implements ActionListener{
    
      private String UserName,Password,Status;
      private Container c;
      private JLabel label;
      private JButton create,udelete,uinfo,pacdel,update,log,pacupdate,userupdate;
      private Font f;


   public AdminHome(String UserName, String Password, String Status) {
      
      
        
        this.UserName= UserName;
        this.Password=Password;
        this.Status=Status;
          
    }

    AdminHome() {
        initcomponents();
    }
  
  

  
    
  public void initcomponents()
  {
      
      c=this.getContentPane();
      c.setLayout(null);
      
  this.setTitle("AdminHome Pane");
  this.setSize(400, 500);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  f=new Font("",Font.BOLD,20);
 label=new JLabel("Admin Details");
 label.setBounds(150, 20, 200, 30);
 label.setForeground(Color.gray);
 label.setFont(f);
 c.add(label);
 
  create=new JButton("Create User");
  create.setBounds(55, 80, 130, 50);
  create.addActionListener(this);
  c.add(create);
  
  udelete=new JButton("User Delete");
  udelete.setBounds(220, 80, 130, 50);
  udelete.addActionListener(this);
  c.add(udelete);
  
  uinfo=new JButton("User Details");
  uinfo.setBounds(55, 280, 130, 50);
  uinfo.addActionListener(this);
  c.add(uinfo);
  
  pacdel=new JButton("Package Delete");
  pacdel.setBounds(220, 180, 130, 50);
  pacdel.addActionListener(this);
  c.add(pacdel);
  
  update=new JButton("Create Package");
  update.setBounds(55, 180, 130, 50);
  update.addActionListener(this);
  c.add(update);
 
  userupdate=new JButton("User Update");
  userupdate.setBounds(220, 280, 130, 50);
  userupdate.addActionListener(this);
  c.add(userupdate);
  
  log=new JButton("Log Out");
  log.setBounds(130, 370, 130, 50);
  log.addActionListener(this);
  c.add(log); 

       
 
 
  
  }

    @Override
    public void actionPerformed(ActionEvent e) {
       String clickbutton=e.getActionCommand();
       
       if(clickbutton.equals(log.getText()))
       {
       Login l=new Login();
       l.setVisible(true);
       this.setVisible(false);
       } 
       else if(clickbutton.equals(create.getText()))
       {
       CreateUser cr=new CreateUser();
       cr.setVisible(true);
       this.setVisible(false);
               
       }
       else if(clickbutton.equals(udelete.getText()))
       {
       DeleteUser dl=new DeleteUser();
       dl.setVisible(true);
       this.setVisible(false);
       
       
       }
       
       else if(clickbutton.equals(uinfo.getText()))
       {
       
       UserInfo in=new UserInfo();
       in.setVisible(true);
       this.setVisible(false);
       }
       else if(clickbutton.equals(pacdel.getText()))
       {
       PacDelete pc=new PacDelete();
       pc.setVisible(true);
       this.setVisible(false);
       
       }
       else if(clickbutton.equals(update.getText()))
       {
       CreatePackage cp=new CreatePackage();
       cp.setVisible(true);
       this.setVisible(false);
       }
       else if(clickbutton.equals(userupdate.getText()))
       {
       UserUpdate up=new UserUpdate();
       up.setVisible(true);
       this.setVisible(false);
       }
       
       }
    }
   

  
    

