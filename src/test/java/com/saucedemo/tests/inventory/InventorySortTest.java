package com.saucedemo.tests.inventory;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventorySortTest extends TestBase {

    private InventoryPage inventoryPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(page);
    }

    @Test
    public void testSortByNameAZ() {
        inventoryPage.selectSortOption("az");
        List<String> actual = inventoryPage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        assertEquals(expected, actual, "Products are not sorted A-Z");
    }

    @Test
    public void testSortByNameZA() {
        inventoryPage.selectSortOption("za");
        List<String> actual = inventoryPage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        assertEquals(expected, actual, "Products are not sorted Z-A");
    }
}
