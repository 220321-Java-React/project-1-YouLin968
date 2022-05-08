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
			
			ArrayList<User> employeeList = new ArrayList<>();
			
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
	
	//We want a method that can take in a Role title, and return all Employees with that Role
	@Override
	public ArrayList<User> getUsersByRole(String title) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//We need a SQL String with a JOIN
			//We need to join employees on roles in order to access the role_title column from the roles table
			//since I want to get employees by their role title, I need access to the data in both tables
			String sql = "select * from employees inner join roles "
					+ "on role_id = role_id_fk where role_title = ?;";
			
			//we have a variable in the SQL statement, so we need a PreparedStatement to fill it in
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//now we just need to input the variable value
			ps.setString(1, title);
			
			//Execute the query into a ResultSet object
			ResultSet rs = ps.executeQuery();
			
			//Instantiate an empty ArrayList that we'll fill with the data from the ResultSet
			ArrayList<User> userList = new ArrayList<>();
			
			
			//while there are records remaining in the ResultSet...
			while(rs.next()) {
				
				//create new Employee objects based on the data, and fill in the ArrayList
				User u = new User(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						null
						);
				
				//get the foreign key from the Employees table to use in our getRoleById() method
				int roleFK = rs.getInt("role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				//fill in the previously null Role variable in this new Employee object (with the setter!)
				u.setRole(r);
				
				//fill in the employeeList with each while loop until eventually rs.next() == false.
				userList.add(e);
			}
			
			return userList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees by ID");
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void insertUser(User user, int role_id) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
		
		//First we need our SQL String that represents the INSERT statement we'll send to the DB
		//Again, there are variables in this statement, that we can fill out thanks to PreparedStatement
		String sql = "insert into ers_users (user_first_name, user_last_name, user_role_id_fk)"
				+ "values (?, ?, ?);";
				
		//Instantiate a PreparedStatement to fill in the variables of our initial SQL String
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//fill in the values of our variables using ps.setXYZ()
		ps.setString(1, user.getUser_first_name());
		ps.setString(2, user.getUser_last_name());
		ps.setInt(3, role_id); 
		//note how the DB role_id is an int, but in Java, Employees have a Role OBJECT
		//this is my workaround of choice... have the user input the id of the desired role when inserting the user data
		
		//Execute the Update!! (the method is called executeUpdate(), but it's for INSERTS, UPDATES, and DELETES)
		ps.executeUpdate();
		
		//Tell the user the insert was successful
		System.out.println("Employee " + user.getUser_first_name() + " added. Welcome aboard agagagagaga!");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong inserting Employee!");
			e.printStackTrace();
		}
		
	} 


	@Override
	public void removeUser(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//SQL String that we want to send to the DB
			String sql = "delete from employees where employee_id = ?;";
			
			//instantiate our PreparedStatement to fill in the variable
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			//ps.executeUpdate() to send our delete to the DB
			ps.executeUpdate();
			
			//let the user know that the dreams of their former employee have been crushed
			System.out.println("Get outta here, employee #" + id);
			
		} catch (SQLException e) {
			System.out.println("YOU CAN'T FIRE ME MY FATHER WILL SUE");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//Ben is leaving this unimplemented... Check RoleDAO for findById functionality
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
