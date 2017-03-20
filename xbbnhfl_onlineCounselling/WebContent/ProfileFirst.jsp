<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit your Profile</title>
<style type="text/css">
.upload-button {
    padding: 4px;
    border: 1px solid black;
    border-radius: 5px;
    display: block;
    float: left;
}

.profile-pic {
    max-width: 200px;
    max-height: 200px;
    display: block;
}

.file-upload {
    display: none;
}
</style>
<script src="http://www.google.com/jsapi" type="text/javascript"></script>
 
<script type="text/javascript">google.load("jquery", "1.3.2");</script>
<script>
$(document).ready(function() {

    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
});
</script>
</head>
<body >
<H1>JUST FEW MORE STEPS TO YOUR DREAM COLLEGE...</H1>
<form method = "post"  action="http://localhost:8080/xbbnhfl_onlineCounselling/markinsertservelet">
<fieldset>
<legend>PERSONAL DETAILS</legend>
<img class="profile-pic" src="http://cdn.cutestpaw.com/wp-content/uploads/2012/07/l-Wittle-puppy-yawning.jpg" />
<div class="upload-button">Upload Image</div>
<input class="file-upload" type="file" accept="image/*" name="profilepic"/>

<table border="0">

<tr><td>
<label>NAME (AS SPECIFIED IN YOUR ACADEMIC RECORDS)</label></td><td><input type="text" name="academicname" value="<%= request.getAttribute("newname") %>" ><br></td></tr><br>
<tr><td><label>FATHERS NAME</label></td><td><input type="text" name="fathername"></td></tr>
<tr><td><label>MOTHERS NAME</label></td><td><input type="text" name="mothername"></td></tr>
<tr><td>GENDER</td><td><input type="radio" name="gender" value="male">MALE<input type="radio" name="gender" value="female">FEMALE</td></tr>
<tr>
<td>EMAIL</td><td><input type="text" name="email"></td></tr>
<tr><td>CONFIRM EMAIL</td><td><input type="text" name="confirmemail"></td>
<tr><td>NUMBER</td><td><input type="text"" name="phoneno"></td>
</tr>
<tr><td>DO YOU NEED A SCHOLARSHIP ?</td><td><input type="radio" name="scholarship" value="yes">Yes<input type="radio" name="scholarship" value="no">No</td></tr>
<tr><td>PERMANENT ADDRESS</td><td><textarea name="address"></textarea></td></tr>


</table>
</fieldset>
<fieldset>
<legend>ACADEMIC CREDENTIALS</legend>
<table border="0">
<tr><td>REGISTRATION NUMBER<input type="text" name="registernumber" value="<%= request.getAttribute("newregno") %>" disabled="true" ></td></tr>
<tr><td ><label>HIGHEST QUALIFICATION</label>
<select name="highestqualification">
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
SPECIALIZATION:<input type="text" name="specialisation" alt="specialisation"></td>
</tr>

<tr>

<td style="padding-left: 10%">ENTER YOUR SCORE DETAILS</td>
</tr>
<tr>
<td style="padding-left: 10%">
<select name="exam1">
<option>EXAM NAME</option>
<option>cat</option>

</select>
<input type="text" name="mark1"></td><br>
</tr>
<tr>
<td style="padding-left: 10%">
<select name="exam2">
<option>EXAM NAME</option>
<option>mat</option>

</select>
<input type="text" name="mark2"><br></td></tr>
<tr>
<td style="padding-left: 10%">
<select name="exam2">
<option>EXAM NAME</option>
<option>xat</option>

</select>
<input type="text" name="mark3"><br></td></tr>
<tr>
<td style="padding-left: 10%">
<select name="exam4">
<option>EXAM NAME</option>
<option>nmat</option>
</select>
<input type="text" name="mark4"><br></td></tr>
<br>
<tr>
<td style="padding-left: 10%">
<select name="exam5">
<option>EXAM NAME</option>
<option>cmat</option>
</select>
<input type="text" name="mark5" ><br></td></tr>
</table>

</fieldset>
<br>
<input type="checkbox" name="agree">I promise that the aformentioned details are true to the best of my knowledge and if any descrepencies in the details mentioned above, I'm liable to legal actions including but not limited to expulsion from the counselling system<br><br>
<input type="submit" value="submit">
</form>


</body>
</html>