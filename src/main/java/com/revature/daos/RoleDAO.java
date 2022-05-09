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
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_user_roles where ers_user_role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
			return new Role(
					rs.getInt("ers_user_role_id"),
					rs.getString("user_role")
					);
				
			}	
			
		} catch (SQLException e) {
			System.out.println("Something went wrong fetching this data!!");
			e.printStackTrace(); 
		}
		
		return null;
	}

	
}//end of the Class
