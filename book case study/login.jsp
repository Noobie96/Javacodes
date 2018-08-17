<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>login form</title>
    </head>
    <body>
        <form method="post" action="userlogin">
               
        username:<input type="text" name="User_Name" /><br/>
        password:<input type="password" name="Password" /><br/>
        
        <input type="submit" value="login" />
        <a href="Registeration.jsp">Register</a>
        </form>
    </body>
</html>