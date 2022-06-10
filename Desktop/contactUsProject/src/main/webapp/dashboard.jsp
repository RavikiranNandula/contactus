<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.submit.database.DashboardRequestDao" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="dashboard.css">
<meta charset="UTF-8">
<title>Insert title here</title>
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
DashboardRequestDao db=new DashboardRequestDao();
ArrayList arr=db.getList();
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
                               <form action="">
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