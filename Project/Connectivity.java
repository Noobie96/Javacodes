package com.FirstServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connectivity {
public static Connection getConnection() {
	    Connection connection=null;
	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/validation","Anushya","Anushya123");
		System.out.println("Connection created");
	} catch (Exception e) {
		
		System.out.println("Unable to load driver & create connection ");
		e.printStackTrace();
	 
	}
		return connection;	}
	    public static PreparedStatement getPreparedStatement(Connection con, String sql){
			
			PreparedStatement ps = null;
			
			try {
				ps = con.prepareStatement(sql);
			} catch (SQLException e) {
				
			    e.printStackTrace();
			}
			return ps;
	    }
	    public static void closeInstance(ResultSet rt) {
	    	try {
	    		rt.close();
	    	}catch(Exception e) {
	    		System.out.println("exception caught");
	    	}}
	    	
	    
	
	    public static void closeInstance(Connection cn,PreparedStatement st) {
	    	try {
	    		cn.close();
	    		st.close();
	    	
	    	}catch(Exception e) {
	    		System.out.println("exception caught");
	    	}
	    }
	    	public static void main(String args[]){
	    		getConnection();
	    	}
	    
}
	
	


