package com.saucedemo.tests.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    @DisplayName("US01 - TC1 - Title and URL of the page")
    public void testLoginPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();

        // Verify the title of the page
        String title = page.title();
        assertTrue(title.equals("Swag Labs"), "Title of the page is not correct.");

        // Verify the URL of the page
        String url = page.url();
        assertTrue(url.contains("saucedemo.com"), "URL is incorrect.");
    }

    //Test example with CSV source, more than one parameter
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @CsvSource(value = {"standard_user, secret_sauce", "problem_user, secret_sauce", "error_user, secret_sauce"})
    @DisplayName("US01 - TC2 - Successful login with valid credentials")
    public void testLoginExitoso(String username, String password) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login(username, password);

        assertTrue(loginPage.isOnInventoryPage(), "Login does not redirect correctly.");
    }

    //Test example with one parameter
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(strings = {"wrong_pass", "123456", "abcdefg"})
    @DisplayName("US01 - TC3 - Login with invalid password")
    public void testLoginWrongPass(String password) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", password);

        assertTrue(loginPage.errorMessage().contains("Username and password do not match any user in this service"), 
                   "Error message for wrong password is not displayed correctly.");
    }

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @EmptySource
    @ValueSource(strings = {""})
    @DisplayName("US01 - TC4 - Login with empty fields")
    public void testLoginEmptyFields(String input){
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login(input, input);

        assertTrue(loginPage.errorMessage().contains("Epic sadface: Username is required"),
        "Error message for empty fields is not displayed correctly.");
    }

    @Test
    @DisplayName("US01 - TC5 - Login with locked user")
    public void testLoginLockedUser() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("locked_out_user", "secret_sauce");
        
        assertTrue(loginPage.errorMessage().contains("Epic sadface: Sorry, this user has been locked out."),
                   "Error message for locked user is not displayed correctly.");
    }
}
