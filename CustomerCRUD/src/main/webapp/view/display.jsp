<html>
<head>
<style>
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

table {
	border-collapse: collapse;
	width: 90%;
}
th,td{
	font-size: 14px;
	text-align: left;
	padding: 8px; 
	border-top:1pt solid #f2f2f2;
  	border-bottom:1pt solid #f2f2f2;
}

#footer {
	clear: both;
	position: relative;
	z-index: 10;
	height: 3em;
	margin-top: -3em;
}

 #header {
	position: relative;
	height: 7em;
	margin-top: -1em;
	margin-left: -1em;
	border-bottom: 1px solid black;
} 

.headerclass{
	margin-left: 4em;
}


hr {
	border: 0;
	height: 0;
	border-top: 1px solid rgba(0, 0, 0, 0.1);
	border-bottom: 1px solid rgba(255, 255, 255, 0.3);
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
	<br/>
	<div style="margin-left: 5em;">
	<h3>Customers</h3>
	<a href="../CustomerCRUD/view/add_new.jsp"> Create New Customer </a>
	<br/>
	<br/>
	<form action="update_delete" method="post">
		<table cellspacing="50">
			<tr >
				<td><b>Name</b></td>
				<td><b>Address</b></td>
				<td><b>Contact Number</b></td>
				<td><b>Alternate Contact Number</b></td>
				<td><b>Specialty</b></td>
				<td><b>Qualification Summary</b></td>

				<td><b>Action</b></td>
			</tr>
		   
			<%@ page import="java.util.*"%>
			<%@ page import="java.io.InputStream"%>
			<%@ page import="org.hibernate.cfg.*,org.hibernate.*" %>
			<%@ page import="devops.*"%>
			
			
			<% 
            //List<Customer> customers  = (List<Customer>)request.getAttribute("customers");
              
            %>
            
			<%
			 GetData data = new GetData();
			 List<Customer> customers = data.getList();
			 for (Customer cust1 : customers) { 
			
	         
			%>

			<tr>
				<td><%=cust1.getName()%></td>
				<td><%=cust1.getAddress()%></td>
				<td><%=cust1.getContactNumber()%></td>
				<td><%=cust1.getAlternateContactNumber()%></td>
				<td><%=cust1.getSpecialty()%></td>
				<td><%=cust1.getQualificationSummary()%></td>
				
				<TD><a href="\CustomerCRUD/view/update.jsp?id=<%=cust1.getId()%>">Edit</a>
					

					<a href="\CustomerCRUD/delete?id=<%=cust1.getId()%>"
					onclick="return confirm('Are you sure..?');">Delete</a></TD>

			</tr>
			<%
				}
			%>

		</table>
	</form>

	<div class="msg_position" style="color: #FF0000;">${update_fail_message}</div>
	<div class="msg_position" style="color: #009933;">${update_success_message}</div>
	<div class="msg_position" style="color: #FF0000;">${delete_fail_message}</div>
	<div class="msg_position" style="color: #009933;">${delete_success_message}</div>
	<br/>
	<hr>
	<br/>
	<footer>&#169; Hexaware Technologies Limited </footer>
	</div>
</body>
</html>
