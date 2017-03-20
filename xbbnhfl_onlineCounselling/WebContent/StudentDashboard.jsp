<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*" %>    
<%@page import="java.util.*" %>    
<%@page import="javax.servlet.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DASHBOARD|ONLINE COUNSELLOR</title>
</head>
<body>
Welcome <% session.getAttribute("registeredname"); %> You are just 1 step away from your dream college..
<br> 
The profile details you entered in your previous step will be used for choosing your college. If you would like to review/change 
any of them, please click the below link.
<br> Please note that once you have completed the counselling process, you can't change your profile details.
<br>
<a href="Editprofile.jsp">CLICK HERE TO EDIT YOUR PROFILE</a>
<br>
<a href="AreYouReady.jsp">CLICK HERE TO PROCEED TO THE COUNSELLING PROCESS</a>

</body>
</html>