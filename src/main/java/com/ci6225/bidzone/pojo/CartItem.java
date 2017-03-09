/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.pojo;

/**
 *
 * @author Ureka
 */
public class CartItem {
    private int productId;
    private int quantity;
    private float amount;
    private int productIndex;
    private Product product;
    
    public CartItem(int productId, int quantity, float amount, int productIndex){
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.productIndex = productIndex;
    }

    public CartItem(int quantity, float amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
