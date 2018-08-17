package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Userlogin extends HttpServlet {
 
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String unames = request.getParameter("User_Name");
        String passs = request.getParameter("Password");
        boolean result=Validate.checkLogin(unames, passs);
        if(result==true)
        { 
        	
            RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
           rs.forward(request, response);
           //ArrayList<?> BookList = (List)> request.getAttribute("Bookarraylist");
           
        }
        else
        {
           
           RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
           rs.include(request, response);
           out.println("Username or Password incorrect");
        }
    }  


}
