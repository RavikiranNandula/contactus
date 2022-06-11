<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.submit.database.DashboardRequestDao" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.Request"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="dashboard.css">
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
     table, th, td {
        border: 1px solid blue;
     }
 </style>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp");
}
%>

<div class="bg-container">
				<form action="login" class="logoutForm" method="post">
                    <input type="submit" value="Logout" class="btn2">
                </form>
               <h1 class="main-heading">Welcome Home</h1>
               <div class="table-container">
                   <h1 class="table-name">Active Requests</h1>
                   <table class="table">
                       <th>Id</th>
                       <th>Full Name</th>
                       <th>E-mail</th>
                       <th>Message</th>
                       <th>Status</th>
                       <th>Change Status</th>
                        <%
                       List<Request> requestList = (List<Request>) request.getAttribute("requestList");
                       
                       for(Request req: requestList) {
                       	if(req.getStatus().equals(1)){
                        %>
				           <TR>
				                <TD> <%= req.getId() %></td>
				               <TD> <%=  req.getFullname() %></TD>
				               <TD> <%=  req.getEmail()%></TD>
				               <TD> <%= req.getMessage()%></TD>
				               <TD> <%=  req.getStatus()%></TD>
				                <td>
                                <form action="dashboard" method="post">
                                     <button class="btn" value="<%= req.getId() %>" name="id">Archive</button> 
                                </form>
                            </td>
				          </TR>
				           <%
                       	}
				            }
				           %>
				          
                   </table>
               </div>
               <div class="table-container">
                   <h1 class="table-name">Archived Requests</h1>
                   <table class="table">
                       <th>Id</th>
                       <th>Full Name</th>
                       <th>E-mail</th>
                       <th>Message</th>
                       <th>Status</th>
                       <th>Change Status</th>
                        <%
 
                       for(Request req: requestList) {
                       	if(req.getStatus().equals(0)){
                        %>
				           <TR>
				                <TD> <%= req.getId() %></td>
				               <TD> <%=  req.getFullname() %></TD>
				               <TD> <%=  req.getEmail()%></TD>
				               <TD> <%= req.getMessage()%></TD>
				               <TD> <%=  req.getStatus()%></TD>
				                <td>
                                <form action="dashboard" method="post">
                                     <button class="btn" value="<%= req.getId() %>" name="id">Archive</button> 
                                </form>
                            </td>
				          </TR>
				           <%
                       	}
				       }
				           %>
				          
                   </table>
               </div>
               
           </div>
</body>
</html>