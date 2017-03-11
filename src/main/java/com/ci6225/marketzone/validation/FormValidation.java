/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.validation;

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
        } else if (!isValidInt(quantity) || Integer.parseInt(quantity) <= 0) {
            errorMessages.add("Please provide valid quantity");
            isValid = false;
        }

        if (unitPrice.trim().length() == 0) {
            errorMessages.add("Please provide your quantity");
            isValid = false;
        } else if (!isValidDouble(unitPrice) || Double.parseDouble(unitPrice) <= 0) {
            errorMessages.add("Please provide valid price");
            isValid = false;
        }

        /*if (image == null) {
            errorMessages.add("Please upload product image");
            isValid = false;
        }*/
        return isValid;
    }

    public boolean validateupdateProduct(String name, String description, String quantity, String unitPrice) {

        boolean isValid = true;
        
        if (!setInputErrorMessage(name, "Product Name", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(description, "Description", 400, 3)) {
            isValid = false;
        }

        if (quantity.trim().length() == 0) {
            errorMessages.add("Please provide your quantity");
            isValid = false;
        } else if (!isValidInt(quantity) || Integer.parseInt(quantity) < 0) {
            errorMessages.add("Please provide valid quantity");
            isValid = false;
        }

        if (unitPrice.trim().length() == 0) {
            errorMessages.add("Please provide your quantity");
            isValid = false;
        } else if (!isValidDouble(unitPrice) || Double.parseDouble(unitPrice) <= 0) {
            errorMessages.add("Please provide valid price");
            isValid = false;
        }

        return isValid;
    }

    public boolean validateSignup(String userType, String userCode, String firstName, String lastName,
            String email, String phone, String country, String password, String confirmPassword, String shopName, String description) {

        boolean isValid = true;

        if (!isValidInt(userType) || !(Integer.parseInt(userType) == 1 || Integer.parseInt(userType) == 2)) {
            errorMessages.add("Please select User type");
            isValid = false;
        }

        if (!setInputErrorMessage(userCode, "UserName", 10, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(firstName, "First Name", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(lastName, "Last Name", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(email, "Email", 50, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(password, "Password", 20, 3)) {
            isValid = false;
        }
        //isValid = setInputErrorMessage(phone, "Phone", 10, 3);
        //isValid = setInputErrorMessage(country, "country", 20, 3);

        if (isValidInt(userType) && Integer.parseInt(userType) == 2) {
            if (!setInputErrorMessage(shopName, "Shop Name", 45, 3)) {
                isValid = false;
            }
            if (!setInputErrorMessage(description, "Description", 200, 3)) {
                isValid = false;
            }
        }

        if (confirmPassword.trim().length() == 0) {
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

    public boolean validateCartAdd(String quantity, String productIndex) {

        boolean isValid = true;
        if (quantity.trim().length() == 0) {
            errorMessages.add("Please provide the quantity");
            isValid = false;
        } else if (!isValidInt(quantity) || Integer.parseInt(quantity) <= 0) {
            errorMessages.add("Please provide valid quantity");
            isValid = false;
        }

        if (productIndex.trim().length() == 0 || !isValidInt(productIndex)) {
            errorMessages.add("Invalid product Item");
            isValid = false;
        }
        return isValid;
    }

    public boolean validateCheckout(String firstName, String lastName, String email, String telephone,
            String address1, String address2, String city, String country, String postalcode) {

        boolean isValid = true;

        if (!setInputErrorMessage(firstName, "First Name", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(lastName, "Last Name", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(email, "Email", 50, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(city, "City", 20, 3)) {
            isValid = false;
        }
        if (!setInputErrorMessage(postalcode, "Postal Code", 20, 3)) {
            isValid = false;
        }

        if (!setInputErrorMessage(address1, "Address1", 20, 3)) {
            isValid = false;
        }

        if (telephone.trim().length() > 10) {
            errorMessages.add("Telephone number field max length is 10");
            isValid = false;
        }
        if (address2.trim().length() > 20) {
            errorMessages.add("Address2 field max length is 20");
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

        if (field.trim().length() == 0) {
            errorMessages.add("Please provide " + fieldName);
            isValid = false;
        } else if (field.trim().length() < minL) {
            errorMessages.add(fieldName + " field min length is " + minL);
            isValid = false;
        } else if (field.trim().length() > maxL) {
            errorMessages.add(fieldName + " field max length is " + maxL);
            isValid = false;
        }

        return isValid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
