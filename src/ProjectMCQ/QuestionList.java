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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;


public class QuestionList extends JFrame implements ActionListener{
    
    JLabel lblque;
    JRadioButton rad1,rad2,rad3,rad4;
    JButton btnnxt,btnsubmit;
    ButtonGroup bg;
   
    int current=0;
    int count=0,marks=0;
    
    PreparedStatement pst=null;
    ResultSet rs=null;
    String getsub;
    String answer;
    public QuestionList(String subject)
    {
         lblque=new JLabel();
         bg=new ButtonGroup();
         
         rad1=new JRadioButton("Option1");
         rad2=new JRadioButton("Option2");
         rad3=new JRadioButton("Option3");
         rad4=new JRadioButton("Option4");
         btnnxt=new JButton("Next");
         btnsubmit=new JButton("Submit");
         
         getsub=subject;
         
         lblque.setBounds(20,30,1000,20);  
         rad1.setBounds(20,60,300,20);
         rad2.setBounds(20,90,300,20);
         rad3.setBounds(20,120,300,20);
         rad4.setBounds(20,150,300,20);
    
        btnnxt.setBounds(270,240,100,30);  
        btnsubmit.setBounds(270,270,100,30);

      
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(900,900);
        setLocationRelativeTo(null);
        JLabel background;
   
        bg.add(rad1);bg.add(rad2);bg.add(rad3);bg.add(rad4);
        add(rad1);add(rad2);add(rad3);add(rad4);
        btnnxt.addActionListener(this);
        btnsubmit.addActionListener(this);
        add(lblque);
        add(btnnxt);add(btnsubmit);
        
        try
        {
       DBconn db=new DBconn();
        ArrayList<String> que=db.getQuestion(subject);
        
        lblque.setText(que.get(0));
        rad1.setText(que.get(1));
        rad2.setText(que.get(2));
        rad3.setText(que.get(3));
        rad4.setText(que.get(4));
        }
        
        catch(IndexOutOfBoundsException out)
        {
            
        }
       }
        
        String ButtonSelect(){
        for(Enumeration<AbstractButton> buttons=bg.getElements();buttons.hasMoreElements();)
        {
            AbstractButton button=buttons.nextElement();
            if(button.isSelected())
            {
                return button.getText();
            }
            
        }
        return null;
    }
        
    
    

    public static void main(String[] args) {
        new QuestionList("Data Structure").setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Display next question
        if(e.getSource().equals(btnnxt))
             {  
                 try
                 {
                     DBconn db=new DBconn();
                     
                     ArrayList<String> que=db.getQuestion(getsub);
                     
                     answer=ButtonSelect();
                     if(answer.equals(que.get(current+5)))
                     {
                         marks+=10;
                     }
                   
                     lblque.setText(que.get(current+6));
                     rad1.setText(que.get(current+1+6));
                     rad2.setText(que.get(current+2+6));
                     rad3.setText(que.get(current+3+6));
                     rad4.setText(que.get(current+4+6));
                     
                     current=current+6; 
                     
                 }
                 catch(IndexOutOfBoundsException out)
                 {
                     JOptionPane.showMessageDialog(null, "Question finished","Error",JOptionPane.OK_OPTION);
                 }
           
             }
            //Submitting final result
           if(e.getSource().equals(btnsubmit))
           {
               JOptionPane.showMessageDialog(null, marks,"Success",JOptionPane.INFORMATION_MESSAGE);
           }
           
           
    }
}
    
    

