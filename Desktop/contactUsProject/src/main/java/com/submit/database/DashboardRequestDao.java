package com.submit.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DashboardRequestDao {
	public Connection connection;
	String url="jdbc:postgresql://localhost:5432/postgres";
	String userName="postgres";
	String password="root";
	String query="select * from contactUsTable";
	public ArrayList getList(){
		ArrayList requestsData=new ArrayList();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				ArrayList request=new ArrayList();
				int id=rs.getInt("id");
				String fullname=rs.getString("fullname");
				String email=rs.getString("email");
				String message=rs.getString("usermessage");
				String status=rs.getString("status");
				request.add(id);
				request.add(fullname);
				request.add(email);
				request.add(message);
				request.add(status);
				requestsData.add(request);
				System.out.println(request);
			}
			
		}
		catch(Exception e) {
			
		}
		return requestsData;
		
	}
	
}
