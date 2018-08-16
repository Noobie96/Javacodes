package com.FirstServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.ReverbType;

public class Validation {
	static Connection connect = null;
	static PreparedStatement ps = null;
	static ResultSet rt = null;
	static int count=0;
	static int records=0;
	static int i=0;
	static String s;
	
	
	
	  public static int isValidName(String firstname,String lastname)throws SQLException {
		 int result=2;
	     String cpattern="a-zA-Z";
		  if((firstname.matches(cpattern))||(lastname.matches(cpattern))){
			  result= 1;
		  }
	  else{
		  
		   result=2;
}return result;}
	  public static int isValidUsername(String username){
		  int result=2;
		  String upattern="a-zA-z0-9";
		  if(username.contains(upattern)){
			  result= 1;
		  }else
		  {result= 2;
		  
		  }return result;
	  }
	 public static int passwordCheck(String password){
      	int result = 2;
      	String pattern="a-zA-Z0-9@!#$%^&*()_+";
      	
      	System.out.println("password:" +password);
        if((password.length()>8)||(password.length()<=15)||(password.matches(pattern))){
      	  System.out.println("valid");
  	     result= 1;
    }else{
  	  result= 2;
    }
      
        return result;
       }
       public static String  encryptPassword(String password){
      	 StringBuilder psw=new StringBuilder(password);
      	 StringBuilder encryptedpwd=psw.reverse();
      	 String ep=encryptedpwd.toString();
      	 //System.out.println(ep);
      	 return ep;
       }
      	 
      	
	  public static int isValidEmailAddress(String email) {
			 int result = 2;

          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ePattern);
          java.util.regex.Matcher matcher = pattern.matcher(email);

        	  if (matcher.matches()) {
          result= 1;
        	  }
        	  else{
        		  result=2;
        	  }
        	  return result;
          }
	  
		  public static int isValidatePhoneNumber(String phoneno) {
			  int result=2;
			
		      Pattern pattern1 = Pattern.compile("\\d{10}");
		      Matcher mbleno = pattern1.matcher(phoneno);
		   
		      if (mbleno.matches()) {
		    	 System.out.println("success");result= 1;
		      }
		  else
		      {
		    	  System.out.println("invalid");result= 2;
		      }
		      return result;
		
		}

			static int Compare(String username,String password) throws SQLException {
				  int result=2;
				try {
					
				String SelectUsername="Select * from userdetails where username=? and pwd=?";
				System.out.println("username"+ username);
				System.out.println("password"+ password);
				connect = Connectivity.getConnection();
				ps = Connectivity.getPreparedStatement(connect, SelectUsername);
				
				ps.setString(1,username);
				String pw1=Validation.encryptPassword(password);
				ps.setString(2,pw1);
				rt = ps.executeQuery();
				while(rt.next()){
					System.out.println("");
					result=1;
				}
				
		        System.out.println("");}
				catch(SQLException e) {
				e.printStackTrace();
			    }
				finally {
				Connectivity.closeInstance(connect, ps);
				Connectivity.closeInstance(rt);
				}
				return result;
				}
      
}
		 


