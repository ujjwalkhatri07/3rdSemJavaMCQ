/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectMCQ;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class DBconn {
    public Connection cntn;
    PreparedStatement pst;
       ResultSet rs=null;
    
    public DBconn()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver"); 
        //Connecting to mysql database of name javaquiz
        cntn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamcq","root","");
        }
        catch(Exception e)
        {
        System.out.println("Error"+ e);
        }
    }
    //Registration of user which will save data in table of database
    public int save(String fullname, String address,String contact,String email,String password)
    {
        int result=0;
        
        try
        {
            //Insert query that will store data according to column name
            pst=cntn.prepareStatement("Insert into newuser values(null,?,?,?,?,?)") ;
            pst.setString(1,fullname);
            pst.setString(2,address);
            pst.setString(3,contact);
            pst.setString(4,email);
            pst.setString(5,password);
            
            result=pst.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error"+ e);
        }
        return result;
    }
    //Generating token name for user
    public String tokenNo()
    {
        String alpha="acefhjnpzvxy013579";
        String token="";
        
        int i;
        for( i=0;i<=6;i++)
        {
            token=token+alpha.charAt(new Random().nextInt(alpha.length()));
            
        }
        return token;
    }
    //Login for user which will check if the user is registered in database or not
    public int login(String Email,String password)
    {
        int result=0;
        
        try
        {
            //Retrieve name and password from database table 
            pst=cntn.prepareStatement("SELECT * FROM newuser WHERE Email=? and Password=?");
            
            pst.setString(1, Email);
            pst.setString(2, password);
            
            ResultSet r = pst.executeQuery();
//            JOptionPane.showMessageDialog(this, "Login successfull",JOptionPane.INFORMATION_MESSAGE);
            
            if(r.next())
            {
                result=1;
                return result;
                
            }
            else
            {
                return result; //returning result to UserLogin form
            }

        }
        catch(Exception e)
        {
            System.out.println("Error " + e);
        }
        return result;
    }
    //Inserting question into database table
    public int insert(String subname, String question,String option1,String option2,String option3,String option4,String correctans)
    {
         int result=0;
        
        try
        {
            pst=cntn.prepareStatement("Insert into question values(null,?,?,?,?,?,?,?)") ;
            pst.setString(1,subname);
            pst.setString(2,question);
            pst.setString(3,option1);
            pst.setString(4,option2);
            pst.setString(5,option3);
            pst.setString(6,option4);
            pst.setString(7,correctans);
            
            result=pst.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error"+ e);
        }
        return result; //Return result to AdminDashboard form
    }
    //Deleting question from database
    public int delete(String correctanswer)
    {   
        int result=0;
        try
        {
        pst=cntn.prepareStatement("Delete from question where correctanswer=?");
        pst.setString(1, correctanswer);
        result=pst.executeUpdate();
        }
        catch(Exception e)
                {
                    System.out.println("Error"+e);
                }
        return result;
    }
    
    //Updating user in database table
     public int update(String name,String add,String contact,String email)
    {
        int result=0;
        try {
            pst=cntn.prepareStatement("Update newuser set FullName=?, Address=?, Contact=? where Email=?");
            pst.setString(1,name);
            pst.setString(2,add);
            pst.setString(3,contact);
            pst.setString(4,email);
            result=pst.executeUpdate();
        } 
        catch (Exception e)
        {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    } 
     public ArrayList<String> getQuestion(String question) 
     {
         ArrayList<String> quearr=new ArrayList<>();
      
         
         try
         {
             String query=("Select * from question Where Subname = ?");
             pst=cntn.prepareStatement(query);
             pst.setString(1,question);
             rs=pst.executeQuery();
             
             while(rs.next())
             {
                 quearr.add(rs.getString("Question"));
                 quearr.add(rs.getString("option1"));
                 quearr.add(rs.getString("option2"));
                 quearr.add(rs.getString("option3"));
                 quearr.add(rs.getString("option4"));
                 quearr.add(rs.getString("correctanswer"));
             }
           
             
         }
         catch(Exception e)
         {
             System.out.println("Error"+e);
         }
         return quearr;
     }
    
    
}
