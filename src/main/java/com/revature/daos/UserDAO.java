package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class UserDAO {

	Public ArrayList<User> getUsers(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				
				User u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						null
						);
				
				int roleFK = rs.getInt("user_role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				e.setRole(r);
				
				employeeList.add(e);
			}
			
			return employeeList;
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting all users!");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
}
