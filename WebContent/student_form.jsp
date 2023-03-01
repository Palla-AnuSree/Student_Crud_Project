<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Student Form</h1>
<form action="studform">
<label for="tbname">Name :</label> <input type="text" name="tbname"/><br>
<label for="tbemail">Email :</label><input type="email" name="tbemail"/><br>
<label for="tbpw">Password :</label><input type="password" name="tbpw"/><br>
<label for="ddlstates">State :</label><select name="ddlstates">
	  <option>---select---</option>
	  <option value="AP">AndhraPradesh</option>
	  <option value="KA">Karnataka</option>
	  <option value="TN">TamilNadu</option>
	  <option value="KL">Kerala</option>
	  <option value="NI">NorthIndia</option>
	 </select><br>
<input type="submit" value="Insert" name="crud"/>
<input type="submit" value="Update" name="crud"/>
<input type="submit" value="Delete" name="crud"/>
<input type="submit" value="ShowAll" name="crud"/>
</form>
</center>
</body>
</html>