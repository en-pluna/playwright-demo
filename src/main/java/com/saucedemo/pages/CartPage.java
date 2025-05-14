package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class CartPage {
    private final Page page;

    // Locators
    private final String cartIcon = ".shopping_cart_link";
    private final String productNameInCart = ".inventory_item_name";

    public CartPage(Page page) {
        this.page = page;
    }

    public void openCart() {
        page.locator(cartIcon).click();
        page.waitForURL("**/cart.html");
    }

    public String getProductNameInCart() {
        Locator productName = page.locator(productNameInCart).first();
        return productName.innerText();
    }

    public boolean isProductInCart(String expectedName) {
        return getProductNameInCart().equals(expectedName);
    }
}
