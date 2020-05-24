Feature: Login into Application 

Scenario Outline: Positive test validating login   
Given Initialize the browser with a chrome 
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login link in home page to land on sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close browsers


Examples:
|username 			   |password |
|mihaillecari@gmail.com|Svetka578|
|test123@gmail.com     |122345   |