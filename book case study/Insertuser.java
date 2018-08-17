package com.example;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 


public class Insertuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	 
  
 
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String name=request.getParameter("Name");         
String username=request.getParameter("User_Name");  
String password=request.getParameter("Password");  
String Email=request.getParameter("Email_ID");
String number=request.getParameter("Contact_Number");
         
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sys","thinesh","thinesh");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeration values(?,?,?,?,?)");  

ps.setString(1,name);  
ps.setString(2,username);  
ps.setString(3,password);  
ps.setString(4,Email);  
ps.setString(5,number);  
            
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
	 

}
