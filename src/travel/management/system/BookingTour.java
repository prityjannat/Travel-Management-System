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
   class BookingTour extends JFrame implements ActionListener{
       
       private String UserName,Password,Status;
       private Container c;
       private JLabel label;
       private Font f;
       private JButton back,log;

   public BookingTour(String UserName, String Password, String Status) {
       
       this.UserName=UserName;
       this.Password=Password;
       this.Status=Status;
       
       initcomponents();
    }
   
   public void initcomponents()
   {
   c=this.getContentPane();
   c.setLayout(null);
   
    this.setTitle("BookingTour Package");
    this.setSize(600, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    f=new Font("",Font.BOLD,18);
    
    label=new JLabel("No Package Is Available Right Now");
    label.setBounds(100, 5, 400, 350);
    label.setForeground(Color.red);
    label.setFont(f);
    c.add(label);
    
    back=new JButton("Main Menu");
    back.setBounds(200, 380, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(315,380,100,50);
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
       else 
       {}
    }

  
    
}
