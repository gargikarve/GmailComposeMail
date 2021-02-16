Feature: Login  mail

Scenario: Login to gmail
Given google sign in url is accessible
When user enters email as "testauto2104@gmail.com"
And clicks on next buttom
And user enters password as "test@ut0123"
And clicks on login
Then User should login successfully with title as "Gmail"
