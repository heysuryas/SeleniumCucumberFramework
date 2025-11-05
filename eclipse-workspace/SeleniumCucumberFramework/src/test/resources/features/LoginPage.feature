@smoke
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User login page is displayed
    When User enters "standard_user" as username
    And User enters "secret_sauce" as password
    And User clicks Login button
    Then User able to view home page
