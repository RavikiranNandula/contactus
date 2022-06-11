package com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.submit.database.RequestDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDao requestDao = new RequestDao();

        List<Request> list = null;
        System.out.println("came");
        try {
			list = requestDao.fetchRequest();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("requestList", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int requestId = Integer.parseInt(request.getParameter("id"));

        RequestDao requestDao = new RequestDao();
        try {
            requestDao.updateStatus(requestId);
            doGet(request, response);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
