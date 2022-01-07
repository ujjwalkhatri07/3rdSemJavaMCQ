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
public class UpdateFile extends JFrame implements ActionListener {
    JLabel lblname,lbladd,lblcontact,lblemail;
    JTextField txtname,txtadd,txtcontact,txtemail;
    JButton btnupdate,btnback;
    ImageIcon img;
    public UpdateFile(){
        setTitle("User Update");
        
        lblname=new JLabel("Full Name");
        txtname=new JTextField();
        
        lbladd=new JLabel("Address");
        txtadd=new JTextField();
        
        lblcontact=new JLabel("Contact");
        txtcontact=new JTextField();
        
        lblemail=new JLabel("Email");
        txtemail=new JTextField();
        
        btnupdate=new JButton("Update");
        btnback=new JButton("Back");
        
        lblname.setBounds(10, 10, 150, 20);
        txtname.setBounds(170,10,150,20);
        
        lbladd.setBounds(10, 40, 150, 20);
        txtadd.setBounds(170,40,150,20);
        
        lblcontact.setBounds(10, 70, 150, 20);
        txtcontact.setBounds(170,70,150,20);
        
        lblemail.setBounds(10, 100, 150, 20);
        txtemail.setBounds(170,100,150,20);
        
        btnupdate.setBounds(110,130,100,30);
        btnupdate.addActionListener(this);
        
        btnback.setBounds(0,160,80,30);
        btnback.addActionListener(this);
        
        add(lblname);add(txtname);
        add(lbladd);add(txtadd);
        add(lblcontact);add(txtcontact);
        add(lblemail);add(txtemail);
        add(btnupdate);add(btnback);
        
        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
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
       btnupdate.setFont(new Font("Calibri",Font.BOLD,15));
       btnback.setFont(new Font("Calibri",Font.BOLD,15));
       
       //Setiing color
       lblname.setForeground(Color.WHITE);
       lbladd.setForeground(Color.WHITE);
       lblcontact.setForeground(Color.WHITE);
       lblemail.setForeground(Color.WHITE);
       
    }
    public static void main(String[]args)
    {
        new UpdateFile().setVisible(true);
                
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
        //Updates user details
        if(e.getSource().equals(btnupdate))
        {
            try {
                DBconn db=new DBconn();
                int result=db.update(txtname.getText(),txtadd.getText(),txtcontact.getText(), txtemail.getText());
                if(result>0)
                {
                    JOptionPane.showMessageDialog(null,"User update successfull");
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"User update successfull");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Error"+ex);
            }
        }
        if(e.getSource().equals(btnback))
        {
            DashboardQN ad=new DashboardQN();
            ad.setVisible(true);
            this.setVisible(false);
        }
    }
    
}
