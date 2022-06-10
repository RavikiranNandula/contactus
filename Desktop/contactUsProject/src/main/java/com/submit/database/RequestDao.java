package com.submit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.RequestPojoClass;

public class RequestDao {
	
	public Connection connection;
	String url="jdbc:postgresql://localhost:5432/postgres";
	String userName="postgres";
	String password="root";
	String query="insert into contactUsTable(fullname,email,usermessage) values(?,?,?)";
	
	 public void submitRequest(RequestPojoClass model) {
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
}