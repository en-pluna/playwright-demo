package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.BaseTest;

public class LoginTest extends BaseTest {
    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.runTest();
    }

    public void runTest() {
        setUp();

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        if (loginPage.isOnInventoryPage()) {
            System.out.println("✅ Login exitoso. Test PASÓ.");
        } else {
            System.out.println("❌ Login falló. Test FALLÓ.");
        }
        tearDown();
    }
}

