/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectMCQ;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class LogAdmin extends JFrame implements ActionListener{
   

    /**
     * @return the username
     */
   JLabel lbluser,lblpass;
   JTextField txtuser;
   JPasswordField pass;
   JButton btnlogin;
   ImageIcon img;
   public LogAdmin(){
        
       lbluser=new JLabel("Username");
       txtuser=new JTextField();
       
       lblpass=new JLabel("Password");
       pass= new JPasswordField();
       
       btnlogin=new JButton("Login");
       
       Container c = getContentPane();
       
       lbluser.setBounds(10, 10, 150, 20);
       txtuser.setBounds(170,10,150,25);
       
       lblpass.setBounds(10, 50, 150, 20);
       pass.setBounds(170,50,150,25);
       
       btnlogin.setBounds(180, 110, 95, 35);
       
       c.add(lbluser);
       c.add(txtuser);
       c.add(lblpass);
       c.add(pass);
       c.add(btnlogin);
       btnlogin.addActionListener(this);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(500,400);
      
       c.setLayout(null);
       setLocationRelativeTo(null);
       
       JLabel background;
       img =new ImageIcon("pic1.jpg");
       background=new JLabel("",img,JLabel.CENTER);
       background.setBounds(0,0,1366,768);
       add(background);
       
       lbluser.setFont(new Font("Calibri",Font.BOLD,16));
       lblpass.setFont(new Font("Calibri",Font.BOLD,16));
       btnlogin.setFont(new Font("Calibri",Font.BOLD,15));
       
       //Color set
       lbluser.setForeground(Color.WHITE);
       lblpass.setForeground(Color.WHITE);
//       btnlogin.setBackground(Color.BLUE);
//       btnlogin.setForeground(Color.WHITE);
   } 
   public static void main(String[] args)
   {
       LogAdmin al = new LogAdmin();
       al.setVisible(true);
   }
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        //Retrieving username and password from textfield
        String user=txtuser.getText();
        String pw=pass.getText();
        
        //Setting username and password for admin
        AdminFile a = new AdminFile();
        a.setUsername("Ujjwal1");
        a.setPassword("abc");
        
        if(e.getSource().equals(btnlogin))
        {
            //Verifying username and password to login
            if(user.equals(a.getUsername()) && pw.equals(a.getPassword()))
            {
            JOptionPane.showMessageDialog(null, "Logged in as Admin","Success",JOptionPane.INFORMATION_MESSAGE);
            DashboardQN ad=new DashboardQN();
            ad.setVisible(true);
            this.setVisible(false);

            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Password incorrect","Failed",JOptionPane.INFORMATION_MESSAGE);
            }
               
        }
    }
    
    
}
