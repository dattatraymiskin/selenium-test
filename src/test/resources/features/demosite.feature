Feature: Login to Saucelabs website

  Scenario Outline: Validating Login process for User with valid product value
    Given User is on Login Screen
    When User enters  username and password and clicks on login button
    Then User selects <productName> from the list
    And User verify the product price is equal to the <productPrice>
   Examples:
     | productName             | productPrice |
     | Sauce Labs Backpack     | 29.99        |
#     | Sauce Labs Bolt T-Shirt | 15.99        |



  Scenario Outline: Validating the price of selected product is correct or not
    Then User selects <productName> from the list
    And User verify the product price is equal to the <productPrice>
   Examples:
     | productName             | productPrice |
     | Sauce Labs Bolt T-Shirt | 40.88        |
