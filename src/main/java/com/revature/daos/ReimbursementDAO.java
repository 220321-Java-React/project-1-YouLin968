package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface {


		@Override
		public ArrayList<Reimbursement> getReimbursement(){
			
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "select * from ers_reimbursement;";
				
				Statement s = conn.createStatement(); //createStatement() is a method from our Connection object
				
				ResultSet rs = s.executeQuery(sql);
				
				
				
				ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
				
				while(rs.next()) {
					
					Reimbursement reimbursement = new Reimbursement(
							
							rs.getInt("reimb_id"),
							rs.getInt("reimb_amount"),
							rs.getInt("reimb_submitted"),
							rs.getInt("reimb_resolved"),
							rs.getString("reimb_description"),
							rs.getInt("reimb_receipt")
							);
					
					reimbursementList.add(reimbursement);
				}
				
				return reimbursementList;
				
			} catch (SQLException e) {
				System.out.println("Something went wrong contacting the database!");
				e.printStackTrace(); 
			}
			
			return null; 
			
		}

		
		
		public Reimbursement getReimbById(int id) {
			
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "select * from ers_reimbursement where reimb_id = ?";
				
				PreparedStatement ps = conn.prepareStatement(sql); 
				
				ps.setInt(1, id); 
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
				return new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getInt("reimb_submitted"),
						rs.getInt("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_receipt")
						);
					
				}	
				
			} catch (SQLException e) {
				System.out.println("Something went wrong fetching this data!!");
				e.printStackTrace(); 
			}
			
			return null;
		}
	
}
