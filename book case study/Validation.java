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
	
	
	
	  public static int isValidName(String Name)throws SQLException {
		 int output=2;
	     String cpattern="a-zA-Z";
		  if((firstname.matches(cpattern)){
			  output= 1;
		  }
	  else{
		  
		   output=2;
}return output;}
	  public static int isValidUsername(String User_Name){
		  int result=2;
		  String upattern="a-zA-z0-9";
		  if(username.contains(upattern)){
			  output= 1;
		  }else
		  {output= 2;
		  
		  }return result;
	  }
	 public static int passwordCheck(String Password){
      	int output = 2;
      	String pattern="a-zA-Z0-9@!#$%^&*()_+";
      	
      	System.out.println("password:" +password);
        if((password.length()>8)||(password.length()<=12)||(password.matches(pattern))){
      	  System.out.println("valid");
  	     output= 1;
    }else{
  	  output= 2;
    }
      
        return output;
       }
       public static String  encryptPassword(String Password){
      	 StringBuilder psw=new StringBuilder(Password);
      	 StringBuilder encryptedpwd=psw.reverse();
      	 String ep=encryptedpwd.toString();
      	 
      	 return ep;
       }
      	 
      	
	  public static int isValidEmailAddress(String Email_ID) {
			 int output = 2;

          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ePattern);
          java.util.regex.Matcher matcher = pattern.matcher(Email_ID);

        	  if (matcher.matches()) {
          result= 1;
        	  }
        	  else{
        		  output=2;
        	  }
        	  return output;
          }
	  
		  public static int isValidatePhoneNumber(String contact number) {
			  int output=2;
			
		      Pattern pattern1 = Pattern.compile("\\d{10}");
		      Matcher contact = pattern1.matcher(contact number);
		   
		      if (contact.matches()) {
		    	 System.out.println("success");output= 1;
		      }
		  else
		      {
		    	  System.out.println("invalid");output= 2;
		      }
		      return output;
		
		}

			static int Compare(String User_Name,String Password) throws SQLException {
				  int output=2;
				try {
					
				String SelectUsername="Select * from registeration where User_Name=? and Password=?";
				System.out.println("username"+ User_Name);
				System.out.println("password"+ Password);
				connect = Connectivity.getConnection();
				ps = Connectivity.getPreparedStatement(connect, Select User_Name);
				
				ps.setString(1,username);
				String pw1=Validation.encryptPassword(password);
				ps.setString(2,pw1);
				rt = ps.executeQuery();
				while(rt.next()){
					System.out.println("");
					output=1;
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
		 


