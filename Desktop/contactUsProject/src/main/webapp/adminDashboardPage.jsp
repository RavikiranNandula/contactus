<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.submit.database.*" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
       table, th, td {
       border: 1px solid blue;
    }
 </style>
<link rel="stylesheet" href="dashboard.css">
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
Connection connection=null;
if(session.getAttribute("username")==null){
	response.sendRedirect("adminLogin.jsp");
}
%>
	<div class="bg-container">
	            <form action="logout" class="logoutForm">
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
                       <tr>
                           <td>
                               101
                           </td>
                           <td>
                               Ravi
                           </td>
                           <td>
                               ravi@gmail.com
                           </td>
                           <td>
                               Hii Hello
                           </td>
                           <td>
                               Active
                           </td>
                           <td>
                               <form action=""class="form">
                                   <input type="submit" class="btn" value="Archive"/>
                               </form>
                           </td>
                       </tr>
                   </table>
               </div>
               <div class="table-container">
                   <h1 class="table-name2">Archived Requests</h1>
                   <table class="table">
                       <th>Id</th>
                       <th>Full Name</th>
                       <th>E-mail</th>
                       <th>Message</th>
                       <th>Status</th>
                       <tr>
                           <td>
                               101
                           </td>
                           <td>
                               Ravi
                           </td>
                           <td>
                               ravi@gmail.com
                           </td>
                           <td>
                               Hii Hello
                           </td>
                           <td>
                               Active
                           </td>
                       </tr>
                   </table>
               </div>
           </div>
</body>
</html>