package com.submit.database;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Request;

public class RequestDao {
	
	public Connection connection;
	String url="jdbc:postgresql://localhost:5432/postgres";
	String userName="postgres";
	String password="root";
	String query="insert into contactUsTable(fullname,email,usermessage) values(?,?,?)";
	String selectQuery="select * from contactUsTable ORDER BY  id";
	String updateQuery="select * from contactUsTable where id=?";
	String updateQueryTo0="UPDATE contactUsTable SET status = 0 where id=?;";
	String updateQueryTo1="UPDATE contactUsTable SET status = 1 where id=?;";
	
	 public void submitRequest(Request model) {
		 try {
			 	Class.forName("org.postgresql.Driver");
				Connection con= DriverManager.getConnection(url,userName,password);
				PreparedStatement st=con.prepareStatement(query);
				st.setString(1,model.getFullname());
				st.setString(2,model.getEmail());
				st.setString(3, model.getMessage());
				
				ResultSet rs=st.executeQuery();
		 }
		 catch(Exception e) {
		 	System.out.println(e.getMessage());
	 }
	
}
	 public List fetchRequest() throws SQLException {
	        Connection connection = null;
	        ResultSet resultSet = null;
	        List<Request> requestsList = new ArrayList<>();

	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection connection1= DriverManager.getConnection(url,userName,password);
	            Statement statement = connection1.createStatement();
	            resultSet = statement.executeQuery(selectQuery);

	            while(resultSet.next()) {
	            	
	                int id = resultSet.getInt("id");
	                String fullname = resultSet.getString("fullname");
	                String email = resultSet.getString("email");
	                String message = resultSet.getString("usermessage");
	                int requestStatus = resultSet.getInt("status");

	                Request req = new Request(id, fullname, email, message, requestStatus);
	                //System.out.println(req);

	                requestsList.add(req);
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        } 
	        //System.out.println(requestsList);
	        return requestsList;
	    }
	 
	 public void updateStatus( int req) {
		 try {
			 	Class.forName("org.postgresql.Driver");
				Connection con= DriverManager.getConnection(url,userName,password);
				PreparedStatement st=con.prepareStatement(updateQuery);
				st.setInt(1, req);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
					System.out.println("came222");
					int status=rs.getInt("status");
					System.out.println(status);
					if(status==1) {
						PreparedStatement st1=con.prepareStatement(updateQueryTo0);
						st1.setInt(1, req);
						ResultSet rs1=st1.executeQuery();
					}
					else if(status==0) {
						PreparedStatement st0=con.prepareStatement(updateQueryTo1);
						st0.setInt(1, req);
						ResultSet rs2=st0.executeQuery();
					}
				}
		 }
		 catch(Exception e) {
		 	System.out.println(e.getMessage());
	 }
	 }

}