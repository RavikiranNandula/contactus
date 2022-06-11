package com.login.check;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Cookie;

import com.submit.database.UserDao;

@WebServlet("/checklogIn")
public class User extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pass=request.getParameter("password");

		UserDao dao=new UserDao();
		HttpSession session=request.getSession();
		if(dao.check(username, pass)) {
			session.setAttribute("username", username);
			response.sendRedirect("dashboard");
		}
		else {
			response.sendRedirect("login.jsp"); 
		}
	}
}
