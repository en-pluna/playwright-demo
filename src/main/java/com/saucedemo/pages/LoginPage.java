package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorPassword = ".error-message-container";

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

    public String errorMessage(){
        return page.innerText(errorPassword);
    }

}
