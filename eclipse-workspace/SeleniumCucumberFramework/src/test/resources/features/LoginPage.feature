
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User login page is displayed
    When User enters "standard_user" as username
    And User enters "secret_sauce" as password
    And User clicks Login button
    Then User able to view home page
    

  Scenario: UnSuccessful login with invalid credentials
    Given User login page is displayed
    When User enters "standard_us1er" as username
    And User enters "secret_sauc1e" as password
    And User clicks Login button
    Then User able to view invalid error message
