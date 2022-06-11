package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.submit.database.RequestDao;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =request.getRequestDispatcher("contactus.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=request.getParameter("name");
		String email=request.getParameter("email");
		String textarea=request.getParameter("textarea");
		
		RequestDao rd=new RequestDao();
		Request model=new Request();
		model.setFullname(fullname);
		model.setEmail(email);
		model.setMessage(textarea);
		
		rd.submitRequest(model);
		response.sendRedirect("thanks.jsp");
	}
}
