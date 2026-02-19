@Amazon
Feature: Amazon Product Search and Cart

  Scenario: Add a product to cart from search results
    Given User is on the homepage
    When User accepts the cookie popup
    And User searches for "Motorcu Eldiveni"
    And User applies free shipping filter
    And User applies four star and above filter
    And User clicks on the first product
    And User selects a size
    And User adds the product to cart
    And User navigates to the cart
    Then The product should be visible in the cart
