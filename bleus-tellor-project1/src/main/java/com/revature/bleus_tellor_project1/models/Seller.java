package com.revature.bleus_tellor_project1.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Seller {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;

    @OneToMany
    private int sellerItems;
    
    private String sellerName;

    private String sellerUsername;
    
    private String sellerPassword;
    
    
    public Seller() {   };
    
    
    public int getSellerId() {
        return sellerId;
    }
    
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
    
    public String getSellerName() {
        return sellerName;
    }
    
    public void setSellerName(String _sellerName) {
        this.sellerName = _sellerName;
    }
    
    public int getNumberOfItems() {
        return sellerItems;
    }
    
    public void setNumberOfItems(int _sellerItems) {
        this.sellerItems = _sellerItems;
    }
    
    public String getSellerUsername() {
        return sellerUsername;
    }
    
    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
    
    public String getSellerPassword() {
        return sellerPassword;
    }
    
    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }
}
