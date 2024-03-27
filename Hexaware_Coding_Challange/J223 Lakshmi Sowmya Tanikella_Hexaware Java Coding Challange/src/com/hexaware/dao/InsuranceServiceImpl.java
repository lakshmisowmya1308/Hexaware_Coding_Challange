package com.hexaware.dao;

import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.model.Client;
import com.hexaware.model.Policy;
import com.hexaware.util.DBConnection;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsuranceServiceImpl implements IPolicyService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;
	
    private Map<Integer, Policy> policyMap; // Simulating database with a map

    public InsuranceServiceImpl() {
        this.policyMap = new HashMap<>();
        getallPolicy();
    }

    @Override
    public boolean createPolicy(Policy p) {
    	con = DBConnection.getConnection();
    	try {
    		if (policyMap.containsKey(p.getPolicyId())) {
    			throw new PolicyNotFoundException();// Policy with the same ID already exists
            }
            else {
            	ps = con.prepareStatement("INSERT INTO Policy (clientid, start_date, end_date, policy_type, policy_status) VALUES(?,?,?,?,?)");
            	ps.setObject(1, p.getCid());
            	ps.setObject(2, p.getStartDate());
            	ps.setObject(3, p.getEndDate());
            	ps.setObject(4, p.getPolicyType());
            	ps.setObject(5, p.getPolicyStatus());
            	int r = ps.executeUpdate();
            	if(r==1) {
            		System.out.println("Policy Created Successfully");
            		
            		return true;
            	}
            	else {
            		throw new PolicyNotFoundException();
            	}
            	
            }
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}catch (PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void getallPolicy() {
    	con = DBConnection.getConnection();
    	try {
    		ps = con.prepareStatement("Select * from policy");
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			int policyId = rs.getInt("policy_id");
                int clientId = rs.getInt("clientid");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String policyType = rs.getString("policy_type");
                String policyStatus = rs.getString("policy_status");

                // Create Policy object
                Policy p = new Policy();
                p.setPolicyId(policyId);
                Client c= new Client();
                c.setClientId(clientId);
                p.setCid(c);
                p.setStartDate(startDate);
                p.setEndDate(endDate);
                p.setPolicyType(policyType);
                p.setPolicyStatus(policyStatus);
                policyMap.put(p.getPolicyId(), p);
    		}
            	
    	}catch(SQLException e) {
    		e.printStackTrace();
    }
    }
    @Override
    public void getPolicy(int policyId) throws PolicyNotFoundException{
    	try {
    		ps = con.prepareStatement("Select * from policy where policy_id = ?");
    		ps.setObject(1, policyId);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			System.out.println("Policy ID: " + rs.getInt("policy_id"));
                System.out.println("Client ID: " + rs.getInt("clientid"));
                System.out.println("Start Date: " + rs.getDate("start_date"));
                System.out.println("End Date: " + rs.getDate("end_date"));
                System.out.println("Policy Type: " + rs.getString("policy_type"));
                System.out.println("Policy Status: " + rs.getString("policy_status"));
                System.out.println();
    		}
    		else {
    			System.out.println("Not Exist");
    		}
    	
    	}catch(SQLException e) {
        	e.printStackTrace();
        }
        
    	
    }

    @Override
    public void getAllPolicies() {
    	try {
    		ps = con.prepareStatement("Select * from policy");
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			System.out.println("Policy ID: " + rs.getInt("policy_id"));
                System.out.println("Client ID: " + rs.getInt("clientid"));
                System.out.println("Start Date: " + rs.getDate("start_date"));
                System.out.println("End Date: " + rs.getDate("end_date"));
                System.out.println("Policy Type: " + rs.getString("policy_type"));
                System.out.println("Policy Status: " + rs.getString("policy_status"));
                System.out.println();
    		}
    	}catch(SQLException e) {
        	e.printStackTrace();
        }
        
    }

    @Override
    public boolean updatePolicy(Policy policy) {
       
        con = DBConnection.getConnection();
        try {
        	 if (!policyMap.containsKey(policy.getPolicyId())) {
             	throw new PolicyNotFoundException();
             }
        ps = con.prepareStatement("UPDATE Policy SET clientid = ?, start_date = ?, end_date = ?, policy_type = ?, " +
                "policy_status = ? WHERE policy_id = ?");
			ps.setInt(1, policy.getCid());
			ps.setObject(2, policy.getStartDate());
			ps.setObject(3, policy.getEndDate());
			ps.setString(4, policy.getPolicyType());
			ps.setString(5, policy.getPolicyStatus());
			ps.setInt(6, policy.getPolicyId());
		int r = ps.executeUpdate();
		if(r>0) {
	        System.out.println("Policy updated successfully!");
	        return true;
		}
         
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch (PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletePolicy(int policyId) {
        
        try {
        	if (!policyMap.containsKey(policyId)) {
            	throw new PolicyNotFoundException();
            }
        	ps = con.prepareStatement("delete from policy where policy_id = ?");
			ps.setObject(1, policyId);
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Employee record deleted successfully");
			}
        return true; // Policy deleted successfully
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch (PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
 
}

