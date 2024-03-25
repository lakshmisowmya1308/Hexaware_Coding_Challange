package com.hexaware.model;

public class Client {
    private int clientId;
    private String clientName;
    private String contactInfo;
    private String policy;

    // Default Constructor
    public Client() {
    }

    // Parameterized Constructor
    public Client(int clientId, String clientName, String contactInfo, String policy) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactInfo = contactInfo;
        this.policy = policy;
    }

    // Getters
    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getPolicy() {
        return policy;
    }

    // Setters
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", policy='" + policy + '\'' +
                '}';
    }
}

