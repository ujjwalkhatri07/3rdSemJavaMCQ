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
public class RegisterFile extends JFrame implements ActionListener{
    JLabel lblname,lbladd,lblcontact,lblemail,lblpass;
    JTextField txtname,txtadd,txtcontact,txtemail;
    JPasswordField pass;
    JButton btnreg,btnback;
    ImageIcon img;
    public RegisterFile(){
        setTitle("User Registration");
        
        lblname=new JLabel("Full Name");
        txtname=new JTextField();
        
        lbladd=new JLabel("Address");
        txtadd=new JTextField();
        
        
        lblcontact=new JLabel("Contact");
        txtcontact=new JTextField();
        
        lblemail=new JLabel("Email");
        txtemail=new JTextField();
        
        lblpass=new JLabel("Password");
        pass=new JPasswordField();
        
        btnreg=new JButton("Register");
        btnback=new JButton("Back");
        
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(10, 10, 150, 20);
        txtname.setBounds(170,10,150,20);
        
        lbladd.setForeground(Color.WHITE);
        lbladd.setBounds(10, 40, 150, 20);
        txtadd.setBounds(170,40,150,20);
        
        lblcontact.setForeground(Color.WHITE);
        lblcontact.setBounds(10, 70, 150, 20);
        txtcontact.setBounds(170,70,150,20);
        
        lblemail.setForeground(Color.WHITE);
        lblemail.setBounds(10, 100, 150, 20);
        txtemail.setBounds(170,100,150,20);
        
        lblpass.setForeground(Color.WHITE);
        lblpass.setBounds(10, 130, 150, 20);
        pass.setBounds(170,130,150,20);
        
        btnreg.setBounds(110, 180, 100, 30);
        btnback.setBounds(0,180,100,30);
        
        add(lblname);add(txtname);
        add(lbladd);add(txtadd);
        add(lblcontact);add(txtcontact);
        add(lblemail);add(txtemail);
        add(lblpass);add(pass);
        add(btnreg);add(btnback);
        btnreg.addActionListener(this);
        btnback.addActionListener(this);
        setLayout(null);
        
        
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Adding background image
       JLabel background;
       img =new ImageIcon("hack2.jpg");
       background=new JLabel("",img,JLabel.CENTER);
       background.setBounds(0,0,1366,768);
       add(background);
       
       //Setting font
       lblname.setFont(new Font("Calibri",Font.BOLD,15));
       lbladd.setFont(new Font("Calibri",Font.BOLD,15));
       lblcontact.setFont(new Font("Calibri",Font.BOLD,15));
       lblemail.setFont(new Font("Calibri",Font.BOLD,15));
       lblpass.setFont(new Font("Calibri",Font.BOLD,15));
       btnreg.setFont(new Font("Calibri",Font.BOLD,13));
       btnback.setFont(new Font("Calibri",Font.BOLD,15));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        //Registering user into database
        if(e.getSource()==btnreg)
        {
            try 
            {
                DBconn dc=new DBconn(); // DatabaseConnect
                //Passing text element to DatabaseConnect
                int result=dc.save(txtname.getText(),txtadd.getText(),txtcontact.getText(), txtemail.getText(),pass.getText());
                if(result>0)
                {
                    JOptionPane.showMessageDialog(null,"Account sucessfully registered","Success",JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Registration incomplete");
                    
                }
            } 
            catch (Exception exc) {
                System.out.println("Error"+exc);
            }
        }
        
        if(e.getSource()==btnback)
        {
            this.setVisible(false);
            LogUser u=new LogUser();
            u.setVisible(true);
        }
    }
        
    
}
