package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAOInterface {

	//This method will return every employee from the database
	ArrayList<ReimbursementType> getReimbType();
	
	//This method will return an employee which we'll get by their id
	ReimbursementType getReimbTypeById(int id) ;
	
	//This method will return every employee of a given role (we'll use a string here, to search by role title)
	ArrayList<ReimbursementType> getReimbTypeByRole(String title);
	
	//This method will take in an employee object, and insert it into the database
	void insertReimbType(ReimbursementType reimbtype, int reimb_type_id);
	
	//This method will take in an int, and remove the employee whose id matches the int
	void removeReimbType(int id);
	
}
