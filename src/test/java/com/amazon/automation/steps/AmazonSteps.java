package com.amazon.automation.steps;

import com.amazon.automation.driver.DriverFactory;
import com.amazon.automation.pages.AmazonHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AmazonSteps {

    private AmazonHomePage amazonHomePage;

    private AmazonHomePage getPage() {
        if (amazonHomePage == null) {
            amazonHomePage = new AmazonHomePage(DriverFactory.getDriver());
        }
        return amazonHomePage;
    }

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        // driver already navigated to base URL in Hooks @Before
    }

    @When("User accepts the cookie popup")
    public void userAcceptsCookiePopup() {
        getPage().acceptCookies();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String product) {
        getPage().searchProduct(product);
    }

    @When("User applies free shipping filter")
    public void userAppliesFreeShippingFilter() {
        getPage().applyFreeShippingFilter();
    }

    @When("User applies four star and above filter")
    public void userAppliesFourStarFilter() {
        getPage().applyFourStarFilter();
    }

    @When("User clicks on the first product")
    public void userClicksOnFirstProduct() {
        getPage().selectFirstProduct();
    }

    @When("User selects a size")
    public void userSelectsSize() {
        getPage().selectSize();
    }

    @When("User adds the product to cart")
    public void userAddsProductToCart() {
        getPage().addToCart();
    }

    @When("User navigates to the cart")
    public void userNavigatesToCart() {
        getPage().goToCart();
    }

    @Then("The product should be visible in the cart")
    public void productShouldBeVisibleInCart() {
        Assert.assertTrue(getPage().isProductInCart(), "Product was not found in the cart");
    }
}
