package com.submit;

//import java.beans.Statement;
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

import com.RequestPojoClass;
import com.submit.database.*;


@WebServlet("/Submit")
public class Request extends HttpServlet{
	
	private RequestDao rd=new RequestDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=request.getParameter("name");
		String email=request.getParameter("email");
		String textarea=request.getParameter("textarea");
		
		RequestPojoClass model=new RequestPojoClass();
		model.setFullname(fullname);
		model.setEmail(email);
		model.setMessage(textarea);
		
		rd.submitRequest(model);
		response.sendRedirect("thanks.jsp");
	}
}
