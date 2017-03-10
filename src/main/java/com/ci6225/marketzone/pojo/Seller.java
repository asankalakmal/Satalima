/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.pojo;

/**
 *
 * @author Ureka
 */
public class Seller extends User{
    private String sellerName;
    private String sellerDescription;
    
    public Seller(String sellerName, String sellerDescription){
       this.sellerName = sellerName;
       this.sellerDescription = sellerDescription;
    }
    
    public Seller(int userId){
       this.userId = userId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerDescription() {
        return sellerDescription;
    }

    public void setSellerDescription(String sellerDescription) {
        this.sellerDescription = sellerDescription;
    }
    
    
}
