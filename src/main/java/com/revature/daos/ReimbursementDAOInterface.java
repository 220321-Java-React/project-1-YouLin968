package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

	ArrayList<Reimbursement> getReimbursement();
	
	Reimbursement getReimbById(int id);
	
	
}
