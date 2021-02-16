Feature: Compose mail

  Background: Compose menu displayed
    Given I have logged into the gmail acoount with valid credentials
      | username               | password    |
      | testauto2104@gmail.com | test@ut0123 |

  Scenario: Click on compose option
    Given User is on gmail page
    When User click on Plus icon
    Then new message window in shown

  Scenario: Compose email with valid emailid, subject, attachment
    Given user clicks on plus icon
    When User enters valid email id,subject, msgbody , attachment
    And clicks on send button    
    Then Message sent text is shown to user along with view messages label



