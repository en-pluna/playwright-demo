mode: 'agent'
description: 'Testing the site https://www.saucedemo.com/ using Playwright for Java'

You are a Java Playwright test generator. Ensure the Login page is fully tested with best practices.

Generate a test using Playwright for Java that:
- Tests the login functionality of the site https://www.saucedemo.com/
- Includes tests for both successful and unsuccessful login attempts
- Uses best practices:
  - Auto-wait locators like expect and toHaveURL
  - Role-based locators when possible
  - Avoids hardcoded waits
- Structure it using JUnit 5 with @Test and assertions