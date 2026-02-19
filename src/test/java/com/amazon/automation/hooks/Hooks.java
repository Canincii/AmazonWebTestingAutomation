package com.amazon.automation.hooks;

import com.amazon.automation.config.ConfigReader;
import com.amazon.automation.driver.DriverFactory;
import com.amazon.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        log.info("--- Starting scenario: {} ---", scenario.getName());
        WebDriver driver = DriverFactory.initDriver();
        driver.get(ConfigReader.get("base.url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed() && driver != null) {
            log.warn("Scenario FAILED: {}", scenario.getName());
            byte[] screenshot = ScreenshotUtils.takeScreenshot(driver);
            if (screenshot.length > 0) {
                Allure.addAttachment("Failure Screenshot", "image/png",
                        new ByteArrayInputStream(screenshot), ".png");
            }
        } else {
            log.info("Scenario PASSED: {}", scenario.getName());
        }

        DriverFactory.quitDriver();
        log.info("--- Finished scenario: {} ---", scenario.getName());
    }
}
