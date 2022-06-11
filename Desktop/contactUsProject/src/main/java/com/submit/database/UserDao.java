package com.submit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	String url="jdbc:postgresql://localhost:5432/postgres";
	String userName="postgres";
	String password="root";
	String query="select * from usertable where username=? and pass=?";
	public boolean check(String username,String password) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection(url,userName,password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs=st.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		
		
		return false;
		
	}

}
