package com.hexaware.dao;

import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.model.Policy;
import java.util.Collection;

public interface IPolicyService {
	
    public boolean createPolicy(Policy policy);

    public void getPolicy(int policyId) throws PolicyNotFoundException;

    public void getAllPolicies();

    public boolean updatePolicy(Policy policy);

    public boolean deletePolicy(int policyId);
}
