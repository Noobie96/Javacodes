package com.FirstServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FirstServlet.InsertionDetails;

public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String UserName = request.getParameter("username");
		String email = request.getParameter("email");
		String ContactNumber = request.getParameter("contact");
		String password = request.getParameter("psw");
		int i = 0;
		int j=0;
		int k=0;
		int l=0;
		int n=0;
		int o=0;
		//String m="";
		try{
			 j=Validation.isValidName(FirstName, LastName);
			 k=Validation.isValidUsername(UserName);
			 l=Validation.passwordCheck(password);
			 // m=Validation.encryptPassword(password);
			 n=Validation.isValidEmailAddress(email);
			 o=Validation.isValidatePhoneNumber(ContactNumber);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if((j==1)||(k==1)||(l==1)||(n==1)||(o==1)){
			
		try {
			i=InsertionDetails.insertDetails(FirstName, LastName, UserName, email, ContactNumber, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("username already exists");
		}}

		// Actual logic goes here.

		// PrintWriter out = response.getWriter();
		if (i == 1) {
			request.setAttribute("SuccessMsg", "Registeration Successful");
			RequestDispatcher rd = request.getRequestDispatcher("owner.jsp");
			rd.include(request, response);
		
		} else if (i == 2) {

			request.setAttribute("invalidMessage", "Registeration unsuccessful");
			RequestDispatcher rd = request.getRequestDispatcher("owner.jsp");
			// response.sendRedirect("owner.jsp");
			rd.include(request, response);

		}}

	

	public void destroy() {

		System.out.println("Destroy Method");

	}

}

		
		