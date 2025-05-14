package com.saucedemo.tests.cart;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest extends TestBase {

    @Test
    public void testAgregarProductoYVerEnCarrito() {
        // Login
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        // Agregar primer producto
        Locator firstProduct = page.locator(".inventory_item_name").first();
        String expectedProductName = firstProduct.innerText();
        page.locator("text=Add to cart").first().click();

        // Ir al carrito
        CartPage cartPage = new CartPage(page);
        cartPage.openCart();

        // Validar
        assertTrue(cartPage.isProductInCart(expectedProductName), "El producto no está en el carrito.");
    }
}
