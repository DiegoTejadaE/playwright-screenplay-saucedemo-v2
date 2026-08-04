package edu.pe.cibertec.saucedemo.ui;

public class CartPage {

    public static final String CART_BADGE =
            "[data-test='shopping-cart-badge']";

    public static final String CART_LINK =
            "[data-test='shopping-cart-link']";

    public static final String CART_ITEMS =
            "[data-test='inventory-item-name']";

    public static String addToCartButton(String productName) {
        return "//div[text()='" + productName +
                "']/ancestor::div[@data-test='inventory-item']" +
                "//button[contains(@data-test,'add-to-cart')]";
    }

    public static String removeButton(String productName) {
        return "//div[text()='" + productName +
                "']/ancestor::div[@data-test='inventory-item']" +
                "//button[contains(@data-test,'remove')]";
    }
}