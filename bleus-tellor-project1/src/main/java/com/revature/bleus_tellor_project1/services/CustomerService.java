package com.revature.bleus_tellor_project1.services;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerService {
    //Customer Id (Primary Key)
    //First Name
    //Last Name
    //UserName
    //Password
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
@Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String userName;
    private String userPassword;

    public CustomerService() {
    }

    public CustomerService(int customerId, String userPassword, String userName, String lastName, String firstName) {
        this.customerId = customerId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public CustomerService(String firstName, String lastName, String userPassword, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPassword = userPassword;
        this.userName = userName;
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
}
