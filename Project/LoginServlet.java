package com.FirstServlet;

import javax.servlet.http.HttpServlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {

		// Set response content type
		String s = (String) request.getParameter("username");

		String s1 = (String) request.getParameter("pwd");
		// response.setContentType("user/html");
		int i = 0;
		try {
			i = Validation.Compare(s, s1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Actual logic goes here.

		 PrintWriter out = response.getWriter();
		if (i == 1) {
			response.sendRedirect("welcome.jsp");
			 out.print("Success!");

		} else if (i == 2) {

			request.setAttribute("errorMessage", "Invalid user or password");
			RequestDispatcher rd = request.getRequestDispatcher("owner.jsp");
			// response.sendRedirect("owner.jsp");
			rd.include(request, response);

		}

	}

	public void destroy() {

		System.out.println("Destroy Method");

	}

}
