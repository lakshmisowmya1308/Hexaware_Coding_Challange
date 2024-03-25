package com.hexaware.model;

public class Payment {
    private int paymentId;
    private String paymentDate;
    private double paymentAmount;
    private Client client;

    // Default Constructor
    public Payment() {
    }

    // Parameterized Constructor
    public Payment(int paymentId, String paymentDate, double paymentAmount, Client client) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.client = client;
    }

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public Client getClient() {
        return client;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", client=" + client +
                '}';
    }
}
