<html>
<head>

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
</fieldset>

</form>


<div class="msg_position" style="color: #FF0000;position=relative;">${login_fail_message}</div>


</body>
</html>
