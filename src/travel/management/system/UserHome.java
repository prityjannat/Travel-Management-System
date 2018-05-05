/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Prity
 */
public class UserHome extends JFrame implements ActionListener
 {
    private Container c;
    private JPanel panel2;
    private JLabel title;
    private Font f; 
    private JButton ticket,tour,cancel,payment,info,logout;
    private String UserName,Password,Status;

    UserHome(String UserName, String Password, String Status) {
   initcomponent();
          
       this.UserName= UserName;
       this.Status=Status;
       this.Password=Password;
    } 
    public void initcomponent()
    {
        c=this.getContentPane();
        c.setLayout(null);
        
        super.setTitle("User Home Window");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      ///  panel2=new JPanel();
       // panel2.setLayout(null);
        
         f= new Font("Arial",Font.BOLD,12);
        title=new JLabel("User Pane");
        title.setBounds(150,20,200,30);
        title.setFont(f);
        c.add(title);
        
        ticket=new JButton("BuyTicket");
        ticket.setBounds(55,80,130,50);
        ticket.addActionListener(this);
        c.add(ticket);
        
        tour=new JButton("BookingTour");
        tour.setBounds(220,80,130,50);
        tour.addActionListener(this);
        c.add(tour);
        
        cancel=new JButton("Cancelation");
        cancel.setBounds(55,180,130,50);
        cancel.addActionListener(this);
        c.add(cancel);
        
        payment=new JButton("Payment");
        payment.setBounds(220,180,130,50);
        payment.addActionListener(this);
        c.add(payment);
        
        info=new JButton("Your Details");
        info.setBounds(55,280,130,50);
        info.addActionListener(this);
        c.add(info);
        
        logout=new JButton("Logout");
        logout.setBounds(220,280,130,50);
        logout.addActionListener(this);
        c.add(logout);
    
    }

   
    public void actionPerformed(ActionEvent e) {
      String clickbutton=e.getActionCommand();
      if(clickbutton.equals(logout.getText()))
      {
          System.out.println("Logout");
      Login l=new Login();
      l.setVisible(true);
      this.setVisible(false);
      
      }
      
      else if(clickbutton.equals(ticket.getText()))
      {
      BuyTicket b1=new BuyTicket(UserName,Password,Status);
      b1.setVisible(true);
      this.setVisible(false);
      
      }
      else if(clickbutton.equals(tour.getText()))
      {
      BookingTour bt=new BookingTour(UserName,Password,Status);
      bt.setVisible(true);
      this.setVisible(false);
      }
      
      else if(clickbutton.equals(cancel.getText()))
      {
      Cancelation cn=new Cancelation(UserName,Password,Status);
      cn.setVisible(true);
      this.setVisible(false);
      
      }
      else if(clickbutton.equals(payment.getText()))
      {
      Payment p=new Payment(UserName,Password,Status);
      p.setVisible(true);
      this.setVisible(false);
      }
      
      else if(clickbutton.equals(info.getText()))
      {
      BookingInfo in = new BookingInfo(UserName,Password,Status);
      in.setVisible(true);
      this.setVisible(false);
      }
      else{}
    }

   
    
    
}
