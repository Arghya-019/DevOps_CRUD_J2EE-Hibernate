<html>
<head>
<script>
function validatePassword()
{
     var new_password = document.getElementById("pass1").value;
     var confirm_new_password = document.getElementById("pass2").value;

     if (new_password.length < 3)
     {
         alert("Please ensure your password is at least 3 characters long.");
         return false;
     }
     else if ( new_password != confirm_new_password)
     {
         alert("Passwords do not match.");
         return false;
     }
     else
     {
          return true;
     }
 }
</script>

<style>

legend {
    display: block;
    padding-left: 2px;
    padding-right: 2px;
    border: none;
    font-size: 20px;
}

#header {
	position: relative;
	height: 7em;
	margin-top: -1em;
	margin-left: -1em;
	border-bottom: 1px solid black;
} 

#footer {
	clear: both;
	position: relative;
	z-index: 10;
	height: 3em;
	margin-top: -3em;
}


form {
	font-size: 14px;
	font-family: Helvetica, Arial, sans-serif;
	color: rgb(51, 51, 51);
}

body {
	font-size: 14px;
	font-family: Helvetica, Arial, sans-serif;
	color: rgb(51, 51, 51);
}



</style>

</head>
<body>

	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
				
			</tr>
		</TABLE>
	</div>
	
<div  style="margin-left: 5em;">

<form action="RegisterServlet" method="post" id="registerform">

<fieldset style="padding:20px;top:230px;left:450px; position: absolute;"> 

<legend>Registration</legend>

<TABLE  cellpadding="5">


<TR>
	<TD>Email</TD>
		<TD><INPUT TYPE="TEXT" NAME="email" SIZE="25" id="e_id" required>
		</TD>
</TR>
<TR>
    <TD>Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" id="pass1" required>
	</TD>
</TR>

<TR>
    <TD>Confirm Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" id="pass2" required>
	</TD>
</TR>

<TR>
    
	<TD><button type="submit" form="registerform" value="Register!" onclick="return validatePassword();">Submit</button></TD>
	
</TR>

</TABLE>
</fieldset> 
</form>

</div>

</body>
</html>