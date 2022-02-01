<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<h1>Displaying the Product Details....</h1>
<hr>
<%= "Entered Product Id is: " + session.getAttribute("pid") %> <br> <br>

<%= "Entered Product Name is: " + session.getAttribute("pname") %>  <br> <br>

<%= "Entered Product Price is: " + session.getAttribute("pprice") %>
<hr>
</body>
</html>