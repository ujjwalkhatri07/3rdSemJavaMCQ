/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectMCQ;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 *
 * @author dell
 */
public class StartQuiz extends JFrame implements ActionListener
{
    JLabel lbl;
    JComboBox jcb;
    JButton start;
    ImageIcon img;
    public StartQuiz(){
            
           setTitle("Start Quiz");
           lbl=new JLabel("Select any Course");
           jcb=new JComboBox();
           jcb.addItem("Data Structure");
           jcb.addItem("Modern Web");
           jcb.addItem("Communication");
           jcb.addItem("Ethics");
           
           lbl.setBounds(30,10,200,30);
           jcb.setBounds(30,50,150,20);
           
           start=new JButton("Start quiz");
           start.setBounds(30,80,100,30);
           
           start.addActionListener(this);
           
           add(jcb);
           add(lbl);
           add(start);
        
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        //Setting background
       JLabel background;
       img =new ImageIcon("c.jpg");
       background=new JLabel("",img,JLabel.CENTER);
       background.setBounds(0,0,500,500);
       add(background);
       
       //Setting font and color
       jcb.setFont(new Font("Calibri",Font.BOLD,15));
       start.setFont(new Font("Calibri",Font.BOLD,15));
       lbl.setFont(new Font("Calibri",Font.BOLD,25));
       lbl.setForeground(Color.white);
       
    }
    
    public static void main(String[] args) {
        new StartQuiz().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Starting quiz
        if(e.getSource().equals(start)){
                new QuestionList(jcb.getSelectedItem().toString()).setVisible(true);
    }
    
    
    }
}
