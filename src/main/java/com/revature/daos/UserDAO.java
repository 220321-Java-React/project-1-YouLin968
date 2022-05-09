package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface{
	
	RoleDAO rDAO = new RoleDAO();

	public ArrayList<User> getUsers(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				
				User u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						null
						);
				
				int roleFK = rs.getInt("user_role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
				
				userList.add(u);
			}
			
			return userList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting all users!");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public ArrayList<User> getUsersByRole(String title) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			
			String sql = "select * from ers_users inner join roles " 
					+ "on ers_user_roles = user_role_id_fk where user_role = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<User> userList = new ArrayList<>();
			
			
			while(rs.next()) {
				
				User u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_first_name"),
						rs.getString("ers_last_name"),
						null
						);
				
				int roleFK = rs.getInt("ers_user_role_id");
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
				
				userList.add(u);
			}
			
			return userList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees by ID");
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void insertUser(User user, int ers_user_role_id) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
		
	
		String sql = "insert into ers_users (user_first_name, user_last_name, user_role_id_fk)"
				+ "values (?, ?, ?);";
				
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getErs_first_name());
		ps.setString(2, user.getErs_last_name());
		ps.setInt(3, ers_user_role_id); 
		
		ps.executeUpdate();
		
		System.out.println("User " + user.getErs_first_name() + " added. Welcome!");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong inserting User!");
			e.printStackTrace();
		}
		
	} 


	@Override
	public void removeUser(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from users where ers_users_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			System.out.println("Get outta here, user #" + id);
			
		} catch (SQLException e) {
			System.out.println("YOU CAN'T FIRE ME MY FATHER WILL SUE");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
