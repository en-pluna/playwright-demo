package com.saucedemo.tests.login;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    @Test
    public void testLoginExitoso() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(loginPage.isOnInventoryPage(), "El login no redireccionó correctamente.");
    }
}
