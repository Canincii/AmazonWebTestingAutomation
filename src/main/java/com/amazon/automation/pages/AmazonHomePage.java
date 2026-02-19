package com.amazon.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for Amazon homepage search and cart flow.
 */
public class AmazonHomePage extends BasePage {

    @FindBy(id = "sp-cc-accept")
    private WebElement cookieAcceptButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "[aria-label='150 TL Üzeri Kargo BEDAVA'] .a-icon")
    private WebElement freeShippingFilter;

    @FindBy(css = ".a-star-medium-4")
    private WebElement fourStarFilter;

    @FindBy(css = ".a-size-base-plus")
    private WebElement firstProduct;

    @FindBy(id = "native_dropdown_selected_size_name")
    private WebElement sizeDropdown;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "[data-csa-c-content-id='sw-gtc_CONTENT']")
    private WebElement goToCartButton;

    @FindBy(id = "sc-active-C405d819e-19a0-4d2b-9fd1-e4cdfc7a8800")
    private WebElement cartItem;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public AmazonHomePage acceptCookies() {
        log.info("Accepting cookie popup");
        click(cookieAcceptButton);
        return this;
    }

    public AmazonHomePage searchProduct(String productName) {
        log.info("Searching for: {}", productName);
        click(searchBox);
        type(searchBox, productName);
        click(searchButton);
        return this;
    }

    public AmazonHomePage applyFreeShippingFilter() {
        log.info("Applying free shipping filter");
        click(freeShippingFilter);
        return this;
    }

    public AmazonHomePage applyFourStarFilter() {
        log.info("Applying 4+ star filter");
        click(fourStarFilter);
        return this;
    }

    public AmazonHomePage selectFirstProduct() {
        log.info("Selecting first product from results");
        click(firstProduct);
        return this;
    }

    public AmazonHomePage selectSize() {
        log.info("Selecting product size");
        click(sizeDropdown);
        return this;
    }

    public AmazonHomePage addToCart() {
        log.info("Adding product to cart");
        click(addToCartButton);
        return this;
    }

    public AmazonHomePage goToCart() {
        log.info("Navigating to cart");
        click(goToCartButton);
        return this;
    }

    public boolean isProductInCart() {
        log.info("Verifying product is in cart");
        return waitForVisible(cartItem).isDisplayed();
    }
}
