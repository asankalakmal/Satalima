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
        if (name.trim().length() < 3) {
            errorMessages.add("Product Name field min length is 3");
            isValid = false;
        } else if (name.trim().length() > 100) {
            errorMessages.add("Product Name field max length is 100");
            isValid = false;
        }

        if (description.trim().length() < 5) {
            errorMessages.add("Product description field min length is 50");
            isValid = false;
        } else if (description.trim().length() > 2000) {
            errorMessages.add("Product description field max length is 2000");
            isValid = false;
        }

        if (quantity.trim().length() == 0 || !isValidInt(quantity)) {
            errorMessages.add("Please provide valid quantity");
            isValid = false;
        }

        if (unitPrice.trim().length() == 0 || !isValidDouble(unitPrice)) {
            errorMessages.add("Please provide valid price");
            isValid = false;
        }

        if (image == null) {
            errorMessages.add("Please upload product image");
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

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
