package com.saucedemo.tests.cart;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

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
    public void testAgregarProductoYVerEnCarrito() {
        // Agregar primer producto
        Locator firstProduct = cartPage.getInventoryProductNames().first();
        String expectedProductName = firstProduct.innerText();
        cartPage.getAddToCartButtons().first().click();

        // Ir al carrito
        cartPage.openCart();

        // Validar
        assertTrue(cartPage.isProductInCart(expectedProductName), "El producto no está en el carrito.");
    }

    @Test
    public void testAgregarVariosProductosBadgeYRemove() {
        // Agregar varios productos y validar badge y botón Remove
        for (int i = 0; i < 3; i++) {
            cartPage.getAddToCartButtons().nth(i).click();
            assertTrue(cartPage.getRemoveFromCartButtons().count() == (i + 1), "El botón de eliminar no se muestra después de agregar un producto al carrito.");
            assertTrue(cartPage.getBadgeCount().equals(String.valueOf(i + 1)), "El número de productos en el carrito no es correcto.");
        }
    }

    @Test
    public void testProductosAgregadosEstanEnCarrito() {
        // Agregar varios productos
        Locator products = cartPage.getInventoryProductNames();
        for (int i = 0; i < 3; i++) {
            cartPage.getAddToCartButtons().nth(i).click();
        }

        // Ir al carrito
        cartPage.openCart();

        // Validar que los productos están en el carrito
        for (int i = 0; i < 3; i++) {
            String expectedProductName = products.nth(i).innerText();
            assertTrue(cartPage.isProductInCart(expectedProductName), "El producto " + expectedProductName + " no está en el carrito.");
        }
    }

}
