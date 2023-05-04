Feature: Registartion functionality 

Scenario: User create an account with only mandetory fields

Given User navigate to the register account page 
When User enter details into the below fileds
|firstName|Sainath                   |
|lastName |Dabhade                   |
|telephone|123456789                 |
|passwords|12345                     |
And User select the privacy policy 
And User click on contiue button 
Then User account should get successfully created


Scenario: User create an account with all fields

Given User navigate to the register account page 
When User enter details into the below fileds
|firstName|Sainath                     |
|lastName |Dabhade                     |
|telephone|123456789                   |
|passwords|12345                       |
And User selects the Yes for newsletter
And User select the privacy policy 
And User click on contiue button 
Then User account should get successfully created

Scenario: User create an duplicate account.

Given User navigate to the register account page 
When User enter duplicate details into the below fileds
|firstName|Sainath                   |
|lastName |Dabhade                   |
|email    |sainathdabhade11@gmail.com|
|telephone|123456789                 |
|passwords|12345                     |
And User selects the Yes for newsletter
And User select the privacy policy 
And User click on contiue button 
Then User should get the proper error message.

Scenario: User create an account without filling any filelds.

Given User navigate to the register account page 
When User dont enter the any fields.
And User click on contiue button 
Then User should get the proper error message evry fields is mandetory.


