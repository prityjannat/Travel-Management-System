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
public class Payment extends JFrame implements ActionListener{
    private String UserName,Password,Status;
    private Container c;
    private JLabel label;
    private JButton back,log,proceed;
    private JRadioButton bkash,DBBL,master,visa;
    private ButtonGroup grp;
    private Font f;

 

    public Payment(String UserName, String Password, String Status) {
        
        this.UserName=UserName;
        this.Password=Password;
        this.Status=Status;
        
        initcomponents();
       
    }


    
    public void initcomponents()
    {
        
    f=new Font("",Font.BOLD,14);
    c=this.getContentPane();
    c.setLayout(null);
    
    this.setTitle("Payment");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    label=new JLabel("Payment within 24 hours");
    label.setBounds(100, 20, 200, 30);
    label.setForeground(Color.pink);
    label.setFont(f);
    c.add(label);
    
    back=new JButton("Main Menu");
    back.setBounds(20, 300, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(200, 300, 100, 50);
    log.addActionListener(this);
    c.add(log);
    
    proceed=new JButton("Done");
    proceed.setBounds(190, 150, 100, 50);
    proceed.addActionListener(this);
    c.add(proceed);
    
    bkash=new JRadioButton("bKash");
    bkash.setBounds(20, 50, 100, 50);
    bkash.setSelected(true);
    c.add(bkash);
    
    DBBL=new JRadioButton("DBBL");
    DBBL.setBounds(20, 110, 100, 50);
    c.add(DBBL);
    
    master=new JRadioButton("MasterCard");
    master.setBounds(20, 170, 100, 50);
    c.add(master);
    
    visa=new JRadioButton("VisaCard");
    visa.setBounds(20, 240, 100, 50);
    c.add(visa);
    
    grp=new ButtonGroup();
    grp.add(bkash);
    grp.add(DBBL);
    grp.add(master);
    grp.add(visa);
    
    
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
       else if(clickbutton.equals(proceed.getText()))
       {
       JOptionPane.showMessageDialog(null, "Already Done ");
       }
       else
       {}
    }

  
    
}
