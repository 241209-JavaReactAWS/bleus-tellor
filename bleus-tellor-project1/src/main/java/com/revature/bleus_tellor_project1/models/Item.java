package com.revature.bleus_tellor_project1.models;

import jakarta.persistence.*;


@Entity
@Table(name = "items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    
    private int sellerId;

    private int itemQuality;

    private String itemBrand;

    private String itemName;

    private double itemPrice;

    private String picUrl;


    public Item() { }

    public Item(int itemId, int sellerId, int itemQuality, String itemBrand, String itemName, double itemPrice) {  }


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

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public int getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(int itemQuality) {
        this.itemQuality = itemQuality;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
