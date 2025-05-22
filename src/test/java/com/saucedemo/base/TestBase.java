package com.saucedemo.base;

import com.microsoft.playwright.*;

//import java.util.List;
//import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

public class TestBase {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }

    //@Test
    //void BrowserSupport(){
    //   try (Playwright pw = Playwright.create()) {
    //        List<BrowserType> browserTypes = List.of(pw.chromium(), pw.firefox(), pw.webkit());
    //
    //        for (BrowserType browserType : browserTypes){
    //            Page page = browserType.launch().newPage();
    //            page.navigate("https://www.automationexercise.com/");
    //            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(browserType.name() + ".png")));
    //        }
    //    }
    //}
}
