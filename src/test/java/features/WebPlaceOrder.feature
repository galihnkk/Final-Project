Feature: Place Order in Cart

  @web
  Scenario: Place order with complete customer data
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    And user click first item in homepage
    And user click add to cart button
    And validate pop up menu displayed "Product added."
    And user click cart menu
    And validate item is added in cart menu
    And validate total item price
    When user click place order button
    Then validate place order pop up is displayed
    When user enter name "Example Name" in place order pop up menu
    And user enter country "Example Country" in place order pop up menu
    And user enter city "Example City" in place order pop up menu
    And user enter credit card "1234567890" in place order pop up menu
    And user enter month "September" in place order pop up menu
    And user enter year "2024" in place order pop up menu
    And user click purchase button in place order pop up menu
    Then validate thank you pop up is displayed

  @web
  Scenario: Place order with only mandatory customer data (name and credit card)
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    And user click first item in homepage
    And user click add to cart button
    And validate pop up menu displayed "Product added."
    And user click cart menu
    And validate item is added in cart menu
    And validate total item price
    When user click place order button
    Then validate place order pop up is displayed
    When user enter name "Example Name" in place order pop up menu
    And user enter credit card "1234567890" in place order pop up menu
    And user click purchase button in place order pop up menu
    Then validate thank you pop up is displayed

  @web
  Scenario: Place order with incomplete customer data (name only)
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    And user click first item in homepage
    And user click add to cart button
    And validate pop up menu displayed "Product added."
    And user click cart menu
    And validate item is added in cart menu
    And validate total item price
    When user click place order button
    Then validate place order pop up is displayed
    When user enter name "Example Name" in place order pop up menu
    And user click purchase button in place order pop up menu
    Then validate pop up menu displayed "Please fill out Name and Creditcard."

  @web
  Scenario: Place order with multiple items
    Given user is in homepage
    And user click login menu
    And user input email in login menu "galihnkk"
    And user input password in login menu "312"
    And user click login button
    And user click first item in homepage
    And user click add to cart button
    And validate pop up menu displayed "Product added."
    And user go back to homepage
    And user click second item in homepage
    And user click add to cart button
    And validate pop up menu displayed "Product added."
    And user click cart menu
    And validate item is added in cart menu
    And validate total item price
    When user click place order button
    Then validate place order pop up is displayed
    When user enter name "Example Name" in place order pop up menu
    And user enter credit card "1234567890" in place order pop up menu
    And user click purchase button in place order pop up menu
    Then validate thank you pop up is displayed