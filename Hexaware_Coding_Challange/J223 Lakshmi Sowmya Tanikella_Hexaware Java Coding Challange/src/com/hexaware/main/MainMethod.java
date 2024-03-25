package com.hexaware.main;

import com.hexaware.dao.InsuranceServiceImpl;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.model.Client;
import com.hexaware.model.Policy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) throws PolicyNotFoundException {
		InsuranceServiceImpl i = new InsuranceServiceImpl();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Scanner s = new Scanner(System.in);
		Policy p = new Policy();
		while(true) {
			System.out.println("Enter Your Choice: ");
			System.out.println("1. createPolicy");
			System.out.println("2. getPolicy");
			System.out.println("3. getAllPolicies");
			System.out.println("4. updatePolicy");
			System.out.println("5. deletePolicy");
			System.out.println("6. Exit..");
			switch(s.nextInt()) {
			case 1: 
				
				System.out.println("Enter details: ");
				System.out.println("Enter cliend id: ");
				Client c= new Client();
                c.setClientId(s.nextInt());
                p.setCid(c);
				System.out.println("Enter policy Start Date: ");
				try {
					p.setStartDate(dateFormat.parse(s.next()));
					System.out.println("Enter End Date: ");
					p.setEndDate(dateFormat.parse(s.next()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				System.out.println("Enter policy status: ");
				p.setPolicyStatus(s.next());
				System.out.println("Enter policy type: ");
				p.setPolicyType(s.next());
				
		        boolean isPolicyCreated = i.createPolicy(p);
		        if (isPolicyCreated) {
		            System.out.println("Policy created successfully!");
		        } else {
		            System.out.println("Failed to create policy. Policy with the same ID already exists.");
		        }
				break;
			case 2: System.out.println("Enter Policy id: ");
					i.getPolicy(s.nextInt());
			        
				break;
			case 3: 
					i.getAllPolicies();
			        
				break;
			case 4: 
				System.out.println("Emter your policy id: ");
				p.setPolicyId(s.nextInt());
				System.out.println("Enter cliend id: ");
				Client ci= new Client();
                ci.setClientId(s.nextInt());
                p.setCid(ci);
				System.out.println("Enter policy Start Date: ");
				try {
					p.setStartDate(dateFormat.parse(s.next()));
					System.out.println("Enter End Date: ");
					p.setEndDate(dateFormat.parse(s.next()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				System.out.println("Enter policy status: ");
				p.setPolicyStatus(s.next());
				System.out.println("Enter policy type: ");
				p.setPolicyType(s.next());
				boolean isPolicyUpdated = i.updatePolicy(p);
		        if (isPolicyUpdated) {
		            System.out.println("Policy updated successfully!");
		        } else {
		            System.out.println("Failed to update policy. Policy not found.");
		        }

				break;
			case 5: 
				System.out.println("Enter Policy id: ");
		        boolean isPolicyDeleted = i.deletePolicy(s.nextInt());
		        if (isPolicyDeleted) {
		            System.out.println("Policy deleted successfully!");
		        } else {
		            System.out.println("Failed to delete policy. Policy not found.");
		        }
				break;
			case 6:
				System.out.println("Exiting...");
                System.exit(0);
				break;
			default: System.out.println("Invalid input");
			}
		}

	}

}
