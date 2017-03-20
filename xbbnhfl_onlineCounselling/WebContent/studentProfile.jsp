<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>  
<%@ page import="javax.servlet.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.inautix.training.counselling.dao.StudentProfileDAO" %>  
<%@ page import="com.inautix.training.counselling.dao.applyCounsellingDAO" %>  
<%@ page import="com.inautix.training.counselling.domain.StudentProfile" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDENT AREA</title>
</head>
<body>
<% StudentProfileDAO sps =new StudentProfileDAO();
Integer regno = (Integer)session.getAttribute("studentid");
 StudentProfile student = sps.otherDetails(regno); %>
WELCOME <% out.println(student.getName()); %> ( <% out.println(session.getAttribute("studentid")); %> )

<form method="post" action="/Editprofile.jsp">
 <fieldset>
 <table border="0">
<tr><td>
<label>NAME </label></td><td><% out.println(student.getName()); %> 
<tr><td><label>FATHERS NAME</label></td><td><% out.println(student.getFathername()); %></td></tr>
<tr><td><label>MOTHERS NAME</label></td><td><% out.println(student.getMothername()); %></td></tr>
<tr><td>GENDER</td><td><% out.println(student.getGender()); %></td></tr>
<tr>
<td>EMAIL</td><td><% out.println(student.getEmail()); %></td></tr>
<tr><td>NUMBER</td><td><% out.println(student.getContactnumber()); %></td>
</tr>
<tr><td>SCHOLARSHIP(YES/No) </td><td><% out.println(student.getScholarship()); %></td></tr>
<tr><td>PERMANENT ADDRESS</td><td><% out.println(student.getAddress()); %></td></tr>
</table>
</fieldset>
<fieldset>
<legend>ACADEMIC CREDENTIALS</legend>
<table border="0">
<tr><td>REGISTRATION NUMBER<% out.println(student.getRegno());  %></td></tr>
<tr><td ><label>HIGHEST QUALIFICATION</label>&nbsp;&nbsp;<% out.println(student.getQualification()); %></td></tr>
<tr><td>SPECIALIZATION:<% out.println(student.getSpecialisation()); %></td>
</tr>
<tr>
<td style="padding-left: 10%">
<% out.println(student.getSubject1()); %><% out.println(student.getMark1()); %></td>
</tr>
<tr>
<td style="padding-left: 10%">
<% out.println(student.getSubject2()); %><% out.println(student.getMark2()); %></td>
</tr>
<tr>
<td style="padding-left: 10%">
<% out.println(student.getSubject3()); %><% out.println(student.getMark3()); %></td>
</tr>
<tr>
<td style="padding-left: 10%">
<% out.println(student.getSubject4()); %><% out.println(student.getMark4()); %></td>
</tr>
<tr>
<td style="padding-left: 10%">
<% out.println(student.getSubject5()); %><% out.println(student.getMark5()); %></td>
</tr>
<tr>COUNSELLING STATUS : <% applyCounsellingDAO ad = new applyCounsellingDAO(); out.println(ad.checkalreadyapplied(regno)); %></tr>
<tr><td><a href="/Editprofile.jsp">CLICK HERE TO EDIT YOUR PROFILE</a><input type="submit" value="GENERATE PDF OF MY PROFILE">
</table>
</fieldset>
</form>
<br>
<a href="http://localhost:8080/xbbnhfl_onlineCounselling/AreYouReady.jsp">CLICK HERE TO PROCEED TO COUNSELLING WINDOW</a>


</body>
</html>