package com.hexaware.model;


import java.util.Date;

public class Policy {
    private int policyId;
    private Client client;
    private Date startDate;
    private Date endDate;
    private String policyType;
    private String policyStatus;
    private int cid;

    

    public int getCid() {
		return cid;
	}


	public void setCid(Client client) {
		this.cid = client.getClientId();
	}


	public Policy() {
    }

     
    public Policy(int policyId, int clientID, Date startDate, Date endDate, String policyType, String policyStatus) {
        this.policyId = policyId;
        this.cid = clientID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.policyType = policyType;
        this.policyStatus = policyStatus;
    }
    
    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", client ID=" + client.getClientId() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", policyType='" + policyType + '\'' +
                ", policyStatus='" + policyStatus + '\'' +
                '}';
    }
}

