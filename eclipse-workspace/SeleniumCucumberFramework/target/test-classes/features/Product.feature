Feature:

 Background:
  Given User login page is displayed
    When User enters "standard_user" as username
    And User enters "secret_sauce" as password
    And User clicks Login button
    Then User able to view home page







Scenario: product filter and Art to cart functionality 
    Given User homepage is displayed
    When User clicks product filter dropdown
    And  User selects filter "Price (low to high)"
    And User clicks on first product
    And User clicks on add to cart 
    And User clicks on add to cart icon
    Then Product detail page is displayed 
    
    
    
    
    
    
    
    

    
   