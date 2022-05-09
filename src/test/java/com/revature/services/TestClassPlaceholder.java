package com.revature.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.daos.LoginDAO;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;

public class TestClassPlaceholder {
	
	LoginDAO ld = new LoginDAO();
	ReimbursementDAO rmd = new ReimbursementDAO();
	RoleDAO rd = new RoleDAO();
	Reimbursement rb = new Reimbursement();
	User ur = new User();
	ReimbursementType rt = new ReimbursementType(null);
	ReimbursementStatus rs = new ReimbursementStatus();
	
	@Test
	public void testSuccessfulLogin() {
		
		assertTrue(ld.login("user", "password"));
		
	}
	
	@Test 
	public void testFailedLogin() {
		
		assertFalse(ld.login("ayy", "lmao"));
	
	}

	@Test
	public void userValueReturn() {
	
		assertNotNull(ur.getErs_first_name());
	
	}
	
}
