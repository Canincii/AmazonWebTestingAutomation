package com.amazon.automation.utils;

import com.amazon.automation.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Reusable explicit wait utilities.
 */
public final class WaitUtils {

    private WaitUtils() {
    }

    private static WebDriverWait getWait(WebDriver driver) {
        int timeout = ConfigReader.getInt("explicit.wait");
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForUrlContains(WebDriver driver, String urlFragment) {
        return getWait(driver).until(ExpectedConditions.urlContains(urlFragment));
    }

    public static boolean waitForTitleContains(WebDriver driver, String titleFragment) {
        return getWait(driver).until(ExpectedConditions.titleContains(titleFragment));
    }
}
