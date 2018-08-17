package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class BookList {
	
	
	static ArrayList<Booklistclass> bookobject=new ArrayList<Booklistclass>();
	private static ResultSet rs;
	private static PreparedStatement ps;
@SuppressWarnings("rawtypes")
public static ArrayList Bookdetails(){
	 Connection con = null;
	 ps = null;
	 ResultSet rs;
	

	 


      String book="Select * from bookstore";
      	       
      try{
         Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sys","thinesh","thinesh");

 PreparedStatement ps = con.prepareStatement(book);		
			 rs=ps.executeQuery();
			Booklistclass bl = null;
	 		
			while(rs.next()){
	 			bl=new Booklistclass();
	 			bl.setCallno(rs.getInt(1));
	 			bl.setBook_Storeid(rs.getInt(2));
	 			bl.setBook_Name(rs.getString(3));
	 			bl.setAuthor(rs.getString(4));
	 			bl.setPublisher(rs.getString(5));
	 			bl.setQuantity(rs.getInt(6));
	 			bl.setPrice(rs.getDouble(7));
	 			
	 			bookobject.add(bl);
	 		}
			}
	 		catch(SQLException | ClassNotFoundException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 			
			return bookobject;	
	 			
}}
