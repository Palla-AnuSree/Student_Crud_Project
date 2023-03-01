<%@ page import="com.techpalle.model.Student" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display all student details</title>
</head>
<body>
<center>
<h1>Student Details</h1>
<table>
<tr>
<td>Sno</td>
<td>Name</td>
<td>Email</td>
<td>Password</td>
<td>State</td>

</tr>
<%
ArrayList<Student> st=(ArrayList<Student>)(request.getAttribute("show"));
for(Student item:st)
{
	out.print("<tr>");
	out.print("<td>"+item.getId());
	out.print("<td>"+item.getName());
	out.print("<td>"+item.getEmail());
	out.print("<td>"+item.getPassword());
	out.print("<td>"+item.getState());
	out.println("</tr>");
}
%>
</table>
</center>
</body>
</html>