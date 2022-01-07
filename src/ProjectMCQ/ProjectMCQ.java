/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectMCQ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class ProjectMCQ extends JFrame implements ActionListener
{

    /**
     * @param args the command line arguments
     */
    JButton btnusr,btnadm;
    JLabel lblA;
    ImageIcon imgA;
    public ProjectMCQ(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setTitle("User Login Type ");
        lblA=new JLabel("");
        btnusr=new JButton("Log in as User");
        btnadm=new JButton("Log in as Admin");
        
        lblA.setBounds(61,51,401,31);
        btnusr.setBounds(81,101,141,41);
        btnusr.setToolTipText("Click here for user");
        btnadm.setBounds(251,101,141,41);
        btnadm.setToolTipText("Click here for admin");
        
        
        add(btnusr);
        add(btnadm);
        add(lblA);
        btnusr.addActionListener(this);
        btnadm.addActionListener(this);
        setSize(500,400);
        
        setLayout(null);
        panel.setToolTipText("A Panel container");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       JLabel background;
       imgA =new ImageIcon("pic1.jpg");
       background=new JLabel("",imgA,JLabel.CENTER);
       background.setBounds(0,0,1366,768);
       add(background);
       
       //Setting font and color
       btnusr.setFont(new Font("Calibri",Font.BOLD,15));
       btnadm.setFont(new Font("Calibri",Font.BOLD,15));
       lblA.setFont(new Font("Monospaced",Font.BOLD,30));
       lblA.setForeground(Color.WHITE);
       
    }
    public static void main(String[] args) {
        // TODO code application logic here
       
        ProjectMCQ jq=new ProjectMCQ();
        jq.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.\
        //Code for access of user
        if (e.getSource().equals(btnusr))
        {

            LogUser u=new LogUser();
            u.setVisible(true);
            this.setVisible(false);
          
        }
        //Code for access of admin
        if(e.getSource().equals(btnadm))
        {

            LogAdmin al=new LogAdmin();
            al.setVisible(true);
            this.setVisible(false);
        }
      
    }
    
}
