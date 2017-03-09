/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.ShoppingCartDao;
import com.ci6225.bidzone.pojo.CartItem;
import com.ci6225.bidzone.pojo.Product;
import com.ci6225.bidzone.pojo.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Ureka
 */
@Stateful
public class ShoppingCartBean implements ShoppingCartBeanLocal{
    private List<Product> productList = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart();
    
    @Override
    public List<Product> searchProducts() throws Exception{
        ShoppingCartDao dao = new ShoppingCartDao();
        productList = dao.getAvailableProductList();
        return productList;
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public ShoppingCart getCart() {
        return cart;
    }

    @Override
    public void addItem(int productIndex, int quantity) {
        Product product = productList.get(productIndex);
        
        CartItem item = new CartItem(product.getId(), quantity, quantity * product.getUnitPrice(), productIndex);       
        item.setProduct(product);
        cart.getCartItems().add(item);
        cart.setTotalPrice(cart.getTotalPrice() + item.getAmount());
        cart.setAdminFee((float) (cart.getTotalPrice() * 0.01));
        cart.setCartTotal(cart.getTotalPrice() + cart.getAdminFee());
        }

    @Override
    @Remove
    public int confirmOrder(String firstName, String lastName, String email, String telephone, String address1, 
            String address2, String city, String postalCode, String country, String comments, int userId) throws Exception{
        cart.setFirstName(firstName);
        cart.setLastName(lastName);
        cart.setEmail(email);
        cart.setTelephone(telephone);
        cart.setAddress1(address1);
        cart.setAddress2(address2);
        cart.setCity(city);
        cart.setPostalCode(postalCode);
        cart.setCountry(country);
        cart.setComments(comments);
        
        ShoppingCartDao dao = new ShoppingCartDao();
        return dao.insertOrder(cart, userId);
    }

    @Override
    public void removeItem(int itemIndex) {
        cart.getCartItems().remove(itemIndex);
        this.updateCartTotal();
    }
    
    private void updateCartTotal(){
        float total = 0;
        for(CartItem item: cart.getCartItems()){
            total += item.getAmount();
        }
        cart.setTotalPrice(total);
        cart.setAdminFee((float) (cart.getTotalPrice() * 0.01));
        cart.setCartTotal(cart.getTotalPrice() + cart.getAdminFee());
    }

    @Override
    public void updateCartItems(List<Integer> quantityList) {
        int index = 0;
        for(CartItem item: cart.getCartItems()){
           item.setQuantity(quantityList.get(index));
           item.setAmount(item.getQuantity() * item.getProduct().getUnitPrice());
           index++;
        }
        this.updateCartTotal();
    }
    
    
}

