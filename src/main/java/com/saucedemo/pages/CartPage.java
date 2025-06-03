package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import java.util.List;

public class CartPage {
    private final Page page;

    // Locators
    private final String cartIcon = ".shopping_cart_link";
    private final String productNamesOnInventory = ".inventory_item_name";
    private final String badge = ".shopping_cart_badge";
    private final String productNamesInCart = ".cart_item .inventory_item_name";

    public CartPage(Page page) {
        this.page = page;
    }

    public void openCart() {
        page.locator(cartIcon).click();
        page.waitForURL("**/cart.html");
    }

    public Locator getInventoryProductNames() {
        return page.locator(productNamesOnInventory);
    }

    public List<String> getCartProductNames() {
        return page.locator(productNamesInCart).allInnerTexts();
    }

    public Locator getAddToCartButtons() {
        return page.locator("text=Add to cart");
    }

    public Locator getRemoveFromCartButtons() {
        return page.locator("text=Remove");
    }

    public String getBadgeCount() {
        return page.locator(badge).innerText();
    }

    public boolean isProductInCart(String productName) {
        return getCartProductNames().contains(productName);
    }
}
