/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.pojo;

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
    private double unitPrice;
    private int sellerId;
    private String sellerName;
    private List<Integer> categoryList;
    
    public Product(String name, String description, int quantity, double unitPrice, int sellerId) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sellerId = sellerId;
    }

    public Product(int id, String name, String description, int quantity, double unitPrice, int sellerId) {
        this(name, description, quantity, unitPrice, sellerId);
        this.id = id;
    }
    
    public Product(int id, String name, String description, int quantity, double unitPrice, String sellerName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sellerName = sellerName;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    
}
