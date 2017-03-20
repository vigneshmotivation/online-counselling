<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>    
<%@ page import="javax.servlet.*" %>    
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COUNSELLING WINDOW | ONLINE COUNSELLOR</title>
</head>
<body>
<% session.getAttribute("registeredname");%> <%  session.getAttribute("regnonew"); %>
YOU ARE ABOUT TO ENTER THE COUNSELLING PROCESS
<br>
PLEASE NOTE THAT THIS IS A ONE TIME PROCESS - ONCE YOU HAVE MADE YOUR CHOICE OF COLLEGE, YOU CANNOT CHOOSE AGAIN
PRESS BACK TO GO TO THE PREVIOUS PAGE AND UPDATE YOUR PROFILE (IF REQUIRED) OR CLICK BELOW TO BEGIN THE COUNSELLING PROCESS<br>
<a href="counselling.jsp">I'm ready to begin</a> <a href="StudentDashboard.jsp">I WANT TO UPDATE MY PROFILE</a>
</body>
</html>