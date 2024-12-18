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

    @ManyToMany
    @JoinTable(
        name = "cart_items",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name="item_id")
    )
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

    public String getCustomerPassword() {
        return userPassword;
    }

    public void setCustomerPassword(String userPassword) {
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
