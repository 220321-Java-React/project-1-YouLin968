package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;



public class RoleDAO implements RoleDAOInterface {

	@Override
	public ArrayList<Role> getRoles(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_user_roles;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Role> roleList = new ArrayList<>();
			
			while(rs.next()) {
				
				Role role = new Role(
				
						rs.getInt("ers_user_role_id"),
						rs.getString("user_role")
						);
				
				roleList.add(role);
			}
			
			return roleList;
					
		} catch (SQLException e) {
			System.out.println("Something went wrong contacting database.");
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	@Override
	public Role getRoleById(int id) {
		
		//use a try-with-resources block to open a DB connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//String that lays out the SQL query we want to run
			//this String has a variable/parameter, the role_id we're searching for is determined at runtime
			String sql = "select * from roles where ers_user_role_id = ?";
			
			//we need a PreparedStatement object to fill in variables of our SQL query 
			PreparedStatement ps = conn.prepareStatement(sql); //conn.prepareStatement() instead of createStatement()
			
			//insert the method's argument (int id) as the variable in our SQL query
			ps.setInt(1, id); //the 1 is referring to the first variable (?) in our SQL String
			//then the second parameter is the value we want to put into that first variable
			
			//Execute the query in a ResultSet object to hold our incoming data
			ResultSet rs = ps.executeQuery();
			
			//the above code gets our data, and now we need to populate that data into a Role object
			//we can return the new role object right away without assigning it to a variable
			
			while(rs.next()) {
				
			return new Role(
					rs.getInt("ers_user_role_id"),
					rs.getString("user_role")
					);
				
			}	
			//note how we don't need an ArrayList here, since we're only returning one object
			
		} catch (SQLException e) {
			System.out.println("Something went wrong fetching this data!!");
			e.printStackTrace(); //print stack trace so we actually get some clues as to what went wrong
		}
		
		return null;
	}

	
}//end of the Class
