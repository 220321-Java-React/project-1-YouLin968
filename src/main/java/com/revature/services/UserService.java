package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {

	UserDAO uDAO = new UserDAO();
	
	public ArrayList<User> getUsers(){
		
		ArrayList<User> users = uDAO.getUsers();
		
		return users;
	}
	
}
