package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAOInterface {

	ArrayList<ReimbursementType> getReimbType();
	
	ReimbursementType getReimbTypeById(int id) ;
	
	ArrayList<ReimbursementType> getReimbTypeByRole(String title);
	
	void insertReimbType(ReimbursementType reimbtype, int reimb_type_id);
	
	void removeReimbType(int id);
	
}
