<html>
<head>

<title>UserRegister</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="PageStyle.css">
<script src="validation.js"></script>

</head>
<body>

<div class="wrapper">

	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
				
			</tr>
		</TABLE>
	</div>
	


<form action="RegisterServlet" method="post" name="Registration" id="registerform">

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
    
	<TD><button type="submit" form="registerform" value="Register!" onclick="return validate();">Submit</button></TD>
	<TD><a href="login.jsp">Login</a></TD>
	
</TR>

</TABLE>

<div id="msg_position" style="color: #FF0000;">${register_fail_message}</div>

</fieldset> 
</form>

</div>

<div class="footer">
<footer style="position: absolute; left: 60px;">&#169; Hexaware Technologies Limited. All rights reserved 2016 </footer>
</div>

</body>
</html>