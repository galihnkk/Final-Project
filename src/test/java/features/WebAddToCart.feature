Feature: Add to cart

  @web
  Scenario: Add one item to cart
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    When user click first item in homepage
    And user click add to cart button
    Then validate pop up menu displayed "Product added."
    When user click cart menu
    Then validate item is added in cart menu
    Then clear item from cart "1"

  @web
  Scenario: Add multiple items to cart
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    When user click first item in homepage
    And user click add to cart button
    Then validate pop up menu displayed "Product added."
    And user go back to homepage
    When user click second item in homepage
    And user click add to cart button
    Then validate pop up menu displayed "Product added."
    When user click cart menu
    Then validate both items were added in cart menu
    Then clear item from cart "2"

  @web
  Scenario: Add multiple items to cart then delete 1 item
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    When user click first item in homepage
    And user click add to cart button
    Then validate pop up menu displayed "Product added."
    And user go back to homepage
    When user click second item in homepage
    And user click add to cart button
    Then validate pop up menu displayed "Product added."
    When user click cart menu
    Then validate both items were added in cart menu
    Then clear item from cart "1"
    Then deleted item will disappeared from cart item list
    Then clear item from cart "1"