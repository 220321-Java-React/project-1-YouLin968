package com.revature.models;

public class Reimbursement {

	private int reimb_id;
	private int reimb_amount;
	private int reimb_submitted;
	private int reimb_resolved;
	private String reimb_description;
	private int reimb_receipt;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimb_id, int reimb_amount, int reimb_submitted, int reimb_resolved,
			String reimb_description, int reimb_receipt) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
	}


	public Reimbursement(int reimb_amount, int reimb_submitted, int reimb_resolved, String reimb_description,
			int reimb_receipt) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + "]";
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public int getReimb_amount() {
		return reimb_amount;
	}


	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}


	public int getReimb_submitted() {
		return reimb_submitted;
	}


	public void setReimb_submitted(int reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}


	public int getReimb_resolved() {
		return reimb_resolved;
	}


	public void setReimb_resolved(int reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}


	public String getReimb_description() {
		return reimb_description;
	}


	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}


	public int getReimb_receipt() {
		return reimb_receipt;
	}


	public void setReimb_receipt(int reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	
	
	
}
