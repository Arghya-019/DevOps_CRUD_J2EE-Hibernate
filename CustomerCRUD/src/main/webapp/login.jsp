<html>
<head>

<title>UserLogin</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="PageStyle.css">

</head>
<body>

<%@ page session="false" %>

<div class="wrapper">

	<div id="header" style="background-color: #add8e6;">
		<TABLE class="headerclass">
			<tr>
				<TD><img src="hexaware_logo.png" alt="logo" /></TD>
				<TD><h1>DevOps Solutions</h1></TD>
            
			</tr>
		</TABLE>
	</div>



<form action="LoginServlet" method="post" >

<fieldset style="padding:30px;top:230px;left:450px; position: absolute;">

<legend>Login</legend>


<TABLE cellpadding="5">


<TR>
	<TD>Email</TD>
		<TD><INPUT TYPE="TEXT" NAME="email" SIZE="25" required></TD>
</TR>
<TR>
    <TD>Password</TD>
      <TD><INPUT TYPE="password" NAME="password" SIZE="25" required></TD>
</TR>

<TR>
    
	<TD><INPUT TYPE="SUBMIT" VALUE="Login!" NAME="B1"> </TD>
	     <TD><a href="register.jsp">Register</a></TD>
</TR>

</TABLE>

<div id="msg_position" style="color: #FF0000;">${login_fail_message}</div>

</fieldset>

</form>
<div class="push"></div>


</div>




<div class="footer">
<footer style="position: absolute; left: 60px;">&#169; Hexaware Technologies Limited. All rights reserved 2016 </footer>
</div>


</body>
</html>
