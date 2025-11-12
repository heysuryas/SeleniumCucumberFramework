Feature: Checkout funchionality 

 Background:
  Given User login page is displayed
    When User enters "standard_user" as username
    And User enters "secret_sauce" as password
    And User clicks Login button
    Then User able to view home page
    
    
   Scenario:
    Given User in checkout page
    When User clicks checkout button
    And User enters "<Firstname>" as firstname  
    And User enters "<Lastname>" as Lastname
    And User enters "<Postcode>" as postcode
    And User clicks finish button
    Then User able to view confirmation message 
    
    
    Examples:
  | Firstname       | Lastname     |Postcode
  | Surya           | Nair         |EH11 1UE
  | Swathy          | kiran        |EH11 3NA