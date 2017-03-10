/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.validation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Ureka
 */
public class FormValidation {

    private List<String> errorMessages = new ArrayList<String>();

    public boolean validateAddProduct(String name, String description, String quantity, String unitPrice, FileItem image) {

        boolean isValid = true;
        
        isValid = setInputErrorMessage(name, "Product Name", 30, 3);
        isValid = setInputErrorMessage(description, "Description", 400, 3);

        if (quantity.trim().length() == 0) {
            errorMessages.add("Please provide your quantity");
            isValid = false;
        } else if (!isValidInt(quantity)) {
            errorMessages.add("Please provide valid quantity");
            isValid = false;
        }
        
        if (unitPrice.trim().length() == 0) {
            errorMessages.add("Please provide your quantity");
            isValid = false;
        } else if (!isValidDouble(unitPrice)) {
            errorMessages.add("Please provide valid price");
            isValid = false;
        }

        if (image == null) {
            errorMessages.add("Please upload product image");
            isValid = false;
        }

        return isValid;
    }
    
    public boolean validateSignup(String userType, String userCode, String firstName, String lastName, 
            String email, String phone, String country, String password, String confirmPassword) {

        boolean isValid = true;
        
        if (!isValidInt(userType) || !(Integer.parseInt(userType)==1 || Integer.parseInt(userType)==2)) {
            errorMessages.add("Please select User type");
            isValid = false;
        }
        
        isValid = setInputErrorMessage(userCode, "UserName", 10, 3);
        isValid = setInputErrorMessage(firstName, "First Name", 20, 3);
        isValid = setInputErrorMessage(lastName, "Last Name", 20, 3);
        isValid = setInputErrorMessage(email, "Email", 20, 3);
        //isValid = setInputErrorMessage(phone, "Phone", 10, 3);
        //isValid = setInputErrorMessage(country, "country", 20, 3);
        isValid = setInputErrorMessage(password, "Password", 20, 5);
        
        if(confirmPassword.trim().length() == 0) {
            errorMessages.add("Please provide Confirm Password");
            isValid = false;
        } else if (!password.trim().equals(confirmPassword.trim())) {
            errorMessages.add("Password does not match with Confirm Password");
            isValid = false;
        } 

        return isValid;
    }
    
    public boolean validateLogin(String userName, String password) {

        boolean isValid = true;
        if (userName.trim().length() == 0) {
            errorMessages.add("Please provide your username");
            isValid = false;
        } 
        if (password.trim().length() == 0) {
            errorMessages.add("Please provide your password");
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean setInputErrorMessage(String field, String fieldName, int maxL, int minL) {
        boolean isValid = true;
        
        if(field.trim().length() == 0) {
            errorMessages.add("Please provide "+fieldName);
            isValid = false;
        } else if (field.trim().length() < minL) {
            errorMessages.add(fieldName+ " field min length is "+minL);
            isValid = false;
        } else if (field.trim().length() > maxL) {
            errorMessages.add(fieldName+ " field min length is "+maxL);
            isValid = false;
        }
        
        return isValid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
