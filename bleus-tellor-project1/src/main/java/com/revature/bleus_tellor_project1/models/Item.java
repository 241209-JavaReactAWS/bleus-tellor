package com.revature.bleus_tellor_project1.models;

import jakarta.persistence.*;


@Entity
@Table(name = "items")
public class Item {
    /*Item Id Primary Key
    User Id
    Item Name
    Item Price
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    
    @ManyToOne
    private int sellerId;

    private String itemName;

    private double itemPrice;


    public Item() { }

    public Item(int sellerId, String itemName, double itemPrice) {  }

    public Item(int itemId, int sellerId, String itemName, double itemPrice) {  }


    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(int _itemId) {
        this.itemId = _itemId;
    }

    public int getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(int _sellerId) {
        this.sellerId = _sellerId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String _itemName) {
        this.itemName = _itemName;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(double _itemPrice) {
        this.itemPrice = _itemPrice;
    }
}
