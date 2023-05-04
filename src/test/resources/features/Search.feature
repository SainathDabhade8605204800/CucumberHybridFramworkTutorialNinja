Feature: Search functionality 

Scenario: User searches for valid products 
Given User open the applications 
When user enter the valid product "HP" in the search fields
And User click on the search button
Then User should get the displayed the valid seached prodcuts 

Scenario: User searches for Invalid products 
Given User open the applications 
When user enter the Invalid product "Honda" in the search fields
And User click on the search button
Then User should get the proper message about no products matching.

Scenario: User searches without any products 
Given User open the applications 
When user dont enter the any product name in search fields.
And User click on the search button
Then User should get the proper message about no products matching.