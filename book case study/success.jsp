<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
    import="java.util.*,com.example.Booklistclass,javax.servlet.RequestDispatcher"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<form method="POST" action="booklist">
<table style ="width:100%">
<tr><th>call no</th>
<th>Book store id</th>
<th>Book Name</th>
<th>Author</th>
<th>Publisher</th>
<th>Quantity</th>
<th>Price</th>
</tr>
<%ArrayList <Booklistclass> blc = null;
if(request.getAttribute("Bookarraylist")!=null)
	
blc =(ArrayList<Booklistclass>) request.getAttribute("Bookarraylist");
Booklistclass Bl;
for(int k=0;k<blc.size();k++){
Bl=((Booklistclass)blc.get(k));%>
<tr>
<td><%=Bl.getCallno() %></td>
<td><%=Bl.getBook_Storeid() %></td>
<td><%=Bl.getBook_Name() %></td>
<td><%=Bl.getAuthor() %></td>
<td><%=Bl.getPublisher() %></td>
<td><%=Bl.getQuantity() %></td>
<td><%=Bl.getPrice() %></td>
</tr>
<%
}
%>
</table>
<input type = "button" value="Update" onclick="window.location.href='update'"/>
<input type = "button" value="Add" onclick="window.location.href=''"/>
<input type = "button" value="Delete" onclick="window.location.href='Delete'"/>
</form>
<%if(request.getAttribute("Task completed")!=null)
	{
	out.println(request.getAttribute("Completed"));}
	%>

</body>
</html>