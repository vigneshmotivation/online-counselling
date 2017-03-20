<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
<%@ page import="com.inautix.training.counselling.dao.StudentProfileDAO" %>  
<%@ page import="com.inautix.training.counselling.dao.applyCounsellingDAO" %>  
<%@ page import="com.inautix.training.counselling.domain.StudentProfile" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT PROFILE</title>
</head>
<body>
<% StudentProfileDAO sps =new StudentProfileDAO();
Integer regno = (Integer)session.getAttribute("studentid");
 StudentProfile student = sps.otherDetails(regno); %>
EDIT PROFILE| <% out.println(student.getName()); %> ( <% out.println(session.getAttribute("studentid")); %> )
<form method = "post"  action="http://localhost:8080/xbbnhfl_onlineCounselling/profilechangeservelet">
<fieldset>
<legend>PERSONAL DETAILS</legend>
<img class="profile-pic" src="http://cdn.cutestpaw.com/wp-content/uploads/2012/07/l-Wittle-puppy-yawning.jpg" />
<div class="upload-button">Upload Image</div>
<input class="file-upload" type="file" accept="image/*" name="profilepic"/>

<table border="0">

<tr><td>
<label>NAME (AS SPECIFIED IN YOUR ACADEMIC RECORDS)</label></td><td><input type="text" name="academicname" value="<%= student.getName() %>" ><br></td></tr><br>
<tr><td><label>FATHERS NAME</label></td><td><input type="text" name="fathername" value="<%= student.getName() %>"></td></tr>
<tr><td><label>MOTHERS NAME</label></td><td><input type="text" name="mothername" value="<%= student.getName() %>"></td></tr>
<% if(student.getGender().equalsIgnoreCase("MALE")) %>
<tr><td>GENDER</td><td><input type="radio" name="gender" value="male" checked="checked">MALE<input type="radio" name="gender" value="female">FEMALE</td></tr>
<% else %>
<tr><td>GENDER</td><td><input type="radio" name="gender" value="male">MALE<input type="radio" name="gender" value="female" checked="checked">FEMALE</td></tr>
<tr>
<td>EMAIL</td><td><input type="text" name="email" value="<%= student.getName() %>" ></td></tr>
<tr><td>NUMBER</td><td><input type="text" name="phoneno" value="<%= student.getName() %>"></td>
</tr>
<% if(student.getScholarship().equalsIgnoreCase("YES")) %>
<tr><td>DO YOU NEED A SCHOLARSHIP ?</td><td><input type="radio" name="scholarship" value="yes" checked="checked">Yes<input type="radio" name="scholarship" value="no">No</td></tr>
<% else %>
<tr><td>DO YOU NEED A SCHOLARSHIP ?</td><td><input type="radio" name="scholarship" value="yes" >Yes<input type="radio" name="scholarship" value="no" checked="checked">No</td></tr>
<tr><td>PERMANENT ADDRESS</td><td><textarea name="address"><% out.print(student.getName()); %></textarea></td></tr>
</table>
</fieldset>
<fieldset>
<legend>ACADEMIC CREDENTIALS</legend>
<table border="0">
<tr><td>REGISTRATION NUMBER<input type="text" name="registernumber" value="<%= student.getRegno() %>" disabled="true" ></td></tr>
<tr><td ><label>HIGHEST QUALIFICATION</label>
<select name="highestqualification" >
<option>B.E</option>
<option>HIGHER SECONDARY</option>
<option>M.E</option>
<option>P.G.D.M</option>
<option>AISSE</option>
<option>DIPLOMA</option>
<option>B.COM</option>
<option>M.COM</option>
<option>Phd</option>
</select>
SPECIALIZATION:<input type="text" name="specialisation" alt="specialisation" value="<%= student.getSpecialisation() %>"></td>
</tr>

<tr>

<td style="padding-left: 10%">ENTER YOUR SCORE DETAILS</td>
</tr>
<tr>
<td style="padding-left: 10%">
<select name="exam1">
<option><% out.println(student.getSubject1()); %></option>
<option>CAT</option>
<option>XAT</option>
<option>NMAT</option>
<option>CMAT</option>
<option>EXAM NAME</option>
</select>
<input type="text" name="mark1" value="<%= student.getMark1() %>"></td><br>
</tr>
<tr>
<td style="padding-left: 10%">
<select name="exam2">
<option><% out.println(student.getSubject2()); %></option>
<option>CAT</option>
<option>XAT</option>
<option>NMAT</option>
<option>CMAT</option>
<option>EXAM NAME</option>

</select>
<input type="text" name="mark2" value="<%= student.getMark2() %>"><br></td></tr>
<tr>
<td style="padding-left: 10%">
<select name="exam2">
<option><% out.println(student.getSubject3()); %></option>
<option>CAT</option>
<option>XAT</option>
<option>NMAT</option>
<option>CMAT</option>
<option>EXAM NAME</option>

</select>
<input type="text" name="mark3" value="<%= student.getMark3() %>"><br></td></tr>
<tr>
<td style="padding-left: 10%">
<select name="exam4">
<option><% out.println(student.getSubject4()); %></option>
<option>CAT</option>
<option>XAT</option>
<option>NMAT</option>
<option>CMAT</option>
<option>EXAM NAME</option>
</select>
<input type="text" name="mark4" value="<%= student.getMark4() %>"><br></td></tr>
<br>
<tr>
<td style="padding-left: 10%">
<select name="exam5">
<option><% out.println(student.getSubject5()); %></option>
<option>CAT</option>
<option>XAT</option>
<option>NMAT</option>
<option>CMAT</option>
<option>EXAM NAME</option>
</select>
<input type="text" name="mark5" value="<%= student.getMark5() %>"><br></td></tr>
</table>

</fieldset>
<br>
<input type="checkbox" name="agree">I promise that the aformentioned details are true to the best of my knowledge and if any descrepencies in the details mentioned above, I'm liable to legal actions including but not limited to expulsion from the counselling system<br><br>
<input type="submit" value="submit">
</form>

</body>
</html>