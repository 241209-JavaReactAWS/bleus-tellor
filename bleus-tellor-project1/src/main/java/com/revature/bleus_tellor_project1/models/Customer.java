package com.revature.bleus_tellor_project1.models;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(unique = true)
    private String userName;

    private String userPassword;

    private Set<Item> itemCart;

    private Role role;

    public Customer() {
    }

    public Customer(int customerId, String userName, String userPassword, Set<Item> itemCart, Role role) {
        this.customerId = customerId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.itemCart = itemCart;
        this.role = role;
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

    public Set<Item> getItemCart() {
        return itemCart;
    }

    public void setItemCart(Set<Item> itemCart) {
        this.itemCart = itemCart;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
