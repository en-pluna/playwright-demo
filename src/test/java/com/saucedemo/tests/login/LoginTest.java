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

    @Test
    public void testLoginWrongPass(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "wrong_pass");

        assertTrue(loginPage.errorMessage().contains("Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginEmptyFields(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("", "");

        assertTrue(loginPage.errorMessage().contains("Epic sadface: Username is required"));
    }

}
