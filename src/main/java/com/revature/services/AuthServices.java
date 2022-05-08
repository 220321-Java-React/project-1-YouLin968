package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;

public class AuthServices {

	public User login(String username, String password) {
		
		if(username.equals("user") && password.equals("password")) {
			
			Role role = new Role();
			
			return new User(10, "Agent", "47", role);
		} else {
			return null;
		}
	}
	
}
