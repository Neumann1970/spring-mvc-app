<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
	<style>
	table, th, td {
  	border: 1px solid black;
	}
</style>
</head>
<body>
	<div class="bg-light" style="padding: 5%;">                      
		<h1 style="text-align:center;"> ${greeting} ${message} </h1>               
	</div> 
	<div style="margin-left:15%; margin-right:15%;">
	<table style="width:100%">
  <tr>
    <th>API</th>
    <th>URL</th> 
  </tr>
  <tr>
    <td><a href="http://localhost:8080/spring-mvc-app/swagger-ui.html">LINK</a></td>
    <td><a href="http://localhost:8080/spring-mvc-app/swagger-ui.html">http://localhost:8080/spring-mvc-app/swagger-ui.html</a></td> 
  </tr>
</table>
</div>
</body>
</html>