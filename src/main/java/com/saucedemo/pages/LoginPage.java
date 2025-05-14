package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public boolean isOnInventoryPage() {
        return page.url().contains("inventory.html");
    }
}
