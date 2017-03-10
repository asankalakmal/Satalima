/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.pojo;

import java.util.List;

/**
 *
 * @author Ureka
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private float unitPrice;
    private int sellerId;
    private Seller seller;
    private String image;
    private List<Integer> categoryList;
    
    public Product(String name, String description, int quantity, float unitPrice, String image) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.image = image;
    }

    public Product(int id, String name, String description, int quantity, float unitPrice, String image) {
        this(name, description, quantity, unitPrice, image);
        this.id = id;
    }
    
    public Product(int id, String name, String description, int quantity, float unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product(String name, String description, float unitPrice, String image) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.image = image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<Integer> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Integer> categoryList) {
        this.categoryList = categoryList;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
