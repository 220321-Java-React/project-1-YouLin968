package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

	UserService us = new UserService();
	
	public Handler getUsersHandler = (ctx) -> {
		
		if(AuthController.ses != null) {
			
			ArrayList<User> users = es.getUsers();
			
			Gson gson = new Gson();
			
			String JSONEmployees = gson.toJson(users);
			
			ctxresult(JSONUsers);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			
			
		} else {
				ctx.status(400);
		}
		
	};
	
	
}


