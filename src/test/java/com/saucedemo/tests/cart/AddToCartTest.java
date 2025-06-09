package com.saucedemo.tests.cart;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class AddToCartTest extends TestBase {

    private CartPage cartPage;

    @BeforeEach
    public void loginAndSetupCartPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        cartPage = new CartPage(page);
    }

    @Test
    @DisplayName("US02 - TC1 - Add product to cart and verify in cart")
    public void testAgregarProductoYVerEnCarrito() {
        // Add first product
        Locator firstProduct = cartPage.getInventoryProductNames().first();
        String expectedProductName = firstProduct.innerText();
        cartPage.getAddToCartButtons().first().click();
        // Go to cart
        cartPage.openCart();
        // Validate
        assertTrue(cartPage.isProductInCart(expectedProductName), "Product is not in the cart after adding it.");
    }

    @Test
    @DisplayName("US02 - TC2 - Add multiple products and verify badge and Remove button")
    public void testAgregarVariosProductosBadgeYRemove() {
        // Add more than one product and valide, badge and Remove button
        for (int i = 0; i < 3; i++) {
            cartPage.getAddToCartButtons().nth(i).click();
            assertTrue(cartPage.getRemoveFromCartButtons().count() == (i + 1),
            "Remove button count is not correct after adding product " + (i + 1) + ".");
            assertTrue(cartPage.getBadgeCount().equals(String.valueOf(i + 1)),
            "Badge count is not correct after adding product " + (i + 1) + ".");
        }
    }

    @Test
    @DisplayName("US02 - TC3 - Verify products added to cart are displayed in the cart")
    public void testProductosAgregadosEstanEnCarrito() {
        // Add more than one product
        Locator products = cartPage.getInventoryProductNames();
        for (int i = 0; i < 3; i++) {
            cartPage.getAddToCartButtons().nth(i).click();
        }
        // Go to Cart
        cartPage.openCart();
        // Valide products are in cart
        for (int i = 0; i < 3; i++) {
            String expectedProductName = products.nth(i).innerText();
            assertTrue(cartPage.isProductInCart(expectedProductName),
            "Product " + expectedProductName + " is not in the cart.");
        }
    }

}
