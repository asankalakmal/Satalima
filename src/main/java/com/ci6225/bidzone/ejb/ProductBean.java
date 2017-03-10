/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.ProductDao;
import com.ci6225.bidzone.pojo.Product;
import com.ci6225.bidzone.pojo.Seller;
import com.ci6225.bidzone.util.CommonUtil;
import java.io.File;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Ureka
 */
@Stateless
public class ProductBean {

    public void addProduct(String name, String description, int userId, int quantity, float unitPrice, FileItem image, String uploadPath) throws Exception {
        ProductDao productDao = new ProductDao();
        String productName = uploadProductImage(image, uploadPath+"/"+Integer.toString(userId));
        Product product = new Product(name, description, quantity, unitPrice, productName);
        Seller seller = new Seller(userId);
        product.setSeller(seller);
        productDao.addProduct(product, userId);
    }

    public void updateProduct(int id, String name, String description, int quantity, float unitPrice, int userId, FileItem image, String uploadPath) throws Exception {
        ProductDao productDao = new ProductDao();
        String productName = uploadProductImage(image, uploadPath+"/"+Integer.toString(userId));
        Product product = new Product(id, name, description, quantity, unitPrice, productName);
        Seller seller = new Seller(userId);
        product.setSeller(seller);
        productDao.updateProduct(product, userId);
    }

    private String uploadProductImage(FileItem image, String uploadPath) throws Exception {

        if (CommonUtil.isSetDirectory(uploadPath)) {
            String fileName = new File(image.getName()).getName();
            String newFileName = CommonUtil.imageNameGenerate(fileName);
            String filePath = uploadPath + File.separator + newFileName;
            File uploadedFile = new File(filePath);
            image.write(uploadedFile);
            return newFileName;
        }
        
        return null;
    }
    
    public List<Product> getProductList(int sellerId) throws Exception{
        ProductDao dao = new ProductDao();
        return dao.getProductListBySellerId(sellerId);
    }
    
    public Product getProduct(int productId) throws Exception{
        ProductDao dao = new ProductDao();
        return dao.getProduct(productId);
    }

}
