/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectMCQ;

/**
 *
 * @author dell
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LogUser extends JFrame implements ActionListener{
   JLabel lblname,lblpswd,lbltkn;
   JTextField txtuser,txttoken;
   JPasswordField txtpass;
   JButton btnlogin,btnsignup;
   ImageIcon img;
   
   public LogUser(){
        setTitle("User Login");
       
       lblname=new JLabel("Email");
       txtuser=new JTextField();
       
       lblpswd=new JLabel("Password");
       txtpass= new JPasswordField();
       
       lbltkn=new JLabel("Token");
       txttoken=new JTextField();
               
       
     
       
       btnlogin=new JButton("Login");
       btnsignup=new JButton("Register a new user");
       
       lblname.setForeground(Color.WHITE);
       lblname.setBounds(10, 10, 150, 27);
       txtuser.setBounds(170,10,150,27);
       
       lblpswd.setForeground(Color.WHITE);
       lblpswd.setBounds(10, 50, 150, 27);
       txtpass.setBounds(170,50,150,27);
       
       lbltkn.setForeground(Color.WHITE);
       lbltkn.setBounds(10,90,150,27);
       txttoken.setBounds(170,90,150,27);
       
      
       btnlogin.setForeground(Color.black);
       btnlogin.setBounds(170, 140, 75, 30);
       btnsignup.setForeground(Color.WHITE);
       btnsignup.setBounds(170,240,169,40);
       
       DBconn db=new DBconn();
       String token=db.tokenNo();
       
       txttoken.setEditable(false);
       txttoken.setText(token);
      
       
       add(lblname);add(txtuser);
       add(lblpswd); add(txtpass);
       add(lbltkn); add(txttoken);
       
   
       add(btnlogin);
       add(btnsignup);
       
       btnsignup.addActionListener(this);
       btnlogin.addActionListener(this);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(500,400);
      
       setLayout(null);
       setLocationRelativeTo(null);
      
       //Code for adding background image
       JLabel background;
       img =new ImageIcon("pic1.jpg");
       background=new JLabel("",img,JLabel.CENTER);
       background.setBounds(0,0,1366,768);
       add(background);
       
       //Setting font
       lblname.setFont(new Font("Calibri",Font.BOLD,15));
       lblpswd.setFont(new Font("Calibri",Font.BOLD,15));
       lbltkn.setFont(new Font("Calibri",Font.BOLD,15));
       btnsignup.setFont(new Font("Calibri",Font.BOLD,16));
       btnlogin.setFont(new Font("Calibri",Font.BOLD,15));
       
       
      
       btnsignup.setBackground(Color.red);
       
   }
   public static void main(String[]args)
   {
       new LogUser().setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource().equals(btnsignup))
        {
            
            RegisterFile sign=new RegisterFile();
            sign.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource().equals(btnlogin))
        {
            try
            {
                DBconn dc=new DBconn();
                int result=dc.login(txtuser.getText(),txtpass.getText());
                
                if(result>0)
                {
                    JOptionPane.showMessageDialog(null, "Login successfull");
                    StartQuiz aq=new StartQuiz();
                    aq.setVisible(true);
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Login unsucessfull");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Error"+ex);
            }
            
        }
    }
}
