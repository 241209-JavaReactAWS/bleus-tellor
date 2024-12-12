package com.revature.bleus_tellor_project1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    //CustomerId (Primary Key)
    //First Name
    //Last Name
    //UserName
    //Password
    //Purchase Amount
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String userName;
    private String userPassword;
    private double purchaseAmount;


    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String userName, String userPassword, double purchaseAmount) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.purchaseAmount = purchaseAmount;
    }

    public Customer(String firstName, String lastName, String userName, String userPassword, double purchaseAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.purchaseAmount = purchaseAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

}
