package com.hexaware.exception;


public class PolicyNotFoundException extends Exception{
	public PolicyNotFoundException() {
		System.out.println("From PolicyNotFoundException constr...");
	}
	public String toString() {
		return "PolicyNotFoundException constr...";
	}
}
