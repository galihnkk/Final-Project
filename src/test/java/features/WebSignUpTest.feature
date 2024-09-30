Feature: Sign Up

  @web
  Scenario: Sign up with unregistered email and password
    Given user is in homepage
    When user click sign up menu
    Then validate sign up pop-up menu is displayed
    And user input random email in sign up menu
    And user input password in sign up menu "3122223"
    And user click sign up button
    Then validate pop up menu displayed "Sign up successful."

  @web
  Scenario: Sign up with unregistered email and no password entered
    Given user is in homepage
    When user click sign up menu
    Then validate sign up pop-up menu is displayed
    And user input random email in sign up menu
    And user click sign up button
    Then validate pop up menu displayed "Please fill out Username and Password."

  @web
  Scenario: Sign up with no email and no password entered
    Given user is in homepage
    When user click sign up menu
    Then validate sign up pop-up menu is displayed
    And user click sign up button
    Then validate pop up menu displayed "Please fill out Username and Password."

  @web
  Scenario: Sign up with only password entered (no email entered)
    Given user is in homepage
    When user click sign up menu
    Then validate sign up pop-up menu is displayed
    And user input random email in sign up menu
    And user click sign up button
    Then validate pop up menu displayed "Please fill out Username and Password."

  @web
  Scenario: Sign up with registered email and password
    Given user is in homepage
    When user click sign up menu
    Then validate sign up pop-up menu is displayed
    And user input email in sign up menu "galihnkk"
    And user input password in sign up menu "312"
    And user click sign up button
    Then validate pop up menu displayed "This user already exist."