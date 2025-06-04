package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import java.util.List;

public class InventoryPage {
    private final Page page;
    private final String sortDropdown = ".product_sort_container";
    private final String productNames = ".inventory_item_name";

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void selectSortOption(String optionValue) {
        page.selectOption(sortDropdown, optionValue);
    }

    public List<String> getProductNames() {
        return page.locator(productNames).allInnerTexts();
    }
}