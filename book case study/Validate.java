package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Validate
 {
	static Connection con = null;
	static PreparedStatement ps=null;
	static ResultSet rs = null;
	static boolean st;
	public static boolean checkLogin(String unames,String passs) 
     {
       st =false;
      try{

	    System.out.println("Login");
         Class.forName("com.mysql.jdbc.Driver");

 	
          con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/sys","thinesh","thinesh");
         ps =con.prepareStatement("select User_Name,Password from registeration where User_Name=? and Password=?");
         ps.setString(1, unames);
         ps.setString(2, passs);
         rs =ps.executeQuery();
         if(rs.next()){
        	st=true;
         }
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }
 
	
}  
 
 
 