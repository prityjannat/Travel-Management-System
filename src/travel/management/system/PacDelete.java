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
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Prity
 */
class PacDelete extends JFrame implements ActionListener{
    private Container c;
    private JLabel label,pacid;
    private Font f;
    private JTextField tpacid;
    private JButton back,log,cancel;
      private String UserName,Password,Status;

 

  

    PacDelete() {
        initcomponents();
    }
    
    public void initcomponents()
    {
          c=this.getContentPane();
          c.setLayout(null);
          
          this.setTitle("Package Delete");
          this.setSize(400, 400);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f=new Font("",Font.BOLD,20);
        label=new JLabel("Package Delete");
        label.setBounds(150, 20, 200, 30);
        label.setFont(f);
        label.setForeground(Color.blue);
        c.add(label);
     
        pacid=new JLabel("PackageId");
        pacid.setBounds(30, 120, 100, 50);
        c.add(pacid);
        
        tpacid=new JTextField();
        tpacid.setBounds(130, 130, 100, 30);
        c.add(tpacid);
        
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
       JOptionPane.showMessageDialog(null, "Package deleted");
       }
       else{}
    }
    public void Dbshow()
    {
     String query="DELETE FROM `package` WHERE package.PackageId='"+tpacid.getText()+"'";
        System.out.println(query);
        Connection con=null;
        Statement st=null;
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        System.out.println("Connectin Established");
        st=con.createStatement();
        System.out.println("Statement Created");
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
        System.out.println("Connection closed");
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
