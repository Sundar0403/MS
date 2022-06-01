<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="pojo.CustomerDetails" %>
<%@page import="logic.BankLogic" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAILS</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
</head>
<body>
<%if(session.getAttribute("customerId")==null)
{
	RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
	reqDispatch.forward(request,response);
} %>
<jsp:include page="CommonOptions.jsp"/>
<center><h2>DEACTIVATED CUSTOMER DETAILS</h2></center>
<table style="background-color:white;">
	<tr class="main">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Customer Address</th>
		<th>Customer Mobile No</th>
		<th>Change Status</th>
	</tr>
	
		<%  Map<Integer,CustomerDetails> newMap=(Map<Integer,CustomerDetails>) request.getAttribute("CustomerDetails");
	        for(Object key:newMap.keySet())
	        {
	        CustomerDetails cusDetails=newMap.get(key);	
	        if(cusDetails.isCustomerStatus()==false)
	        {
		%>
	<tr>
	<td><%out.print(cusDetails.getCustomerId()); %></td>
	<td><%out.print(cusDetails.getCustomerName()); %></td>
	<td><%out.print(cusDetails.getCustomerAddress()); %></td>
	<td><%out.print(cusDetails.getMobileNumber()); %></td>
	<td><form action="ActivateCustomer?customerId=<%=cusDetails.getCustomerId() %>" method="post"><button>Activate</button></form></td>
	</tr>
	<%
	        }
	        }
	%>
	
</table>
</body>
</html>