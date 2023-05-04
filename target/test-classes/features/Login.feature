
Feature: Login functionality 

Scenario Outline: Login with valid credentials 
Given User Navigate to log in page 
When User has enters valid email address <username> into email field.
And User has enters valid passwords <passwords> into passwords filed
And User click on Log in button
Then User should get successfully logged in
Examples:
|username                  |passwords|
|amotooricap1@gmail.com    |12345    |
|amotooricap2@gmail.com    |12345    |
|amotooricap3@gmail.com    |12345    |
|amotooricap1@gmail.com    |12345    |
|sainathdabhade11@gmail.com|12345    |

Scenario: Log in with invalid credentials 
Given User Navigate to log in page 
When User has enters invalid email address into email field.
And User has enters invalid passwords "123456" into passwords filed
And User click on Log in button
Then User should get proper warning message credentials miss matched

Scenario: Log in with Valid email and invalid passwords 
Given User Navigate to log in page 
When User has enters valid email address "sainathdabhade11@gmail.com" into email field.
And User has enters invalid passwords "123456" into passwords filed
And User click on Log in button
Then User should get proper warning message credentials miss matched


Scenario: Log in with InValid email and valid passwords 
Given User Navigate to log in page 
When User has enters invalid email address into email field.
And User has enters valid passwords "12345" into passwords filed
And User click on Log in button
Then User should get proper warning message credentials miss matched


Scenario: Log in without any credentials 
Given User Navigate to log in page 
When User dont enter the email address into email field.
And User dont enter the passwords into passwords filed
And User click on Log in button
Then User should get proper warning message credentials miss matched
