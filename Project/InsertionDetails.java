package com.FirstServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InsertionDetails 
{
static Connection connect = null;
static PreparedStatement ps = null;
static ResultSet rt = null;
static int count=0;
static int records=0;
static int i=0;
static String s;
static int insertDetails(String firstname,String lastname, String username,String email,String contact ,String psw ) throws SQLException {
	int result=2;
	try {
		String InsertValue="insert into userdetails(firstname,lastname,username,email,contact,pwd) values(?,?,?,?,?,?)";
		connect = Connectivity.getConnection();
		ps = Connectivity.getPreparedStatement(connect, InsertValue);
		
		ps.setString(1,firstname);
		ps.setString(2,lastname);
		ps.setString(3,username);
		ps.setString(4,email);
		ps.setString(5,contact);
		String pw=Validation.encryptPassword(psw);
		ps.setString(6,pw);
	
		int i=ps.executeUpdate();
	         result=1;
	}
		catch(SQLException e) {
		e.printStackTrace();
		System.out.println("error in insertion");
	    }
		finally {
		Connectivity.closeInstance(connect, ps);
		//Connectivity.closeInstance(rt);
		}
	return result;
	}
		
	

	}
	
	
	


  


