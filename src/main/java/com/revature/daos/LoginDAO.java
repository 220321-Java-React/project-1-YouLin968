package com.revature.daos;

public class LoginDAO {

	public boolean login(String username, String password) {
		if(username.equals("user") && password.equals("password")) {
			return true;
		}
		
		return false;
	}
	
}
