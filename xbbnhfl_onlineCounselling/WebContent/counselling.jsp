<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"  %>
<%@ page import="com.inautix.training.counselling.controller.EligibleCollege"  %>
<%@ page import="com.inautix.training.counselling.dao.getEligibleCollegeDAO"  %>
<%@ page import="com.inautix.training.counselling.controller.applyCounsellingController"  %>
<%@ page import="javax.servlet.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COUNSELLING WINDOW|ONLINE COUNSELLOR</title>
</head>
<body>
<% out.println(session.getAttribute("studentid"));
Integer regnos =(Integer)session.getAttribute("studentid");
%>
<% 
applyCounsellingController cr = new applyCounsellingController();
List<String> l = new ArrayList<String>();
EligibleCollege se = new EligibleCollege();
//Integer regno = (Integer)session.getAttribute("studentid");
l = se.getEligibleColleges(regnos);
getEligibleCollegeDAO colseat = new getEligibleCollegeDAO();
Iterator itr = l.iterator();%>
<table>
<tr><td>COLLEGE NAME</td><td>SEATS</td></tr>
<%
while(itr.hasNext())
{ 
 String temp = (String) itr.next();
 %>
<tr><td><% out.print(temp);%><%out.print(colseat.getcurrentseats(temp)); %></td></tr>
<% 
} %>
</table>
<form method = "post" action="http://localhost:8080/xbbnhfl_onlineCounselling/collegeprocessing">
<input type="text" name="collegename">
<input type="submit" value="submit">
</form>

</body>
</html>