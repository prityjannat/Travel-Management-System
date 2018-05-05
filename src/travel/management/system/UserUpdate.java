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
import java.sql.Statement;


import javax.swing.*;

/**
 *
 * @author Prity
 */
class UserUpdate extends JFrame implements ActionListener{
    private Container c;
    private JLabel label,uid,uname,upass,ustatus;
    private Font f;
    private JTextField tid,tname,tpass,tstatus;
    private JButton back,log,sub;
    
    UserUpdate()
    {
    initcomponents();
    }
  public void initcomponents() {
        
      c=this.getContentPane();
      c.setLayout(null);
      
      this.setTitle("Update Pane");
      this.setSize(400, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      f=new Font("",Font.BOLD,20);
      label=new JLabel("Update User");
      label.setBounds(150, 20, 200, 30);
      label.setBackground(Color.red);
      label.setFont(f);
      label.setForeground(Color.black);
      c.add(label);
      
      uid=new JLabel("UserId");
      uid.setBounds(20, 70, 100, 30);
      c.add(uid);
      
      uname=new JLabel("UserName");
      uname.setBounds(20, 120, 100, 30);
      c.add(uname);
      
      upass=new JLabel("Password");
      upass.setBounds(20, 170, 100, 30);
      c.add(upass);
      
      ustatus=new JLabel("Status");
      ustatus.setBounds(20, 220, 100, 30);
      c.add(ustatus);
      
     tid=new JTextField("");
    tid.setBounds(90, 70, 100, 30);
    c.add(tid);
    
    tname=new JTextField("");
    tname.setBounds(90, 120, 100, 30);
    c.add(tname); 
    
    tpass=new JTextField("");
    tpass.setBounds(90, 170, 100, 30);
    c.add(tpass);
    
    tstatus=new JTextField("");
    tstatus.setBounds(90, 220, 100, 30);
    c.add(tstatus);
    
    back=new JButton("Main Menu");
    back.setBounds(20, 300, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(200, 300, 100, 50);
    log.addActionListener(this);
    c.add(log);
    
    sub=new JButton("Submit");
    sub.setBounds(230, 140, 100, 50);
    sub.addActionListener(this);
    c.add(sub);
    
  
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
        else if(clickbutton.equals(sub.getText()))
                {
                Dbshow();
                JOptionPane.showMessageDialog(null, "Updated");
                }
        else{}
    }
    
    public void Dbshow()
    {
    String query="UPDATE `user` SET UserName='"+tname.getText()+"',Password='"+tpass.getText()+"',Status='"+tstatus.getText()+"' WHERE UserId='"+tid.getText()+"'";
        System.out.println(query);
       Connection con=null;
       Statement st=null;
       
       try{
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
       st=con.createStatement();
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
       }
       if(st!=null)
       {
       st.close();
       }
       
       }catch(Exception e)
       {
       
       }
       
       
       }
    
    }

  
   
    
}
