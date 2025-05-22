# Playwright Java Automation Project

This project is a Java-based automated testing framework for the SauceDemo web application, using Playwright and JUnit.

## Features

- Automated UI tests for login and cart functionalities on [https://www.saucedemo.com/](https://www.saucedemo.com/).
- Uses [Playwright](https://playwright.dev/java/) for browser automation.
- Test cases are written with [JUnit Jupiter](https://junit.org/junit5/).
- Project is managed with Maven.

## Project Structure

- **Test classes:**  
  Located in `src/test/java/com/saucedemo/tests`
  - Example: `com.saucedemo.tests.login.LoginTest`, `com.saucedemo.tests.cart.AddToCartTest`
- **Page Object Model:**  
  For maintainable test code:
  - `com.saucedemo.pages.LoginPage`
  - `com.saucedemo.pages.CartPage`
- **Test setup and teardown:**  
  In `com.saucedemo.base.TestBase`
- **Maven configuration:**  
  In `pom.xml`

## How to Run

1. Install dependencies:
   ```sh
   mvn install
   ```
2. Run tests:
   ```sh
   mvn test
   ```

You can extend this project by adding more page objects and test cases as needed.